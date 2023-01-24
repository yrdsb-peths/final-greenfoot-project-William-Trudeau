import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The buttons class to implement different buttons actions.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Button extends Actor
{
    private String name;
    GifImage logoImage = new GifImage("logo.gif");
    Shop shop;
    public Button(String name) {
        this.name = name;
    }
    
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        buttonClicked();
        if (this.name.equals("Logo")) {
            this.setImage(logoImage.getCurrentImage());
        }    
        if (Greenfoot.mouseMoved(this) && this.name.equals("1"))
        {
            getWorld().addObject(((Guide)getWorld()).level1, 400, 250);
        }
        transparent();
    }    
    /**
     * When mouse moved on to the button, the button will change transparency.
     * That way user can easily know which button they are on.
     */    
    private void transparent() {
        if (Greenfoot.mouseMoved(this) && !this.name.equals("Logo") && !this.name.equals("null")) {
            this.getImage().setTransparency(180);
        }
        else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            this.getImage().setTransparency(255);
        }
    }
    public void buttonClicked() {
        if (Greenfoot.mouseClicked(this)) {
            if (getWorld() instanceof Shop) {
                shop = (Shop) getWorld();
            }    
            switch (this.name) {
                case "StartButton":
                    Greenfoot.setWorld(new Mode());
                    break;
                case "GuideButton":
                    Greenfoot.setWorld(new Guide());
                    break;
                case "ShopButton":
                    Greenfoot.setWorld(new Shop());
                    break;
                case "Back":
                    Greenfoot.setWorld(new Menu());
                    break;
                case "Solo":
                    Greenfoot.setWorld(new Solo());
                    break;
                case "Default":
                    if (!Shop.SKIN.equals("Default")) {
                        skinStatus(shop);
                        shop.ppl1Label.setValue("Selected");
                        Shop.SKIN = "Default";
                    } 
                    break;
                case "Baby": 
                    if (!Shop.SKIN.equals("Baby") && Shop.UNLOCK[1]) {
                        skinStatus(shop);
                        shop.baby1Label.setValue("Selected");
                        Shop.SKIN = "Baby";
                    }
                    else if (!Shop.UNLOCK[2]){
                        if (Shop.MONEY >= 100){
                            Shop.MONEY -= 100;
                            Shop.UNLOCK[1] = true;
                            shop.baby1Label.setValue("Available");
                        }
                        else {
                            shop.addObject(shop.noMoney, 400, 235);
                            Greenfoot.delay(20);
                            shop.removeObject(shop.noMoney);
                        }
                    }
                    break;
                case "Guy":
                    if (!Shop.SKIN.equals("Guy") && Shop.UNLOCK[2]) {
                        skinStatus(shop);
                        shop.guy1Label.setValue("Selected");
                        Shop.SKIN = "Guy";
                    }
                    else if (!Shop.UNLOCK[2]){
                        if (Shop.MONEY >= 265){
                            Shop.MONEY -= 265;
                            Shop.UNLOCK[2] = true;
                            shop.guy1Label.setValue("Available");
                        }
                        else {
                            shop.addObject(shop.noMoney, 400, 235);
                            Greenfoot.delay(20);
                            shop.removeObject(shop.noMoney);
                        }
                    }
                    break;
                case "Boy":
                    if (!Shop.SKIN.equals("Boy") && Shop.UNLOCK[3]) {
                        skinStatus(shop);
                        shop.boy1Label.setValue("Selected");
                        Shop.SKIN = "Boy";
                    }
                    else if (!Shop.UNLOCK[3]){
                        if (Shop.MONEY >= 599){
                            Shop.MONEY -= 599;
                            Shop.UNLOCK[3] = true;
                            shop.boy1Label.setValue("Available");
                        }
                        else {
                            shop.addObject(shop.noMoney, 400, 235);
                            Greenfoot.delay(20);
                            shop.removeObject(shop.noMoney);
                        }
                    }
                    break;
                case "Sheild":
                    skillStatus(shop);
                    shop.sheildLabel.setValue("Selected"); 
                    Shop.SKILL = "Sheild";
                    break;
                case "Speed":
                    skillStatus(shop);
                    shop.speedLabel.setValue("Selected");
                    Shop.SKILL = "Speed";
                    break;
                case "Score":
                    skillStatus(shop);
                    shop.scoreLabel.setValue("Selected");
                    Shop.SKILL = "Score";
                    break;
                case "Again":
                    Greenfoot.setWorld(new Solo());
                    break;
                case "AgainDouble":
                    Greenfoot.setWorld(new PlayerSelect());
                    break;
                case "BackMode":
                    Greenfoot.setWorld(new Mode());
                    break;
            }
        }
    }    
    private void skinStatus(Shop shop) {
        if (Shop.UNLOCK[0]) {
            shop.ppl1Label.setValue("Available");
        }
        if (Shop.UNLOCK[1]) {
            shop.baby1Label.setValue("Available");
        }
        if (Shop.UNLOCK[2]) {
            shop.guy1Label.setValue("Available");
        }
        if (Shop.UNLOCK[3]) {
            shop.boy1Label.setValue("Available");
        }
    }
    private void skillStatus(Shop shop) {
        shop.sheildLabel.setValue("Available");
        shop.speedLabel.setValue("Available");
        shop.scoreLabel.setValue("Available");
    }
    public String getName() {
        return this.name;
    }
}
       

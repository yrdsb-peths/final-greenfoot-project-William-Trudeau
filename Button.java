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
    Shop shop;
    Guide guide;
    GifImage logoImage = new GifImage("logo.gif");
    GreenfootSound clickSound = new GreenfootSound("click.wav");
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
        buttonMoved();
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
    public void buttonMoved() {
        if (Greenfoot.mouseMoved(this)&& !this.name.equals("Logo") && !this.name.equals("null")) {
            if (getWorld() instanceof Guide) {
                guide = (Guide)getWorld();
            }
            switch (this.name) {
                case "1":
                    guideClean(guide);
                    guide.addObject(guide.g1, 400, 430);
                    break;
                case "2":
                    guideClean(guide);
                    guide.addObject(guide.g2, 400, 430);
                    break;
                case "3":
                    guideClean(guide);
                    guide.addObject(guide.g3, 400, 430);
                    break;
                case "4":
                    guideClean(guide);
                    guide.addObject(guide.g4, 400, 430);
                    break;
                case "5":
                    guideClean(guide);
                    guide.addObject(guide.g5, 400, 430);
                    break;
                case "6":
                    guideClean(guide);
                    guide.addObject(guide.g6, 400, 430);
                    break;
                case "7":
                    guideClean(guide);
                    guide.addObject(guide.g7, 400, 430);
                    break;
                case "8":
                    guideClean(guide);
                    guide.addObject(guide.g8, 400, 430);
                    break;
                case "9":
                    guideClean(guide);
                    guide.addObject(guide.g9, 400, 430);
                    break;
                case "10":
                    guideClean(guide);
                    guide.addObject(guide.g10, 400, 430);
                    break;
            }
        }
    }
    public void buttonClicked() {
        if (Greenfoot.mouseClicked(this)) {
            if (getWorld() instanceof Shop) {
                shop = (Shop) getWorld();
            }    
            clickSound.play();
            switch (this.name) {
                case "StartButton":
                    ((Menu)getWorld()).background.stop();
                    Greenfoot.setWorld(new Mode());
                    break;
                case "GuideButton":
                    Greenfoot.setWorld(new Guide());
                    break;
                case "ShopButton":
                    Greenfoot.setWorld(new Shop());
                    break;
                case "Back":
                    if (getWorld() instanceof Mode) {
                        ((Mode)getWorld()).background.stop();
                    }
                    Greenfoot.setWorld(new Menu());
                    break;
                case "Solo":
                    ((Mode)getWorld()).background.stop();
                    Greenfoot.setWorld(new Solo());
                    break;
                case "Double":
                    ((Mode)getWorld()).background.stop();
                    Greenfoot.setWorld(new Double());
                case "Crazy":
                    ((Mode)getWorld()).addObject(((Mode)getWorld()).notReady, 400, 250);
                    Greenfoot.delay(50);
                    ((Mode)getWorld()).removeObject(((Mode)getWorld()).notReady);
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
                    ((Solo)getWorld()).background.stop();
                    Greenfoot.setWorld(new Solo());
                    break;
                case "AgainDouble":
                    ((Double)getWorld()).background.stop();
                    Greenfoot.setWorld(new Double());
                    break;
                case "BackMode":
                    if (getWorld() instanceof Solo) {
                        ((Solo)getWorld()).background.stop();
                    }
                    else {
                        ((Double)getWorld()).background.stop();
                    }
                    Greenfoot.setWorld(new Mode());
                    break;
            }
        }
    }    
    public void skinStatus(Shop shop) {
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
    public void skillStatus(Shop shop) {
        shop.sheildLabel.setValue("Available");
        shop.speedLabel.setValue("Available");
        shop.scoreLabel.setValue("Available");
    }
    public void guideClean(Guide guide){
        guide.removeObject(guide.g1);
        guide.removeObject(guide.g2);
        guide.removeObject(guide.g3);
        guide.removeObject(guide.g4);
        guide.removeObject(guide.g5);
        guide.removeObject(guide.g6);
        guide.removeObject(guide.g7);
        guide.removeObject(guide.g8);
        guide.removeObject(guide.g9);
        guide.removeObject(guide.g10);
    }
    public String getName() {
        return this.name;
    }
}
       

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
                case "Solo":
                    Greenfoot.setWorld(new Solo("fas", "dawd"));
                    break;
                    
            } 
        }
    }
    public String getName() {
        return this.name;
    }
}
       

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The buttons class to 
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        if (Greenfoot.mouseClicked(this)) {
            switch (this.name) {
                case "StartButton":
                    Greenfoot.setWorld(new Levels());
                case "GuideButton":
                    Greenfoot.setWorld(new Guide());
                case "ShopButton":
                    Greenfoot.setWorld(new Shop());
            } 
        }
        if (this.name == "Logo") {
            this.setImage(logoImage.getCurrentImage());
        }    
         transparent();
    }    
    /**
     * When mouse moved on to the button, the button will change transparency. That way user can clearly know which button they are on.
     */    
    private void transparent() {
        if (Greenfoot.mouseMoved(this) && this.name != "Logo") {
            this.getImage().setTransparency(180);
        }
        else if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            this.getImage().setTransparency(255);
        }
    }
}
       

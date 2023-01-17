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
        if (this.name == "Logo") {
            this.setImage(logoImage.getCurrentImage());
        }    
         transparent();
    }    
    /**
     * When mouse moved on to the button, the button will change transparency.
     * That way user can easily know which button they are on.
     */    
    private void transparent() {
        if (Greenfoot.mouseMoved(this) && this.name != "Logo") {
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
                    Greenfoot.setWorld(new Levels());
                case "GuideButton":
                    Greenfoot.setWorld(new Guide());
                case "ShopButton":
                    Greenfoot.setWorld(new Shop());
                case "1":
                    Greenfoot.setWorld(new Level1());
                case "2":
                    Greenfoot.setWorld(new Level2());
                case "3":
                    Greenfoot.setWorld(new Level3());
                case "4":
                    Greenfoot.setWorld(new Level4());
                case "5":
                    Greenfoot.setWorld(new Level5());
                case "6":
                    Greenfoot.setWorld(new Level6());
                case "7":
                    Greenfoot.setWorld(new Level7());
                case "8":
                    Greenfoot.setWorld(new Level8());  
                case "9":
                    Greenfoot.setWorld(new Level9());
                case "10":
                    Greenfoot.setWorld(new Level10()); 
            } 
        }
    }
    
    public String getName() {
        return this.name;
    }
}
       

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameDefault Menu for Player to slected different sub Menu.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Menu extends World
{
    GreenfootSound background = new GreenfootSound("menu.mp3");
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        Button logo = new Button("Logo");
        addObject(logo, 400, 100);
        logo.setImage("logo.gif");
        Button start = new Button("StartButton");
        addObject(start, 400, 235);
        start.setImage("button_start.png"); 
        Button guide = new Button("GuideButton");
        addObject(guide, 400, 330);
        guide.setImage("button_guide.png");
        Button shop = new Button("ShopButton");
        addObject(shop, 400, 425);
        shop.setImage("button_shop.png");
    }
    public void started() {
        background.setVolume(35);
        background.playLoop();
    }
    public void stopped() {
        background.stop();
    }
}

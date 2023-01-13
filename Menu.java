import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * GameStart Menu
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Menu extends World
{
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        Button logo = new Button("Logo");
        addObject(logo, 400, 85);
        logo.setImage("logo.gif");
        Button start = new Button("StartButton");
        addObject(start, 400, 220);
        start.setImage("button_start.png"); 
    }
}

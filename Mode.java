import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Mode extends World
{
    Button logo = new Button("Logo");
    Button back = new Button("Back");
    Button infiniteSolo = new Button("Solo");
    Button infiniteDouble = new Button("Double");
    Button infiniteCrazy = new Button("Crazy");
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Mode()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        addObject(logo, 400, 100);
        addObject(back, 68, 28);
        back.setImage("button_back.png");
        addObject(infiniteSolo, 400, 250);
        infiniteSolo.setImage("button_infinite-solo.png");
        addObject(infiniteDouble, 400, 350);
        infiniteDouble.setImage("button_infinite-double.png");
        addObject(infiniteCrazy, 400, 450);
        infiniteCrazy.setImage("button_infinite-crazy.png");
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Levels extends World
{
    /**
     * Constructor for objects of class Levels.
     * 
     */
    public Levels()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        Button infiniteMode = new Button("InfiniteMode");
        addObject(infiniteMode, 400, 400 );
        infiniteMode.setImage("button_infinite-mode.png");
    }
}

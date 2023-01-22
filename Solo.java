import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solo extends World
{
    int level;
    Label cd = new Label("CD:", 20 );
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Solo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        Player player = new Player(Shop.SKIN, Shop.SKILL, 1);
        addObject(player, 400, 225);
        
    }
    public void timeScore() {
        
    }
    public void createFireball() {
        
    }
    public void createArrow() {
        
    }
    public void createBomb() {
        
    }
    public void createBanana() {
        
    }
    public void createHamburger() {
        
    }
    public void gameOver() {
        
    }
}

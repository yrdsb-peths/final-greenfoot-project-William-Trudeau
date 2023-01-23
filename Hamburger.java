import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hamburger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hamburger extends Actor
{
    static int score;
    SimpleTimer timer = new SimpleTimer();
    public Hamburger() {
        timer.mark();
    }
    /**
     * Act - do whatever the Hamburger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(timer.millisElapsed() > 5000) {
            getWorld().removeObject(this);
        }
    }
    public void level(int level) {
        score += 500;
    }
    
    public int getScore() {
        return score;
    }
}

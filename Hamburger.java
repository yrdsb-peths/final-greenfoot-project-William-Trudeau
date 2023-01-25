import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hamburger
 * 
 * William Wang
 * 1.0.0
 */
public class Hamburger extends Actor
{
    static int score = 1000;
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
        score = (level/3)*500 + 1000;
    }
}

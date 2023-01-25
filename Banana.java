import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Banana
 * 
 * William Wang
 * 1.0.0
 */
public class Banana extends Actor
{
    static int score = 500;
    SimpleTimer timer = new SimpleTimer();
    public Banana() {
        timer.mark();
    }
    /**
     * Act - do whatever the Hamburger wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(timer.millisElapsed() > 1500) {
            getWorld().removeObject(this);
        }
    }
    public void level(int level) {
        score = (level/2)*100+500; 
    }
}

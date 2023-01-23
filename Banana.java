import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Banana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Banana extends Actor
{
    static int score = 10000;
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
        score += 100;
    }
}

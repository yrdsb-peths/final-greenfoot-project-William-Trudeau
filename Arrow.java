import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{
    static int speed = 1;
    SimpleTimer timer = new SimpleTimer();
    public Arrow(int level) {
        timer.mark();
    }
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY();
        if (timer.millisElapsed() > 10) {
            setLocation(x, y+speed);
            timer.mark();
        }    
        if(getY() >= 530) {
            getWorld().removeObject(this);
        }
    }
    public static void level(int level) {
        speed = level % 10 == 0 ? speed+1: speed;
    }
}

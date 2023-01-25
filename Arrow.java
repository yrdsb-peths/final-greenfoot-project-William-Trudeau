import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrow
 * 
 * William Wang
 * 1.0.0
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
        if (timer.millisElapsed() > 8) {
            setLocation(x, y+speed);
            timer.mark();
        }    
        if(getY() >= 530) {
            getWorld().removeObject(this);
        }
    }
    public static void level(int level) {
        speed = (level/10)*1+1;
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Fireball
 * 
 * William Wang
 * 1.0.0
 */
public class Fireball extends Actor
{
    static int speed = 1;
    int side;
    SimpleTimer timer = new SimpleTimer();
    public Fireball(int level, int side) {
        this.side = side;
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
        if (side == 0 && timer.millisElapsed() > 10) {
            setLocation(x+speed, y+speed);
            timer.mark();
        }
        else if (side == 1 && timer.millisElapsed() > 10) {
            setLocation(x-speed, y+speed);
            timer.mark();
        }
        if(getY() >= 530) {
            getWorld().removeObject(this);
        }
    }
    public static void level(int level) {
        speed = (level/5)*1+1;
    }
}

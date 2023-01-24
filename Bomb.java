import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    static int speed = 1;
    int side;
    static int score = 1000; 
    SimpleTimer timer = new SimpleTimer();
    public Bomb(int level, int side) {
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
            setLocation(x+speed, y);
            timer.mark();
        }
        else if (side == 1 && timer.millisElapsed() > 10) {
            setLocation(x-speed, y);
            timer.mark();
        }
        else if (side == 2 && timer.millisElapsed() > 10) {
            setLocation(x, y+speed);
            timer.mark();
        }
        else if (side == 3 && timer.millisElapsed() > 10) {
            setLocation(x, y-speed);
            timer.mark();
        }
        if(getY() >= 545 || getY() <= 5 || getX() >= 795 || getX() <= 5 ) {
            getWorld().removeObject(this);
        }
    }
    public static void level(int level) {
        speed = (level/3)*1+1;
        score = (level/3)*1000+1000;
    }
}

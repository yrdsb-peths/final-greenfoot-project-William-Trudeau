import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int speed = 1;
    double score = 1;
    int player = 1;
    String skill;
    String skin;
    boolean isUse = false;
    boolean sheild = false;
    boolean firstTime = true;
    SimpleTimer cd = new SimpleTimer();
    SimpleTimer timer = new SimpleTimer();
    public Player(String skin, String skill, int player) {
        this.skill = skill;
        this.skin = skin;
        this.player = player;
        if (skill.equals("Score")) {
            this.score = 1.5;
        }
        doSkin();
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        control();
        check();
    }
    private void control() {
        if (this.player == 1) {
            if(Greenfoot.isKeyDown("w")) {
                setLocation(getX(),getY()-(3*speed));
            }
            else if (Greenfoot.isKeyDown("a")) {
                setLocation(getX()-(3*speed),getY());
            }
            else if (Greenfoot.isKeyDown("s")) {
                setLocation(getX(),getY()+(3*speed));
            }
            else if (Greenfoot.isKeyDown("d")) {
                setLocation(getX()+(3*speed),getY());
            }
            else if (Greenfoot.isKeyDown("f")) {
                skill();
            }
        }
        else {
            if(Greenfoot.isKeyDown("up")) {
                setLocation(getX(),getY()-(3*speed));
            }
            else if (Greenfoot.isKeyDown("left")) {
                setLocation(getX()-(3*speed),getY());
            }
            else if (Greenfoot.isKeyDown("down")) {
                setLocation(getX(),getY()+(3*speed));
            }
            else if (Greenfoot.isKeyDown("right")) {
                setLocation(getX()+(3*speed),getY());
            }
            else if (Greenfoot.isKeyDown("f")) {
                skill();
            }
        }
    }
    private void skill() {
        switch (this.skill) {
            case "Sheild":
                if (cd.millisElapsed() > 8000 && !isUse) {
                    sheild = true;
                    timer.mark();
                    GreenfootImage sheildImage = new GreenfootImage("sheild.png");
                    sheildImage.scale(72, 72);
                    this.setImage(sheildImage);
                }
                else if (firstTime) {
                    sheild = true;
                    timer.mark();
                    isUse = true;
                    GreenfootImage sheildImage = new GreenfootImage("sheild.png");
                    sheildImage.scale(72, 72);
                    this.setImage(sheildImage);
                }
                break;
            case "Speed":
                if (cd.millisElapsed() > 6000 && !isUse) {
                    speed = 3;
                    timer.mark();
                    isUse = true;
                    GreenfootImage speedImage = new GreenfootImage("speed.png");
                    speedImage.scale(100, 100);
                    this.setImage(speedImage);
                }
                else if (firstTime) {
                    speed = 3;
                    timer.mark();
                    isUse = true;
                    GreenfootImage speedImage = new GreenfootImage("speed.png");
                    speedImage.scale(80, 80);
                    this.setImage(speedImage);
                }
                break;
        }
    }
    private void check() {
        switch (this.skill) {
            case "Sheild":
                if (timer.millisElapsed() > 3000 && isUse) {
                    sheild = false;
                    cd.mark();
                    isUse = false;
                    doSkin();
                }
                break;
            case "Speed":
                if (timer.millisElapsed() > 2000 && isUse) {
                    speed = 1;
                    cd.mark();
                    isUse = false;
                    doSkin();
                }
                break;
            }    
    }
    private void doSkin() {
        if (this.player == 1) {
            switch (this.skin) {
                case "Default":
                    this.setImage("ppl1.png");
                    break;
                case "Baby":
                    this.setImage("baby1.png");
                    break;
                case "Guy":                        
                    this.setImage("guy1.png");
                    break;
                case "Boy":
                    this.setImage("boy1.png");
                    break;
            }
        }
        else if (this.player == 2){
            switch (this.skin) {
                case "Default":
                    this.setImage("ppl2.png");
                    break;
                case "Baby":
                    this.setImage("baby2.png");
                    break;
                case "Guy":                        
                    this.setImage("guy2.png");
                    break;
                case "Boy":
                    this.setImage("boy2.png");
                    break;
            }
        }
    }
}

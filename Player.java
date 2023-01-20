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
    int score = 1;
    int player = 1;
    public Player(String Skin,String skill, int player) {
        
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        control();
        doSkin();
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
        }
    }
    private void doSkin() {
        switch (Menu.SKIN) {
            case "default":
                break;
            case "default2":
                this.setImage("ppl2.png");
            case "baby1":
                this.setImage("baby1.png");
                break;
            case "baby2":
                this.setImage("baby2.png");
                break;
            case "guy1":
                this.setImage("guy1.png");
                break;
            case "guy2":
                this.setImage("guy2.png");
                break;
            case "boy1":
                this.setImage("boy1.png");
                break;
            case "boy2":
                this.setImage("boy2.png");
                break;
        }
    }
    private void doSkill() {
        
    }
}

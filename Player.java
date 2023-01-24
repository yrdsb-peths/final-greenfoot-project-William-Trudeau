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
    int score = 0;
    int multi = 1;
    int player = 1;
    String skill;
    String skin;
    boolean isUse = false;
    boolean isCD = false;
    boolean sheild = false;
    boolean firstTime = true;
    boolean death = false;
    SimpleTimer cd = new SimpleTimer();
    SimpleTimer timer = new SimpleTimer();
    GreenfootSound damage = new GreenfootSound("damage.wav");
    GreenfootSound reward = new GreenfootSound("reward.wav");
    public Player(String skin, String skill, int player) {
        this.skill = skill;
        this.skin = skin;
        this.player = player;
        if (skill.equals("Score")) {
            this.score = 2;
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
        touch();
    }
    public void touch() {
        if(isTouching(Fireball.class))
        {
            damage.play();
            if (getWorld() instanceof Solo && sheild == false) {
                ((Solo)getWorld()).gameOver();
                getWorld().removeObject(this);
            }
            else if (getWorld() instanceof Double && sheild == false) {
                this.death = true;
                ((Double)getWorld()).gameOver();
                getWorld().removeObject(this);
            }
            return;
        }
        if(isTouching(Arrow.class))
        {
            damage.play();
            if (getWorld() instanceof Solo && sheild == false) {
                ((Solo)getWorld()).gameOver();
                getWorld().removeObject(this);
            }
            else if (getWorld() instanceof Double && sheild == false) {
                this.death = true;
                ((Double)getWorld()).gameOver();
                getWorld().removeObject(this);
            }
            return;
        }
        if(isTouching(Bomb.class))
        {
            damage.play();
            removeTouching(Bomb.class);
            this.score -= Bomb.score;
        }
        if(isTouching(Banana.class))
        {
            reward.play();
            removeTouching(Banana.class);
            this.score += Banana.score*multi;
        }
        if(isTouching(Hamburger.class))
        {
            reward.play();
            removeTouching(Hamburger.class);
            this.score += Hamburger.score*multi;
        }
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
            else if (Greenfoot.isKeyDown("l")) {
                skill();
            }
        }
    }
    private void skill() {
        switch (this.skill) {
            case "Sheild":
                if ((cd.millisElapsed() > 8000 && !isUse) || firstTime) {
                    sheild = true;
                    timer.mark();
                    isUse = true;
                    firstTime = false;
                    GreenfootImage sheildImage = new GreenfootImage("sheild.png");
                    sheildImage.scale(72, 72);
                    this.setImage(sheildImage);
                    isCD = false;
                }
                break;
            case "Speed":
                if ((cd.millisElapsed() > 6000 && !isUse) || firstTime) {
                    speed = 3;
                    timer.mark();
                    isUse = true;
                    isCD = false;
                    firstTime = false;
                    GreenfootImage speedImage = new GreenfootImage("speed.png");
                    speedImage.scale(100, 100);
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
                    isCD = true;
                    doSkin();
                }
                break;
            case "Speed":
                if (timer.millisElapsed() > 2000 && isUse) {
                    speed = 1;
                    cd.mark();
                    isUse = false;
                    isCD = true;
                    doSkin();
                }
                break;
            }   
        if ((cd.millisElapsed() > 6000 && !isUse) || firstTime) {
            isCD = false;
        }
        else {
            isCD = true;
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

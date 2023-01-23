import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Solo extends World
{
    int level = 1;
    int score = 0;
    Label showLevel = new Label("Level: "+ level, 36  );
    Label cd = new Label("CD:", 20 );
    Label showScore = new Label("Score: " + score, 35);
    Player player = new Player(Shop.SKIN, Shop.SKILL, 1);
    SimpleTimer timerFireball = new SimpleTimer();
    SimpleTimer timerArrow = new SimpleTimer();
    SimpleTimer timerBomb = new SimpleTimer();
    SimpleTimer timerBanana = new SimpleTimer();
    SimpleTimer timerHamburger = new SimpleTimer();
    SimpleTimer timer = new SimpleTimer();
    Button again = new Button("Again");
    Button back = new Button("BackMode");
    
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Solo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        addObject(player, 400, 225);
        addObject(showScore, 400, 20);
        addObject(showLevel, 63, 20);
        timer.mark();
        timerFireball.mark();
        timerArrow.mark();
        timerBomb.mark();
        timerBanana.mark();
        timerHamburger.mark();
    }
    public void act() {
        if (timerFireball.millisElapsed() > 5000-(level*10)) {
            createFireball();
            timerFireball.mark();
        }
        if (timerArrow.millisElapsed() > 6500) {
            createArrow();
            timerArrow.mark();
        }
        if (timerBomb.millisElapsed() > 10000) {
            createBomb();
            timerBomb.mark();
        }
        if (timerBanana.millisElapsed() > 3500) {
            createBanana();
            timerBanana.mark();
        }
        if (timerHamburger.millisElapsed() > 8000) {
            createHamburger();
            timerHamburger.mark();
        }
        timeScore();
        levelUp();
    }
    public void timeScore() {
        if (timer.millisElapsed() > 10) {
            score += 6;
            showScore.setValue("Score: " + score);
            timer.mark();
        }
    }
    public void createFireball() {
        int amount = Greenfoot.getRandomNumber(4);
        for (int i = amount+1; i > 0; i--) {
            int side = Greenfoot.getRandomNumber(2);
            Fireball fireball = new Fireball(level, side);
            int y = Greenfoot.getRandomNumber(550);
            GreenfootImage image = new GreenfootImage("fireball.png");
            image.scale(60, 60);
            fireball.setImage(image);
            if (side == 0) {
                image.mirrorHorizontally();
                addObject(fireball, 0, y);
            }
            else {
                addObject(fireball, 800, y);
            }
        }
    }
    public void createArrow() {
        int amount = Greenfoot.getRandomNumber(3+(level/10));
        for (int i = amount+1; i > 0; i--) {
            Arrow arrow = new Arrow(level);
            int x = Greenfoot.getRandomNumber(800);
            GreenfootImage image = new GreenfootImage("arrow.png");
            image.scale(80, 80);
            arrow.setImage(image);
            addObject(arrow, x, 0);
        }    
    }
    public void createBomb() {
        int amount = Greenfoot.getRandomNumber(4);
        for (int i = amount+1; i > 0; i--) {
            int side = Greenfoot.getRandomNumber(4);
            Bomb bomb = new Bomb(level, side);
            int x = Greenfoot.getRandomNumber(794);
            int y = Greenfoot.getRandomNumber(544);
            GreenfootImage image = new GreenfootImage("bomb.png");
            image.scale(60, 60);
            bomb.setImage(image);
            if (side == 0) {
                addObject(bomb, 6, y);
            }
            else if (side == 1) {
                addObject(bomb, 794, y);
            }
            else if (side == 2) {
                addObject(bomb, x, 6);
            }
            else if (side == 3) {
                addObject(bomb, x, 544);
            }
        }
    }
    public void createBanana() {
        int amount = Greenfoot.getRandomNumber(4);
        for (int i = amount+1; i > 0; i--) {
            Banana banana = new Banana();
            int x = Greenfoot.getRandomNumber(800);
            int y = Greenfoot.getRandomNumber(550);
            GreenfootImage image = new GreenfootImage("banana.png");
            image.scale(50, 50);
            banana.setImage(image);
            addObject(banana, x, y);
        }    
    }
    public void createHamburger() {
        Hamburger hamburger = new Hamburger();
        int x = Greenfoot.getRandomNumber(800);
        int y = Greenfoot.getRandomNumber(550);
        GreenfootImage image = new GreenfootImage("hamburger.png");
        image.scale(50, 50);
        hamburger.setImage(image);
        addObject(hamburger, x, y);  
    }
    public void levelUp() {
        if (level*1500 < score-1500) {
            level += 1;
            showLevel.setValue("Level: "+level);
            Fireball.level(level);
            Arrow.level(level);
            Bomb.level(level);
        }
    }
    public void gameOver() {
        
    }
}

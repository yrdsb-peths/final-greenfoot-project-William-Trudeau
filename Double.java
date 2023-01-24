import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Double here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Double extends World
{
    int level = 1;
    int gameScore = 0;
    Player player = new Player("Default", "Sheild", 1);
    Player player2 = new Player("Default", "Speed", 2);
    Label showLevel = new Label("Level: "+ level, 36  );
    Label cd = new Label("CD: ", 35 );
    Label cd2 = new Label("CD: ", 35);
    Label showScore = new Label("GameScore: " + gameScore, 35);
    Label showScore1 = new Label("Score: " + player.score, 25);
    Label showScore2 = new Label("Score: " + player2.score, 25);
    Label gameOver = new Label("Winner - ", 100);
    Label money = new Label("$ "+gameScore/10,35);
    boolean isGameOver = false;
    SimpleTimer timerFireball = new SimpleTimer();
    SimpleTimer timerArrow = new SimpleTimer();
    SimpleTimer timerBomb = new SimpleTimer();
    SimpleTimer timerBanana = new SimpleTimer();
    SimpleTimer timerHamburger = new SimpleTimer();
    SimpleTimer timer = new SimpleTimer();
    Button again = new Button("AgainDouble");
    Button back = new Button("BackMode");
    GreenfootSound background = new GreenfootSound("game.mp3");
    /**
     * Constructor for objects of class Game.
     * 
     */
    public Double()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1);
        addObject(player, 300, 225);
        addObject(player2, 500, 225);
        addObject(showScore, 400, 20);
        addObject(showScore1, 60, 522);
        addObject(showScore2, 740, 522);
        addObject(showLevel, 63, 20);
        addObject(cd, 220, 520);
        addObject(cd2, 580, 520);
        addObject(money, 720, 20);
        timer.mark();
        timerFireball.mark();
        timerArrow.mark();
        timerBomb.mark();
        timerBanana.mark();
        timerHamburger.mark();
        background.setVolume(8);
        background.playLoop();
    }
    public void act() {
        if (!isGameOver) {
            if (timerFireball.millisElapsed() > 5000-(level*100)) {
                createFireball();
                timerFireball.mark();
            }
            if (timerArrow.millisElapsed() > 6500-(level*100)) {
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
            if (timerHamburger.millisElapsed() > 8000-(level*100)) {
                createHamburger();
                timerHamburger.mark();
            }
            updateCD();
            timeScore();
            levelUp();
            money.setValue("$ "+gameScore/15);
        }    
    }
    public void updateCD() {
        //Player 1
        if (!player.isUse && player.isCD) {
            cd.setValue("CD: Cooldown");
        }
        else if (!player.isUse) {
            cd.setValue("CD: Ready");
        }
        else if (player.isUse) {
            cd.setValue("CD: Using");
        }
        //Player 2
        if (!player2.isUse && player2.isCD) {
            cd2.setValue("CD: Cooldown");
        }
        else if (!player2.isUse) {
            cd2.setValue("CD: Ready");
        }
        else if (player2.isUse) {
            cd2.setValue("CD: Using");
        }
    }
    public void timeScore() {
        if (timer.millisElapsed() > 10) {
            if (!player.death) {
                player.score += 6;
            }    
            if (!player2.death) {
                player2.score += 6;
            }
            gameScore = (player.score+player2.score)/2;
            showScore.setValue("GameScore: " + gameScore);
            showScore1.setValue("Score: " + player.score);
            showScore2.setValue("Score: " + player2.score);
            timer.mark();
        }
    }
    public void createFireball() {
        int amount = Greenfoot.getRandomNumber(4+(level/8));
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
        int amount = Greenfoot.getRandomNumber(3+(level/5));
        for (int i = amount+1; i > 0; i--) {
            Arrow arrow = new Arrow(level);
            int x = Greenfoot.getRandomNumber(800);
            GreenfootImage image = new GreenfootImage("arrow.png");
            image.scale(70, 70);
            arrow.setImage(image);
            addObject(arrow, x, 0);
        }    
    }
    public void createBomb() {
        int amount = Greenfoot.getRandomNumber(4+(level/10));
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
        int amount = Greenfoot.getRandomNumber(4+(level/10));
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
        level = gameScore/1500+1;
        showLevel.setValue("Level: "+level);
        Fireball.level(level);
        Arrow.level(level);
        Bomb.level(level);
    }
    public void gameOver() {
        if (player.death && player2.death){
            isGameOver = true;
            back.setImage("back.png");
            again.setImage("again.png");
            addObject(gameOver, 400, 220);
            if (player.score > player2.score) {    
                gameOver.setValue("Winner: Player1");
            }    
            else if (player.score == player2.score) {
                gameOver.setValue("Tie");
            }
            else {
                gameOver.setValue("Winner: Player2");
            }
            addObject(back, 300, 320);
            addObject(again, 500, 320);
            Shop.MONEY += gameScore/15;
        }    
    }
}

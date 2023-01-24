import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Shop extends World
{
    static int MONEY = 200;
    static String SKIN = "Default";
    static String SKILL = "Speed";
    static boolean[] UNLOCK = {true, false, false, false};
    
    Label ppl1Label = new Label("Selected", 20);
    Label baby1Label = new Label("Price: 100", 20);
    Label guy1Label = new Label("Price: 265", 20);
    Label boy1Label = new Label("Price: 599", 20);
    
    Button back = new Button("Back");
    Button box = new Button("null"); 
    Button shop = new Button("null");
    
    Button ppl1 = new Button("Default");
    Button baby1 = new Button("Baby");
    Button guy1 = new Button("Guy");
    Button boy1 = new Button("Boy");
    
    Label useSkin = new Label("Skin: "+SKIN, 40);
    Label useSkill = new Label("Skill: "+SKILL, 40);
    Label noMoney = new Label("Not Enough Money", 80);
    Label money = new Label("$"+MONEY, 40);
    
    Button sheild = new Button("Sheild");
    Button speed = new Button("Speed");
    Button score = new Button("Score");
    
    Label sheildLabel = new Label("Selected", 20);
    Label speedLabel = new Label("Available", 20);
    Label scoreLabel = new Label("Available", 20);
    /**
     * Constructor for objects of class Shop.
     * 
     */
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        setMenu();
        setShop();
        setStatus();
    }
    public void act() {
        useSkin.setValue("Skin: "+SKIN);
        useSkill.setValue("Skill: "+SKILL);
        money.setValue("$"+MONEY);
    }
    private void setMenu() {
        addObject(back, 68, 28);
        back.setImage("button_back.png");  
        addObject(box, 400, 300);
        box.setImage("button_box.png"); 
        addObject(shop, 400, 70);
        shop.setImage("shop.png");
    }
    private void setShop() {
        addObject(ppl1, 100, 220);
        ppl1.setImage("ppl1.png"); 
        addObject(baby1, 300, 220);
        baby1.setImage("baby1.png");
        addObject(guy1, 500, 220);
        guy1.setImage("guy1.png"); 
        addObject(boy1, 700, 220);
        boy1.setImage("boy1.png");
        
        addObject(sheild, 200, 330);
        GreenfootImage sheildImage = new GreenfootImage("sheild.png");
        sheildImage.scale(72, 72);
        sheild.setImage(sheildImage);
        
        addObject(speed, 400, 320);
        GreenfootImage speedImage = new GreenfootImage("speed.png");
        speedImage.scale(100, 100);
        speed.setImage(speedImage);
        
        addObject(score, 600, 330);
        GreenfootImage scoreImage = new GreenfootImage("score.png");
        scoreImage.scale(80, 80);
        score.setImage(scoreImage);
    }
    private void setStatus() {
        addObject(ppl1Label, 100, 275); 
        addObject(baby1Label, 300, 275);
        addObject(guy1Label, 500, 275);
        addObject(boy1Label, 700, 275);
        
        addObject(sheildLabel, 200, 390); 
        addObject(speedLabel, 400, 390);
        addObject(scoreLabel, 600, 390);
        
        addObject(useSkin, 300, 480);
        addObject(useSkill, 500, 480);
        addObject(money, 720, 25);
    }
}

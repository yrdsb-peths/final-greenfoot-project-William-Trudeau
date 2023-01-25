import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Guide for Players
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Guide extends World
{
    private int width;
    private int height;
    //Button Array
    private Button[] levelsButton = new Button[10];
    //Labels for different buttons
    Label g1 = new Label("Welcome to Crazy Dodge!\nHere is Guide Menu, which\nyou can move your mouse on\n different button to see\n how this game working!", 30);
    Label g2 = new Label("Money is what you can earn\n through playing. Purchase\n different cool skins in Shop!\n Every 15 score equal to\n 1 dollar!", 30);
    Label g3 = new Label("Solo\nYou have to avoid touching\n Fireball and Arrow!\n 'W','A','S','D' are control keys!\n 'F' is the skill Key!", 30);
    Label g4 = new Label("Double\n You have to beat your friend\n with the higher score.\n 'Left','Up','Right','Down' are the\n control key of player 2!\n 'L' is the skill Key!\nFor fair, you can't choose skin and skill!", 30);
    Label g5 = new Label("Skill\nSheild - CD 8s, Last 3s, Default\nNo Damage Taken\nSpeed - CD 6s, Last 2s, Locked\nBoost 3x Moving Speed\nScore - 2x Score collect Food\nLocked", 30);
    Label g6 = new Label("Fireball\nSpawn only at right and left.\nSpawn every 5s\nEvery 10 Level reduce 1s\nEvery 5 Level speed +1", 30);
    Label g7 = new Label("Arrow\nSpawn only at top.\nspawn every 6.5s\nEvery 10 level reduce 1s\nEvery 10 Level speed +1", 30);
    Label g8 = new Label("Bomb\nSpawn any side.\nSpawn every 10s\nEvery 3 level speed +1\nTouch will lose score!", 30);
    Label g9 = new Label("Banana\nSpawn anywhere.\nSpawn every 3.5s\nEvery 2 level will score +100!", 30);
    Label g10 = new Label("Hamburger\nSpawn anywhere.\nSpawn every 8s\nEvery 10 level reduce 1s\nEvery 3 level will score +500!", 30);
    
    Button guide = new Button("null");
    Button textbox = new Button("null");
    Button back = new Button("Back");
    /**
     * Constructor for objects of class Guide.
     * 
     */
    public Guide()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        addObject(guide, 400, 65);
        addObject(textbox, 400, 435);
        addObject(back, 68, 28);
        addObject(g1, 400, 430);
        back.setImage("button_back.png");
        guide.setImage("guide.png");
        textbox.setImage("textbox.png");
        //Quickly creating button in Array
        for (int i = 0; i < 10; i++) {
            String str = Integer.toString(i+1);
            levelsButton[i] = new Button(str);
        }
        //Quickly setting image for Array
        for (Button i: levelsButton) {
            addObject(i, 150+width, 170+height);
            i.setImage(i.getName()+".png");
            width += 125;
            width = Integer.parseInt(i.getName()) == 5 ? 0: width;
            height = Integer.parseInt(i.getName()) >= 5 ? 100 : 0;
        }
    }
}

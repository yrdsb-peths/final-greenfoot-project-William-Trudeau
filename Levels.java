import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Levels extends World
{
    int width;
    int height;
    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Levels()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 550, 1); 
        Button[] levelsButton = new Button[10];
        for (int i =0; i < 10; i++) {
            String str = Integer.toString(i);
            levelsButton[i] = new Button(str);
        }
        levelsButton[0] = new Button("1");
        levelsButton[1] = new Button("2");
        Button two = new Button("3");
        Button three = new Button("4");
        Button four = new Button("5");
        Button five = new Button("6");
        Button six = new Button("7");
        Button seveen = new Button("8");
        Button eight = new Button("9");
        Button nine = new Button("10");
        for (Button i: levelsButton) {
            addObject(i, 200+width, 200);
            i.setImage(i.getName());
            width += 20;
            height = i.equals(levelsButton[5]) ? 300 : 200;
        }

    }
}

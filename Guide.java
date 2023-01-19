import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guide here.
 * 
 * @author William Wang
 * @version 1.0.0
 */
public class Guide extends World
{
    private int width;
    private int height;
    private Button[] levelsButton = new Button[10];
    Label level1 = new Label("test", 40);
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
        back.setImage("button_back.png");
        guide.setImage("guide.png");
        textbox.setImage("textbox.png");
        for (int i = 0; i < 10; i++) {
            String str = Integer.toString(i+1);
            levelsButton[i] = new Button(str);
        }
        for (Button i: levelsButton) {
            addObject(i, 150+width, 170+height);
            i.setImage(i.getName()+".png");
            width += 125;
            width = Integer.parseInt(i.getName()) == 5 ? 0: width;
            height = Integer.parseInt(i.getName()) >= 5 ? 100 : 0;
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button that leads to the instruction screen
 * 
 * @author Adam Li 
 * @version 1.0
 */
public class InstructionButton extends Button
{

    public InstructionButton(String name)
    {
        super(name);
    }    
    
    /**
     * Decides what to do when pressed,
     * Loads the instruction screen
     */
    public void buttonPressed(){
        Greenfoot.setWorld(new Screen(3));
    }
}

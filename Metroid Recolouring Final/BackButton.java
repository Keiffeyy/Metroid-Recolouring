import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button that leads back to the main menu
 * 
 * @author Adam Li  
 * @version 1.0
 */
public class BackButton extends Button
{
    public BackButton(String name)
    {
        super(name);
    }
    
    public void buttonPressed()
    {
        if (getWorld() instanceof Screen)        
            Greenfoot.setWorld(new Screen(2));
    }
}

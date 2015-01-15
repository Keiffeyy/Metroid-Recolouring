import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A health display for the enemy.
 * 
 * @author Adam Li
 * @version 1.0
 */
public class EnemyHUD extends Actor
{
    private Enemy owner;
    private GreenfootImage display;
    /**
     *  Constructor. 
     *  @param owner     The enemy for which the HUD is displayed for
     */
    public EnemyHUD(Enemy owner)
    {   
        display = new GreenfootImage(52,13);//nromally just 50 pixles
        this.owner = owner;         
        display.setColor(new Color(208, 208, 217));
        double ratio = 50/owner.getMaxHealth();
        display.drawRect(0,0,51,11);        
        display.setColor(Color.RED);
        display.fillRect(1,1,(int)(owner.getHealth()*ratio),10);
        if(owner instanceof BossEye){//if boss, follow diffrent format of 150 pixles
            display = new GreenfootImage(152,13);        
            display.setColor(new Color(208, 208, 217));
            ratio = 0.1;
            display.drawRect(0,0,151,11);        
            display.setColor(Color.RED);
            display.fillRect(1,1,(int)(owner.getHealth()*ratio),10);
        }
        setImage(display);
    }

    /**
     * Updates the HUD
     */
    public void act() 
    {
        getWorld().removeObject(this);//just delete aftet this frame, remade every turn
    }  

}

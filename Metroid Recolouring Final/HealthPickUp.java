import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * For player to pickup and increase missile ammo number
 * 
 * @author David Liu and Jessie Leung and Adam Li
 * @version January 20,2014
 */
public class HealthPickUp extends Collision
{
    private GreenfootSound pickUp = new GreenfootSound("PickUp.wav");

    /**
     * Runs detect() every act
     */
    public void act() 
    {
        detect();
    }    

    /**
     * Detects if pickUp touches player, play sound, set player missile ammo number, removes itself if yes
     */
    private void detect(){
        if(touch(Player.class)){
            pickUp.play();
            Player p =new Player();
            p=(Player)getOneTouchedObject(Player.class);
            if(p.getHealth()+10<=100){
                p.setHealth(p.getHealth()+10);
            }else{
                p.setHealth(100);
            }
            getWorld().removeObject(this);
        }
    }
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapons here.
 * 
 * @author Jerry Xu
 * @version January 20, 2014
 */
public abstract class EnemyWeapons extends Actor
{
    /**
     * Act - do whatever the Weapons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(((Map)(getWorld())).checkPause()==false){
            action();
            checkRemove();
        }
    }    

    protected abstract void action();
    
    private void checkRemove()
    {
        Actor tile = getOneIntersectingObject(Tile.class);
        if (tile != null)
        {
            getWorld().removeObject(this);
        }
        else
        {
            Player player = (Player)getOneIntersectingObject(Player.class);
            if (player != null)
            {
                if(!((Map)(getWorld())).getPlayer().recentlyAttacked())
                    player.enemyHit(player.getHealth()-5);
                getWorld().removeObject(this);
            }
        }
    }  
}

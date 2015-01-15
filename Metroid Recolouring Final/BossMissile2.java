import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossMissile2 here.
 * 
 * @author Jerry Xu
 * @version January 20, 2014
 */
public class BossMissile2 extends EnemyWeapons
{
    public BossMissile2()
    {
        setImage("BossMissile2.PNG");
    }
    
    public void addedToWorld(World world)
    {
        Map m = (Map)getWorld();
        turnTowards(m.getPlayerX(), m.getPlayerY());
    }
    
    protected void action() 
    {
        move(6);
    }
}
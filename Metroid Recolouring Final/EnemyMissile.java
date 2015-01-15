import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author Jerry Xu
 * @version January 20, 2014
 */
public class EnemyMissile extends EnemyWeapons
{
    public void addedToWorld(World world)
    {
        Map m = (Map)getWorld();
        turnTowards(m.getPlayerX(), m.getPlayerY());
    }

    protected void action() 
    {
        move(15);
    }   
}
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyMissile1 here.
 * 
 * @author Jerry Xu
 * @version January 20, 2014
 */
public class BossMissile1 extends EnemyWeapons
{
    private int turn;
    
    public BossMissile1(int t)
    {
        this.turn = t;
    }
    
    public void addedToWorld(World world)
    {
        turn(turn);
    }
    
    /**
     * Act - do whatever the EnemyMissile1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   protected void action() 
    {
        move(5);
    }
}
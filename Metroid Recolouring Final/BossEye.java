import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The boss's weakspot. E.g. The only spot where he'll take damage.
 * Has specific health and if is destroyed, the boss is dead.
 * 
 * @author Jerry Xu
 * @version Jan 19, v1.2
 */
public class BossEye extends Enemy
{
    private int health; //the number of hits required to defeat the boss, essentially
    private int counter;
    public BossEye()
    {
        super(1500,15);
        setImage("BossEye.png");
        health = 1500;
    }

    /**
     * Act method. Maintains its position above the boss.
     */
    public void act() 
    {
        if(((Map)(getWorld())).checkPause()==false){
            HUD();
            Map m = (Map)getWorld();
            counter++;
            if(counter<1000){
                setLocation(m.getBossX(), m.getBossY() - 150);
            }else if (counter<2000){
                setLocation(m.getBossX(), m.getBossY()+150-60);
            }
            else{
                counter=0;
            }
            shouldKillSelf();
        }
    }

    protected void onDeath(){}

    protected void attackMove(){}

    protected void randomMove(){}
}
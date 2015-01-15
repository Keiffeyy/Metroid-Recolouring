import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A walking type enemy.
 * 
 * Walks for 50 to 200 acts in a random direction. Then waits for 50 to 200 acts until next move sequence.
 * 
 * @author Jerry Xu
 * @version Jan 19
 */
public class Walker extends Enemy
{
    private boolean moving;

    public Walker()
    {
        super(15, 5);
        fallC = 0;
        moveDelay = 1;
        moving = false;
    }

    /**
     * Act - do whatever the Walker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected void attackMove()
    {
        //NOT ATTACKS
    }    

    private void gravitize()
    {
        if (getOneObjectAtOffset(0,getImage().getHeight()/2,Tile.class)!=null)
        {
            fallC = 0;
        }
        else
        {
            if(fallC<10)
                fallC ++;
        }
    }

    protected void randomMove()
    {
        gravitize();
        if (moveDelay == 0)
        {
            moveDirection = Greenfoot.getRandomNumber(2) - 1;
            if (moveDirection == 0)
            {
                moveDirection = 1;
            }
            moving = true;
            moveDelay = Greenfoot.getRandomNumber(150) + 50;
            moveTime = Greenfoot.getRandomNumber(150) + 50;
        }
        else if (!moving)
        {
            moveDelay --;
        }

        if (moveTime > 0)
        {
            moveTime --;
            if (moveTime == 0)
            {
                moving = !moving;
                moveDirection = 0;
            }
        }
        checkStopMovement();
        if (moveDirection < 0){
            setImage("WalkerLeft.png");
        } else if (moveDirection > 0){
            setImage("WalkerRight.png");
        }

        setLocation(getX() + moveDirection, getY() + fallC);
    }   

    private void checkStopMovement()
    {
        if (touchSide(false, this)||touchSide(true, this))
        {
            moveDirection = -moveDirection;
        }
    }

    protected void onDeath(){
        getWorld().addObject(new HealthPickUp(), (int)(((SWorld)(getWorld())).getScrolledX())+getX(), (((SWorld)(getWorld())).getScrolledY())+getY());
    }
}
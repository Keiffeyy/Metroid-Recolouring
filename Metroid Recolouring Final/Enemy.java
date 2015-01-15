import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Abstract Supercalss for all of the enemies each person has designed. <br> Each person 
 * will have to create an enemy, based on their own AI. The act method is already preset so don't worry 
 * about that! <br><br> Each subclass constructor will have to contain a "super(insert_health_point);"<br><br>
 * 
 * Each team member is required (aside from Jerry who is designing the boss and enemies of course) to
 * create 2 methods - randomMove() and attackMove(). They must be PROTECTED methods. Any other
 * wording, naming, convention, etc will result in an error. randomMove() must also cotain a setLocation(x_Location, y_Location);     
 * 
 * @author David Liu and Jerry Xu and Keith Wong (sounds)
 * @version 1.2
 */
public abstract class Enemy extends Collision
{
    protected int hP, maxHP, uniqueDamage, moveDirection, moveDelay, moveTime, fallC, projectileCooldown;
    protected boolean moving;
    private GreenfootSound death = new GreenfootSound("EnemyDeath.wav");
    private EnemyHUD thisHUD;
    /**
     * Defines the Enemy that each team member coded
     * 
     * @param hitpoints The health you want your enemy to have
     */
    public Enemy(int hitpoints, int damage){
        hP = hitpoints;
        maxHP = hP;
        this.uniqueDamage = damage;
    }

    /**
     * Act - do whatever the PlayerEnemy wants to do. This method is called every time screen refreshes
     */
    public void act() 
    {
        if(!((Map)(getWorld())).checkPause()){
            damagePlayer();
            randomMove();
            attackMove();            
            HUD();
            shouldKillSelf();
        }
    }    

    /**
     * Makes heads up display to show current level of health
     */
    protected void HUD(){
        getWorld().addObject(new EnemyHUD(this), getX()+((Map)getWorld()).getScrolledX(), getY()+((Map)getWorld()).getScrolledY()-getImage().getHeight()); 
    }

    /**
     * Controls how the enemy would move like
     */
    protected abstract void randomMove();

    /**
     * Controls how the enemy would perform a killing move, leave empty if N/A
     */
    protected abstract void attackMove();

    /**
     * Predict circumstances to kill self
     */
    protected void shouldKillSelf(){
        if(touch(Weapon.class)){
            int damage = ((Weapon)getOneIntersectingObject(Weapon.class)).getDamage();
            getWorld().removeObject(getOneIntersectingObject(Weapon.class));
            hP-=damage;
        }
        if(hP <=0){
            onDeath();
            death.play();
            getWorld().removeObject(this);
            if(this instanceof BossEye){     
                MusicPlayer.switchToBossDefeat();
                Greenfoot.setWorld(new Screen(4));
            }
        }
    }

    /**
     * Checks and applies damage to player
     */
    private void damagePlayer(){
        Player p = (Player)getOneIntersectingObject(Player.class);
        if(p!=null){
            if(!p.recentlyAttacked()){
                p.enemyHit(p.getHealth()-uniqueDamage);
            }
        }
    }

    /**
     * What to do when hit, what code to run on death
     */
    protected abstract void onDeath();

    /**
     * returns the current health of the enemy. 
     */
    protected int getHealth()
    {
        return hP;
    }

    /**
     * Returns the max health of the enemy
     */
    protected int getMaxHealth()
    {
        return maxHP;
    }
}
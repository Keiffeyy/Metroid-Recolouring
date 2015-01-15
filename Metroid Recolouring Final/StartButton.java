import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button for Starting Game
 * @author David Liu
 * @version 1.2
 */
public class StartButton extends Button
{
    /**
     * Creates a new Button
     * 
     * @param name The word to display
     */
    public StartButton(String name){
        super(name);
    }    

    /**
     * Decides what to do when pressed,
     * Loads the very first map
     */
    public void buttonPressed(){
        MusicPlayer.switchToBGM();
        Greenfoot.setWorld(new Map("map1.txt",288,168,960,3840,100,0,0));//changed to starting world
    }    
}

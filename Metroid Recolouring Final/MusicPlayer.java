import greenfoot.*;
/**
 * Decides which background music to play.
 * 
 * @author KeithWong 
 * @version January 21, 2014
 */
public class MusicPlayer 
{
    private static GreenfootSound bgm = new GreenfootSound("bgm.mp3");
    private static GreenfootSound bossDefeatMusic = new GreenfootSound("GuileTheme.mp3");

    /**
     * Plays the background music.
     */
    public static void playBGM(){
        bgm.playLoop();
    }

    /**
     * Sets the volume of the background music.
     * 
     * @param volume The desired volume.
     */
    public static void setBGMVolume(int volume){
        bgm.setVolume(volume);
    }
    
    /**
     * Sets the volume of the boss defeat music.
     * 
     * @param volume The desired volume.
     */
    public static void setBossDefeatVolume(int volume){
        bossDefeatMusic.setVolume(volume);
    }
    
    /**
     * Stops the background music.
     */
    public static void stopBGM(){
        bgm.stop();
    }

    /**
     * Switches to the bossDefeatMusic.
     */
    public static void switchToBossDefeat(){
        if (bgm.isPlaying())
            stopBGM();
        bossDefeatMusic.playLoop();
    }

    /**
     * Switches to the background music.
     */
    public static void switchToBGM(){
        if (bossDefeatMusic.isPlaying())
        bossDefeatMusic.stop();
        playBGM();
    }
}

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class Music {
    void playMusic(String musicLocation){
        try
        {
            File musicPath = new File(musicLocation);
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            }
            else
            {
                System.out.println("Cant find");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
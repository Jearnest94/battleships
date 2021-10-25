import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Utilities {

    /**
     *
     * @param arr Prints 2 dimensional array.
     */
    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * Waits for user input. Useful for passing device between users without revealing information.
     */
    public static void pressEnter() {
        System.out.println("<Press Enter to continue>");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }

    /**
     *
     * @param musicLocation Plays sound file in specified directory.
     */
    public static void playSound(String musicLocation){
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

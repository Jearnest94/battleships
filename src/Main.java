import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        boolean mapsize = false;
        Music music = new Music();

        JOptionPane.showMessageDialog(null, "Välkommen till Sänka Skepp. 8)");

        //CPU or 2Player
        //Set player name
        //Sätt map-size
        while (mapsize) {
            System.out.println("Map Size:");
            System.out.println("X: ");
            int xMapSize = input.nextInt();
            System.out.println("Y: ");
            int yMapSize = input.nextInt();
            mapsize = false;
        }

        int xMapSize = 12;
        int yMapSize = 12;



        Mapsson playerOneMap = new Mapsson(1, xMapSize, yMapSize);
        Mapsson playerTwoMap = new Mapsson(2, xMapSize, yMapSize);
        Utilities.printArray(playerOneMap.getMap());

        Game game = new Game();

            game.placementPhase(input, playerOneMap);
            game.placementPhase(input, playerTwoMap);


        boolean attackPhase = true;
        while (attackPhase) {
            game.attackPhase(input, playerOneMap, music);
            game.attackPhase(input, playerTwoMap, music);
        }



        System.out.println();
    }


    public static void pressEnter() {
        System.out.println("<Enter>");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}

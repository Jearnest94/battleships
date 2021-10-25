import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        Utilities playSound = new Utilities();
        boolean mapsize = false;
        int xMapSize;
        int yMapSize;


        JOptionPane.showMessageDialog(null, "Välkommen till Sänka Skepp. 8)");

        //CPU or 2Player
        //Set player name
        //Set map-size
        if (mapsize) {
            System.out.println("Map Size:");
            System.out.println("X: ");
            xMapSize = input.nextInt();
            System.out.println("Y: ");
            yMapSize = input.nextInt();
            mapsize = false;
        } else {
            xMapSize = 12;
            yMapSize = 12;
        }


        Mapsson playerOneMap = new Mapsson(1, xMapSize, yMapSize);
        Mapsson playerTwoMap = new Mapsson(2, xMapSize, yMapSize);
        Mapsson playerOneMapInvis = new Mapsson(1, xMapSize, yMapSize);
        Mapsson playerTwoMapInvis = new Mapsson(2, xMapSize, yMapSize);
        Utilities.printArray(playerOneMap.getMap());

        Game game = new Game();

            game.placementPhase(input, playerOneMap);
            game.placementPhase(input, playerTwoMap);

        boolean attackPhase = true;
        while (attackPhase) {
            game.attackPhase(input, playerOneMap, playerOneMapInvis, playerTwoMap, playSound);
            game.attackPhase(input, playerTwoMap, playerTwoMapInvis, playerOneMap, playSound);
        }

        System.out.println();
    }



}

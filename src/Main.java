import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        boolean mapsize = false;
        int xMapSize;
        int yMapSize;

        JOptionPane.showMessageDialog(null, "Välkommen till Sänka Skepp. 8)");

        //CPU or 2Player
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

        //Create maps through class: "Mapsson"
        //Default map is 12x12 2D-array filled with: "~ ", which represents water.
        Mapsson playerOneMap = new Mapsson(1, xMapSize, yMapSize);
        Mapsson playerTwoMap = new Mapsson(2, xMapSize, yMapSize);
        Mapsson playerOneHitScanMap = new Mapsson(1, xMapSize, yMapSize);
        Mapsson playerTwoHitScanMap = new Mapsson(2, xMapSize, yMapSize);

        Utilities.printArray(playerOneMap.getMap());
        Game game = new Game();

        //Initializes ship placement phase.
        game.placementPhase(input, playerOneMap);
        game.placementPhase(input, playerTwoMap);

        //Runs attackPhase-method until a player wins. Alternates between player one and player two.
        while (true) {
            game.attackPhase(input, playerOneMap, playerOneHitScanMap, playerTwoMap);
            if (game.winCondition(Game.getPlayerOneHitCount())) {
                break;
            }
            game.attackPhase(input, playerTwoMap, playerTwoHitScanMap, playerOneMap);
            if (game.winCondition(Game.getPlayerTwoHitCount())) {
                break;
            }
        }

        System.out.println();
    }


}

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialization
        Scanner input = new Scanner(System.in);
        boolean gameModeCPU = false;
        boolean mapsize = false;
        int xMapSize = 8;
        int yMapSize = 8;
        int menuSelection;

        JOptionPane.showMessageDialog(null, "Welcome to Battleships, captain!");
        Utilities.playSound("battleships.wav");

        //Menu
        while (true) {
            System.out.println("- Battleships -");
            System.out.println("1) Play");
            System.out.println("2) CPU/2-Player (toggle)");
            System.out.println("3) Set map size");
            System.out.println("4) About");
            System.out.println("5) Quit");
            menuSelection = input.nextInt();

            if (menuSelection == 1) {
                //Create all maps through class: "Mapsson"
                //Default map is 8x8 2D-array filled with: "~ ", which represents water.
                Mapsson playerOneMap = new Mapsson(1, xMapSize, yMapSize);
                Mapsson playerTwoMap = new Mapsson(2, xMapSize, yMapSize);
                Mapsson playerOneHitScanMap = new Mapsson(1, xMapSize, yMapSize);
                Mapsson playerTwoHitScanMap = new Mapsson(2, xMapSize, yMapSize);

                Utilities.printArray(playerOneMap.getMap());
                Game game = new Game();

                //Initializes ship placement phase.
                if (gameModeCPU) {
                    game.placementPhase(input, playerOneMap);
                    game.placementPhaseCPU(input, playerTwoMap);
                } else {
                    game.placementPhase(input, playerOneMap);
                    game.placementPhase(input, playerTwoMap);
                }

                //Runs attackPhase-method until a player wins. Alternates between Player 1 and Player 2/CPU.
                if (gameModeCPU) {
                    while (true) {
                        game.attackPhase(input, playerOneMap, playerOneHitScanMap, playerTwoMap);
                        if (game.winCondition(Game.getPlayerOneHitCount())) {
                            break;
                        }
                        game.attackPhaseCPU(playerTwoMap, playerTwoHitScanMap, playerOneMap);
                        if (game.winCondition(Game.getPlayerTwoHitCount())) {
                            break;
                        }
                    }

                } else {
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
                }

            } else if (menuSelection == 2) {
                if (gameModeCPU) {
                    gameModeCPU = false;
                    System.out.println("\n2-Player mode enabled.");
                    Utilities.pressEnter();
                } else if (!gameModeCPU) {
                    gameModeCPU = true;
                    System.out.println("\nCPU-mode enabled.");
                    Utilities.pressEnter();
                }
            } else if (menuSelection == 3) {
                mapsize = true;
            } else if (menuSelection == 4) {
                System.out.println();
                System.out.println("Battleships game made by Jonathan Earnest as a school project at KYH Internet of Things (GBG 2021)");
                Utilities.pressEnter();
            } else if (menuSelection == 5) {
                System.out.println();
                System.out.println("Thank you for playing Battleships 8)");
                Utilities.pressEnter();
                Utilities.playSound("FireHit.wav");
                break;
            }

            //Set map-size. (Default is 8 x 8)
            if (mapsize) {
                System.out.println("Map Size: (Default 8 x 8)");
                System.out.print("X: ");
                xMapSize = input.nextInt();
                System.out.print("Y: ");
                yMapSize = input.nextInt();
                System.out.println();
                System.out.println("Map size set to " + xMapSize + " x " + yMapSize);
                System.out.println();
                mapsize = false;
            }

        }

        System.out.println("Test: endmain");
    }


}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public void attackPhase(Scanner input, Mapsson playerMap, Mapsson playerMapInvis, Mapsson enemyMap, Utilities sound) {
        boolean wincondition = false;
        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println();
            System.out.println("<Player "  + playerMap.getPlayerID() +  "> Bomb Turn");
            Utilities.printArray(playerMapInvis.getMap());
            System.out.print("X: ");
            int xBomb = input.nextInt() - 1;
            System.out.print("Y: ");
            int yBomb = input.nextInt() - 1;

            if (enemyMap.getMap()[yBomb][xBomb].matches("@ |# |&")) {
                Utilities.playSound("FireHit.wav");
                System.out.println("Hit! Fire again.");
                playerMapInvis.getMap()[yBomb][xBomb] = "X ";
                Utilities.printArray(playerMapInvis.getMap());
                Utilities.pressEnter();
            } else {
                Utilities.playSound("FireSplash.wav");
                System.out.println("Miss!");
                playerMapInvis.getMap()[yBomb][xBomb] = "O ";
                Utilities.printArray(playerMapInvis.getMap());
                Utilities.pressEnter();
                playerTurn = false;
            }

        }
    }

    public void placementPhase(Scanner input, Mapsson playerMap) {

        Ship shipA = new Ship("@ ", 0, 0, 5, "");
        Ship shipB = new Ship("# ", 0, 0, 3, "");
        Ship shipC = new Ship("& ", 0, 0, 2, "");

        List<Ship> shipList = new ArrayList<Ship>();
        shipList.add(shipA);
        shipList.add(shipB);
        shipList.add(shipC);

        for (Ship ship:shipList) {
            //Set ship coordinates.
            System.out.println("<Player "  + playerMap.getPlayerID() +  "> Placement Turn");
            System.out.println("Ship: @ @ @ @ @ ");
            System.out.print("X: ");
            ship.setXPos(input.nextInt() - 1);
            System.out.print("Y: ");
            ship.setYPos(input.nextInt() - 1);

            //Set Horizontal/Vertical.
            String orientation;
            System.out.println("Set orientation:");
            System.out.println("1) Horizontal");
            System.out.println("2) Vertical");
            int select = input.nextInt();
            if (select == 1) {
                ship.setOrientation("Horizontal");
            } else {
                ship.setOrientation("Vertical");
            }

            //Check for ships on placement Coordinates.
            if (playerMap.getMap()[ship.getXPos()][ship.getYPos()].matches("@ |# |& ")) {
                Utilities.printArray(playerMap.getMap());
                System.out.println("Ship placement failed.");
            } else {
                playerMap.addShip(ship);
                Utilities.printArray(playerMap.getMap());
                System.out.println("Ship placed successfully.");
            }

        }

        Utilities.pressEnter();


    }


}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public void attackPhase(Scanner input, Mapsson playerMap, Music music) {

        int currentPlayer;
        currentPlayer = playerMap.getPlayerID();

        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println("<Player "  + playerMap.getPlayerID() +  "> Bomb Turn");
            System.out.print("X: ");
            int xBomb = input.nextInt();
            System.out.print("Y: ");
            int yBomb = input.nextInt();

            if (playerMap.getMap()[xBomb][yBomb].matches("@ |# |&")) {
                music.playMusic("FireHit.wav");
                System.out.println("Hit!");
                playerMap.getMap()[xBomb][yBomb] = "X ";
                Utilities.printArray(playerMap.getMap());
            } else {
                music.playMusic("FireSplash.wav");
                System.out.println("Miss!");
                playerMap.getMap()[xBomb][yBomb] = "O ";
                Utilities.printArray(playerMap.getMap());
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
            ship.setXPos(input.nextInt());
            System.out.print("Y: ");
            ship.setYPos(input.nextInt());

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
            if (playerMap.getMap()[ship.getXPos()][ship.getYPos()].matches("@ |# |&")) {
                System.out.println("Ship placement failed.");
            } else {
                playerMap.addShip(ship);
                System.out.println("Ship placed successfully.");
                Utilities.printArray(playerMap.getMap());
            }

        }


    }


}

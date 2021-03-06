import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private static int playerOneHitCount = 0;
    private static int playerTwoHitCount = 0;

    public static int getPlayerOneHitCount() {
        return playerOneHitCount;
    }

    public void setPlayerOneHitCount(int hitCount) {
        this.playerOneHitCount = hitCount;
    }

    public static int getPlayerTwoHitCount() {
        return playerTwoHitCount;
    }

    public void setPlayerTwoHitCount(int hitCount) {
        this.playerTwoHitCount = hitCount;
    }

    /**
     * Win condition method that returns boolean.
     */
    public boolean winCondition(int hitCount) {
        if (hitCount < 9) {
            return false;
        } else
            return true;
    }

    /**
     * Placement phase method.
     * Creates 3 ships and forces player to place each one on the map
     * @param playerMap Player map. Used for placing the ships on the map
     */
    public void placementPhase(Scanner input, Mapsson playerMap) {
        //Create the 3 different ship types.
        Ship shipA = new Ship("@ ", 0, 0, 5, "");
        Ship shipB = new Ship("# ", 0, 0, 3, "");
        Ship shipC = new Ship("& ", 0, 0, 2, "");

        List<Ship> shipList = new ArrayList<Ship>();
        shipList.add(shipA);
        shipList.add(shipB);
        shipList.add(shipC);

        for (Ship ship : shipList) {
            placeShip(input, ship, playerMap);
        }
        Utilities.pressEnter();
    }

    /**
     * Ship placement method
     * @param ship used for setting x, y and ship orientation through input
     * @param playerMap
     */
    private void placeShip(Scanner input, Ship ship, Mapsson playerMap) {
        //Set ship coordinates.
        System.out.println("<Player " + playerMap.getPlayerID() + "> Placement Turn");

        try {
            System.out.print("Ship: ");
            for (int i = 0; i < ship.getLength(); i++) {
                System.out.print(ship.getSymbol());
            }
            System.out.println();
            System.out.print("X: ");
            ship.setXPos(input.nextInt() - 1);
            System.out.print("Y: ");
            ship.setYPos(input.nextInt() - 1);

            //Set Horizontal/Vertical.
            System.out.println("Set orientation:");
            System.out.println("1) Horizontal");
            System.out.println("2) Vertical");
            int select = input.nextInt();
            if (select == 1) {
                ship.setOrientation("Horizontal");
            } else {
                ship.setOrientation("Vertical");
            }
        } catch(Exception E) {
            System.out.println("Invalid Input.");
            Utilities.pressEnter();
        }

        //Check if ship placement is valid then place ship, else try again
        if (playerMap.addShip(ship)) {
            playerMap.addShip(ship);
            Utilities.printArray(playerMap.getMap());
            System.out.println("Ship placed successfully.");
        } else {
            Utilities.printArray(playerMap.getMap());
            System.out.println("Ship placement failed.");
            placeShip(input, ship, playerMap);
        }

    }

    /**
     * Attack phase method. This is where most of the game runs.
     * @param input      Scanner
     * @param playerMap  Player map. Used for Player ID in this case.
     * @param hitScanMap Enemy map without enemy ships.
     * @param enemyMap   Enemy map. To check if bomb placement connects.
     */
    public void attackPhase(Scanner input, Mapsson playerMap, Mapsson hitScanMap, Mapsson enemyMap) {
        boolean playerTurn = true;

        //Player turn. Asks for coordinates to Fire at.
        while (playerTurn) {
            System.out.println();
            System.out.println("<Player " + playerMap.getPlayerID() + "> Bomb Turn");
            Utilities.printArray(hitScanMap.getMap());
            System.out.print("X: ");
            int xBomb = input.nextInt() - 1;
            System.out.print("Y: ");
            int yBomb = input.nextInt() - 1;

            try {
                //Bomb connects with ship:
                if (enemyMap.getMap()[yBomb][xBomb].matches("@ |# |& ")) {
                    Utilities.playSound("FireHit.wav");
                    System.out.println("Hit!");
                    hitScanMap.getMap()[yBomb][xBomb] = "X ";
                    enemyMap.getMap()[yBomb][xBomb] = "X ";

                    //Add 1 score to appropriate player
                    if (playerMap.getPlayerID() == 1) {
                        setPlayerOneHitCount(getPlayerOneHitCount() + 1);
                    } else if (playerMap.getPlayerID() == 2) {
                        setPlayerTwoHitCount(getPlayerTwoHitCount() + 1);
                    }

                    //Check win condition (10 hits)
                    if (winCondition(Game.getPlayerOneHitCount())) {
                        System.out.println("Player " + playerMap.getPlayerID() + " wins the game!");
                        break;
                    } else if (winCondition(Game.getPlayerTwoHitCount())) {
                        System.out.println("Player " + playerMap.getPlayerID() + " wins the game!");
                        break;
                    }
                    Utilities.printArray(hitScanMap.getMap());
                    Utilities.pressEnter();

                    //User attempts to bomb an already bombed square
                } else if (enemyMap.getMap()[yBomb][xBomb].matches("X |O ")) {
                    System.out.println("Already shot there! Try Again.");
                    Utilities.printArray(hitScanMap.getMap());
                    Utilities.pressEnter();

                    //Bomb misses ship. This will end player turn.
                } else if (enemyMap.getMap()[yBomb][xBomb].matches("~ ")) {
                    Utilities.playSound("FireSplash.wav");
                    System.out.println("Miss!");
                    hitScanMap.getMap()[yBomb][xBomb] = "O ";
                    enemyMap.getMap()[yBomb][xBomb] = "O ";
                    Utilities.printArray(hitScanMap.getMap());
                    Utilities.pressEnter();
                    playerTurn = false;
                }

            } catch (Exception E) {
                System.out.println("Invalid Input.");
                Utilities.pressEnter();
            }

        }


    }

    /**
     * The classes below are same as above but for CPU.
     * Random numbers are used for Fire and Placement.
     */
    public void placementPhaseCPU(Scanner input, Mapsson playerMap) {
        //Create the 3 different ship types.
        Ship shipA = new Ship("@ ", 0, 0, 5, "");
        Ship shipB = new Ship("# ", 0, 0, 3, "");
        Ship shipC = new Ship("& ", 0, 0, 2, "");

        List<Ship> shipList = new ArrayList<>();
        shipList.add(shipA);
        shipList.add(shipB);
        shipList.add(shipC);

        for (Ship ship : shipList) {
            placeShipCPU(ship, playerMap);
        }
    }

    private void placeShipCPU(Ship ship, Mapsson playerMap) {
        Random random = new Random();
        int randomX = random.nextInt(playerMap.getxSize());
        int randomY = random.nextInt(playerMap.getySize());
        int randomOrientSelect = random.nextInt(2) + 1;
        //Set ship coordinates.
        System.out.println("<CPU> Placement Turn");
        System.out.print("Ship: ");
        for (int i = 0; i < ship.getLength(); i++) {
            System.out.print(ship.getSymbol());
        }
        System.out.println();
        System.out.print("X: ");
        ship.setXPos(randomX);
        System.out.print("Y: ");
        ship.setYPos(randomY);

        //Set Horizontal/Vertical.
        System.out.println("Set orientation:");
        System.out.println("1) Horizontal");
        System.out.println("2) Vertical");
        if (randomOrientSelect == 1) {
            ship.setOrientation("Horizontal");
        } else {
            ship.setOrientation("Vertical");
        }
        //Check if ship placement is valid, else try again
        if (playerMap.addShip(ship)) {
            playerMap.addShip(ship);
            Utilities.printArray(playerMap.getMap());
            System.out.println("Ship placed successfully.");
        } else {
            Utilities.printArray(playerMap.getMap());
            System.out.println("Ship placement failed.");
            placeShipCPU(ship, playerMap);
        }

    }

    public void attackPhaseCPU(Mapsson playerMap, Mapsson hitScanMap, Mapsson enemyMap) {
        Random random = new Random();
        int randomX = random.nextInt(playerMap.getxSize());
        int randomY = random.nextInt(playerMap.getySize());
        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println();
            System.out.println("<CPU> Bomb Turn");
            Utilities.printArray(hitScanMap.getMap());
            System.out.print("X: ");
            int xBomb = randomX;
            System.out.print("Y: ");
            int yBomb = randomY;

            try {
                //Bomb connects with ship:
                if (enemyMap.getMap()[yBomb][xBomb].matches("@ |# |& ")) {
                    Utilities.playSound("FireHit.wav");
                    System.out.println("Hit!");
                    hitScanMap.getMap()[yBomb][xBomb] = "X ";
                    enemyMap.getMap()[yBomb][xBomb] = "X ";
                    randomX = random.nextInt(playerMap.getxSize());
                    randomY = random.nextInt(playerMap.getySize());
                    //Add 1 score to appropriate player
                    if (playerMap.getPlayerID() == 1) {
                        setPlayerOneHitCount(getPlayerOneHitCount() + 1);
                    } else if (playerMap.getPlayerID() == 2) {
                        setPlayerTwoHitCount(getPlayerTwoHitCount() + 1);
                    }

                    //Check win condition (10 hits)
                    if (winCondition(Game.getPlayerOneHitCount())) {
                        System.out.println("Player " + playerMap.getPlayerID() + " wins the game!");
                        break;
                    } else if (winCondition(Game.getPlayerTwoHitCount())) {
                        System.out.println("CPU wins the game!");
                        break;
                    }
                    Utilities.printArray(hitScanMap.getMap());

                    //User attempts to bomb an already bombed square
                } else if (enemyMap.getMap()[yBomb][xBomb].matches("X |O ")) {
                    randomX = random.nextInt(playerMap.getxSize());
                    randomY = random.nextInt(playerMap.getySize());
                    System.out.println("Already shot there! Try Again.");
                    Utilities.printArray(hitScanMap.getMap());

                    //Bomb misses ship. This will end players turn.
                } else if (enemyMap.getMap()[yBomb][xBomb].matches("~ ")) {
                    Utilities.playSound("FireSplash.wav");
                    System.out.println("Miss!");
                    hitScanMap.getMap()[yBomb][xBomb] = "O ";
                    enemyMap.getMap()[yBomb][xBomb] = "O ";
                    Utilities.printArray(hitScanMap.getMap());
                    playerTurn = false;
                }

            } catch (Exception E) {
                System.out.println("Invalid Input.");
                randomX = random.nextInt(playerMap.getxSize());
                randomY = random.nextInt(playerMap.getySize());
            }

        }


    }


}

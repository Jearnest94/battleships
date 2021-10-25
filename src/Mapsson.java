import java.util.ArrayList;

/**
 * Map-class
 * Contains x-size, y-size, 2d String array and player ID
 */
public class Mapsson {

    private final int xSize;
    private final int ySize;
    private final String[][] map;
    private final int playerID;

    public Mapsson(int playerID, int xSize, int ySize)  {
        this.playerID = playerID;
        this.xSize = xSize;
        this.ySize = ySize;

        map = new String[xSize][ySize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                map[i][j] = "~ ";
            }
        }
    }

    public String[][] getMap() {
        return map;
    }

    public int getPlayerID() {
        return playerID;
    }

    /**
     *
     * @param ship contains ship length, x-position, y-position, ship symbol and ship orientation
     * @return ship placement failed or successful boolean
     * (Checks if ship overextends map size and if there is already a ship on designated coordinates)
     */
    public boolean addShip(Ship ship) {
        int length = ship.getLength();
        int xPos = ship.getXPos();
        int yPos = ship.getYPos();
        String symbol = ship.getSymbol();
        String orientation = ship.getOrientation();


        //Does ship fit on map?
        if (orientation.equals("Horizontal")) {
            if (xPos + length >= xSize) {
                return false;
            }
            //Is there water where I want to place my ship?
            for (int j = xPos; j < xPos + length; j++) {
                if (!map[yPos][j].equals("~ ")) {
                    return false;
                }
            }
            //Prints ship with appropriate Symbol on map
            for (int j = xPos; j < xPos + length; j++)
                map[yPos][j] = symbol;
        } else {
            //Same as above but x-axis instead of y-axis
            if (yPos + length >= ySize) {
                return false;
            }
            for (int i = yPos; i < yPos + length; i++) {
                if (!map[xPos][i].equals("~ ")) {
                    return false;
                }
            }
            for (int i = yPos; i < yPos + length; i++)
                map[i][xPos] = symbol;
        }

        return true;


    }


}

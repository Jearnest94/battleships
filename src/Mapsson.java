import java.util.ArrayList;

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

    public boolean addShip(Ship ship) {
        int length = ship.getLength();
        int xPos = ship.getXPos();
        int yPos = ship.getYPos();
        String symbol = ship.getSymbol();
        String orientation = ship.getOrientation();

        //Kollar om det är vatten på X-axeln
        if (orientation.equals("Horizontal")) {
            if (xPos + length >= xSize) {
                return false;
            }
            for (int j = xPos; j < xPos + length; j++) {
                if (!map[yPos][j].equals("~ ")) {
                    return false;
                }
            }
            for (int j = xPos; j < xPos + length; j++)
                map[yPos][j] = symbol;
        } else {
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

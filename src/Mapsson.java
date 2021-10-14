import java.util.ArrayList;

public class Mapsson {

    private int xSize;
    private int ySize;
    private String[][] map;
    private ArrayList<Ship> ships;

    public Mapsson (int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;

        map = new String[xSize][ySize];

        for (int i = 0; i < ySize; i++) {
            for (int j = 0; j < xSize; j++) {
                map[i][j] = "~ ";
            }
        }

        ships = new ArrayList<>();

    }

    public boolean addShip(Ship ship) {
        //ships.add(ship);
        int length = ship.getLength();
        int xPos = ship.getXPos();
        int yPos = ship.getYPos();
        String symbol = ship.getSymbol();
        String orientation = ship.getOrientation();

        int boundary;
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
            // Lägger ut skeppet
            for (int j = xPos; j < xPos + length; j++)
                map[yPos][j] = symbol;
        //Samma fast Y-axeln
        } else {
            if (yPos + length >= ySize) {
                return false;
            }


            for (int i = yPos; i < yPos + length; i++) {
                if (!map[xPos][i].equals("~ ")) {
                    return false;
                }
            }
            //Lägger ut skeppet
            for (int i = yPos; i < yPos + length; i++)
                map[xPos][i] = symbol;
        }

        return true;



    }

    public void printMap() {

    }


}

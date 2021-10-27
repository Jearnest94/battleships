public class Ship {

    private final String symbol;
    private final int length;
    private int xPos;
    private int yPos;
    private String orientation;

    /**
     * Ship object contains:
     * @param symbol Ship symbol
     * @param xPos X position
     * @param yPos Y position
     * @param length Ship length
     * @param orientation Ship orientation (Horizontal/Vertical)
     */
    public Ship(String symbol, int xPos, int yPos, int length, String orientation) {
        this.symbol = symbol;
        this.xPos = xPos;
        this.yPos = yPos;
        this.length = length;
        this.orientation = orientation;
    }

    public String getSymbol() {
        return symbol;
    }
    public int getXPos() {
        return xPos;
    }
    public int getYPos () {
        return yPos;
    }
    public int getLength() {
        return length;
    }
    public String getOrientation() {
        return orientation;
    }
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }


}

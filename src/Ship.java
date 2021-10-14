public class Ship {

    private String symbol;
    private int length;
    private int xPos;
    private int yPos;
    private String orientation;


    //Kalla på konstruktorn för att skapa ett nytt skepp (Nyckelordet 'new')
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



}

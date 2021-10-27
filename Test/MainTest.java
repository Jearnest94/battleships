import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Game game = new Game();
    Ship shipA = new Ship("@ ", 0, 0, 5, "");
    Ship shipA2 = new Ship("@ ", 12, 12, 5, "");
    Ship shipB = new Ship("# ", 4, 4, 3, "");
    Ship shipC = new Ship("& ", 8, 8, 2, "");
    Mapsson playerMap12x12 = new Mapsson(1, 12, 12);
    Mapsson playerMap8x8 = new Mapsson(1, 8, 8);

    @Test
    public void defaultMapSize() {
        int resultX = playerMap12x12.getxSize();
        int resultY = playerMap12x12.getySize();
        assertEquals(12, resultX);
        assertEquals(12, resultY);
    }

    @Test
    public void bombConnect() {
        String result;
        playerMap12x12.addShip(shipA);
        if (playerMap12x12.getMap()[0][0].matches("@ |# |& ")) {
            result = "hit";
        } else {
            result = "miss";
        }
        assertEquals("hit", result);
    }

    @Test
    public void validPlacement12x12() {
        boolean result = playerMap12x12.addShip(shipA);
        assertEquals(true, result);
    }

    @Test
    public void invalidPlacement12x12() {
        boolean result = playerMap12x12.addShip(shipA2);
        assertEquals(false, result);
    }

    @Test
    public void validPlacemen8x8() {
        boolean result = playerMap8x8.addShip(shipB);
        assertEquals(true, result);
    }

    @Test
    public void invalidPlacemen8x8() {
        boolean result = playerMap8x8.addShip(shipC);
        assertEquals(false, result);
    }

}
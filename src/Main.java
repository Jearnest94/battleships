import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

      /*  System.out.println("Set map size(x): ");
        int sizeX = input.nextInt();
        System.out.println("Set map size (y): ");
        int sizeY = input.nextInt();*/

        // Skapa Karta
        String[][] gfxKarta = new String[12][12];
        for (int i = 0; i < gfxKarta.length; i++) {
            for (int j = 0; j < gfxKarta[i].length; j++) {
                gfxKarta[i][j] = ". ";
            }
        }
        Printsson.printArray(gfxKarta);

        boolean placeShipA = true;
        boolean placeShipB = true;

        while (placeShipA) {
            System.out.println("Place ship [O]:");
            System.out.print("X: ");
            int ship_A1_X = input.nextInt() - 1;
            System.out.print("Y: ");
            int ship_A1_Y = input.nextInt() - 1;
            gfxKarta[ship_A1_X][ship_A1_Y] = "O ";
            placeShipA = false;
        }

        while (running) {
            Printsson.printArray(gfxKarta);
            System.out.println("Vart vill du bomba? 8))");
            System.out.print("X: ");
            int bombX = input.nextInt();
            System.out.print("Y: ");
            int bombY = input.nextInt();
            gfxKarta[bombX][bombY] = "X ";
            System.out.println("Allahu Akbar!");
            System.out.println("Tryck Enter för att detonera.");
            input.nextLine();

        }


    }
}

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;
        // JOptionPane.showMessageDialog(null,"Välkommen till Sänka Skepp. 8)");
        Music music = new Music();

        //Sätt mapsize
        /*System.out.println("Map Size:");
        System.out.println("X: ");
        int xMapSize = input.nextInt();
        System.out.println("Y: ");
        int yMapSize = input.nextInt();*/

        int xMapSize = 12;
        int yMapSize = 12;

        Mapsson playerOneMap = new Mapsson(xMapSize, yMapSize);
        Mapsson playerTwoMap = new Mapsson(xMapSize, yMapSize);





      /*  System.out.println("Set map size(x): ");
        int sizeX = input.nextInt();
        System.out.println("Set map size (y): ");
        int sizeY = input.nextInt();

        // Skapa Karta
        String[][] gfxKarta = new String[12][12];
        for (int i = 0; i < gfxKarta.length; i++) {
            for (int j = 0; j < gfxKarta[i].length; j++) {
                gfxKarta[i][j] = ". ";
            }
        }
        String[][] gfxKarta_p1 = new String[12][12];
        for (int i = 0; i < gfxKarta_p1.length; i++) {
            for (int j = 0; j < gfxKarta_p1[i].length; j++) {
                gfxKarta_p1[i][j] = ". ";
            }
        }
        String[][] gfxKarta_p2 = new String[12][12];
        for (int i = 0; i < gfxKarta_p2.length; i++) {
            for (int j = 0; j < gfxKarta_p2[i].length; j++) {
                gfxKarta_p2[i][j] = ". ";
            }
        }

        Printsson.printArray(gfxKarta);

        boolean p1_PlaceShipA1 = true;

        while (p1_PlaceShipA1) {
            System.out.println("<Player 1> Place ship [O]:");
            System.out.print("X: ");
            int ship_A1_X = input.nextInt() - 1;
            System.out.print("Y: ");
            int ship_A1_Y = input.nextInt() - 1;
            gfxKarta[ship_A1_X][ship_A1_Y] = "O ";
            p1_PlaceShipA1 = false;
        }

        boolean p2_PlaceShipA1 = true;

        while (p2_PlaceShipA1) {
            System.out.println("<Player 2> Place ship [O]:");
            System.out.print("X: ");
            int ship_A1_X = input.nextInt() - 1;
            System.out.print("Y: ");
            int ship_A1_Y = input.nextInt() - 1;
            gfxKarta[ship_A1_X][ship_A1_Y] = "O ";
            p2_PlaceShipA1 = false;
        }

        while (running) {
            boolean p1_turn = true;
            while (p1_turn) {
                Printsson.printArray(gfxKarta);
                System.out.println("<Player 1> Vart vill du bomba? 8))");
                System.out.print("X: ");
                int bombX = input.nextInt() - 1;
                System.out.print("Y: ");
                int bombY = input.nextInt() - 1;
                gfxKarta[bombX][bombY] = "X ";
                music.playMusic("wav.wav");
                System.out.println("Allahu Akbar!");
                System.out.println("Tryck Enter för att detonera.");
                pressEnter();
                p1_turn = false;
            }
            boolean p2_turn = true;
            while (p2_turn) {
                Printsson.printArray(gfxKarta);
                System.out.println("<Player2> Vart vill du bomba? 8))");
                System.out.print("X: ");
                int bombX = input.nextInt() - 1;
                System.out.print("Y: ");
                int bombY = input.nextInt() - 1;
                gfxKarta[bombX][bombY] = "X ";
                music.playMusic("wav.wav");
                System.out.println("Allahu Akbar!");
                System.out.println("Tryck Enter för att detonera.");
                pressEnter();
                p2_turn = false;
            }




        }



*/
    }

    public static void pressEnter() {
        System.out.println("<Enter>");
        Scanner input = new Scanner(System.in);
        input.nextLine();
    }
}

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class library {

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);
    static String[] sequence = new String[4];
    static String[] colors = {"yel", "blu", "bro", "bla", "gre", "whi", "red", "ora"};
    static String[][] arrhelp = new String[10][4];

    public static void drawComb() {

        // ilość do ustawienia później
        // clasy z dużej litery zawsze, moduły z małekj
        sequence = DrawWithoutRepeat.start(colors, 4);
        System.out.println();
        System.out.println("Wylosowana sekwencja to: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(sequence[i] + " , ");
        }
    }

    public static String[] setComb() {

        System.out.println();
        System.out.println("Ustaw kolory w pożądanej kolejności.");

        String[] yourComb = {" -- ", " -- ", " -- ", " -- "};
        for (int i = 0; i < 4; i++) {
            System.out.print("Twoja sekwencja:  ");
            for (int j = 0; j < 4; j++) {
                System.out.print(yourComb[j] + " ");
            }
            System.out.println();
            System.out.print("Kolory do wyboru: ");
            for (int j = 0; j < 8; j++) {
                System.out.print(colors[j] + " , ");
            }
            System.out.println();
            System.out.print("Podaj kolejny kolor: ");
            // choose istnieje tylko w pętli
            String choose = scanner.nextLine();
            boolean rep = false;
            for (int j = 0; j < 4; j++) {
                if (choose.equals(yourComb[j])) {
                    System.out.println("kolor się powtarza, spróbuj jeszcze raz");
                    rep = true;
                    break;
                     // cofnięcie do poprzedniegoi kroku pętli
                }
            }
            if (!rep) {
                yourComb[i] = choose;
            } else {
                i--;
            }
        }
        System.out.print("Wybrałeś sekwencję:- ");
        for (int i = 0; i < 4; i++) {
            System.out.print(yourComb[i] + " ");
        }
        return yourComb;
    }

    public static boolean checkComb(String[] yourComb, int round) {

        String[] helper = new String[4];
        for (int i = 0; i < 4; i++) {
            helper[i] = " -- ";
            // zerujemy ilość celnych trafień, aby stwierdzić, czy w rundzie padła zwycięska sekwencja
        }
        int count = 0;
        boolean win = false;

        // najpierw prostsza wersja - każde pole pomocnika odpowiada polu sekwencji
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (yourComb[i].equals(sequence[j])) {
                    // nie może być ==, nie porówna tak elementów tablicy
                    // czy zatem stringi zawsze przez equeals?
                    if (i == j) {
                        helper[i] = "hit";
                        count++;
                    } else {
                        helper[i] = "is";
                    }
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("Twoje trafienia: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(helper[i] + " , ");
            arrhelp[round][i] = helper[i];

        }
        if (count == 4) {
            System.out.println("Zgadłeś sekwencję, wygrałeś !!!");
            win = true;
        }
        return win;
    }

    public static void dispBoard(String[][] arrOfSeq, int round) {

        System.out.println();
        for (int i = 0; i < (9 - round); i++) {
            System.out.println(" --  --  --  --");
        }
        for (int i = round; i >= 0; i--) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                System.out.print(arrOfSeq[i][j] + "  ");
            }
            System.out.print("  trafienia:   ");
            for (int k = 0; k < 4; k++) {
                System.out.print(arrhelp[i][k] + "  ");
            }
        }

    }
}
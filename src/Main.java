
public class Main {

    static String[][] arrOfSeq = new String[10][4];

    /**
     * ustawianie kombinacji kolorów
     * sprawdzanie trafności kombinacji
     * rysowanie kombinacji
     * <p>
     * kombinacja bedzie tablicą
     * yel, blu, gre, bro, bla, whi, red, ora
     *
     * @param args
     */
    public static void main(String[] args) {

        boolean end = false;
        for (int i = 0; i < 10; i++) {
            library.drawComb();
            // ta sama nazwa zmiennej w innej klasie - zasięgi nazw pomiędzy klasami
            arrOfSeq[i] = library.setComb();
            end = library.checkComb(arrOfSeq[i], i);
            library.dispBoard(arrOfSeq, i);

            if (end) {
                System.out.println("Odgadłeś kombinację kolorów! Wygrałeś!");
                break;
            }
        }
        if (!end) {
            System.out.println("Skończyły Ci się próby! Przegrałeś!");
        }
    }
}
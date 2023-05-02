import java.util.Random;

class DrawWithoutRepeat {
    // gdy nie ma metody main to nie jest to runnable class
    // druga wersja tej metody z pustymi miejscami w tablicy
    public static String[] start(String[] strArr, int amount) {
        /*
        twarda kopia tablicy
        losuje element
        zwraca element
        usuwa element z tablicy
        skraca tablicę o jeden element
        losuje nowy element
        zwraca wylosowane elementy
        */

        // twarda kopia oryginalnej tablicy
        String[] strArrCopy = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArrCopy[i] = strArr[i];
            // aby nie ingerowała w orginalną tablicę
        }

        Random random = new Random();
        int len = strArrCopy.length;
        String[] retStrArr = new String[amount];

        for (int i = 0; i < retStrArr.length; i++) {
            int index = random.nextInt(0, len);
            retStrArr[i] = strArrCopy[index];
            len--; // zmniejszamy ilość elemnetów

            // przesuwamy tablicę o jeden do miejsca wyjęcia elementu
            for (int j = index; j < len; j++) { // - 1 bo inaczej wyskoczy poza ilość elementów, a i tak skopiuje ostatni
                strArrCopy[j] = strArrCopy[j + 1]; // aby nie wyskoczyło poza ilość elementów
                }
            }
        // skracamy tablicę o jeden element
        String[] tmpArr = new String[len];
        for (int i = 0; i < len; i++) {
            tmpArr[i] = strArrCopy[i];
        }
        // skrócona tablica wraca do pierwotnej zmiennej - wciąż są to referencje współdzielone
        strArrCopy = tmpArr;

        return retStrArr;
    }
}

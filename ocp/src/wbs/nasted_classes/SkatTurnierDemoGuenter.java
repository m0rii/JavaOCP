package wbs.nasted_classes;

import java.util.Arrays;
import java.util.List;

public class SkatTurnierDemoGuenter {

    /*
     * wir organisieren ein skat-turnier, an dem 10 spieler teilnehmen. wir
     * listen alle möglichen kombinationen von genau 3 skatspielern auf. wie
     * viele kombinationen gibt es insgesamt?
     */
    public static void main(String[] args) {
            String[] skatSpieler = { "anton", "bernd", "chris", "dieter",
                            "elfriede", "friedrich", "gustav", "heinrich", "isidor",
                            "judith" };
            MyList<String> spieler = new MyList<>(Arrays.asList(skatSpieler));
            int anzahl = 0;
            for (List<String> subList : spieler) {
                    if (subList.size() == 3) {
                            System.out.println(subList);
                            anzahl++;
                    }
            }
            // 120 = (10 * 9 * 8 ) / (1 * 2 * 3)
            System.out.println("es gibt " + anzahl + " mögliche kombinationen"); 
    }
}

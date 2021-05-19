package wbs.nasted_classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

// reifolge name keine rolle
public class SkatTurnierDemo {

    /*
     * wir organisieren ein skat-turnier, an dem 10 spieler teilnehmen. wir
     * listen alle möglichen kombinationen von genau 3 skatspielern auf. wie
     * viele kombinationen gibt es insgesamt?
     */
    public static void main(String[] args) {
            String[] skatSpieler = { "anton", "bernd", "chris", "dieter",
                            "elfriede", "friedrich", "gustav", "heinrich", "isidor",
                            "judith" };
           MyList<String> players = new MyList<>(Arrays.asList(skatSpieler));
           
          for(List<String> p : players) {	  
        	  if(p.size() == 3) {
        		System.out.println(p);
        	     }

          }
         
    }
}

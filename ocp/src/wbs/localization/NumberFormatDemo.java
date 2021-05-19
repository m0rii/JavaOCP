package wbs.localization;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {

    public static void main(String[] args) {
            
            float f1 = 123.4567f;
            
            Locale locFR = new Locale("fr","FR");
            Locale locUS = new Locale("us", "US");
            
            NumberFormat nfUS1, nfUS2, nfFR; // abstract und with methode getInstance funktioniert
            
            nfUS1 = NumberFormat.getInstance(locUS);
            nfUS2 = NumberFormat.getCurrencyInstance(locUS);
            nfFR = NumberFormat.getCurrencyInstance(locFR);
            
            System.out.println(nfUS1.format(f1));
            System.out.println(nfUS2.format(f1));
            System.out.println(nfFR.format(f1));
            
            System.out.printf(Locale.GERMANY, "%6.2f%n", 3.1415927);
            System.out.printf(Locale.US, "%6.2f%n", 3.1415927);

    }

}

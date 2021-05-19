package wbs.localization;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

// wir geben für alle verfügbaren Locales die sprache aus,
// und zwar in deutsch, englisch, französich, chinesisch, japanisch

// -> getAvailableLocales()
// -> getDisplayLanguage()

public class AvailableLocalesDemo {

        public static void main(String[] args) {

                Locale[] availableLocales = Locale.getAvailableLocales();
                Locale[] selectedLocales = { Locale.GERMAN, Locale.ENGLISH,
                        Locale.FRENCH, Locale.CHINESE, Locale.JAPANESE };
                Comparator<Locale> cmp = (l1, l2) -> {
                        return l1.getDisplayLanguage().compareTo(l2.getDisplayLanguage());
                };
                
                for (Locale selectedLocale : selectedLocales) {
                        System.out.println(" --- " + selectedLocale + " ---");
                        
                        Arrays.sort(availableLocales, cmp);
                        
                        for (Locale availableLocale : availableLocales) {
                                System.out.println(availableLocale.getDisplayLanguage(
                                        selectedLocale));
                        }
                        
                        Arrays.sort(availableLocales,cmp);
                        
                        for(Locale availableLocale : availableLocales) {
                        	System.out.println(availableLocale.getDisplayLanguage(selectedLocale) + " -> " +
                        			availableLocale.getDisplayCountry(selectedLocale));
                        }
 
                }

                System.out.println("number of available locales: "
                        + availableLocales.length);
        }
}

package wbs.localization;


import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

        public static void main(String[] args) {

                Locale fr_CA = new Locale("fr", "CA");
                Locale fr = new Locale("fr");
                Locale fa= new Locale("fa");
                Locale korea = Locale.KOREA;
                Locale defaultLocale = new Locale("de", "DE");

                Locale[] locales = { fr_CA, fr, defaultLocale, korea,fa };
                
                // Locale.setDefault(Locale.CHINESE);
                ResourceBundle bundle;

                System.out.println("default locale: " + Locale.getDefault());
                System.out.println();
                for (Locale locale : locales) {
                        System.out.println("--- " + locale + " ---");

                        
                        bundle = ResourceBundle.getBundle(
                                        "wbs/localization/ResourceBundle", locale);
                        System.out.println(bundle.getString("one"));
                        System.out.println(bundle.getString("two"));
                        System.out.println(bundle.getString("three"));
                        System.out.println(bundle.getString("four"));
                        System.out.println(bundle.getString("five"));
                        
                        try {
                                System.out.println(bundle.getString("six"));
                        } catch (MissingResourceException e) {
                                System.out.println(e);
                        }
                        
                        System.out.println();
                }
        }
        
    
}

package wbs.localization;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleLocaleBuilderDemo {
	public static void main(String[] args) {
		// fluent API. Pattern (GoF) : Builder , nested class static
		// 
		Locale locale = new Locale.Builder().setLanguage("xy").setRegion("XY").build(); // 2 buchtaben is standard like de sonst exception
		                
		ResourceBundle bundle = ResourceBundle.getBundle("wbs/localization/ResourceBundle", locale);
		Enumeration<String> en = bundle.getKeys();
		
		while (en.hasMoreElements()) { // in iterator is has next()
			String key = en.nextElement(); 
			String val = bundle.getString(key); // 
			System.out.println(key + " : " + val);
		}
	}
	/*
	 *   wann sollte man an die methode bundle.getString() aufrufen,und wann die methode bundle.getObject()?
	 *   

        welche neuere interface entspricht dem hier   verwendeten interface enumeration?
        wie heissen jeweils die methoden?
        

        haben wir hier nested classes? ja
         falls ja: welchen typ von nested class? nested public static final

        was ist der return-typ der methoden  setLanguage() und setRegion()?
        
         was ist der return-typ der methode build()

         was passiert, wenn für language oder region
         strings verwendet werden, deren länge nicht 2 ist? java.util.IllformedLocaleException

        was ist die ausgabe, wenn wir die laguage von xy auf xz ändern?
	 */
}

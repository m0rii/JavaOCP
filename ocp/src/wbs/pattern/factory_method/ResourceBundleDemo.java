package wbs.pattern.factory_method;


import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

        public static void main(String[] args) {

                Locale locale = Locale.ENGLISH;
                
                ResourceBundle bundle1 = ResourceBundle.getBundle("wbs.pattern.factory_method.Bundle1",locale);
                ResourceBundle bundle2 = ResourceBundle.getBundle("wbs.pattern.factory_method.Bundle2",locale);
                ResourceBundle bundle3 = ResourceBundle.getBundle("wbs.pattern.factory_method.Bundle3",locale);
                
                Object o1 = bundle1.getObject("one");
                Object o2 = bundle2.getObject("one");
                Object o3 = bundle3.getObject("one");
                
                System.out.println(o1 + " -> " + o1.getClass());
                System.out.println(o2 + " -> " + o2.getClass());
                System.out.println(o3 + " -> " + o3.getClass());
                
                System.out.println("----------");
                
                System.out.println(bundle1.getClass().getSuperclass());
                System.out.println(bundle2.getClass().getSuperclass());
                System.out.println(bundle3.getClass().getSuperclass());
                
                System.out.println("----------");
                System.out.println(bundle1.getClass().getSuperclass().getSuperclass());
                System.out.println(bundle2.getClass().getSuperclass().getSuperclass());
                System.out.println(bundle3.getClass().getSuperclass().getSuperclass());
        }
}
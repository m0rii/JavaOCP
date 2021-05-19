package wbs.exception_assertions;
public class BadAssertions1Demo {

    /*
     * wir provozieren 2 compilerfehler durch fehlerhafte verwendung von
     * assertions
     */
    public static void m1() {
    }

    public static String m2() {
            return "abc";
    }

    public static boolean m3() {
            return false;
    }

    public static void main(String[] args) {
            assert m3(); // ok
            // assert m1(); // compilerfehler: m1() liefert keinen wert
            // assert m2(); // compilerfehler: m2() liefert keinen boolean
            assert args.length != 0; // compilierungsfähig. nicht appropriate. // public 
            assert args.length != 0 : m2(); // compilierungsfähig. nicht appropriate. // public 
            // assert args.length != 0 : m1(); compilerfehler: m1() liefert keinen
            // wert
            assert args.length != 0 : m3(); // compilierungsfähig. nicht appropriate.
    }
}

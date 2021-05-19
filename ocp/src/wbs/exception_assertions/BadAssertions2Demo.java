package wbs.exception_assertions;

public class BadAssertions2Demo {

    /*
     * wir illustrieren einige compilierungsfähige, aber klar unangemessene
     * verwendungen von assertions
     */

    static int n = 0;

    public static boolean m1() {
            n = 1;
            return false;
    }

    public void m2(String s) {
            assert s.length() > 5; // assert zum parametercheck von p u b l i c methoden
                                                            // ist nicht "appropriate"
    }

    private static void m3(String s) {
            assert s.indexOf('1') >= 0; // ok... die methode m3() ist private...
    }

    public static void main(String[] args) {
            assert m1(); // nicht ok. assertion hat side effect
            try {
                    m3("xyz"); // nicht ok. assertion error sollte hier nicht gefangen
                                            // werden
            } catch (AssertionError e) {
                    // ein leerer catch-block ist i.d.r. auch nicht ok...
            }
            System.out.println("going on...");
    }
}
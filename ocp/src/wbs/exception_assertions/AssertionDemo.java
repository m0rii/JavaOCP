package wbs.exception_assertions;

public class AssertionDemo {

    public static void main(String[] args) {
            int i = Math.random() > 0.5 ? -10 : Integer.MIN_VALUE;
            if (i < 0) {
                    i = -i;
            }
            System.out.println("Der Wert von i ist: " + i);
            // i sollte also immer positiv sein
            assert (i >= 0) : "unmöglich: i ist negativ!";
            
            //runconfiguration -> Arguments -> VM Argument -> -ea (assert aktivitation)
            
           // java -cp cop/bin -ea wbs.exception_assertions.AssertionDemo
     }
}

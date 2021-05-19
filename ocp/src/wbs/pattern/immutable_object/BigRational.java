package wbs.pattern.immutable_object;

import java.math.BigInteger;

public final class BigRational extends Number implements Comparable<BigRational> {
    
    private static final long serialVersionUID = 1L;

        // felder
        private final BigInteger numerator;
        private final BigInteger denominator;

        // konstanten

        public static final BigRational ZERO;
        public static final BigRational ONE;
        public static final BigRational TEN;

        static {
                ZERO = new BigRational(0);
                ONE = new BigRational(1);
                TEN = new BigRational(10);
        }

        // hamashoon mian inja constructorha
        public BigRational(final BigInteger numerator, final BigInteger denominator)
                throws ArithmeticException {
                this.numerator = numerator;
                this.denominator = denominator;
        }

        public BigRational(final long numerator, final long denominator)
                throws ArithmeticException {
                this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
        }

        // setzt den nenner automatisch auf 1
        public BigRational(final BigInteger numerator) {
                this(numerator, BigInteger.ONE);
        }

        // setzt den nenner automatisch auf 1
        public BigRational(final long numerator) {
                this(BigInteger.valueOf(numerator));
        }

        // methoden

        public BigRational reverse() throws ArithmeticException {
                return null;
        }

        public BigRational negate() {
                return null;
        }

        public BigRational add(final MyBigRational rational) {
                return null;
        }

        public BigRational subtract(final MyBigRational rational) {
                return null;
        }

        public MyBigRational multiply(final MyBigRational rational) {
                return null;
        }

        public MyBigRational divide(final MyBigRational rational) throws ArithmeticException {
                return null;
        }

        public MyBigRational pow(final int n) throws ArithmeticException {
                return null;
        }
        
        public int signum() {
			return 0;
        	
        }

        /**
         * 
         * @param s                allowed pattern: "3/4"        "3" ... <br>
         * @return                the bigrational
         * @throws NumberFormatException        invalid char(s) in string
         * @throws ArithmeticException                division by zero
         */
        public static MyBigRational valueOf(final String s) throws NumberFormatException,
                ArithmeticException {
                return null;
        }

        // methods from Number
        
        public int intValue() {
                return this.intValue();
        }

        @Override
        public long longValue() {
                return 0;
        }

        @Override
        public float floatValue() {
                return 0;
        }

        @Override
        public double doubleValue() {
                return 0;
        }

        // methods from Comparable
        
        @Override
        public int compareTo(final BigRational r) {
                return 0;
        }

        // methods from Object
        @Override
        public int hashCode() {
                return 0;
        }

        @Override
        public boolean equals(final Object other) {
                return false;
        }

        @Override
        public String toString() {
                return null;
        }

        // getter
        public BigInteger getNumerator() {
                return numerator;
        }

        public BigInteger getDenominator() {
                return denominator;
        }
        
}



// wir erstellen eine klasse zum bruchrechnen.
// wir wollen also folgende rechnungen ausführen können:
// 3/4 + 4/5
// 22/39 - 13/14 + 12/27
// 14/3 * 17/5
// usw...

// bitte beantworten sie die folgenden fragen:

// welche felder sollte die klasse haben? 
// (typ, sichtbarkeit, final,...)
//  2 felder , private , type int - Integer oder BigInteger, long , Long , float und double sinf schlecht

// welche konstruktoren sollte die klasse anbieten?
// (parameter, sichtbarkeit, exceptions,...)
// public konstruktoren , 2 parameter zahler und nehnar , exception koennen wir division by zero Mathemathic

// welche methoden sollte die klasse anbieten?
// (return-typ, parameter, sichtbarkeit, static , exceptions,...)
// public , nicht static , multi , divide, sub und so methode , dividion deklariet mathemathic exception wegen division by zero
// object ist ein und nicht static ist besser 

// was wählen wir als basisklasse?
// (Object,...)
// Number , Object und Number ist besser

//  
// soll die klasse ein natural ordering haben?
// (falls ja: welches interface müssten wir implementieren? wie?)
// ja , interface comparable 

// sollen instanzen der klasse immutable sein?
// (falls ja: warum?) ja

// soll die methode equals() überschrieben werden?
// (falls ja: warum? wie? welche methode müsste dann ebenfalls überschrieben werden?)
// ja definitive , 

// sollen brüche intern immer in gekürzten form vorliegen?
// (falls ja: warum?)
// ja and nein

// soll die methode toString() überschrieben werden?
// (falls ja: wie?)



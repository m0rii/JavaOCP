package wbs.pattern.immutable_object;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;

import org.junit.jupiter.api.Test;

// was teste ich zuerst?
//  BigRational object , haupt constructor liefern 

// wie und was muss ich testen?
//

class BigRationalTest {

	@Test
	void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	void testIntValue() {
		fail("Not yet implemented");
	}

	@Test
	void testLongValue() {
		fail("Not yet implemented");
	}

	@Test
	void testFloatValue() {
		fail("Not yet implemented");
	}

	@Test
	void testDoubleValue() {
		fail("Not yet implemented");
	}

	@Test
    void testBigRationalBigIntegerBigInteger() {
            // zu testen:
            // - wird gekürzt?
            // - wird der nenner 0 abgefangen?
            // - steht ein eventuelles vorzeichen im zähler?
            boolean isGekuerzt = false;
            boolean isZeroSave = false;
            boolean hasSignInNumerator = false;
            BigRational r1 = new BigRational(BigInteger.valueOf(4), BigInteger
                    .valueOf(2));
            isGekuerzt = r1.getNumerator().equals(BigInteger.valueOf(2)) && r1
                    .getDenominator().equals(BigInteger.valueOf(1));
            try {
                    new BigRational(BigInteger.valueOf(4), BigInteger.valueOf(0));
            } catch (ArithmeticException e) {
                    isZeroSave = true;
            }

            BigRational r3 = new BigRational(BigInteger.valueOf(1), BigInteger
                    .valueOf(-2));
            hasSignInNumerator = r3.getNumerator().equals(BigInteger.valueOf(-1))
                    && r3.getDenominator().equals(BigInteger.valueOf(2));
            
            assertTrue(isGekuerzt && isZeroSave && hasSignInNumerator);
            
     // was beweist diese test? 
      // wer kann diser test schreiben? nur der entwickler? nein , man muss chnittstelle verstehen , man muss wissen was kann nicht gut gehen
            
    }

	@Test
	void testBigRationalLongLong() {
		fail("Not yet implemented");
	}

	@Test
	void testBigRationalBigInteger() {
		fail("Not yet implemented");
	}

	@Test
	void testBigRationalLong() {
		fail("Not yet implemented");
	}

	@Test
	void testReverse() {
		fail("Not yet implemented");
	}

	@Test
	void testNegate() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testSubtract() {
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		fail("Not yet implemented");
	}

	@Test
	void testDivide() {
		fail("Not yet implemented");
	}

	@Test
	void testPow() {
		fail("Not yet implemented");
	}

	@Test
	void testSignum() {
		fail("Not yet implemented");
	}

	@Test
	void testValueOf() {
		fail("Not yet implemented");
	}

	@Test
	void testCompareTo() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNumerator() {
		fail("Not yet implemented");
	}

	@Test
	void testGetDenominator() {
		fail("Not yet implemented");
	}

}

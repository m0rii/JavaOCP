package wbs.concurrent.variante;

import java.math.BigInteger;
/*
 * wir geben nun alle paare con primezahzwillingen aus, wiederum austigend sortiert
 */
public class TwinPrimesPair implements Comparable<TwinPrimesPair> {
   
	BigInteger first;
	BigInteger second;
	public TwinPrimesPair(BigInteger first , BigInteger second) {
		this.first =first;
		this.second = second;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "(" + first + "," + second + ")";
	}
	@Override
	public int compareTo(TwinPrimesPair pair) {
		// TODO Auto-generated method stub
		return this.first.compareTo(pair.first);
	}
    
}

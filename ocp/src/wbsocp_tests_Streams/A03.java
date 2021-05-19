package wbsocp_tests_Streams;

import java.util.stream.Stream;

//welche der folgenden methoden von Stream sind intermediate? skip , distinct ? collect
//anyMatch()
//count()
//skip() 
//findFirst()
//distinct() 
//collect()
//findAny()

//welche der folgenden behauptungen ist richtig?
//der code terminiert.
//der code terminiert nicht.
//der code wirft eine exception.
public class A03 {
	public static void main(String[] args) {
		Stream.iterate(2, n -> n + 2).filter(n -> n % 2 == 1).limit(5).findAny().get();
	//der code terminiert nicht.
	}
}
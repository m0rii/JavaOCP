package wbs.stream.basic;

import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.stream.IntStream;


public class AverageDemo {
	//wir illustieren 2 verschieden wege , den durchschnitt aller elemente
	// eines IntStream zu ermitteln
	
	public static IntStream createStream() {
		IntStream is;
		is = Math.random() < 0.33 ? IntStream.empty() : Math.random() < 0.66 ? IntStream.of(0) : IntStream.of(-1,1,-2,2);
		return is;
	}

	public static void main(String[] args) {	
		double avg = createStream().summaryStatistics().getAverage();	
		System.out.println("getAverage() von IntSummaryStatics: " + avg);
		
		OptionalDouble optional = createStream().average();
		DoubleConsumer consumer = x -> System.out.println("average() von IntStream:" + x);
		optional.ifPresent(consumer);
		
		

	}

}

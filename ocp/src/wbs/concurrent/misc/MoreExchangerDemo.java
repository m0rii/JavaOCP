package wbs.concurrent.misc;

import java.util.concurrent.Exchanger;
import java.util.stream.Stream;

/*
 * macht dasselbe wie ExchangerDemo, kommt aber ohne die hilfsklassen
 * ExchangingThread_1 und ExchangingThread_2 aus.
 */
public class MoreExchangerDemo {

        public static void main(String[] args) {
            Exchanger<String> exchanger = new  Exchanger<String>();
            
        Stream.of("One","Two").forEach(s -> new Thread(() -> {
        	String recieved;
        	try {
        		Thread.sleep(s.equals("One") ? 2000 : 5000);
        	}catch(Exception e) {
        		
        	}
        	System.out.println(
        			Thread.currentThread().getName() + " exchanging " +s);
        	try {
        		recieved = exchanger.exchange(s);
        		System.out.println(
            			Thread.currentThread().getName() + " recieving " +recieved);
        	}catch(Exception e) {
        		
        	}
       
        }).start());
       
                
        }
}

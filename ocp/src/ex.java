import java.io.IOException;
import java.time.LocalDate;

public class ex {
	 int i=5;
int y=5;

       
	public static void main(String[] args)  {
		new ex().print(2);
	
		int x =0;
		try {
			
			
		}catch (ArithmeticException i) {
		
			System.out.println(i+  "" +x);
		}
		
		LocalDate d = LocalDate.ofYearDay(2016, 40);
		System.out.println(d.getMonthValue());
		
	}
	public  void print(int i) {
	    System.out.println(i+y);
	    int y =4;
	}
}

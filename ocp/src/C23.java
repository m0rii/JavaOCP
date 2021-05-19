import java.util.Arrays;
import java.util.Date;

public class C23 {
	int y =3;
	 static int x = 10;
	
	float f = 1;
	long l = 20000000000l;
	long l2 = 200;
	
    public static void main(String[] args) {
    	int x3 =0;
   System.out.println(x3);
   
   int big = 3;
   int smal = 5;
   System.out.println(big > smal);
   
      int a[][] = new int [3][];
      a[2]= new int [] {1,2,3};
      System.out.println(a[2][2]);
      
      //int [][] ints = new int [2][];
     // Arrays.sort(ints);
      new C23().print();
      
      int x= 9;
  	System.out.println(x);
  	System.out.println(new Date());
  	
  	for(int i =10; i<14;System.out.println(i)) 
  		i++;
  	
  	

     }
    
    public void print() {
    	int x= 8;
    	System.out.println(x);
    }

}
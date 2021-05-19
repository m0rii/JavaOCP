import java.io.IOException;
import java.util.Arrays;

public class test2 {
	int o = y;
	static int y;
	static boolean b = false;
	
    public static void main(String[] args) {
    	
        short s = 1;
        Short s2 = new Short((short) 5);
        int c = new Integer(5);
        
        char c2 = new Character('a');
        
        byte b6 = new Byte((byte) 5);
        
        b6+=1;
       System.out.println(b6);
        
        
        System.out.println(c);
        System.out.println(s2);
        
    	Boolean b = Boolean.valueOf("yes");
    	System.out.println(b);
    	String str = null;
    	if(b=true) {str ="true";}
    	str = b?str:"false";
    			
    	y++;
    	System.out.println(y);
		double db[] = {10,11};
		int[] x = new int[3];
		Arrays.fill(x, 1);
		for(int i : x) System.out.println(i);
		
	
		
		
        System.out.println(db[1]);
        
        
	}
    public static void test()  {
    	
    }
}

package ccinterviews.bit;

public class BitShiftTest {
	public static void main(String args[]) {
	       
	     int number = 8; //0000 1000
	     System.out.println("Original number : " + number+" Binary: "+Integer.toBinaryString(number));
	     
	   
	     //left shifting bytes with 1 position
	     number = number<<1; //should be 16 i.e. 0001 0000

	     //equivalent of multiplication of 2
	     System.out.println("value of number after left shift: " + number+" Binary: "+Integer.toBinaryString(number));

	     
	     number = -8;
	     System.out.println("Original number : " + number+" Binary: "+Integer.toBinaryString(number));
	     //right shifting bytes with sign 1 position
	     number = number>>1; //should be 16 i.e. 0001 0000

	     //equivalent of division of 2
	     System.out.println("value of number after right shift with sign: " + number+" Binary: "+Integer.toBinaryString(number));
	   
	     number = -8;
	     System.out.println("Original number : " + number+" Binary: "+Integer.toBinaryString(number));
	     //right shifting bytes without sign 1 position
	     number = number>>>1; //should be 16 i.e. 0001 0000

	     //equivalent of division of 2
	     System.out.println("value of number after right shift with sign: " + number+" Binary: "+Integer.toBinaryString(number));
	     
	     
	     int t = -24;
	     System.out.println("Original: "+t+" Binary:\t\t"+Integer.toBinaryString(t));
	     int mask = 0x7fffffff;
	     int pos_t = t & mask;
	     System.out.println("Positive: "+pos_t+" Binary:\t"+Integer.toBinaryString(pos_t));
	     System.out.println("Mask: "+mask+" Binary:\t"+Integer.toBinaryString(mask));
	   
	    }  


}

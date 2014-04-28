package ccinterviews.bit;

public class BitManipulation {

	public static boolean getBit(int num, int i) {
		int mask = 1 << i;
		return (num & mask) != 0;
	}
	
	public static int setBit(int num, int i) {
		int mask = 1 << i;
		return num | mask;
	}
	
	public static int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}
	
	
	
	public static void main(String[] args) {
		int a = Integer.parseInt("00010010", 2);;
		System.out.println(a);
		System.out.println(getBit(a, 4));
		System.out.println(Integer.toBinaryString(setBit(a, 3)));
		System.out.println(Integer.toBinaryString(clearBit(a, 3)));
	}
}

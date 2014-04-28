package ccinterviews.bit;

public class BaseConverter {

	private static int digitToValeu(char c) {
		if(c >= '0' && c <='9') return c - '0';
		else if(c >= 'A' && c <= 'F') return 10 + c - 'A';
		else if(c >= 'a' && c <= 'f') return 10 + c - 'a';
		return -1;
	}
	
	public static int toDecimal(String number, int base) {
		if(base < 2 || (base > 10 && base != 16)) {
			return -1;
		}
		
		int val = 0;
		//for(int i = number.length() - 1; i >= 0; i--) {
		for(int i = 0; i < number.length(); i++) {
			int digit = digitToValeu(number.charAt(i));
			if(digit < 0 || digit >= base) return -1;
			//int exp = number.length() - 1 - i;
			//val += digit * Math.pow(base, exp);
			val = digit + (base * val);
		}
		return val;
	}
	
	public static void main(String[] args) {
		System.out.println(toDecimal(Integer.toBinaryString(24), 2));
	}
}

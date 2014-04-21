package topcoder.srm.april21.srm617;

public class SilverbachConjecture {

	boolean isPrime(int n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    int sqrtN = (int)Math.sqrt(n)+1;
	    for(int i = 6; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
	
	
	public int[] solve(int n) {
		
		for(int i = 4; i <= n/2; i++) {
			int a = i;
			int b = n - i;
			if(isPrime(a)==false && isPrime(b)==false) {
				int[] res = {a, b};
				return res;
			}
		}
		
		return new int[2];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SilverbachConjecture s = new SilverbachConjecture();
		
		int[] res = s.solve(30);
		System.out.println(res[0]+" "+res[1]);

	}

}

package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//TLE with java but AC with C++
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Prob11849 {

	public void solution(InputStream inStream) {
		Scanner in = new Scanner(inStream);
		
		while(in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			if(n==0 && m==0) break;
			
			//int[] jacks = new int[n];
			//Set<Integer> jacks = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				int x = in.nextInt();
				//jacks[i] = x;
				//jacks.add(x);
				
			}
			
			int sell = 0;
			for(int i=0;i<m;i++) {
				int x = in.nextInt();
//				if(Arrays.binarySearch(jacks, x) >= 0) {
//					sell++;
//				}
//				if(jacks.contains(x)) {
//					sell++;
//				}
			}
			
			System.out.println(sell);
			
			
		}
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob11849 sol = new Prob11849();
//	
//		FileInputStream fis = new FileInputStream("input/11849.txt");
//		sol.solution(fis);
//	
//
//
//	}	
}


//class Main {
//	public static void main(String[] args)  {
//		Prob11849 sol = new Prob11849();
//	
//		sol.solution(System.in);
//	
//
//
//	}	
//
//}
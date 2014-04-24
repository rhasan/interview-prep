package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.Scanner;



class Prob10038 {
	public void solution(InputStream inStream) {
		Scanner in = new Scanner(inStream);
		
		while(in.hasNext()) {
			int N = in.nextInt();
			boolean[] taken = new boolean[N+1]; 
			int x = in.nextInt();
			if(N == 1) {
				System.out.println("Jolly");
				continue;
			}
			for(int i = 1; i < N; i++) {
				int y = in.nextInt();
				int diff = Math.abs(x - y);
				//System.out.println(diff+" "+(x-y));
				x = y;
				
				if(diff > 0 && diff <= N)
					taken[diff] = true;
			}
			boolean jolly = true;
			for(int i = 1; i < N; i++) {
				if(taken[i] == false) {
					jolly = false;
					//System.out.println(" break "+i);
					break;
				}
			}
			if(jolly) {
				System.out.println("Jolly");
			} else {
				System.out.println("Not jolly");
			}

		
		}
		in.close();
		
		
		
	}

//	public static void main(String[] args) throws FileNotFoundException {
//		Prob10038 sol = new Prob10038();
//		
//		FileInputStream fis = new FileInputStream("input/10038.txt");
//		sol.solution(fis);
//		
//		//sol.solution(System.in);
//	
//	}

}


//class Main {
//
//	public static void main(String[] args) {
//		Prob10038 sol = new Prob10038();
//		
//		
//		sol.solution(System.in);
//	
//	}
//}

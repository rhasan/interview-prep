package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Prob11917 {

	
	public void solution(InputStream source) {
		Scanner in = new Scanner(source);
		
		int N = in.nextInt();
		
		for(int test = 1; test <= N; test++) {
			System.out.print("Case "+test+": ");
			Map<String, Integer> subjects = new HashMap<String, Integer>();
			int ns = in.nextInt();
			
			for(int i = 0; i < ns; i++) {
				String s = in.next();
				int sd = in.nextInt();
				//System.out.println(s+" "+sd);
				subjects.put(s, sd);
			}
			int D = in.nextInt();
			String as = in.next();
			//System.out.println("assignment: "+D+" "+as);
			
			int sohaDay = subjects.containsKey(as)?subjects.get(as):-1;
			if(sohaDay < 0 ) {
				System.out.println("Do your own homework!");
				continue;
			}
			
			if(sohaDay <= D) {
				System.out.println("Yesss");
			} else if(sohaDay <= D+5) {
				System.out.println("Late");
			} else {
				System.out.println("Do your own homework!");
			}
		}
	}
	
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob11917 sol = new Prob11917();
//
//		FileInputStream fis = new FileInputStream("input/11917.txt");
//		sol.solution(fis);
//
//	}	
}

class Main {

	public static void main(String[] args) {
		Prob11917 sol = new Prob11917();

		sol.solution(System.in);

	}
}



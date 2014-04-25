package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Prob484 {

	public void solution(InputStream source) {
		Scanner in = new Scanner(source);
		
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		Map<Integer, Integer> order = new HashMap<Integer,Integer>();
		
		int i = 0;
		while(in.hasNext()) {
			int x = in.nextInt();
			if(numbers.containsKey(x)) {
				numbers.put(x, numbers.get(x)+1);
			} else {
				numbers.put(x, 1);
				order.put(i, x);
				i++;
			}
			
			
		}
		int total = i;
		
		for(int k = 0; k < total; k++) {
			int x = order.get(k);
			System.out.println(x+" "+numbers.get(x));
		}
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob484 sol = new Prob484();
//
//		FileInputStream fis = new FileInputStream("input/484.txt");
//		sol.solution(fis);
//
//	}	
	
	
}


//class Main {
//
//	public static void main(String[] args) {
//		Prob484 sol = new Prob484();
//
//		sol.solution(System.in);
//
//	}
//}
//

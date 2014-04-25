package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Prob11286 {
	public static int N_COURSES = 5;
	public void solution(InputStream source) {
		Scanner in = new Scanner(source);
		
		
		
		while(in.hasNext()) {
			int n = in.nextInt();
			if(n == 0) break;
			
			int maxVal = -1;
			String maxComb = "";
			Map<String, Integer> comb = new HashMap<String, Integer>();
			for(int f = 0; f < n; f++) {
				
				int[] courses = new int[N_COURSES];
				for(int i = 0; i < N_COURSES; i++) {
					int x = in.nextInt();
					courses[i] = x;
				}
				String key = combId(courses);
				//System.out.println("Key:"+key);
				int val = 1;
				if(comb.containsKey(key)) {
					val = comb.get(key)+1;
				}
				
				comb.put(key, val);
				if(maxVal < val) {
					maxVal = val;
					maxComb = key;
				}
			}
			
			//System.out.println();
			int count = 0;
			for(Entry<String, Integer> entry:comb.entrySet()) {
				if(maxVal == entry.getValue()) {
					//System.out.println(entry.getKey());
					count += maxVal;
				}
			}
			System.out.println(count);
		}
		
		in.close();
	}
	
	private String combId(int[] courses) {
		Arrays.sort(courses);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N_COURSES; i++) {
			sb.append(Integer.toString(courses[i]));
		}
		
		return sb.toString();
	}
	
	
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob11286 sol = new Prob11286();
//
//		FileInputStream fis = new FileInputStream("input/11286.txt");
//		sol.solution(fis);
//
//	}	
}



//class Main {
//
//	public static void main(String[] args) {
//		Prob11286 sol = new Prob11286();
//
//		sol.solution(System.in);
//
//	}
//}

package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//TLE with java input functions
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Prob10282 {

	
	public void solution(InputStream source) {
		Scanner in = new Scanner(source);
		
		Map<String, String> dict =  new HashMap<String, String>();
		
		while(in.hasNext()) {
			String line = in.nextLine();
			if(line.trim().isEmpty()) break;
			
			String[] words = line.split(" ");
			dict.put(words[1].toLowerCase(), words[0]);
		}
		
		while(in.hasNext()) {
			String line = in.nextLine();
			if(dict.containsKey(line)) {
				System.out.println(dict.get(line));
			} else {
				System.out.println("eh");
			}
		}
		
		in.close();
		
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob10282 sol = new Prob10282();
//
//		FileInputStream fis = new FileInputStream("input/10282.txt");
//		sol.solution(fis);
//
//	}
}

//class Main {
//
//	public static void main(String[] args) {
//		Prob10282 sol = new Prob10282();
//
//		sol.solution(System.in);
//
//	}
//}
//

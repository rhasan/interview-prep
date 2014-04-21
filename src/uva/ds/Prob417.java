package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class Prob417 {

	Map<String, Integer> map = new HashMap<String, Integer>();
	int total = 0;
	private void generate() {
		int total = 1;
		for(char i = 'a'; i <= 'z'; i++) {
			String str = ""+i;
			map.put(str, total++);
		}

		for(char i = 'a'; i <= 'z'; i++) {
			String str1 = ""+i;
			//map.put(str, total++);
			for(char j = (char)((int)i+1); j <= 'z'; j++) {
				String str2 = str1 + j;
				map.put(str2, total++);
				
			}
		}
		

		
		for(char i = 'a'; i <= 'z'; i++) {
			String str1 = ""+i;

			for(char j = (char)((int)i+1); j <= 'z'; j++) {
				String str2 = str1 + j;

				for(char k = (char)((int)j+1); k <= 'z'; k++) { 
					String str3 = str2 + k;
					map.put(str3, total++);
					
				}
				
			}
		
		}
		

		for(char i = 'a'; i <= 'z'; i++) {
			String str1 = ""+i;
			//map.put(str, total++);
			for(char j = (char)((int)i+1); j <= 'z'; j++) {
				String str2 = str1 + j;
				
			}

			for(char j = (char)((int)i+1); j <= 'z'; j++) {
				String str2 = str1 + j;


				for(char k = (char)((int)j+1); k <= 'z'; k++) { 
					String str3 = str2 + k;
					
					for(char l = (char)((int)k+1); l <= 'z'; l++) {
						String str4 = str3 + l;
						map.put(str4, total++);
						
					}

				}
				
			}
		
		}
		
		for(char i = 'a'; i <= 'z'; i++) {
			String str1 = ""+i;

			for(char j = (char)((int)i+1); j <= 'z'; j++) {
				String str2 = str1 + j;


				for(char k = (char)((int)j+1); k <= 'z'; k++) { 
					String str3 = str2 + k;
					

					for(char l = (char)((int)k+1); l <= 'z'; l++) {
						String str4 = str3 + l;

						for(char m = (char)((int)l+1); m <= 'z'; m++) {
							
							String str5 = str4 + m;
							//System.out.println("final:"+str5+" rank:"+(total+1));
							
							map.put(str5, total++);
							
							
						}
					}
				}
				
			}
		
		}
		//System.out.println(map.size());
		//System.out.println(total);
		//System.out.println("-------------");
		
	}
	public void solution(InputStream inStream) {
		//map.put("", 0);
		generate();
		//System.out.println(total);
		
		Scanner in = new Scanner(inStream);
		
		while(in.hasNext()) {
			String str = in.nextLine();
			if(map.containsKey(str)) {
				System.out.println(map.get(str));
			} else {
				System.out.println(0);
			}
		}
		
	}
	
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob417 sol = new Prob417();
//		FileInputStream fis = new FileInputStream("input/417.txt");
//		sol.solution(fis);
//		
//	}	
}


class Main {

//	public static void main(String[] args) throws FileNotFoundException {
//		Prob417 sol = new Prob417();
//		FileInputStream fis = new FileInputStream("in/h.in");
//		sol.solution(fis);
//		
//	}

	public static void main(String[] args) {
		Prob417 sol = new Prob417();
		sol.solution(System.in);
		
	}
		
		
}
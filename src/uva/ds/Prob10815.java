package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Prob10815 {
	public void solution(InputStream inStream) {
		Scanner in = new Scanner(inStream);
		Set<String> set = new TreeSet<String>();
		while(in.hasNext()) {
			String line = in.nextLine();
			//System.out.println(line);
			StringTokenizer tokenizer = new StringTokenizer(line, " \t\n\r\f!\"#$%&'()*+,-./0123456789:;<=>?@[]^_`{|}~\\");
			//" `~!@#$%^&*()-+_={}|\\[]'\";:/?.>,<"
			while(tokenizer.hasMoreElements()) {
				set.add(tokenizer.nextToken().toLowerCase());
			}

		}
		for(String s:set) {
			if(s.trim().isEmpty()==false)
				System.out.println(s);
		}
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob10815 sol = new Prob10815();
//
//		FileInputStream fis = new FileInputStream("input/10815.txt");
//		sol.solution(fis);
//
//	}	
	
}


class Main {

	public static void main(String[] args) {
		Prob10815 sol = new Prob10815();
		
		
		sol.solution(System.in);
	
	}
}
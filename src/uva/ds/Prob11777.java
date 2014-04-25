package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

class Prob11777 {

	public void solution(InputStream source) {
		Scanner in = new Scanner(source);
		
		int testCases = in.nextInt();
		for(int test = 1; test <= testCases; test++) {
			System.out.print("Case "+test+": ");
			// Term1  Term2  Final  Attendance  Class_Test1  Class_Test2  Class_Test3
			double term1 = in.nextInt();
			double term2 = in.nextInt();
			double fnl = in.nextInt();
			double att = in.nextInt();
			double[] tests = new double[3];
			tests[0] = in.nextInt();
			tests[1] = in.nextInt();
			tests[2] = in.nextInt();
			Arrays.sort(tests);
			double testScore = (tests[1] + tests[2]) / 2;
			
			double total = term1 + term2 + fnl + att + testScore;
			System.out.println(grade(total));
			
			
		}
	}
	
	private String grade(double score) {
		
		if(score >= 90.0) {
			return "A";
		} else if(score >= 80.0 && score < 90.0) {
			return "B";
		} else if(score >= 70.0 && score < 80.0) {
			return "C";
		} else if(score >= 60.0 && score < 70.0) {
			return "D";
		}
		return "F";
	}
	
//	public static void main(String[] args) throws FileNotFoundException {
//		Prob11777 sol = new Prob11777();
//
//		FileInputStream fis = new FileInputStream("input/11777.txt");
//		sol.solution(fis);
//
//	}
}

//
//class Main {
//
//	public static void main(String[] args) {
//		Prob11777 sol = new Prob11777();
//
//		sol.solution(System.in);
//
//	}
//}


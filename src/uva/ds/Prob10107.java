package uva.ds;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Prob10107 {
	public void solution(InputStream inStream) {
		Scanner in = new Scanner(inStream);
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(in.hasNext()) {
			int x = in.nextInt();
			insert(list, x);
			//show(list);
			int median = median(list);
			System.out.println(median);
		}
	}
	private void show(List<Integer> list) {
		for(int x:list) {
			System.out.print(x+" ");
		}
		
		System.out.println();
	}
	private int median(List<Integer> list) {
		int size = list.size();
		if(size == 1) {
			return list.get(0);
		}
		//System.out.println("Size:"+size);
		if(size%2 != 0) {
			return list.get((size-1)/2);
		}
		int first = (size-2)/2;
		int second = first+1;
		long sum = (long)list.get(first) + (long)list.get(second);
		return (int) ( sum / (long)2); 
	}
	
	
	public void insert(List<Integer> list, int x) {
//	    int pos = Collections.binarySearch(list, x);
//	    if (pos < 0) {
//	        list.add(-pos-1, x);
//	    }
		int i=0;
		for(;i<list.size();i++) {
			if(!(x<list.get(i))) break;
		}
		list.add(i, x);
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Prob10107 sol = new Prob10107();
	
		FileInputStream fis = new FileInputStream("input/10107.txt");
		sol.solution(fis);
	


	}	

}

//class Main {
//
//	public static void main(String[] args) {
//		Prob10107 sol = new Prob10107();
//		
//		
//		sol.solution(System.in);
//	
//	}
//}

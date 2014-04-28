package builtin.datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaHeap {

	public static Integer[] input = {10,50,6000,85,3,1,100};
	
	
	
	public static void testMinHeap() {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int x:input) {
			minHeap.add(x);
		}
		
		while(minHeap.isEmpty() == false) {
			System.out.println(minHeap.poll());
		}
		
		//remove(obj) O(n)
		//pool() O(log(n)) 
		//add(e)/offer(e) O(log(n))
	}
	
	public static void testMaxHeap() {
		MaxHeapCmp cmp = new MaxHeapCmp();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, cmp);
		for(int x:input) {
			maxHeap.add(x);
		}
		
		while(maxHeap.isEmpty() == false) {
			System.out.println(maxHeap.poll());
		}
		
		//remove(obj) O(n)
		//pool() O(log(n)) 
		//add(e)/offer(e) O(log(n))
	}
	
	
	public static void main(String[] agrs) {
		testMinHeap();
		testMaxHeap();
	}
}

class MaxHeapCmp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o2 - o1;
	}
	
}
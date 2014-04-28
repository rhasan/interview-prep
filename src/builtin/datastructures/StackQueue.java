package builtin.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
	public Integer[] input = {10,50,6000,85,3,1,100};
	
	public void testStack() {
		System.out.println("java.util.Stack");
		Stack<Integer> stack = new Stack<Integer>();
		for(int x:input) {
			stack.push(x);
		}
		while(stack.isEmpty() == false) {
			System.out.println(stack.pop());
		}
		
		Deque<Integer> dqStack = new ArrayDeque<Integer>();
		
		
		System.out.println("java.util.Deque");
		for(int x:input) {
			dqStack.push(x);
		}
		while(dqStack.isEmpty() == false) {
			System.out.println(dqStack.pop());
		}
		
	}
	
	
	public void testQueue() {
		System.out.println("java.util.Queue");
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int x:input) {
			queue.add(x);
		}
		while(queue.isEmpty() == false) {
			System.out.println(queue.poll());
		}
		

	}
	
	public static void main(String[] args) {
		StackQueue sq = new StackQueue();
		sq.testStack();
		sq.testQueue();
	}
}

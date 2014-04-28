package builtin.datastructures;

import java.util.TreeSet;

public class SetTest {

	public static void testTreeSet() {
		Integer[] input = {10,50,6000,85,3,1,100};
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int x:input) {
			set.add(x);
		}
		for(int x:set.descendingSet()) {
			System.out.println(x);
		}
	}
	
	public static void main(String[] args) {
		testTreeSet();
	}
}

package datastructures;

import static org.junit.Assert.*;

import org.junit.Test;

public class DSTest {

	@Test
	public void testLinkedList() {
		//fail("Not yet implemented");
		
		LinkedList<String> ll = new LinkedList<String>();
		
		//adding to the head
		ll.add("element 1");
		ll.add("element 2");
		ll.add("element 3");
		ll.add("element 4");
		
		for(String s:ll){
			System.out.print(s+", ");
		}
		System.out.println();

		//adding to the tail
		ll.addToTail("element 5");
		ll.addToTail("element 6");
		ll.addToTail("element 7");
		ll.addToTail("element 8");
		
		for(String s:ll){
			System.out.print(s+", ");
		}
		System.out.println();		
		
	}

}

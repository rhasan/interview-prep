package builtin.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortingTest {
	public void testMergeSorting() {
		
		Person p1 = new Person("Bob", 1);
		Person p2 = new Person("Alice", 2);
		Person p3 = new Person("Claire",3);
		
		List<Person> list = new ArrayList<Person>();
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		Collections.sort(list, new PersonCmp());
		for(Person p:list) {
			System.out.println(p);
		}
		
		
	}
	
	private void showList(List<Integer> list) {
		for(int x:list) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	public void testShuffleAndQucikSort() {
		int[] input = {10,50,6000,85,3,1,100};
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int x:input) {
			list.add(x);
		}
		//no shuffle method in Arrays
		Collections.shuffle(list);
		showList(list);
		Collections.sort(list);
		showList(list);
		
		
	}
	
	private class Person {
		String name;
		int id;
		public Person(String name, int id) {
			this.name = name;
			this.id = id;
		}
		@Override
		public String toString() {
			
			return "("+name+", "+Integer.toString(id)+")";
		}
	}
	
	private class PersonCmp implements Comparator<Person> {
		@Override
		public int compare(Person p1, Person p2) {
			
			return p1.name.compareTo(p2.name);
		}
	}
	
	
	public static void main(String[] args) {
		SortingTest st = new SortingTest();
		st.testMergeSorting();
		st.testShuffleAndQucikSort();
	}
	
}

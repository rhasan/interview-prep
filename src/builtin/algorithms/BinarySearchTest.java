package builtin.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;




public class BinarySearchTest {
	
	public void testBinarySearch() {
		
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
		
		Person p = new Person("Alice",0);
		int pos = Collections.binarySearch(list,p, new PersonCmp());
		if(pos >=0) {
			System.out.println("Found: "+list.get(pos));
		}
		p = new Person("A",0);
		pos = Collections.binarySearch(list,p, new PersonCmp());
		if(pos >=0) {
			System.out.println("Found: "+list.get(pos));
		} else {
			System.out.println("Not found, insert position: "+(-pos-1));
		}
		
		
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
		BinarySearchTest bstest = new BinarySearchTest();
		bstest.testBinarySearch();
	}
}

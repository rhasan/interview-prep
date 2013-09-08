package datastructures;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Generic linked list 
 * @author Rakebul
 *
 * @param <Item> Item data type
 */
public class LinkedList<Item> implements Iterable<Item> {

	//number of elements
	private int N;
	//first element of the list
	private Node first;
	//last element of the list
	private Node last;
	
	/**
	 * Helper linked list class
	 * @author Rakebul
	 *
	 */
	private class Node {
		private Item item;
		private Node next;
	}
	
	/**
	 * Initializes an empty linked list
	 */
	public LinkedList() {
		first = null;
		last = null;
		N = 0;
	}
	
	
	/**
	 * Size of the linked list
	 * @return size of the linked list
	 */
	public int size() {
		return N;
	}
	
	/**
	 * Adds an item to the head of the list
	 * @param item item to add
	 */
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
		if (oldFirst == null) {
			last = first;
		}
	}
	
	/**
	 * Adds an item to the tail of the list
	 * @param item item to add
	 */
	public void addToTail(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		
		if(oldLast!=null) {
			oldLast.next = last;
		}
		else if(oldLast==null) {
			first = last;
		}
		
		N++;
	}
	
	/**
	 * Iterator class for linked list
	 * @author Rakebul
	 *
	 */
	private class ListIterator implements Iterator<Item> {
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			
			return current!=null;
		}

		@Override
		public Item next() {
			if(hasNext()==false) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			 throw new UnsupportedOperationException();
			
		}
		
	}
	
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

}

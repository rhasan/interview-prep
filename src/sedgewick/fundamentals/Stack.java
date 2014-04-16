package sedgewick.fundamentals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class Stack<Item> implements Iterable<Item> {
	private Node<Item> first;
	private int N;
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}
	
	public Stack() {
		first = null;
		N = 0;
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item item) {
		Node<Item> node = new Node<Item>();
		node.item = item;
		node.next = first;
		first = node;
		N++;
	}
	
	public Item pop() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	
	public Item peek() {
		if(isEmpty()) throw new NoSuchElementException("Stack underflow");
		return first.item;
	}
	
    
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}	
	
	private class ListIterator implements Iterator<Item> {
		private Node<Item> current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	/**
     * Unit tests the <tt>Stack</tt> data type.
     */
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }



}

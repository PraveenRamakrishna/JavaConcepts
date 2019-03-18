package concepts.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Doubly-linked list implementation of the List and Deque interfaces
 * Main difference between ArrayList and LinkedList is that ArrayList is implemented using re sizable array 
 * while LinkedList is implemented using doubly LinkedList
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument  
 */
public class UnderstandLinkedList {
	
	static List<String> arrayList = null;
	
	static LinkedList<String> linkedList = null;
	
	static long startTime ; 
	
	static long endTime ; 
	

	public static void main(String[] args) {
		
		insertingRemovingElements();
		
		positionalAccess();
		
		dequeMethodImplementations();
		
		stackImplementation();
		
	}
	
	/**
	 * You will pay a big price in performance for Positional access which
	 * requires linear-time in a LinkedList and constant-time in an ArrayList.
	 */
	private static void positionalAccess() {
		System.out.println("\nPositional Access:");
		arrayList = new ArrayList<String>(Collections.nCopies(10000,"TEMP"));
		linkedList = new LinkedList<String>(Collections.nCopies(10000, "TEMP"));
		int position = (int) (Math.random() * (9999 - 1)) + 1;
		//LinkedList
		startTime = System.nanoTime();
		linkedList.get(position);
		endTime = System.nanoTime();
		System.out.print(" Time taken to positional access an element at " + position + " position by Linked List: "	+ (endTime - startTime));
		//ArrayList
		startTime = System.nanoTime();
    	arrayList.get(position);
    	endTime = System.nanoTime();
    	System.out.println(" Array List: " + (endTime - startTime));
	}


	/**
	 * If you frequently add elements to the beginning of the List or iterate over the List to delete elements from its interior, 
	 * you should consider using LinkedList.These operations require constant-time in a LinkedList and linear-time in an ArrayList
	 */
	private static void insertingRemovingElements() {
		
		arrayList = new ArrayList<String>(Collections.nCopies(10000, "TEMP"));
		
		linkedList = new LinkedList<String>(Collections.nCopies(10000, "TEMP"));
	
		System.out.println("Inserting Removing Elements: \n Removing elements to the beginning:");
		for (int i = 0; i < 3; i++) {
			//LinkedList
			startTime = System.nanoTime();
	    	linkedList.remove(i);
	    	endTime = System.nanoTime();
	    	System.out.print("  Time taken to remove an element at "+i+" position by Linked List: " + (endTime - startTime));
	    	//ArrayList
	    	startTime = System.nanoTime();
	    	arrayList.remove(i);
	    	endTime = System.nanoTime();
	    	System.out.println(" Array List: " + (endTime - startTime));
		}
		
		System.out.println(" Adding elements to the beginning:");
		for (int i = 0; i < 3; i++) {
			//LinkedList
			startTime = System.nanoTime();
	    	linkedList.add(i,"TEMP");
	    	endTime = System.nanoTime();
	    	System.out.print("  Time taken to add an element at "+i+" position by Linked List: " + (endTime - startTime));
	    	//ArrayList
	    	startTime = System.nanoTime();
	    	arrayList.add(i,"TEMP");
	    	endTime = System.nanoTime();
	    	System.out.println(" Array List: " + (endTime - startTime));
		}
		
	}
		

	/**
	 * Deque supports the insertion and removal of elements at both end points.
	 * Deque interface is a richer abstract data type than both Stack and Queue because it implements both stacks 
	 * and queues at the same time
	 * The methods given in the Deque interface are divided into three parts:
	 *  1. Insert
	 *  2. Remove
	 *  3. Examine / Retrieve 
	 */
	private static void dequeMethodImplementations() {
		linkedList = new LinkedList<String>();

		linkedList.addFirst("First");
		linkedList.addFirst("Middle");
		linkedList.addLast("Last");
		
		//Retrieves, but does not remove, the first/Last element of this list, throws an exception if the list is empty.
		assert  "First".equals(linkedList.getFirst());
		assert "Last".equals(linkedList.getLast());
		
		//Removes and returns the first/Last element from this list, throws an exception if the list is empty.
		assert "First".equals(linkedList.removeFirst());
		assert "Last".equals(linkedList.removeLast());
				
		assert 0 == linkedList.size();
		
		//Inserts the specified element at the front/end of this list
		assert linkedList.offerFirst("First");
		assert linkedList.offerLast("Last");
		
		//Retrieves, but does not remove, the first/Last element of this list, or returns null if this list is empty.
		assert "First".equals(linkedList.peekFirst());
		assert "Last".equals(linkedList.peekLast());			
		
		//Removes and removes, the first/last element of this list, or returns null if this list is empty.
		assert "First".equals(linkedList.pollFirst());
		assert "Last".equals(linkedList.pollLast());
		
		assert 0 == linkedList.size();
	}
		
		/**
		 *  last-in-first-out stacks implementation
		 */
		private static void stackImplementation() {
			
			linkedList = new LinkedList<String>();
			
			//Inserts an element at front of the List
			linkedList.push("First");
			linkedList.push("Second");

			// removes and returns the first element of this list, throws exception if List is empty
			assert "Second".equals(linkedList.pop());
			assert "First".equals(linkedList.pop());
		}
}

package concepts.collection.deque;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 *  A deque is a double-ended-queue, is a linear collection of elements that supports the insertion and removal of elements at both end points.
 *  The Deque interface is a richer abstract data type than both Stack and Queue because it implements both stacks and queues at the same time.
 *  The Deque interface, defines methods to access the elements at both ends of the Deque instance. 
 *  Methods are provided to insert, remove, and examine the elements
 *  
 *  ArrayDeque, is resizable-array implementation of the Deque interface. Array deques have no capacity restrictions, they grow as necessary to support usage
 *  ArrayDeque, likely to be faster than Stack when used as a stack, and faster than LinkedList when used as a queue.
 *  
 *  Most ArrayDeque operations run in amortized constant time. 
 *  Exceptions include remove, removeFirstOccurrence, removeLastOccurrence, contains, iterator.remove(), 
 *  and the bulk operations, all of which run in linear time
 *  
 *  NOTE: In order to enable assert, please do pass -ea as VM argument  
 */
public class UnderstandArrayDeque {
	
	static long startTime ; 
	
	static long endTime ; 
	
	public static void main(String[] args){
		
		stackImplementation();
		
		isArrayDequeFasterThanLinkedListWhenUsedAsQueue();
		
	}
	
	/**
	 * ArrayDeque, likely to be faster than LinkedList when used as a queue. 
	 */
	private static void isArrayDequeFasterThanLinkedListWhenUsedAsQueue() {
		
		Deque<String> arrayDeque = new ArrayDeque<String>(Collections.nCopies(100, "TEMP"));
		
		Deque<String> linkedList = new LinkedList<String>(Collections.nCopies(100, "TEMP"));
		
		startTime = System.nanoTime();
		assert linkedList.offer("TEMP");
		endTime = System.nanoTime();
		System.out.print(" Time taken to add an element at end of Queue by LinkedList: "	+ (endTime - startTime));
		
		startTime = System.nanoTime();
		assert arrayDeque.offer("TEMP");
    	endTime = System.nanoTime();
    	System.out.println(" ArrayDeque: " + (endTime - startTime));
    	
    	startTime = System.nanoTime();
		linkedList.peek();
		endTime = System.nanoTime();
		System.out.print(" Time taken to retrieve an element from head of Queue by LinkedList: "	+ (endTime - startTime));
		
		startTime = System.nanoTime();
		arrayDeque.peek();
    	endTime = System.nanoTime();
    	System.out.println(" ArrayDeque: " + (endTime - startTime));
    	
    	startTime = System.nanoTime();
		linkedList.poll();
		endTime = System.nanoTime();
		System.out.print(" Time taken to retrieve & remove an element from head of Queue by LinkedList: "	+ (endTime - startTime));
		
		startTime = System.nanoTime();
		arrayDeque.poll();
    	endTime = System.nanoTime();
    	System.out.println(" ArrayDeque: " + (endTime - startTime));
	}

	/**
	 *  last-in-first-out stacks implementation
	 */
	private static void stackImplementation() {
		Deque<String> deque = new ArrayDeque<String>();
		
		//Inserts an element at front of the List
		deque.push("First");
		deque.push("Second");
		
		// removes and returns the first element of this list, throws exception if List is empty
		assert "Second".equals(deque.pop());
		assert "First".equals(deque.pop());
	}
	
}

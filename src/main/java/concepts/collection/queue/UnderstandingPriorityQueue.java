package concepts.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

import concepts.collection.CodingTask;
import concepts.collection.Priority;
import concepts.collection.PriorityTask;

/**
 * Priority Queue are efficiently implemented by Priority Heap, orders elements according to their values.
 * Since it accommodates duplicates, it does not share the requirement of NavigableSet for an ordering consistent with equals.
 * Priority queues is not suitable for concurrent use.
 * 
 * The head of the queue is the least element with respect to the specified ordering. 
 * If multiple elements are tied for least value, the head is one of those elements; ties are broken arbitrarily.
 */
public class UnderstandingPriorityQueue {

	private static Queue<PriorityTask> priorityQueue = new PriorityQueue<PriorityTask>();
	
	public static void main(String[] args) {
		
		isMultipleElementsTiedForLeastValue();

	}

	private static void isMultipleElementsTiedForLeastValue() {
		priorityQueue.offer((new PriorityTask(new CodingTask("DBDesign"),Priority.LOW)));
		priorityQueue.offer((new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM)));
		priorityQueue.offer((new PriorityTask(new CodingTask("Analysis"),Priority.HIGH)));
		priorityQueue.offer((new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)));
		priorityQueue.offer((new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH))) ;
		assert "Analysis : HIGH".equals(priorityQueue.poll().toString());
	}

}

package concepts.collection.list;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ArrayList in Java implements List interface and allow null. 
 * Java ArrayList also maintains insertion order of elements and allows duplicates opposite to
 * any Set implementation which doesn't allow duplicates
 * 
 * ArrayList is implemented using a dynamic array, it increases in size on
 * demand
 * 
 * ArrayList grows at a point where its Size is equal to the capacity.
 * 
 * The Performance of ArrayList reflects that of Array - Performance for "random-access", operation set & get take constant time.
 * 
 * The downside of an array implementation is in inserting or removing arbitrary elements, because that may require adjusting the position of other elements.
 * 
 * If application need is Insertion and removal from the beginning of the List, rather than randomaccess, then its good to use Deque interface with ArrayDeque implementation.
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument  
 */

public class UnderstandArrayList {

	static List<String> tempObjectList = null;
	
	static long startTime ; 
	
	static long endTime ; 
	
	public static void main(String[] args) {
		collectionRemove();
		
		positionalAccess();
		
		searchOperations();
		
		rangeViewOperations();
		
		resizingArrayOnCapacity();
		
		insertingRemovingElements();
		
	}

	
	/**
	 * The remove operation always removes the first occurrence of the specified element from the list
	 */
	private static void collectionRemove() {
		tempObjectList = new ArrayList<String>(Arrays.asList("1","3", "2","3","4","5"));
		tempObjectList.remove("3");
		assert tempObjectList.toString().equals("[1, 2, 3, 4, 5]"):"The first occurrence of the specified element is not removed";
	}
	
	/**
	 * The basic positional access operations are get, set, add and remove. 
	 * The set and remove operations return the old value that is being overwritten or removed.
	 */
	private static void positionalAccess() {
		tempObjectList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		tempObjectList.add(5, "6");
		assert "6".equals(tempObjectList.get(5));
		assert "6".equals(tempObjectList.set(5, " "));
		assert " ".equals(tempObjectList.remove(5));
	}
	
	/**
	 * List returned from range view operations is backed up by the List on which operation was called, 
	 * so changes in the former are reflected in the latter.
	 */
	private static void rangeViewOperations() {
		tempObjectList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		List<String> subList = tempObjectList.subList(1, 4);
		assert ("[2, 3, 4]").equals(subList.toString());
		subList.remove(1);
		assert ("[2, 4]").equals(subList.toString());
		assert ("[1, 2, 4, 5]").equals(tempObjectList.toString());
	}

	/**
	 * Operations (indexOf and lastIndexOf) return the first or last index of the specified element in the list.
	 */
	private static void searchOperations() {
		tempObjectList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5","3",null));
		assert 3 == tempObjectList.indexOf("4");
		assert -1 == tempObjectList.indexOf(" ");
		assert 5 == tempObjectList.lastIndexOf("3");
		assert tempObjectList.contains(null);
 	}

	/**
	 * Because ArrayList is a dynamically resizing array data structure, which
	 * means it is implemented as an array with an initial (default) fixed size.
	 * When this is filled up, the array will be extended to a double sized one
	 * The expansion factor is implementation specific (in this case
	 * (oldCapacity * 3)/2 + 1)
	 */
	private static void resizingArrayOnCapacity() {
		System.out.println("Numbers to back additional time spent while dynamically resizing array: ");
		tempObjectList = new ArrayList<String>(3);
		for (int i = 0; i <= 5; i++) {
			startTime = System.nanoTime();
			tempObjectList.add("TEMP");
			endTime = System.nanoTime();
			System.out.println(" Is adding " + i + "th element resizing array..? leading to more process time: " + (endTime - startTime));
		}
	}
	
	/**
	 * The performance of removing elements from the end of the list is substantially 
	 * better than that of removing elements from the beginning.
	 */
	private static void insertingRemovingElements() {
		tempObjectList = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5"));
		System.out.println("\nNumbers to back removing/adding elements from the arbitrary/end: ");
		// add element at arbitrary & at end, to check performance difference
		startTime = System.nanoTime();
		tempObjectList.add(2,"0");
		endTime = System.nanoTime();
		System.out.println(" Time taken to add an element in arbitrary location: " + (endTime - startTime));
		startTime = System.nanoTime();
		tempObjectList.add("6");
		endTime = System.nanoTime();
		System.out.println(" Time taken to add an element from end: " + (endTime - startTime));
		
		// Delete element at arbitrary & at end, to check performance difference
		startTime = System.nanoTime();
		tempObjectList.remove("0");
		endTime = System.nanoTime();
		System.out.println(" Time taken to remove an element in arbitrary location: " + (endTime - startTime));
		startTime = System.nanoTime();
		tempObjectList.remove("6");
		endTime = System.nanoTime();
		System.out.println(" Time taken to remove an element from end: " + (endTime - startTime));
		
	}
	
}

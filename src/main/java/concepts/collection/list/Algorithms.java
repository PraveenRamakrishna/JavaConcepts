package concepts.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Pieces of reusable functionality provided by the Java platform. 
 * All of them come from the Collections class, and all take the form of static methods
 * whose first argument is the collection on which the operation is to be
 * performed. The great majority of the algorithms provided by the Java platform
 * operate on List instances, but a few of them operate on arbitrary Collection
 * instances.
 * NOTE: In order to enable assert, please do pass -ea as VM argument  
 */
public class Algorithms {
	
	static long startTime ; 
	
	static long endTime ; 

	public static void main(String[] args) {

		sorting();
		
		routineDataManipulation();		
		
		searching();
		
		composition();
		
		findingExtremeValues();
	}

	

	/**
	 * The sort algorithm reorders a List so that its elements are in ascending order according to an ordering relationship
	 * Two forms of the operation are provided. 
	 *  - The simple form takes a List and sorts it according to its elements' natural ordering
	 * 	- The order takes Comparator implementation as argument
	 * 
	 * The sort operation uses a slightly optimized merge sort algorithm that is fast and stable:
	 *   Fast: It is guaranteed to run in n log(n) time and runs substantially faster on nearly sorted lists.
	 *         A quicksort is generally considered to be faster than a merge sort but isn't stable and doesn't guarantee n log(n) performance.
	 *   Stable: It doesn't reorder equal elements. This is important if you sort the same list repeatedly on different attributes
	 *   
	 * Divide and Conquer algorithm:   
	 *   Megesort: divide the original data into smaller sets of data to solve the problem.
	 *   
	 *   Quicksort: the original data is separated into two parts (divide - based on pivot element) which are individually sorted (conquered) and then combined.
	 */
	private static void sorting() {
		Name nameArray[] = { 
				new Name("Praveen", "R"), 
				new Name("Aditi", "P"), 
				new Name("Deepti", "M"),
				new Name("Praveen", "P") };
		List<Name> names = Arrays.asList(nameArray);

		Collections.sort(names, new Comparator<Name>() {
			public int compare(Name o1, Name o2) {
				return o1.firstName().compareTo(o2.firstName());
			}
		});
		assert ("[Aditi P, Deepti M, Praveen R, Praveen P]").equals(names.toString());

		Collections.sort(names);
		assert ("[Aditi P, Deepti M, Praveen P, Praveen R]").equals(names.toString());
	}
	
	/**
	 * Collections class provides five algorithms for doing routine data manipulation on List objects - reverse, fill, copy, swap & addAll 
	 */
	private static void routineDataManipulation() {
		Name nameArray[] = { 
				new Name("Praveen", "R"), 
				new Name("Aditi", "P"), 
				new Name("Deepti", "M"),
				new Name("Praveen", "P") };
		
		List<Name> names = Arrays.asList(nameArray);
		Collections.reverse(names);
		assert ("[Praveen P, Deepti M, Aditi P, Praveen R]").equals(names.toString());
		
		//The destination List must be at least as long as the source. If it is longer, the remaining elements in the destination List are unaffected.
		Collections.copy(names, Arrays.asList(new Name("P", "Praveen"),	new Name("M", "Deepti")));
		assert ("[P Praveen, M Deepti, Aditi P, Praveen R]").equals(names.toString());	
		
		Collections.swap(names, 0, 3);
		assert ("[Praveen R, M Deepti, Aditi P, P Praveen]").equals(names.toString());	
		
		Collections.fill(names, new Name("",""));
		assert ("[ ,  ,  ,  ]").equals(names.toString());
	}
	
	/**
	 * Binary search requires that the collection is already sorted 
	 * Binary search checks the element in the middle of the collection. If the search
	 * element smaller or greater then the found element then a sub-array is
	 * defined which is then search again. If the searched element is smaller
	 * then the found element then the sub-array is from the start of the array
	 * until the found element. If the searched element is larger then the found
	 * element then the sub-array is from the found element until the end of the
	 * array. Once the searched element is found or the collection is empty then
	 * the search is over
	 * 
	 * Binary Search: assumes that the List is sorted into ascending order according to the specified Comparator. 
	 * The sort algorithm can be used to sort the List prior to calling binarySearch.
	 */
	private static void searching() {
		Name nameArray[] = { 
				new Name("Praveen", "R"), 
				new Name("Aditi", "P"), 
				new Name("Deepti", "M"),
				new Name("Praveen", "P") };
		List<Name> names = Arrays.asList(nameArray);
		//Unsorted List
		startTime = System.nanoTime();
		assert 2 == Collections.binarySearch(names, new Name("Deepti", "M"));
		endTime = System.nanoTime();
		System.out.println("Binary Serach performance when List is Unsorted: " +(endTime - startTime));
		//Sorted List
		Collections.sort(names);
		startTime = System.nanoTime();		
		assert 1 == Collections.binarySearch(names, new Name("Deepti", "M"));
		endTime = System.nanoTime();
		System.out.println("Binary Serach performance when List is sorted: " +(endTime - startTime));
		
		assert -1 == Collections.binarySearch(names, new Name(" ", " "));
	}
	
	/**
	 * The algorithms test some aspect of the composition of one or more Collections:
	 *   	frequency — counts the number of times the specified element occurs in the specified collection
     *  	disjoint — determines whether two Collections are disjoint; that is, whether they contain no elements in common
	 */
	private static void composition() {
	 //Frequency
	 Integer[] numbersArray = {1, 0, 0, 1, 0, 1, 1, 1, 1, null};
	 List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(numbersArray));
	 assert 6 == Collections.frequency(numbers, new Integer(1));	
	 //I can even count occurrences of null
	 assert 1 == Collections.frequency(numbers, null);
	 
	 //Disjoint
	 Integer[] disjointArray = {1, 0, 0, 1, 0, 1, 1, 1, 1};
	 List<Integer> disjointNumbers = new ArrayList<Integer>(Arrays.asList(disjointArray));
	 assert !Collections.disjoint(numbers, disjointNumbers);
	}
	
	
	/**
	 * The min and the max algorithms return, respectively, the minimum and maximum element contained in a specified Collection. 
	 * Both of these operations come in two forms. 
	 * The simple form takes only a Collection and returns the minimum (or maximum) element according to the elements' natural ordering. 
	 * The second form takes a Comparator in addition to the Collection and returns the minimum (or maximum) element according to the specified Comparator.
	 */
	private static void findingExtremeValues() {
		Name nameArray[] = { 
				new Name("Praveen", "R"), 
				new Name("Aditi", "P"), 
				new Name("Deepti", "M"),
				new Name("Praveen", "P") };
		List<Name> names = Arrays.asList(nameArray);
		"Praveen R".equals(Collections.max(names).toString());
		"Aditi P".equals(Collections.min(names).toString());
		"Praveen P".equals(Collections.max(names, new Comparator<Name>() {
			public int compare(Name o1, Name o2) {
				return o1.firstName.compareTo(o2.firstName);
			}
		}).toString());
	}
	
	/**
	 * Private nested class 
	 */
	private static class Name implements Comparable<Name> {
		private final String firstName, lastName;

		public Name(String firstName, String lastName) {
			if (firstName == null || lastName == null)
				throw new NullPointerException();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String firstName() {
			return firstName;
		}

		public boolean equals(Object o) {
			if (!(o instanceof Name))
				return false;
			Name n = (Name) o;
			return n.firstName.equals(firstName) && n.lastName.equals(lastName);
		}

		public int hashCode() {
			return 31 * firstName.hashCode() + lastName.hashCode();
		}

		public String toString() {
			return firstName + " " + lastName;
		}

		public int compareTo(Name n) {
			int lastCmp = firstName.compareTo(n.firstName);
			return (lastCmp != 0 ? lastCmp : lastName.compareTo(n.lastName));
		}
	}

}

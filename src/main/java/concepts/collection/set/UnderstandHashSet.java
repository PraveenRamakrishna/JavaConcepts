package concepts.collection.set;

import java.util.HashSet;
import java.util.Set;

import concepts.collection.CodingTask;

/**
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument
 */
public class UnderstandHashSet {

	private static final Set<CodingTask> setOne = new HashSet<CodingTask>();

	public static void main(String[] args) {

		addNonDuplicate();

		addDuplicate();

		addNull();

		union();

		intersection();

		asymmetric();

		containsAll();

		symmetric();
		
	}

	/**
	 * The set of elements contained in either of two specified sets but not in
	 * both
	 */
	private static void symmetric() {
		init();

		Set<CodingTask> setTwo = new HashSet<CodingTask>();
		setTwo.add(new CodingTask("Task4"));
		setTwo.add(new CodingTask("Task3"));

		Set<CodingTask> symmetricDiff = new HashSet<CodingTask>(setOne);
		//Union of SetOne and SetTwo
		symmetricDiff.addAll(setTwo);

		Set<CodingTask> tempSet = new HashSet<CodingTask>(setOne);
		//intersection of SetOne and SetTwo
		tempSet.retainAll(setTwo);

		//asymmetric of my Union & Intersection 
		symmetricDiff.removeAll(tempSet);
		
		System.out.println("Symmetric Difference: " + symmetricDiff);

	}

	private static void init() {
		setOne.clear();
		setOne.add(new CodingTask("Task1"));
		setOne.add(new CodingTask("Task2"));
		setOne.add(new CodingTask("Task3"));
	}

	private static void addNonDuplicate() {
		init();
		setOne.add(new CodingTask("Task4"));
		assert (4 == setOne.size()) : "Couldn't add Non Duplicate";
	}

	private static void addDuplicate() {
		init();
		setOne.add(new CodingTask("Task4"));
		assert (4 == setOne.size()) : "Duplicate is not getting overridden..!";
	}

	private static void addNull() {
		init();
		assert 3 == setOne.size();
		setOne.add(null);
		assert 4 == setOne.size() : "Null is not counted for Size, even though it occupies 0th position";
	}

	/**
	 * Transforms s1 into the union of s1 and s2. (The union of two sets is the
	 * set containing all of the elements contained in either set.)
	 */
	private static void union() {
		init();
		Set<CodingTask> setTwo = new HashSet<CodingTask>(4);
		setTwo.add(new CodingTask("Task5"));
		setTwo.add(new CodingTask("Task4"));
		setTwo.add(null);
		setTwo.add(new CodingTask("Task3"));
		assert 4 == setTwo.size();
		setOne.addAll(setTwo);
		assert 6 == setOne.size();
		System.out.println("Union: "+setOne);
	}

	/**
	 * Transforms s1 into the intersection of s1 and s2. (The intersection of
	 * two sets is the set containing only the elements common to both sets.)
	 */

	private static void intersection() {
		init();
		Set<CodingTask> setTwo = new HashSet<CodingTask>(4);
		setTwo.add(new CodingTask("Task5"));
		setTwo.add(new CodingTask("Task4"));
		setTwo.add(null);
		setTwo.add(new CodingTask("Task3"));
		assert 4 == setTwo.size();
		setOne.retainAll(setTwo);
		assert 1 == setOne.size();
		System.out.println("Intersection: "+setOne);
	}

	/**
	 * Transforms s1 into the (asymmetric) set difference of s1 and s2. (For
	 * example, the set difference of s1 minus s2 is the set containing all of
	 * the elements found in s1 but not in s2.)
	 */
	private static void asymmetric() {
		init();
		Set<CodingTask> setTwo = new HashSet<CodingTask>(4);
		setTwo.add(new CodingTask("Task5"));
		setTwo.add(new CodingTask("Task4"));
		setTwo.add(null);
		setTwo.add(new CodingTask("Task3"));
		assert 4 == setTwo.size();
		setOne.removeAll(setTwo);
		assert 2 == setOne.size();
		System.out.println("asymmetric set: "+setOne);
	}

	/**
	 * returns true if s2 is a subset of s1. (s2 is a subset of s1 if set s1
	 * contains all of the elements in s2.)
	 */
	private static void containsAll() {
		init();
		setOne.add(new CodingTask("Task4"));
		Set<CodingTask> setTwo = new HashSet<CodingTask>(4);
		setTwo.add(new CodingTask("Task4"));
		setTwo.add(new CodingTask("Task3"));
		assert setOne.containsAll(setTwo);
		setTwo.add(null);
		assert !setOne.containsAll(setTwo);

	}

}

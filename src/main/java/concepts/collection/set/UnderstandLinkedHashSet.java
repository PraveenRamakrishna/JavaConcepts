package concepts.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import concepts.collection.CodingTask;

/**
 * LinkedHashSet is in some sense intermediate between HashSet and TreeSet.
 * Implemented as a hash table with a linked list running through it, it
 * provides insertion-ordered iteration (least recently inserted to most
 * recently) and runs nearly as fast as HashSet. The LinkedHashSet
 * implementation spares its clients from the unspecified, generally chaotic
 * ordering provided by HashSet without incurring the increased cost associated
 * with TreeSet
 *
 */

public class UnderstandLinkedHashSet {

	public static void main(String[] args) {

		final Set<CodingTask> linkedHashSet = new LinkedHashSet<CodingTask>();
		

		final Set<CodingTask> hashSet = new HashSet<CodingTask>();

		addElementsToSet(linkedHashSet);

		addElementsToSet(hashSet);

		System.out.println("LinkedHasSet - Will return thier elements in the order they are added: " + linkedHashSet);

		System.out.println("Hashset - doesn't garntuee the order of elements in the order they are added: " + hashSet);

	}

	private static void addElementsToSet(final Set<CodingTask> set) {
		set.add(new CodingTask("Task5"));
		set.add(new CodingTask("Task1"));
		set.add(new CodingTask("Task3"));
		set.add(new CodingTask("Task2"));
		set.add(null);
	}

}

package concepts.collection.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import concepts.collection.CodingTask;
import concepts.collection.Priority;
import concepts.collection.PriorityTask;

/**
 * TreeSet uses a data type called a red-black tree, which has the advantage that if it becomes unbalanced through
 * insertion or removal of an element, it can always be re-balanced in O(log n) time
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument
 */
public class UnderstandSortedSet {
	private static SortedSet<PriorityTask> sortedSet;
	
	private static SortedSet<PriorityTask> subSet;
	
	private static HashSet<PriorityTask> hashSet;
	
	public static void main (String[] args){
		
		areElementsOrderedInAscending();
		
		doesSortedSetUseEqualsOrCompareTo();
		
		getRangeViews();
		
		//areDuplicatesOverridden();
		
	}
	
	
	public static void areElementsOrderedInAscending(){
		sortedSet = new TreeSet<PriorityTask>();
		sortedSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));
		sortedSet.add(new PriorityTask(new CodingTask("DBDesign"),Priority.LOW));
		sortedSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		assert "[InterfaceDesign : HIGH, MethodDesign : HIGH, ClassDesign : MEDIUM, DBDesign : LOW]".equals(sortedSet.toString()) : "Set not sorted in assending order, check Comparator or Comprable impementation ";
	}
	
	/**The Contract for SortedSet states that it will use the compare method of its Comparator or
	 * if it does not have one, the compareTo method of its elements - instead of the elements equal method to 
	 * determine when the elements are distinct.
	*/ 
	public static void doesSortedSetUseEqualsOrCompareTo(){
		//Comparator implementation to sort Tasks based only on priority 
		sortedSet = new TreeSet<PriorityTask>(new Comparator<PriorityTask>() {
			public int compare(PriorityTask o1, PriorityTask o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}
		});
		sortedSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));

		//HasSet uses equals to identify if the obejct's are equal.
		hashSet = new HashSet<PriorityTask>();
		hashSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		hashSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		hashSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));		
		
		assert 3 == hashSet.size();
		assert "[ClassDesign : MEDIUM, InterfaceDesign : HIGH, MethodDesign : HIGH]".equals(hashSet.toString());
		System.out.println("Hashset: " + hashSet.toString());
		
		assert 2 == sortedSet.size();
		assert "[MethodDesign : HIGH, ClassDesign : MEDIUM]".equals(sortedSet.toString()):"Seems SortedSet used equals not compareTo for equals comprasion";
		System.out.println("SortedSet: " + sortedSet.toString());
	}
	
	/**
	 * Override hashcode & equals only using priority  
	 */
	public static void areDuplicatesOverridden(){
		
		sortedSet = new TreeSet<PriorityTask>(new Comparator<PriorityTask>() {
			public int compare(PriorityTask o1, PriorityTask o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}
		});
		sortedSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));

		//HasSet uses equals to identify if the obejct's are equal.
		hashSet = new HashSet<PriorityTask>();
		hashSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		hashSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		hashSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));		
		
		assert 2 == hashSet.size();
		assert "[MethodDesign : HIGH, ClassDesign : MEDIUM]".equals(hashSet.toString());
		System.out.println("Hashset: " + hashSet.toString());
		
		assert 2 == sortedSet.size();
		assert "[MethodDesign : HIGH, ClassDesign : MEDIUM]".equals(sortedSet.toString()):"Seems SortedSet used equals not compareTo for equals comprasion";
		System.out.println("SortedSet: " + sortedSet.toString());
		
	}
			
	/**
	 * SortedSet - Range View methods, which return subsets that are always inclusive of the lower bound and exclusive of the higher
	 */
	public static void getRangeViews(){
		sortedSet = new TreeSet<PriorityTask>();
		sortedSet.add(new PriorityTask(new CodingTask("InterfaceDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("ClassDesign"),Priority.MEDIUM));
		sortedSet.add(new PriorityTask(new CodingTask("DBDesign"),Priority.LOW));
		sortedSet.add(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH)) ;
		sortedSet.add(new PriorityTask(new CodingTask("CodeReview"),Priority.MEDIUM)) ;
		sortedSet.add(new PriorityTask(new CodingTask("RefactoringCode"),Priority.MEDIUM)) ;
		System.out.println("SortedSet: " + sortedSet.toString());
		
		// subSet: returns a set containing every element of the original set
		// that is greater than or equal to fromElement and less than toElement
		//>= & < to_element
 		
		subSet = sortedSet.subSet(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH), new PriorityTask(new CodingTask("RefactoringCode"),Priority.MEDIUM));	
		assert 3 == subSet.size();
		assert "[MethodDesign : HIGH, ClassDesign : MEDIUM, CodeReview : MEDIUM]".equals(subSet.toString());
		System.out.println("Subset: " + subSet.toString());
		
		// headSet: returns every element that is less than toElement
		//< to_element
		subSet = sortedSet.headSet(new PriorityTask(new CodingTask("MethodDesign"),Priority.HIGH));
		assert 1 == subSet.size();
		assert "[InterfaceDesign : HIGH]".equals(subSet.toString());
		System.out.println("Headset: " + subSet.toString());
		
		// tailSet: returns every element that is greater than or equal to fromElement
		// >= to_element
		subSet = sortedSet.tailSet(new PriorityTask(new CodingTask("RefactoringCode"),Priority.MEDIUM));
		assert 2 == subSet.size();
		assert "[RefactoringCode : MEDIUM, DBDesign : LOW]".equals(subSet.toString());
		System.out.println("Tailset: " + subSet.toString());
		
	}	
	
	
}

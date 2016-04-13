package concepts.nestedclasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Nested classes are divided into two categories: static and non-static. Nested
 * classes that are declared static are called static nested classes. Non-static
 * nested classes are called inner classes.
 */

public class NestedClasses {

	private int innerClassCanAccessMe = 10;

	private List<Integer> list = new ArrayList<Integer>();

	// Non-static nested classes are called inner classes.
	public class InnerClass {
		// Inner classes, have access to other members of the enclosing class,
		// even if they are declared private
		public void accessMembers(Integer integer) {
			list.add(integer);
		}
		
		public int getSize() {
			return list.size();
		} 

	}

	private void print(String text) {

		System.out.println(text);

	}

	public int getSize() {
		return this.list.size();
	}

	// Nested classes that are declared static are called static nested classes
	public static class StaticNestedClass {

		/**
		 * As with class methods and variables, a static nested class is
		 * associated with its outer class. And like static class methods, a
		 * static nested class cannot refer directly to instance variables or
		 * methods defined in its enclosing class: it can use them only through
		 * an object reference.
		 */

	}

}

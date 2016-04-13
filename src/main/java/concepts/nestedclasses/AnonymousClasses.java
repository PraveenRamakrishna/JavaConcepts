package concepts.nestedclasses;

import java.util.Arrays;
import java.util.Comparator;

public class AnonymousClasses {
	//An anonymous class has access to the members of its enclosing class.
	private int canAnaonymousAccess = 1;

	void sort() {
		// anonymous class cannot access local variables in its enclosing scope
		// that are not declared as final or effectively final
		Arrays.sort(new String[10], new Comparator<String>() {
			public int compare(String o1, String o2) {
				return canAnaonymousAccess;
			}
		});
	}
}

package concepts.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * NOTE: In order to enable assert, please do pass -ea as VM argument
 */

public class BeforeJava5 {

	public static void main(String[] args) {

		List ints = Arrays.asList(new Integer[] { new Integer(1), new Integer(2), new Integer(3) });
		int sum = 0;
		for (Iterator iterator = ints.iterator(); iterator.hasNext();) {
			int n = ((Integer) iterator.next()).intValue();
			sum = sum + n;
		}
		assert sum == 6;
	}
}
 
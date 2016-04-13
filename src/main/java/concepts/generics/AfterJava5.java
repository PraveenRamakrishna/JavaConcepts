package concepts.generics;

import java.util.Arrays;
import java.util.List;

/**
 * Generics - One of the several new introduction in Java5
 * 
 * Generics allow you to abstract over types - The net effect, especially in large programs, is improved readability and robustness.
 * 
 * The compiler checks the type correctness of the program at compile-time. The compiler translates generic and parameterized types by a technique called TYPE ERASURE
 * 
 * 
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument
 */
public class AfterJava5 {

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		int sum = 0;
		for (Integer integer : ints) {
			sum = sum + integer;
		}
		assert sum == 6;
	}
}

package concepts.generics;

import java.util.Arrays;
import java.util.List;

/**
 * One subtlety of boxing and unboxing is that == is defined differently
 * on primitive and on reference types. On type int, it is defined by equality of values,
 * and on type Integer, it is defined by object identity
 * 
 * NOTE: In order to enable assert, please do pass -ea as VM argument
 */

public class BoxingUnboxing {

	public static void main(String[] args) {
		List<Integer> bigs = Arrays.asList(100,200,300);
		assert sumInteger(bigs) == sum(bigs);
		assert sumInteger(bigs) != sumInteger(bigs);

	}

	public static int sum(List<Integer> ints) {
		int s = 0;
		for (int n : ints) {
			s += n;
		}
		return s;
	}
	
	public static Integer sumInteger(List<Integer> ints) {
		Integer s = 0;
		for (Integer n : ints) {
			s += n;
		}
		return s;
	}

}

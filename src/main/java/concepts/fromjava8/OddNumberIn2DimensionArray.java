package concepts.fromjava8;

import java.util.Arrays;
import java.util.stream.Stream;

public class OddNumberIn2DimensionArray {

	public static void main(String[] args) {
		
		int [][] matrix = new int[][]{{7, 2, 3},{5,8,4}};
		
		Stream.of(matrix)
			  .flatMapToInt(Arrays::stream)
			  .filter(i -> i %2 != 0)
			  .forEach(System.out::println);
	}
}

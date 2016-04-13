package concepts.evaluation;

public class PreAndPostIncrement {
	public static void main(String[] args) {
		int i = 5;
		int j = 10;

		System.out.println(i++ + --i + i++);
		System.out.println(j-- + j++ + j++);
		
		int x = 5;
		int y = 10;
		
		System.out.println( ++x * y--);
		
		int[] test = new int[4];
		int l = 0;
		test[++l] = 1 ;
		for (int k = 0; k < test.length; k++) {
			System.out.println(test[k] );
		}
		
		int m = 42;
		int n = m++;
		System.out.printf("%d %d\n", m, n);
		
		
	}
}

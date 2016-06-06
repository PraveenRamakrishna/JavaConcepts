package concepts.fromjava8;

import java.util.function.Consumer;

public class Shadowing {
	
	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void inFirstLevel(int x) {
			// The following statement causes the compiler to generate
			// the error "local variables referenced from a lambda expression
			// must be final or effectively final" in statement A:

			// x = 99;

			Consumer<Integer> myConsumer = new Consumer<Integer>() {
				
				@Override
				public void accept(Integer y) {
					System.out.println("x = " + x);
					System.out.println("y = " + y);
					System.out.println("this.x = " + FirstLevel.this.x);
					System.out.println("Shadowing.this.x = " + Shadowing.this.x);
				}
			}; 
			myConsumer.accept(x);
		}

	}
	
	public static void main(String... args) {
		Shadowing.FirstLevel firstLevel = new Shadowing().new FirstLevel();
		firstLevel.inFirstLevel(23);
	}

}

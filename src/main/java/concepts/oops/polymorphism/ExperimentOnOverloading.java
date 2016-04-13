package concepts.oops.polymorphism;

/**
 * The Most Specific method...? 
 * # You can overload a method by changing its signature. method signature is made of number of arguments, type of arguments
 * and order of arguments. 
 * # Return type is not a part of method signature, so changing method return type means no overloading unless you change argument
 * with return type.
 */
public class ExperimentOnOverloading {

	private static void testingOverloading(String message) {
		System.out.println("testingOverloading-String message: " + message);
	}

	private static void testingOverloading(Object message) {
		System.out.println("testingOverloading-Object message: " + message);
	}

	public static void main(String[] args) {
		int number = 10;
		testingOverloading(null);
		testingOverloading(number % 2 == 0);
		testingOverloading((number % 2 == 0) ? null : null);//JLS: "If the second and third operands have the same type (which may be the null type), then that is the type of the conditional expression."
		testingOverloading((number % 2 == 0) ? null : new Object());//JLS: "If one of the second and third operands is of the null type and the type of the other is a reference type, then the type of the conditional expression is that reference type."
	}

}

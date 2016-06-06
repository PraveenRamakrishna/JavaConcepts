package concepts.fromjava7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You can replace the type arguments required to invoke the constructor of a
 * generic class with an empty set of type parameters (<>) as long as the
 * compiler can infer the type arguments from the context.
 */
public class TypeInferenceForGenericInstanceCreation {

	public static void main(String[] args) {
		//Prior to Java 7
		Map<String, List<String>> myMap = new HashMap<String, List<String>>();
		
		// In Java 7
		Map<String, List<String>> myMap7 = new HashMap<>();
		
		//Type Inference and Generic Constructors of Generic and Non-Generic Classes
		
		//Prior to Java 7
		MyClass<Integer> myObject = new MyClass<Integer>("");
		
		//In Java 7
		MyClass<Integer> myObject7 = new MyClass<>("");
	}
}


class MyClass<X> {
	  <T> MyClass(T t) {
	    // ...
	  }
	}
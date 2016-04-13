package concepts.generics;


/**
 * To cope with this sort of situation, it's useful to consider more flexible generic types
 * 
 * It is sometimes expected that a List<Object> would be a supertype of a List<String> , because Object is a supertype of String . 
 * This expectation stems from the fact that such a type relationship exists for arrays:  
 * Object[] is a supertype of String[] , because Object is a supertype of String .(This type relationship is known as covariance .)  
 * The super-subtype-relationship of the component types extends into the corresponding array types. 
 * No such a type relationship exists for instantiations of generic types. (Parameterized types are not covariant.) 
 */
public class Subtyping {

	public static void main(String[] args) {

		// Is the following code snippet legal...?
		
		// 1 - List<String> ls = new ArrayList<String>();
		// 2 - List<Object> lo = ls;
		
	}

}

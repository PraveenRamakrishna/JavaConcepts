package concepts.generics;

/**
 * Type parameters can be used throughout the generic declaration, pretty much where you would use ordinary types
 * 
 * Imagination of SinpleGenerics<Integer> stands for a version of SimpleGenrics where E has been uniformly replaced by Integer
 * 
 * A generic type declaration is compiled once and for all, and turned into a single class file, just like an ordinary class or interface declaration.
 * 
 * Type parameters are analogous to the ordinary parameters used in methods or constructors. 
 * Much like a method has formal value parameters that describe the kinds of values it operates on, a generic declaration has formal type parameters. 
 * When a method is invoked, actual arguments are substituted for the formal parameters, and the method body is evaluated. 
 * When a generic declaration is invoked, the actual type arguments are substituted for the formal type parameters.
 * 
 * 
 */
public interface  SimpleGenerics<E> {
 
	void add(E element);
	
	E get();
	
	boolean delete(E element);
}


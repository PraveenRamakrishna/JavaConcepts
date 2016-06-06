package concepts.fromjava8;


/**
 * Virtual extension methods or often called as defender methods,  can now be added to interfaces providing a default
 * implementation of the declared behavior.
 * 
 * Simply speaking, interfaces in Java can now implement methods.
 * The benefit that default methods bring is that now it’s possible to add a new default method to the interface and it doesn’t break the implementations.
 * 
 * The default methods isn’t the language feature that would be appropriate to use every day, but it is an essential feature for Java Collections API
 * update to be able to use lambdas naturally.
 */

public class DefaultMethodInInterface {

	interface A {
		default void foo() {
			System.out.println("Calling A.foo()");
		}
	}

	interface B {
		default void foo() {
			System.out.println("Calling B.foo()");
		}
	}
	
	//NOTE: What if the class implements two interfaces and both those interfaces define a default method	with the same signature?
	class Clazz implements A,B{
		// we have to resolve it manually by overriding the	conflicting method
		@Override
		public void foo() {
			A.super.foo();
		}
	}


}


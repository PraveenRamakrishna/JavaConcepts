package concepts.fromjava8;


/**
 * Simply speaking, interfaces in Java can now implement methods.
 * The benefit that default methods bring is that now it’s possible to add a new default method to the interface and it doesn’t break the implementations.
 * 
 * default methods are not tied to Lambda Expressions or the functional style of programming. However, many of the convenience methods in collections
 * would not be possible without them.
 * 
 * Java compiler follows few rules to resolve default methods
 * 
 * 1. Subtypes automatically carry over the default methods from their supertypes.
 * 
 * 2. For interfaces that contribute a default method, the implementation in a
 *    subtype takes precedence over the one in supertypes.
 *    
 * 3. Implementations in classes, including abstract declarations, take precedence
 *    over all interface defaults
 * 
 * 4. If there’s a conflict between two or more default method implementations,
 *    or there’s a default-abstract conflict between two interfaces, the inheriting
 *    class should disambiguate.
 */

public class DefaultMethods {
	 
	interface Fly {
		default void takeOff() { System.out.println("Fly::takeOff"); }
		default void land() { System.out.println("Fly::land"); }
		default void turn() { System.out.println("Fly::turn"); }
		default void cruise() { System.out.println("Fly::cruise"); }
	}
	 
	 //Rule 1 & 2
	 interface FastFly extends Fly {
		 default void takeOff() { System.out.println("FastFly::takeOff"); }
	}
	 
	 interface Sail {
		 default void cruise() { System.out.println("Sail::cruise"); }
		 default void turn() { System.out.println("Sail::turn"); }
	}
	 
	 class Vehicle {
		 public void turn() { System.out.println("Vehicle::turn"); }
	}	 
	 
	/**
	 * Even though turn() method is present in the interfaces, the
	 * implementation in the superclass Vehicle takes precedence - Rule 3
	 */
	class SeaPlane extends Vehicle implements Sail, FastFly{		
		private int altitude;
		
		//The Java Compiler will force to implement the crusie() method because the default
        //implementation in Sail & Fly conflict - Rule 4		
		@Override
		public void cruise() {
			if(altitude > 0){
				//At first glance the use of super may appear superfluous, but its required.
				//Thats how Java compiler knows if we're referring to a "default" method or
				//a static method in the interface.
				// In java 8, interfaces can optionally have default & static methods, possibly with the same name.
				FastFly.super.cruise();
			}else{
				Sail.super.cruise();
			}
		}
		 
	 }
	
	public static void main(String[] args) {
		final SeaPlane seaPlane = new DefaultMethods().new SeaPlane();
		seaPlane.takeOff();
		seaPlane.turn();
		seaPlane.cruise();
		seaPlane.land();
	}
}

package concepts.oops.polymorphism;

/**
 * The distinction between hiding and overriding has important implications. The
 * version of the overridden method that gets invoked is the one in the
 * subclass. The version of the hidden method that gets invoked depends on
 * whether it is invoked from the superclass or the subclass. Let's look at an
 * example that contains two classes
 */
public class MethodOverridingAndHiding {

	public static void main(String[] args) {
		Cat myCat = new Cat();
		Animal myAnimal = myCat;
		Animal.testClassMethod();
		myAnimal.testInstanceMethod();
	}
}

class Animal {
	public static void testClassMethod() {
		System.out.println("The class method in :" + Animal.class);
	}

	public Animal testInstanceMethod() {
		System.out.println("The instance method in : " + Animal.class);
		return new Animal();
	}
}

class Cat extends Animal {
	/*
	 * If a subclass defines a class method with the same signature as a class
	 * method in the superclass, the method in the subclass hides the one in the
	 * superclass.
	 */
	public static void testClassMethod() {
		System.out.println("The class method in: " + Cat.class);
	}

	/*
	 * An overriding method can also return a subtype of the type returned by
	 * the overridden method. This is called a covariant return type.
	 */

	/*
	 * @Override annotation that instructs the compiler that you intend to
	 * override a method in the superclass. If, for some reason, the compiler
	 * detects that the method does not exist in one of the superclasses, it
	 * will generate an error
	 */
	@Override
	public Cat testInstanceMethod() {
		System.out.println("The instance method in " + Cat.class);
		return new Cat();
	}
}

package concepts.fromjava8;

/**
 * Method References, To decide how to route the parameters, the java compiler will check whether the method is
 * an instance method or static method. 
 * If it's an instance method, then the synthesized method parameters becomes the call target.
 * If the method is static , then the parameters to the synthesized method is routed as an argument to the method. 
 */

public class MethodReferences {
	//Requirement - Read & print characters in a String.
	public static void main(String... args) {
		final String str = "w00t";
		str.chars()
		   .filter(Character::isDigit)
		   .forEach(MethodReferences::printChar);
	
	}
	
	private static void printChar(int aChar){
		System.out.println((char)aChar);
	}
}

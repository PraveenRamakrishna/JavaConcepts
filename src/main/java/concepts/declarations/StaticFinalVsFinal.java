package concepts.declarations;

import java.io.File;

import org.apache.commons.lang3.ObjectUtils;

public class StaticFinalVsFinal {

	
	public static void main(final String args[]) {

		final ConstantTest firstObject = new ConstantTest();
		final ConstantTest secondObject = new ConstantTest();
		System.out.println("-------------First Object-------------");
		firstObject.printAddresses();
		System.out.println("-------------Second Object-------------");
		secondObject.printAddresses();
	}
}

/**
 * Primitive types in Java are always "cached", same for strings literals (not
 * new String objects), so no difference between static and non-static members.
 * However there is a memory duplication for non-static members if they are not
 * of a primitive type
 */
class ConstantTest{
	private int value = 10;
	private final int valueFinal = 10;
	private static final int valueStatic = 20;	
	private final File valueObject = new File("");
	private static final File valueObjectStatic = new File("");

	public void printAddresses() {
		System.out.println("int address " + ObjectUtils.identityToString(value));
		System.out.println("final int address " + ObjectUtils.identityToString(valueFinal));
		System.out.println("final static int address " + ObjectUtils.identityToString(valueStatic));
		System.out.println("final file address " + ObjectUtils.identityToString(valueObject));
		System.out.println("final static file address " + ObjectUtils.identityToString(valueObjectStatic));
	}

}
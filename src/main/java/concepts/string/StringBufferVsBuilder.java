 package concepts.string;

/**
 * Use java.lang.StringBuffer & java.lang.StringBuilder classes when you have to
 * make a lot of modifications to String of characters. String objects are
 * immutable, so if you choose to do lot of manipulations with string object,
 * will end with lot of abandoned String objects in the String pool.
 * 
 * StringBuffer & StringBuilder can be manipulated over & over again without leaving behind discarded String Objects 
 */
public class StringBufferVsBuilder {

		public static void main(String[] args) {
		
		System.out.println("Which Concatenation is faster...?");
		
		// StringConcatenation
		String literal = "Praveen";
		
		literal.equals("test");
		long startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			literal += "Kumar";
		}
		System.out.println("StringLiteral: " + (System.nanoTime() - startTime));

		// StringBuffer, all the methods are Synchronized
		StringBuffer stringBuffer = new StringBuffer("Praveen");
		startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			stringBuffer.append("Kumar");
		}
		System.out.println("StringBuffer: " + (System.nanoTime() - startTime));

		// StringBuilder was added in Java 5, It has same methods as StringBuffer but the methods are not Thread safe.
		// StrinBuilder will run faster[Not Much Faster..!].
		StringBuilder stringBuilder = new StringBuilder("Praveen");
		startTime = System.nanoTime();
		for (int i = 0; i < 100; i++) {
			stringBuilder.append("Kumar");
		}
		System.out.println("StringBulder: " + (System.nanoTime() - startTime));
	}
}

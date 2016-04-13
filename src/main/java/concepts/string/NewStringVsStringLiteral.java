package concepts.string;

public class NewStringVsStringLiteral {

	public static void main(String[] args) {
		
		/**A new object is created each time in Heap */
		String a = new String("xpto"); 
		String b = new String("xpto");
		
		/**
		 * The String will only be created the first time (a new object), and
		 * it'll be cached in the String constant pool, so every time you refer
		 * to it in it's literal form, you're getting the exact same object,
		 * which is amazingly fast.
		 */
		String c = "xpto"; 
		String d = "xpto";

		System.out.println("testing...!");
		
		System.out.println("a == b: "+ (a == b));
		System.out.println("a == c: "+ (a == c));
		System.out.println("c == d: "+ (c == d));
		
		System.out.println("a.equals(b): "+a.equals(b));
		System.out.println("c.equals(d): "+c.equals(d));
		System.out.println("a.equals(c): "+a.equals(c));
		System.out.println("b.equals(d): "+b.equals(d));
		
		String lengthyString="String - This is to experiment on How String and new String behave, when to use what...?";
		String subOfLengthString = lengthyString.substring(12, 18);
	    lengthyString = null;
		
	    String lengthyNewString="New String - This is to experiment on How String and new String behave, when to use what...?";
		String subOfLengthNewString = new String(lengthyNewString.substring(12, 18));
		subOfLengthNewString = null;
		
	}

}

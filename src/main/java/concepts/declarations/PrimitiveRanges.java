package concepts.declarations;


/**
 * The main reason primitive data type are there because, creating object,
 * allocating heap is too costly and there is a performance penalty for it. As
 * you may know primitive data types like int, float etc are most used, so
 * making them as Objects would have been huge performance hit. So Java
 * designers thought it would be better to make it as non-objects. And yes,
 * wrappers exists in-case you are ready to compromise bit on performance but
 * you require more facility of OOP. So in that case you can use wrappers
 */

public class PrimitiveRanges {
	
	public static void main(String[] args){
		
		/**
		 * Six Number Types in java are made of a 8-bit bytes & are signed[they can
		 * be Positive & Negative] the left most bit [Significant bit] is used to
		 * represent the sign[0 means positive & 1 means negative]
		 */
		
		 byte b = 127; // 8 Bits, can represent 0 to 127 or -128 to -1
		
		 short s = 32767; // 16 bits, can represent 0 to 32767 or -32767 to -1
		
		/**
		 * The byte & short data type can be useful for saving memory in large arrays, where
		 * the memory savings actually matters. They can also be used in place of
		 * int where their limits help to clarify your code;
		 */
		
		 int i = 2147483647;//32 bits, can represent 0 to 2147483647 or -2147483648 to -1
		
		 long l = 9223372036854775807l; //64 bits, can represent 0 to 9223372036854775807L or -9223372036854775808 to -1
		
		 float f= 0.0f; //32 bits 
		
		 double d = 0.0; // 64 bits
		
		 boolean bn = true; // Can be either be true / false
		
		/** The Java programming language also supports a few special escape
		 * sequences for char and String literals like \b (backspace), \t (tab) etc
		 */
		 char c = '\u00AE'; //The char data type is a single 16-bit Unicode character. It has a minimum value of '\u0000' (or 0) and a maximum value of '\uffff' (or 65,535 inclusive).
		
		/** Overflow / Underflow
		 * If it overflows, it goes back to the minimum value and continues from
		 * there. If it underflows, it goes back to the maximum value and
		 * continues from there.
		 */
		if ((Integer.MAX_VALUE + 1)  == Integer.MIN_VALUE ) {
			System.out.println("Overflow Occurred..!");
			//throw new RuntimeException("Overflow Occurred..!"); //One of the mechanisms to know either overflow or underflow has occured in the system
		} 
		
		if ((Integer.MIN_VALUE - 1) ==  Integer.MAX_VALUE ) {
			System.out.println("Underflow Occurred..!");
			//throw new RuntimeException("Underflow Occurred..!");
		}
		
		System.out.println("Symbol:" + c);
		
	}
}

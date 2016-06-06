package concepts.fromjava7;

/**
 * In Java SE 7 and later, any number of underscore characters (_) can appear
 * anywhere between digits in a numerical literal. This feature enables you, for
 * example, to separate groups of digits in numeric literals, which can improve
 * the readability of your code. For instance, if your code contains numbers
 * with many digits, you can use an underscore character to separate digits in
 * groups of three, similar to how you would use a punctuation mark like a
 * comma, or a space, as a separator.
 * 
 * The following example shows other ways you can use the underscore in numeric
 * literals:
 * 
 * NOTE: You can place underscores only between digits; you cannot place underscores in the following places:
 * 
 * 	- 	At the beginning or end of a number. 
 *  - 	Adjacent to a decimal point in a floating point literal 
 *  - 	Prior to an F or L suffix 
 *  - 	In positions where a string of digits is expected
 */
public class UnderscoresInNumericLiterals {
	long creditCardNumber = 1234_5678_9012_3456L;
	
	long socialSecurityNumber = 999_99_9999L;
	
	float pi = 	3.14_15F;
	
	long hexBytes = 0xFF_EC_DE_5E;
	
	long hexWords = 0xCAFE_BABE;
	
	long maxLong = 0x7fff_ffff_ffff_ffffL;
	
	byte nybbles = 0b0010_0101;
	
	long bytes = 0b11010010_01101001_10010100_10010010;
		
}

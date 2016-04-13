package concepts.evaluation;

/**
 * The evaluation of an expression where operators have the same precedence is
 * from left to right.
 */
public class EvaluationRespectsParenthesesPrecedence {

	public static void main(String[] args) {
		// If either (or both) of the operands of the + operator is a string,
		// the other is automatically cast to a string. String concatenation and addition
		// have the same precedence 
		System.out.println("12" + 3 + 4);

		System.out.println(1 + 2 + "3" + 4 + 5);
		
		System.out.println("12" + 3 * 4);

		System.out.println("1" + 2 * 3 / 4);

		System.out.println((2 * 3 % 4));
		
	}
}

package concepts.evaluation;

public class EvaluateLeftHandOperandFirst {

	/**
	 * The left-hand operand of a binary operator appears to be fully evaluated
	 * before any part of the right-hand operand is evaluated. If the operator
	 * is a compound-assignment operator, then evaluation of the left-hand
	 * operand includes both remembering the variable that the left-hand operand
	 * denotes and fetching and saving that variable's value for use in the
	 * implied binary operation. If evaluation of the left-hand operand of a
	 * binary operator completes abruptly, no part of the right-hand operand
	 * appears to have been evaluated.
	 */
	public static void main(String[] args) {
		// first example
		int a = 9;		
		a += (a = 3); 
		System.out.println(a);
		// second example
		int b = 9;
		b = b + (b = 3);
		System.out.println(b);
	}

}

package concepts.evaluation;

public class EvaluateOperandsBeforeOperation {

	/** The Java programming language guarantees that every operand of an
	 operator (except the conditional operators &&, ||, and ? :) appears to be
	 fully evaluated before any part of the operation itself is performed.*/

	public static void main(String[] args) {
		int divisor = 0;
		try {
			int i = 1 / (divisor * loseBig());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	static int loseBig() throws Exception {
		throw new Exception("Shuffle off to Buffalo!");
	}

}

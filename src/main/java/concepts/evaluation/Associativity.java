package concepts.evaluation;

public class Associativity {

	public static void main(String[] args) {
		int k = 1;
        int[] l = { 1 };
        // Value Of Left-Hand Side Of Compound Assignment Is Saved Before Evaluation Of Right-Hand Side
	    k += (k = 4) * (k + 2);
	    l[0] += (l[0] = 4) * (l[0] + 2);
	    System.out.println("k==" + k + " and a[0]==" + l[0]);
	    
 	    //Conditional Operator ? :
	    System.out.println(1 > 0 ? 0 : 1 > 0 ? 1 : 0 > 1 ? 1 : 0);
	}

}

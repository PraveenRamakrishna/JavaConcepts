package concepts.fromjava8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/** Function-Style Code, is like a Signal-to-Noise ratio, we write fewer lines for code, but each line or expression achieve more. Some benifits
- Avoid explicit mutation or reassignment of variables.
- Functional version can easily be parallelized.
- Code is more expressive
- The functional-style version is more concise(Fewer lines of code to achieve the same result)
- The functional-style version is Intuitive(code reads more like we state the problem)*/
public class ImperativeToFunctional {
	static List<BigDecimal> prices = Arrays.asList(new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("50"), new BigDecimal("12"), new BigDecimal("25"));
	
	//Requirement - to total prices > 20$ & discount by 10%
	
	public static void main(String[] args) {
		imperativeStyle();
		
		functionalStyle();
	}
	
	private static void imperativeStyle(){
		BigDecimal totalOfDiscountPrices = BigDecimal.ZERO;
		for (BigDecimal price : prices) {
			if(price.compareTo(BigDecimal.valueOf(20)) > 0){
				totalOfDiscountPrices = totalOfDiscountPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
			}
		}
		System.out.println("Imperative Style- Total of discounted prices: "+totalOfDiscountPrices);
	}
	
	
	/*
	 * Design with Higher-Order functions, with which we can 
	 * 	- pass functions to functions
	 *  - Create functions within functions
	 *  - Return functions to functions.
	 *  
	 *  price -> price.compareTo(BigDecimal.valueOf(20))>0, the function being passed is Just in Time, which is anonymous, it has no name, In java 8 
	 *  rather than referring to these as anonymous functions, we call them as Lambda Expressions.    
	 */
	private static void functionalStyle(){
		BigDecimal totalOfDiscountPrices = prices.stream()
		.filter(price -> price.compareTo(BigDecimal.valueOf(20))>0)
		.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
		.reduce(BigDecimal.ZERO, BigDecimal::add);
		
		System.out.println("Funcational Style - Total of discounted prices: "+totalOfDiscountPrices);
	}
}

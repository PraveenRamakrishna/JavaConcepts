package concepts.fromjava8;

import java.math.BigDecimal;
import java.util.function.Function;

public class DelegationUsingLambdaExpressions {
	
	private Function<String,BigDecimal> priceFinder;
	
	public BigDecimal computeStockWorth(final String ticker, final int shares){
			return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
	}

	public DelegationUsingLambdaExpressions(Function<String, BigDecimal> priceFinder) {
		super();
		this.priceFinder = priceFinder;
	}
	
	public static void main(String... args){
		final DelegationUsingLambdaExpressions expressions = new DelegationUsingLambdaExpressions(YahooFinance::getPrice);
		System.out.println(String.format("1000 shared of google worth: $%.2f",expressions.computeStockWorth("Goog", 1000)));		
	}
}

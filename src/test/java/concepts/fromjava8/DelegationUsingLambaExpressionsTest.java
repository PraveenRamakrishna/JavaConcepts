package concepts.fromjava8;

import java.math.BigDecimal;

import org.junit.Test;

public class DelegationUsingLambaExpressionsTest {

	@Test
	public void computeStockWorth() {
		final DelegationUsingLambdaExpressions expressions = new DelegationUsingLambdaExpressions(ticker -> new BigDecimal("6.01"));
		assert new BigDecimal("6010.00").equals(expressions.computeStockWorth("GOO", 1000));
	}

}

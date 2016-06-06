package concepts.fromjava7;

/**
 * The Java SE 7 compiler performs more precise analysis of rethrown exceptions
 * than earlier releases of Java SE. This enables you to specify more specific
 * exception types in the throws clause of a method declaration.
 */
public class ImprovedTypeChecking {
	/**
	 * Suppose you want to specify these exception types in the throws clause of
	 * the rethrowException method declaration. In releases prior to Java SE 7,
	 * you cannot do so. Because the exception parameter of the catch clause, e,
	 * is type Exception, and the catch block rethrows the exception parameter
	 * e, you can only specify the exception type Exception in the throws clause
	 * of the rethrowException method declaration.
	 */
	public void rethrowExceptionPriorToJava7(String exceptionName) throws Exception {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * You can specify the exception types FirstException and SecondException in
	 * the throws clause in the rethrowException method declaration. The Java SE
	 * 7 compiler can determine that the exception thrown by the statement throw
	 * e must have come from the try block, and the only exceptions thrown by
	 * the try block can be FirstException and SecondException. Even though the
	 * exception parameter of the catch clause, e, is type Exception, the
	 * compiler can determine that it is an instance of either FirstException or
	 * SecondException
	 * 
	 * @throws FirstException
	 * @throws SecondException
	 */
	public void rethrowExceptionInJava7(String exceptionName) throws FirstException, SecondException {
		try {
			if (exceptionName.equals("First")) {
				throw new FirstException();
			} else {
				throw new SecondException();
			}
		} catch (Exception e) {
		      throw e;
	    }
	}

	static class FirstException extends Exception {

	}

	static class SecondException extends Exception {
	}

}

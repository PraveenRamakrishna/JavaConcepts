package concepts.fromjava8;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * We have very limited options here:
 *  - We could either handle the exception right their within Lambda Expression.
 *  - Catch it & throw it as unchecked exception.
 */
public class DealingWithExceptions {

		public static void main(String[] args) {
			
			handleExceptionRightTheir();
			
			throwRuntimeException();
	
		}

		private static void handleExceptionRightTheir() {
		Stream.of("/tmp", "/usr")
				.map(path -> {
					try {
						return new File(path).getCanonicalPath();
					} catch (IOException e) {
						return e.getMessage();
					}
				}).forEach(System.out::println);
	    }
		
		
	/**
	 * Transforming from a checked to an unchecked exception and rethrowing may
	 * work fine if the calls to the lambda expressions are made sequentially.
	 * If the calls are made concurrently from different threads, however, there
	 * are a few caveats.
	 * 
	 * In a concurrent execution, an exception raised within the lambda
	 * expressions will be propagated automatically to the calling primary
	 * thread. There are two snags: First, this will not terminate or obstruct
	 * the execution of other lambda expressions running concurrently. Second,
	 * if exceptions are thrown from multiple concurrent executions, only one of
	 * them will be reported in the catch block. If the details of all the
	 * exceptions are important, it’s better to capture those within the lambda
	 * expressions and pass them back to the main thread as part of the result.
	 */
	  private static void throwRuntimeException() {
			Stream.of("/tmp", "/usr")
					.map(path -> {
						try {
							return new File(path).getCanonicalPath();
						} catch (IOException e) {
							throw new RuntimeException(e);
						}
					}).forEach(System.out::println);

	  }

}

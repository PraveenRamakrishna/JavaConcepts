package concepts.exception;

public class FinallyBehaviourInCaseOfExit {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        @Override
	        public void run() {
	            System.out.println("bye");
	        }
	    });
		
		try {
			System.out.println("try");
			System.exit(0);
			System.out.println("try-after exit");
		} catch (Exception e) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}
	}
}

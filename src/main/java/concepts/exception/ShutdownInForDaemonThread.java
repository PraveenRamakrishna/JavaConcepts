package concepts.exception;

public class ShutdownInForDaemonThread {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        @Override
	        public void run() {
	            System.out.println("Shutdown Hook - bye");
	        }
	    });
		
		System.out.println("Main Thread - Started");
		DaemonThread daemonThread = new DaemonThread();
		daemonThread.start();
		System.out.println("Main Thread - Stop");
	}
}

class DaemonThread extends Thread{
	@Override
	public void run() {
		System.out.println("I am a Daemon thread, Created to do job in background...");
		try {
			System.out.println("DameonThread - Started");
			Thread.sleep(1000);
			System.out.println("DameonThread - Ended");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

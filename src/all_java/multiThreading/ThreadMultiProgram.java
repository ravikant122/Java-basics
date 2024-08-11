package all_java.multiThreading;

public class ThreadMultiProgram extends Thread {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getName() + " with id "
					+ Thread.currentThread().getId() + " is running");
			// Thread.currentThread().getId() -- returns id of current thread running
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

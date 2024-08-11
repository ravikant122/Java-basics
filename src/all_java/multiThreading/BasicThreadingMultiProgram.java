package all_java.multiThreading;

public class BasicThreadingMultiProgram extends Thread {
	public static void main(String[] args) {
		// threads are in different programs -- subprocess
		// only the main process is here -- that will call threads from here

		// 1. ThreadForMultiprogram -- class in diff file
		for (int i = 0; i < 6; i++) {
			ThreadMultiProgram the = new ThreadMultiProgram();
			the.start();
		}

		// 2. Runnable_MultiProgram -- class in diff file
		for (int i = 0; i < 6; i++) {
			Thread the = new Thread(new RunnableMultiProgram());
			// to call a Runnable implementing class -- we've to create Thread class obj --
			// bcoz Runnable = an interface
			the.start(); // same start to start Runnable
		}

		// Imp:
		// bcoz of multithreading -- both threads will be called concurrently
		// when one thread runs -- then other theads won't

	}
}	

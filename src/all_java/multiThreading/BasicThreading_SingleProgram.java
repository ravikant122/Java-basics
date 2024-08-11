package all_java.multiThreading;

class A{
	static int method() {
		return 10;
	}
}

//extending Thread
class Threading1 extends Thread {
	
	@Override
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
			// Thread.currentThread().getId() -- returns id of current thread running	
// calling of simple class
			System.out.println(A.method());
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

//implementing Runnable interface
class Threading2 implements Runnable {
	
	@Override
	public void run() { // overridding the run method(abstract) of Runnable Interface
		try {
			// Displaying the thread that is running
			System.out.println("Runnable Thread " + Thread.currentThread().getId() + " is running");
			// Thread.currentThread().getId() -- returns id of current thread running
// calling of simple class
			System.out.println(A.method());
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

public class BasicThreading_SingleProgram  {
	public static void main(String[] args) {
		
		// main process -- program
		// threads -- light-weighted processes within a process

		// the classes which are wants to participate in multithreading 
		// -- should extends Thread or implement Runnable 
		// main class doesn't need to extend Thread class -- it works -- no diff if extends or not extends
		
		// PROCESS OF THREADING --
		// a thread contains a methods run(this methods should override bcoz similar
		// method also present in Thread class
		// -- part inside run will run concurrently
		// in the main program we create an obj of thread
		// & call the start methods(present in Thread class) -- start will start
		// executing thread by calling run

		// why start() instead we can directly call run method --
		// every called method are processed onto the call stack -- single stack for all methods
		// but start() creates a separate call stack specially for that thread only
		// due to start() -- we create multiple threads for that program
		// if we call that thread by run method -- only one will be created (thread 0)

		// there will always be a main thread -- that is of main class 
		// doesn't matter whether main class extends Thread class or not
		
		// creation of threads
		// 1. thread extending Thread class -- java.lang.thread
		for (int i = 0; i < 6; i++) {
			Threading1 the = new Threading1();
			the.start();
		}

		// 2. thread implementing Runnable interface
		for (int i = 0; i < 6; i++) {
			Thread the = new Thread(new Threading2());
			// to call a Runnable implementing class -- we've to create Thread class obj --
			// bcoz Runnable = an interface
			the.start(); // same to start Runnable
		}
	}
}

package all_java.multiThreading;

import java.util.concurrent.Semaphore;

class Shared {
	static int count = 0;
}

class MyThread extends Thread {
	Semaphore sem;
	String threadName;

	public MyThread(Semaphore sem, String threadName) {
		super(threadName);
		this.sem = sem;
		this.threadName = threadName;
	}

	@Override
	public void run() {

		// run by thread A
		if (this.getName().equals("A")) {
			System.out.println("Starting " + threadName);
			try {
				// First, get a permit.
				System.out.println(threadName + " is waiting for a permit.");

				// acquiring the lock
				sem.acquire();

				System.out.println(threadName + " gets a permit.");

				// Now, accessing the shared resource.
				// other waiting threads will wait, until this
				// thread release the lock
				for (int i = 0; i < 5; i++) {
					Shared.count++;
					System.out.println(threadName + ": " + Shared.count);

					// Now, allowing a context switch -- if possible.
					// for thread B to execute
					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}

			// Release the permit.
			System.out.println(threadName + " releases the permit.");
			sem.release();
		}

		// run by thread B
		else // if-else bcoz A increments the count & B decrements
		{
			System.out.println("Starting " + threadName);
			try {
				// First, get a permit.
				System.out.println(threadName + " is waiting for a permit.");

				// acquiring the lock
				sem.acquire();

				System.out.println(threadName + " gets a permit.");

				// Now, accessing the shared resource.
				// other waiting threads will wait, until this
				// thread release the lock
				for (int i = 0; i < 5; i++) {
					Shared.count--;
					System.out.println(threadName + ": " + Shared.count);

					// Now, allowing a context switch -- if possible.
					// for thread A to execute
					Thread.sleep(10);
				}
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
			// Release the permit.
			System.out.println(threadName + " releases the permit.");
			sem.release();
		}
	}
}

public class SemaphoreSema {
	public static void main(String args[]) throws InterruptedException {
		// Semaphore is to restrict access to a shared resource
		// allow only given no of threads to access the same

		// creating a Semaphore object with number of permits 1 -- only 1 thread can
		// access a resource
		Semaphore sem = new Semaphore(1);

		// creating two threads with name A and B
		// Note that thread A will increment the count
		// and thread B will decrement the count
		MyThread mt1 = new MyThread(sem, "A");
		MyThread mt2 = new MyThread(sem, "B");

		// stating threads A and B
		mt1.start();
		mt2.start();

		// if A gets permit first -- then it will increment count by 5 times with 5
		// sleep also -- during that B can't access the same

		// count will always remain 0 after both threads will complete their execution
		System.out.println("count: " + Shared.count);

	}
}

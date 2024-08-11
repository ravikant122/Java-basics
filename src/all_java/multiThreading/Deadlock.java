package all_java.multiThreading;

class Util {
	// Util class to sleep a thread
	static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

// This class is shared by both threads 
class SharedResource {
	// first synchronized method
	synchronized void test1(SharedResource s2) {
		System.out.println("test1-begin");
		Util.sleep(1000);

		// taking object lock of s2 enters
		// into test2 method
		s2.test2(this);
		System.out.println("test1-end");
	}

	// second synchronized method
	synchronized void test2(SharedResource s1) {
		System.out.println("test2-begin");
		Util.sleep(1000);

		// taking object lock of s1 enters
		// into test1 method
		s1.test1(this);
		System.out.println("test2-end");
	}
}

class Thread1 extends Thread {
	private SharedResource s1;
	private SharedResource s2;

	// constructor to initialize fields
	public Thread1(SharedResource s1, SharedResource s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	// run method to start a thread
	@Override
	public void run() {
		// taking object lock of s1 enters
		// into test1 method
		s1.test1(s2);
	}
}

class Thread2 extends Thread {
	private SharedResource s1;
	private SharedResource s2;

	// constructor to initialize fields
	public Thread2(SharedResource s1, SharedResource s2) {
		this.s1 = s1;
		this.s2 = s2;
	}

	// run method to start a thread
	@Override
	public void run() {
		// taking object lock of s2
		// enters into test2 method
		s2.test2(s1);
	}
}

public class Deadlock {
	public static void main(String[] args) {
		// DEADLOCK
		// -- suppose there are two threads X and Y
		// -- X locked a shared resource and Y waiting for that resource to be free from
		// X
		// -- simentaneously
		// -- Y locked a shared resource and X waiting for that resource to be free from
		// Y
		// -- both threads get stuck

		// creating one object
		SharedResource s1 = new SharedResource();

		// creating second object
		SharedResource s2 = new SharedResource();

		// creating first thread and starting it
		Thread1 t1 = new Thread1(s1, s2);
		t1.start();

		// creating second thread and starting it
		Thread2 t2 = new Thread2(s1, s2);
		t2.start();

// steps explained: -- object lock = goes into syncrhronized block

// Thread t1 starts and calls test1 method by taking the object lock of s1.
// Thread t2 starts and calls test2 method by taking the object lock of s2.
// t1 prints test1-begin and t2 prints test-2 begin and both waits for 1 second, so that both threads can be started if any of them is not.
// t1 tries to take object lock of s2 and call method test2 but as it is already acquired by t2 so it waits till it become free. 
// -- It will not release lock of s1 until it gets lock of s2.
// Same happens with t2. It tries to take object lock of s1 and call method test1 but it is already acquired by t1, 
// -- so it has to wait till t1 release the lock. t2 will also not release lock of s2 until it gets lock of s1.

		// synchronized block of both s1 and s2 will remain in parallel
		// -- when s1's sync. and s2's sync. block get on
		// -- s1 tries to get into s2's sync -- but it can't bcoz s2's sync. is already
		// on
		// -- similarly s2 tries to get into s1's sync. -- but it can't bcoz s1's sync
		// is already on

// Now, both threads are in wait state, waiting for each other to release locks. 
// -- Now there is a race around condition that who will release the lock first.
// As none of them is ready to release lock, so this is the Dead Lock condition.
// When you will run this program, it will be look like execution is paused.

		// sleeping main thread
		Util.sleep(2000);
	}
}

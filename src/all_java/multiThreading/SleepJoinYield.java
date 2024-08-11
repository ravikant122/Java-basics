package all_java.multiThreading;

class SleepDemo implements Runnable {
	public void run() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Thread.currentThread().getName() + "  " + i);
			try {
				// thread to sleep for 1000 milliseconds
				Thread.sleep(1000);
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}

// join for until die
class JoinDemo extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			try {
				Thread.sleep(500); // here we put thread in sleep then also no other threads can execution
				System.out.println("Current Thread: " + Thread.currentThread().getName());
			}

			catch (Exception ex) {
				System.out.println("Exception has" + " been caught" + ex);
			}
			System.out.println(i);
		}
	}
}

// join for limited time
class JoinDemo1 implements Runnable {
	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t.getName());

		// checks if current thread is alive
		System.out.println("Is Alive? " + t.isAlive());
	}
}

// yield demo
class YieldDemo extends Thread {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName() + " is runnin");
		}
	}
}

// main class
public class SleepJoinYield {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {

		// sleep(long miliSec)
		// sleep(long miliSec, int nanoSec) -- mili + nano
		Thread d1 = new Thread(new SleepDemo());
		Thread d2 = new Thread(new SleepDemo());

		d1.setName("d1");
		d2.setName("d2");
		d1.start();
		d2.start();

		// it will sleep the thread for given time for sure
		// disAdv -- in that time(sleep time of thread), if no other threads running or
		// needs to be run -- then CPU will be in idle state

		// join -- it will put all other threads in waiting state until the current thread won't die
		// if we call t.join() -- on a thread t -- then no other thread can execute until t won't die

		// join() -- until die -- whole thread will execute at once -- without interruption of other threads
		// -- thread execution will stop after execution of run() method -- after thread will enter in termination state

		// join(long mills) -- thread will be executed for given time -- after that
		// thread will be declared as DEAD
		// join(long mills, int nanoSec)

		// IMP --> after any join() -- any thread = DEAD
		JoinDemo t1 = new JoinDemo();
		JoinDemo t2 = new JoinDemo();
		JoinDemo t3 = new JoinDemo();

		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		// thread t1 starts
		t1.start();

		// starts second thread after when first thread t1 has died.
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName()); // main thread
			t1.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}

		// t2 starts
		t2.start();

		// starts t3 after when thread t2 has died
		try {
			System.out.println("Current Thread: " + Thread.currentThread().getName()); // main thread
			t2.join();
		}

		catch (Exception ex) {
			System.out.println("Exception has been caught" + ex);
		}

		t3.start();

		// join(long miliSec) -- with Thread.currentThread().isAlive() -- returns true
		// if thread is alive, else false
		Thread t = new Thread(new JoinDemo1());
		t.start();

		// after 1000 mili sec -- thread will automatically die due to join
		t.join(1000);

		System.out.println("\nJoining after 1000 mili seconds: \n");
		System.out.println("Current thread: " + t.getName());

		// Checks if this thread is alive
		System.out.println("Is alive? " + t.isAlive()); // false

		// yield -- it pauses the currently executing thread temporarily
		// -- for giving a chance to the remaining waiting threads of the same priority
		// -- if there is no waiting thread or all the waiting threads have a lower
		// priority then the same thread will continue its execution
		// it depends on the scheduler to let to execute other threads -- it may or may
		// not happen all the time
		YieldDemo y1 = new YieldDemo();
		YieldDemo y2 = new YieldDemo();

		y1.setName("y1");
		y2.setName("y2");

		y1.setPriority(6); // for excluding main thread
		y2.setPriority(6);

		y1.start();
		y1.yield(); // yield = static fn
		y2.start();

	}
}

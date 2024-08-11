package all_java.multiThreading;

class DaemonThread extends Thread {
	public DaemonThread(String name) {
		super(name);
	}

	public void run() {
		// Checking whether the thread is Deamon or not
		if (Thread.currentThread().isDaemon()) {
			System.out.println(getName() + " is Daemon thread");
		}

		else {
			System.out.println(getName() + " is User thread");
		}
	}
}

public class Deamons {
	public static void main(String[] args) {
		// deamon threads = lowest-priority threads
		// work -- service provide to main/user threads
		// ex. = garbage collector -- automatically works & provide service to main
		// thread/program when an obj is deleted
		DaemonThread t1 = new DaemonThread("t1");
		DaemonThread t2 = new DaemonThread("t2");
		DaemonThread t3 = new DaemonThread("t3");

		// Setting user thread t1 to Daemon
		t1.setDaemon(true);

		// starting first 2 threads
		t1.start();
		t2.start();

		// Setting user thread t3 to Daemon -- we can't set a thread deamon after
		// starting it -- thread.start()
		t3.setDaemon(true);
		t3.start();
	}
}

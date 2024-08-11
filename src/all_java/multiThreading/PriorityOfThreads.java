package all_java.multiThreading;

public class PriorityOfThreads extends Thread {
	public static void main(String[] args) {
		ThreadMultiProgram t1 = new ThreadMultiProgram();
		ThreadMultiProgram t2 = new ThreadMultiProgram();
		ThreadMultiProgram t3 = new ThreadMultiProgram();

		// default priority = 5 -- of main Thread also
		// getPriority -- to get thread's priority
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		System.out.println(Thread.currentThread().getPriority()); // main thread's priority

		// setPriority(newPrio) --    1 <= newPrio <=10
		// Thread.MIN_PRIORITY -- 1
		// Thread.MAX_PRIORITY -- 10
		// Thread.NORM_PRIORITY -- 5
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(6);
		Thread.currentThread().setPriority(Thread.NORM_PRIORITY); // main thread's
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		System.out.println(Thread.currentThread().getPriority());

		// setName(String name) -- to set a name to a thread -- default name --
		// Thread-0/1/2 ...
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		// t2 --> t3 --> t1 -- order of execution -- but it keeps on change
		t1.start();
		t2.start();
		t3.start();

		// lets the priority of main thread = 6
		// & if we don't set priorities for child threads( t1 / t2 / t3 )
		// then priority of child threads = main thread's prio

		// if two threads having same prio -- then it depends on the thread scheduler
		// that which thread will execute first

	}
}

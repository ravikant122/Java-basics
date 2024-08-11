package all_java.multiThreading;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
	private CountDownLatch latch;

	Worker(CountDownLatch llatch, String name) {
		super(name);
		this.latch = llatch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			latch.countDown(); // decrease count of latch -- main thread run only when count of latch = 0 --
								// until then it waits
		}
//    	System.out.println(latch.getCount());
//    	System.out.println(Thread.currentThread().getName() + " finished");
// result will be diff if we uncomment the above two lines -- only printing will be change -- main thread will start after all thread ends
	}
}

// main class
class Countdown extends Thread {
	public static void main(String[] args) throws InterruptedException {
		// CountDownLatch -- use when a main task should run after successful completion
		// of its subtask
		// main task will wait until all of its tasks not executed succefully

		CountDownLatch latch = new CountDownLatch(4); // give no of task

		// Let us create four worker threads and start them.
		Worker first = new Worker(latch, "WORKER-1");
		Worker second = new Worker(latch, "WORKER-2"); // DOUBT -- why can't we give same sleeping/delay time in each
														// worker
		Worker third = new Worker(latch, "WORKER-3");
		Worker fourth = new Worker(latch, "WORKER-4");

		// these four threads will run parallely and main thread will start after
		// completion of these
		first.start();
		second.start();
		third.start();
		fourth.start();

		// The main task waits for four threads -- "main" thread
		System.out.println(latch.getCount()); // this will be print first -- bcoz at that time all task are on sleep
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Main thread has started
		System.out.println(Thread.currentThread().getName() + " has finished");

	}
}
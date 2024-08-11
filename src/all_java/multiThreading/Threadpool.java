package all_java.multiThreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
	private String name;

	public Task(String s) {
		name = s;
	}

	// Prints task name and sleeps for 1s
	// This Whole process is repeated 5 times
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				if (i == 0) {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Initialization Time for" + " task name - " + name + " = " + ft.format(d));
					// prints the initialization time for every task
				} else {
					Date d = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
					System.out.println("Executing Time for task name - " + name + " = " + ft.format(d));
					// prints the execution time for every task
				}
				Thread.sleep(1000);
			}
			System.out.println(name + " complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Threadpool {
	public static void main(String[] args) {
		// Thread Pool -- the server-side for each query, we've to make a seperate
		// thread to process it
		// -- that's kinda costly and un-efficient
		// -- we create thread pool with fixed no of threads
		// -- using it -- we can use previously created threads -- that are not in use
		// when new query enters

		// steps
		// 1. create a thread pool with fixed size
		// 2. pass all tasks to execute in thread pool
		// 3. at the end, shutdown the pool

		// now no. of queries can be greater than no of threads in thread pool
		// -- if threads in pool are busy to process early queries
		// -- then new queries will be placed in queue
		// -- & will be process as threads get free

		// these are tasks not threads
		Runnable r1 = new Task("task 1");
		Runnable r2 = new Task("task 2");
		Runnable r3 = new Task("task 3");
		Runnable r4 = new Task("task 4");
		Runnable r5 = new Task("task 5");

		// creates a thread pool with 3 as the fixed pool size
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// passes the Task objects to the pool to execute
		executor.execute(r1);
		executor.execute(r2);
		executor.execute(r3);
		executor.execute(r4);
		executor.execute(r5);
		// since the size of pool is 3 -- so it can process 3 tasks at a time
		// task 4 & 5 have to wait until one of the task is not finished

		// pool shutdown
		executor.shutdown();
		// Call shutdown() on the pool to end the executor
		// -- If you try to send another task to the executor after shutdown, it will
		// throw a RejectedExecutionException

		// ThreadpoolExecutor -- implementation of interface ExecutorService
		// -- provide flexibility of parameters to tune
		// object of this will not be any factory method of Executors(newfixed,
		// newCached etc.)

		// parameters
		// 1. corePoolSize -- no of threads in the thread pool -- dead or alive
		// 2. maxPoolSize -- max no of threads that can be created in the pool
		// no of threads can grow upto maxPoolSize
		// 3. keepAliveTime -- if no of threads are greater than corePoolSize & some of
		// them are idle(not working)
		// -- using this we can destroy those threads
		// -- if a thread is idle more than keepAliveTime -- then it will be destroyed
		// 5. TimeUnit -- reperesent unit of keepAliveTime
		// 6. Queue -- we can use any queue(bounded or unbounded)
		// 7. factoryMethod -- methods like newFixedThread or newCachedThread etc. --
		// cast the method into ThreadFactory
		ThreadPoolExecutor exe = new ThreadPoolExecutor(4, 10, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		// 60 = seconds -- represented by TimeUnit.SECONDS
		exe.setCorePoolSize(3);
		exe.setMaximumPoolSize(8);

		exe.execute(r1);
		exe.execute(r2);
		exe.execute(r3);
		exe.execute(r4);
		exe.execute(r5);

	}
}

package all_java.multiThreading;

class Sender {
	public void send(String msg) {
		System.out.println("Sending\t" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
		System.out.println("\n" + msg + "Sent");
	}
}

// Class for send a message using Threads 
class ThreadedSend extends Thread {
	String msg;
	Sender sender;

	// Recieves a message object and a string
	// message to be sent
	ThreadedSend(String m, Sender obj) {
		msg = m;
		sender = obj;
	}

	public void run() {
		synchronized (msg) // sync. doesn't work on variables
		{
			System.out.println("msg is " + msg);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(msg + " is gonna send");
		}

		// Only one thread can send a message at a time.
		synchronized (sender) // block synchronization -- we can do this -- just creating a block that is
								// synchronized
		{
			// synchronizing the snd object
			sender.send(msg);
		}
	}
}

// method sync
class methodSyncing {
	synchronized public void sync(String msg) {
		System.out.println("reading\t" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
		System.out.println("writing\t" + msg);
	}
}

class methodSync extends Thread {
	String msg;
	methodSyncing obj;

	methodSync(String msg, methodSyncing obj) {
		this.msg = msg;
		this.obj = obj;
	}

	public void run() {
		this.obj.sync(this.msg);
	}
}

// multiple sync on this(obj) in diff methods
class ProtocolUtilities {
	public void produce() throws InterruptedException {
		synchronized (this) // t1 thread called this method means this block -- t2 thread called consume
							// method
		{ // both sync blocks applied on this means obj -- don't worry sync. will work
			// fine
			System.out.println("thread running"); // first this sync will execute full without interruption of below
													// sync
			Thread.sleep(1000);
			System.out.println("Resumed");
		}
	}

	public void consume() throws InterruptedException {
		synchronized (this) {
			System.out.println("Waiting for return key.");
			Thread.sleep(1000);
			System.out.println("Return key pressed");
		}
	}
}

// wait() -- notify()
class ProCons {
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("producer thread running");

			// releases the lock on shared resource
			wait(); // this will wake after the block of notify execute completely -- no
					// Interruption in notify's block

			// and waits till some other method invokes notify().
			System.out.println("Resumed");
		}
	}

	public void consume() throws InterruptedException {
		// this makes the produce thread to run first.
		Thread.sleep(1000);

		synchronized (this) {
			System.out.println("Waiting for return key.");
			notify(); // it notifies that thread that waiting(sleep) can wake up
			// notify only wakes up wait() -- it is not like wait() -- so this block will
			// execute completely -- bcoz it's a Sync. block
			// -- without interruption of wait()'s block
			System.out.println("Return key pressed");
		}
	}
}

// main class
public class Syncronization {
	public static void main(String args[]) {

		// synchronization = only one thread can access information at a time
		// if a thread is entered in synchronized block -- then all thread will have to
		// wait until that thread won't execute fully
		Sender snd = new Sender();
		ThreadedSend S1 = new ThreadedSend(" Hi ", snd);
		ThreadedSend S2 = new ThreadedSend(" Bye ", snd);

		// Start two threads of ThreadedSend type
		S1.start();
		S2.start();

		// we can't say which thread will enter first -- but if a thread enters -- then
		// no other thread can enter
		// let S1 = first enter in sync. block -- then S2 will have to wait till s1 is
		// inside the sync. block
		// as we can see -- when S1 enters -- we put S1 in sleep
		// but then also S2 can't enter & execute it's code
		// S2 have to wait till S1 is inside the sync. block

		// throws null pointer exception -- if obj = NULL on sync. is applied
		// sync. doesn't work on variables

		// method sync -- if we apply sync on a method -- just write synchronized in the
		// starting of declaration of method
		methodSyncing msgsync = new methodSyncing();
		methodSync msg1 = new methodSync(" Hi ", msgsync);
		methodSync msg2 = new methodSync(" Bye ", msgsync);

		msg1.start();
		msg2.start();

		// block sync -- we create a sync. block -- all the code inside that will be the
		// part of synchronization
		ProtocolUtilities ProtocolUtilities = new ProtocolUtilities();

		// Create a thread object that calls ProtocolUtilities.produce()
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ProtocolUtilities.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Create another thread object that calls ProtocolUtilities.consume()
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ProtocolUtilities.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();

		// wait() & notify()

		// In sync block or method -- another thread can't interrupt
		// wait() -- put that thread in sleeping or waiting state
		// notify() -- tells waiting state that it can wake up now
		// the block of notify() will execute completely -- then wait()'s thread will
		// wake up
		// bcoz notify != wait() -- & bcoz of synchronization it
		ProCons ProtocolUtilities1 = new ProCons();

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ProtocolUtilities1.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					ProtocolUtilities1.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t3.start();
		t4.start();

		// notifyAll() -- wakes up all the threads that are on wait()

	}
}

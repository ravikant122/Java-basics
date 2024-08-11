package all_java.multiThreading;

public class BasicThreading_SingleClass {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() { // this is inside Runnable
				for (int i = 0; i < 5; i++) {
					System.out.println("upper thread");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Create another thread object that calls
		// ProtocolUtilities.consume()
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("lower thread");
					try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		// Start both threads
		t1.start();
		t2.start();
	}
}

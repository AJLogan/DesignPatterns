package demos.threads.deadlock.classifier;

/**
 * @author Garth Gilmour
 */
public class Deadlock {
	public static void main(String[] args) {
		final Deadlock d = new Deadlock();

		Thread t1 = new Thread() {
								public void run() {
									d.instanceSynchronizedOne();
								}
							};
		Thread t2 = new Thread() {
								public void run() {
									staticSynchronized(d);
								}
							};

		t1.start();
		t2.start();

		while(true) {
			try {
				t1.join(3000);
				t2.join(3000);
			} catch(InterruptedException ex){}
			if(t1.isAlive() || t2.isAlive()) {
				System.out.println("Still waiting for threads");
			} else {
				break;
			}
		}

		System.out.println("Main ends");
	}


	private synchronized void instanceSynchronizedOne() {
		Thread.yield();
		System.out.println("[instanceSynchronizedOne] about to call staticSynchronized");
		staticSynchronized(this);  //MAY CAUSE DEADLOCK!!!
		System.out.println("[instanceSynchronizedOne] returned from call to staticSynchronized");
	}

	private synchronized void instanceSynchronizedTwo() {
		Thread.yield();
	}

	private static synchronized void staticSynchronized(Deadlock d) {
		Thread.yield();
		System.out.println("[staticSynchronized] about to call instanceSynchronizedTwo");
		d.instanceSynchronizedTwo();  //MAY CAUSE DEADLOCK!!!
		System.out.println("[staticSynchronized] returned from call to instanceSynchronizedTwo");
	}
}

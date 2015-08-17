/*
 * Created on Nov 16, 2003
 *
 */
package demos.threads.deadlock.blocks;

/**
 * @author Garth Gilmour
 *
 */
public class Deadlock {

	public static void main(String[] args) {
		final Deadlock d1 = new Deadlock();

		Runnable r1 = new Runnable() {
							public void run() {
								d1.methodA();
							}
						};
		Runnable r2 = new Runnable() {
							public void run() {
								d1.methodB();
							}
						};
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

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
	private void methodA() {
		synchronized(lock1) {
			Thread.yield();
			synchronized(lock2) {
				System.out.println("We never get here!");
			}
		}
	}
	private void methodB() {
		synchronized(lock2) {
			Thread.yield();
			synchronized(lock1) {
				System.out.println("We never get here!");
			}
		}
	}
	private Object lock1 = new Object();
	private Object lock2 = new Object();
}

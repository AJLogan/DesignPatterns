package demos.threads.deadlock.simple;

/**
 * @author Garth Gilmour
 */
public class Launcher {

	public static void main(String[] args) {
		final TestOne testOne = new TestOne();
		final TestTwo testTwo = new TestTwo();

		Runnable r1 = new Runnable() {
							public void run() {
								testOne.funcOne(testTwo);
							}
						};
		Runnable r2 = new Runnable() {
							public void run() {
								testTwo.funcOne(testOne);
							}
						};
				
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		//call 'testOne.funcOne(testTwo)' in a new thread
		t1.start();
		//call 'testTwo.funcOne(testOne)' in a new thread
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
}

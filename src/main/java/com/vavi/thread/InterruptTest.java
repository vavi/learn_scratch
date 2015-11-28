package com.vavi.thread;

import org.junit.Test;

public class InterruptTest {

	@Test
	public void testInterrput() throws Exception {
		InterruptThread it = new InterruptThread();
		Thread t = new Thread(it);
		t.setName("ghj");
		t.setDaemon(true);
		t.start();
		Thread.sleep(1000);
		synchronized (t) {
			t.notify();
		}
		// t.interrupt();// 这句话执行后，有可能主线程先执行（但是子线程还未来得及响应中断），也有可能子线程先响应中断
		// t.sleep(1000);// 加上这行,会导致线程已经死亡,这样中断状态回是false

		Thread.sleep(3000);

		System.out.println(t.isInterrupted());
		System.out.println(t.isAlive());
		// System.out.println(Thread.currentThread().getName()
		// + Thread.currentThread().isInterrupted());
		// Assert.assertFalse(t.isInterrupted());
		// t.join();

	}
}

class InterruptThread implements Runnable {

	public void run() {
		boolean b = true;
		try {
			while (b) {
				synchronized (this) {
					System.out.println("I'm wating1");
					wait();
					System.out.println("I'm wating2");
				}
			}
			System.out.println("thread running ,now will go to sleep 6s");
			// System.out.println(Thread.currentThread().getName()
			// + Thread.currentThread().isInterrupted());
			Thread.sleep(6000L);
		} catch (InterruptedException e) {

			System.out.println("I'm interrupted,my status is "
			// + Thread.currentThread().getName()
					+ Thread.currentThread().isInterrupted());
			Thread.currentThread().interrupt();
			System.out.println("after RE interrupting, my status is "
			// + Thread.currentThread().getName()
					+ Thread.currentThread().isInterrupted());
			System.out.println("NO InterruptedException threw,I'm happy.");
			// throw new RuntimeException(e);
		}
	}

}

// begin to sleep
// true
// true
// ghjfalse

// begin to sleep
// false
// true
// ghjfalse

// thread running ,now will go to sleep 6s
// false
// true
// I'm interrupted,my status is false
// after RE interrupting, my status is true

// thread running ,now will go to sleep 6s
// true
// true
// I'm interrupted,my status is false
// after RE interrupting, my status is true
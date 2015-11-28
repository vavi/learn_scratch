package com.vavi.thread;

import java.util.concurrent.locks.LockSupport;

import org.junit.Test;

public class LockSupportTest {
    @Test
    public void testLockSupport() throws Exception {
	System.out.println(11);
	// LockSupport.park();
	System.out.println(222);

	LockSupportThread t1 = new LockSupportThread();
	LockSupportThread t2 = new LockSupportThread();

	t1.setOther(t2);
	t2.setOther(t1);

	t1.start();
	// t2.start();
	// t1.interrupt();
	// t2.interrupt();

	System.out.println(t1.isAlive());
	System.out.println(t1.isInterrupted());
	System.out.println(t1.isAlive());
	t1.join();
	t2.join();

    }

    static class LockSupportThread extends Thread {

	private Thread other;

	public Thread getOther() {
	    return other;
	}

	public void setOther(Thread other) {
	    this.other = other;
	}

	@Override
	public void run() {
	    // LockSupport.unpark(other);

	    LockSupport.park();
	    System.out.println(Thread.currentThread().getId());
	    // LockSupport.unpark(Thread.currentThread());
	    LockSupport.park();
	    System.out.println("aabb" + Thread.currentThread().getId());

	}

    }
}

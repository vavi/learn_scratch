package com.javaspeak.concurrency.cas.atomicintegerfieldupdater;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @author John Dickerson
 */
public class ReaderThread extends Thread {

	private final CountDownLatch countDownLatch;
	private final Details details;
	private final int maxNumberCalls;

	public ReaderThread(CountDownLatch countDownLatch, int maxNumberCalls) {

		details = new Details();
		this.countDownLatch = countDownLatch;
		this.maxNumberCalls = maxNumberCalls;
	}

	public Details getDetails() {

		return this.details;
	}

	@Override
	public void run() {

		while (true) {

			if (details.getNumberTimesInvoked() >= maxNumberCalls) {

				break;
			}

			LockSupport.parkNanos(1);
		}

		countDownLatch.countDown();
	}
}

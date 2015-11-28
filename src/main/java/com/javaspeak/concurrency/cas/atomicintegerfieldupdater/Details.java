package com.javaspeak.concurrency.cas.atomicintegerfieldupdater;

/**
 * @author John Dickerson
 */
public class Details {

	volatile int numberTimesInvoked;

	public int getNumberTimesInvoked() {

		return numberTimesInvoked;
	}

	public void setNumberTimesInvoked(int numberTimesInvoked) {

		this.numberTimesInvoked = numberTimesInvoked;
	}
}

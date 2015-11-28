package com.javaspeak.concurrency.cas.atomicintegerfieldupdater;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * volatiles cannot be used directly in operations that do x = x + 1 for numbers
 * can be skipped or duplicated when there are multiple threads involved.
 * <p>
 * Hardware supports Atomic Compare And Swap operations. CAS java classes like
 * AtomicInteger can use this feature of the hardware to ensure that a
 * "x = x + 1" like operation is atomic.
 * <p>
 * However AtomicInteger is significantly more resource intensive than a simple
 * volatile. If there are many instances of a class which has an AtomicInteger
 * this increase in resource over a volatile can be significant.
 * <p>
 * The AtomicIntegerFieldUpdater comes to the rescue - it can be registered with
 * a volatile variable of a class and can then be used on multiple instances of
 * the class.
 * 
 * If there are 1000s of instances of a class which would ordinarily have
 * AtomicInteger this can be a big saving.
 * 
 * AtomicIntegerFieldUpdater is able to update a volatile field of an object
 * atomically.
 * 
 * @author John Dickerson
 */
public class AtomicIntegerFieldUpdaterCounter {

	// AtomicIntegerFieldUpdater is registered with Details.class so that it
	// knows it will later be updating the volatile field called
	// numberTimesInvoked
	private final AtomicIntegerFieldUpdater<Details> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater
			.newUpdater(Details.class, "numberTimesInvoked");

	/**
	 * Diferent threads can call this method to update the volatile field of an
	 * instance of Details
	 * 
	 * @param details
	 *            Details object which has the volatile field called
	 *            "numberTimesInvoked" in it.
	 * 
	 * @return the value of the counter after it has been incremented by one
	 */
	public int addOne(Details details) {

		// performs a "x = x + 1" style atomic operation
		return atomicIntegerFieldUpdater.addAndGet(details, 1);
	}

	/**
	 * See test class for example of using this class with multiple threads,
	 * some of which are writing to the volatile field and some which are
	 * reading from the volatile field
	 */
	public static void main(String[] args) {

		AtomicIntegerFieldUpdaterCounter atomicIntegerFieldUpdaterCounter = new AtomicIntegerFieldUpdaterCounter();

		// This call would ordinarily be made by many other threads
		System.out.println(atomicIntegerFieldUpdaterCounter
				.addOne(new Details()));
	}
}

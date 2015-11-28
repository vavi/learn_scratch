package com.vavi.thread;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

@SuppressWarnings("rawtypes")
public final class ContextSwitchTest {
	static final int RUNS = 3;
	static final int ITERATES = 100;

	static AtomicReference turnReference = new AtomicReference();

	static final class WorkerThread extends Thread {
		volatile Thread other;
		volatile int nparks;

		@SuppressWarnings("unchecked")
		@Override
		public void run() {
			final AtomicReference reference = turnReference;
			final Thread other = this.other;
			if (turnReference == null || other == null)
				throw new NullPointerException();
			int p = 0;
			for (int i = 0; i < ITERATES; ++i) {
				while (!reference.compareAndSet(other, this)) {
					LockSupport.park();
					++p;
				}
				LockSupport.unpark(other);
			}
			// LockSupport.unpark(other);
			nparks = p;
			System.out.println("parks: " + p);

		}
	}

	static void test() throws Exception {
		WorkerThread a = new WorkerThread();
		WorkerThread b = new WorkerThread();
		a.setName("aa");
		b.setName("bb");
		a.other = b;
		b.other = a;
		turnReference.set(a);
		long startTime = System.nanoTime();
		a.start();
		b.start();
		a.join();
		b.join();
		long endTime = System.nanoTime();
		int parkNum = a.nparks + b.nparks;
		System.out.println("Average time: " + ((endTime - startTime) / parkNum)
				+ "ns");
	}

	public static void main(String[] args) throws Exception {
		// for (int i = 0; i < RUNS; i++) {
		test();
		// }
	}
}
package com.vavi.thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class Work implements Runnable {
	private final int id;
	private final CountDownLatch beginSignal;
	private final CountDownLatch endSignal;

	public Work(int id, CountDownLatch begin, CountDownLatch end) {
		this.id = id;
		this.beginSignal = begin;
		this.endSignal = end;
	}

	@Override
	public void run() {
		try {
			beginSignal.await();
			System.out.println("起跑...");
			System.out.println("work" + id + "到达终点");
			endSignal.countDown();
			System.out.println("work" + id + "继续干其他事情");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
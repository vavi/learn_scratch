package com.tom.jdk5.concurrent.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*************************************
 * 使用阻塞队列实现生产者消费者问题
 * 
 * BlockingQueue的offer/poll操作不能满足阻塞等待的效果
 * 
 * 
 *************************************/

class Plate {
    // 一个盘子，可以放10个水果
    private final BlockingQueue<String> fruits = new LinkedBlockingQueue<String>(
	    10);

    // 如果有水果，则取得，否则取不走
    public String get() {
	try {
	    return fruits.take();
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt();
	    return null;
	}
    }

    public void put(String fruit) {
	try {
	    fruits.put(fruit);
	} catch (InterruptedException e) {
	    Thread.currentThread().interrupt();
	}
    }
}

class Producer implements Runnable {

    private final Plate plate;

    public Producer(Plate p) {
	this.plate = p;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 100; i++) {
		this.plate.put("" + i);
		System.out.println("第" + i + "个水果放入盘子");
		Thread.sleep((long) (200 * Math.random()));
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}

class Consumer implements Runnable {

    private final Plate plate;

    public Consumer(Plate p) {
	this.plate = p;
    }

    @Override
    public void run() {
	try {
	    for (int i = 0; i < 100; i++) {
		String j = this.plate.get();
		System.out.println("第" + j + "个水果取出盘子");
		Thread.sleep((long) (400 * Math.random()));
	    }
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

}

public class ProducerConsumerTest {
    public static void main(String[] args) {
	Plate p = new Plate();
	Producer producer = new Producer(p);
	Consumer consumer = new Consumer(p);
	new Thread(producer).start();
	new Thread(consumer).start();

    }
}
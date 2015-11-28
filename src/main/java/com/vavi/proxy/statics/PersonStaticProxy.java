package com.vavi.proxy.statics;

import com.vavi.proxy.Sleepable;

public class PersonStaticProxy implements Sleepable {
	private final Sleepable sleep;

	public PersonStaticProxy(Sleepable sleep) {
		this.sleep = sleep;
	}

	public void sleep() {
		System.out.println("take off clothes before sleeping");
		this.sleep.sleep();
		System.out.println("sweet dream now..");

	}

	public void eat() {
		System.out.println("wash hands before eating");
		this.sleep.eat();
		System.out.println("ready to sleep now..");

	}

}

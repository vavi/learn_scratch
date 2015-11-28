package com.vavi.proxy.statics;

import org.junit.Test;

import com.vavi.proxy.Person;
import com.vavi.proxy.Sleepable;

public class TestPersonStaticProxy {
	@Test
	public void testSleep() throws Exception {
		Person person = new Person();
		Sleepable proxy = new PersonStaticProxy(person);
		proxy.eat();
		proxy.sleep();
	}
}

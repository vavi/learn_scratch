package com.vavi.spring.aop.jdk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vavi.proxy.Sleepable;

public class SpringProxyTest {

	public static void main(String[] args) {
		ApplicationContext appCtx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Sleepable sleeper = (Sleepable) appCtx.getBean("humanProxy");
		sleeper.sleep();
	}
}
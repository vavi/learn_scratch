package com.vavi.spring.extension;

import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.UrlResource;

public class SpringExtensionLearnTest {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// InputStream resourceAsStream =
		// SpringExtensionLearnTest.class.getClassLoader().getResourceAsStream("applicationContext.xml");
		// BeanFactory xx = new
		// ClassPathXmlApplicationContext("classpath:applicationContext.xml") ;

		URL resourceUrl = SpringExtensionLearnTest.class
				.getResource("applicationContext.xml");
		ApplicationContext applicationContext = new GenericXmlApplicationContext(
				new UrlResource(resourceUrl));

		applicationContext.getBean("SpringExtensionLearn");
	}
}

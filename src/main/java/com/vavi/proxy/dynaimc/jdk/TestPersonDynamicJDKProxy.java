package com.vavi.proxy.dynaimc.jdk;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.vavi.proxy.Person;
import com.vavi.proxy.Sleepable;

public class TestPersonDynamicJDKProxy {
	@Test
	public void testProxy() throws Exception {

		// System.getProperties().put(
		// "sun.misc.ProxyGenerator.saveGeneratedFiles", true);
		Person person = new Person();
		PersonDynamicJDKProxyHandler handler = new PersonDynamicJDKProxyHandler(
				person);

		Sleepable proxy = (Sleepable) Proxy.newProxyInstance(person.getClass()
				.getClassLoader(), person.getClass().getInterfaces(), handler);

		// 获取代理类的字节码
		generateProxyClassFile();

		proxy.eat();
		proxy.sleep();

	}

	private void generateProxyClassFile() {
		byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass(
				"$MyProxy", Person.class.getInterfaces());

		FileOutputStream out = null;
		String path = "/Users/ghj/startup/$MyProxy.class";
		try {
			out = new FileOutputStream(path);
			out.write(classFile);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

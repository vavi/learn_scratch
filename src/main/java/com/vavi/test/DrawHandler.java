package com.vavi.test;

import java.lang.reflect.Method;

public class DrawHandler implements InvocationHandler {
	
	private Object draw;
	
	public DrawHandler (Object draw){
		this.draw = draw;
	}

	public void invoke(Method m,Object[] args) throws Exception{
		System.out.println("before");
		m.invoke(draw, args);
		System.out.println("after");
	}

}

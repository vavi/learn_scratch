package com.vavi.proxy.dynaimc.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PersonDynamicJDKProxyHandler implements InvocationHandler {
    private final Object targetObject;

    public PersonDynamicJDKProxyHandler(Object targetObject) {
	this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
	    throws Throwable {
	if (method.getName().equals("eat")) {

	    System.out.println("wash hands before eating");
	    method.invoke(targetObject, args);
	    System.out.println("ready to sleep now..");
	} else {

	    System.out.println("take off clothes");
	    method.invoke(targetObject, args);
	    System.out.println("sweet dream now..");

	}

	return null;
    }
}

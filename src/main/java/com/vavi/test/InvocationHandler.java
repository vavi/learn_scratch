package com.vavi.test;

import java.lang.reflect.Method;

public interface InvocationHandler {
		public void invoke(Method m,Object... args) throws Exception;
}

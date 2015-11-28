//package com.vavi.proxy.dynaimc.jdk;
//
//import java.lang.reflect.Method;
//import java.lang.reflect.Proxy;
//import java.lang.reflect.UndeclaredThrowableException;
//
//import com.vavi.proxy.Sleepable;
//
//public final class MyProxy extends Proxy implements Sleepable {
//    private static Method m1;
//    private static Method m3;
//    private static Method m0;
//    private static Method m4;
//    private static Method m2;
//
//    public MyProxy()
//
//    {
//	super(paramInvocationHandler);
//    }
//
//    public final boolean equals()
//
//    {
//	try {
//	    return ((Boolean) this.h.invoke(this, m1,
//		    new Object[] { paramObject })).booleanValue();
//	} catch (Error localError) {
//	    throw localError;
//	} catch (Throwable localThrowable) {
//	    throw new UndeclaredThrowableException(localThrowable);
//	}
//    }
//
//    @Override
//    public final void eat()
//
//    {
//	try {
//	    this.h.invoke(this, m3, null);
//	    return;
//	} catch (Error localError) {
//	    throw localError;
//	} catch (Throwable localThrowable) {
//	    throw new UndeclaredThrowableException(localThrowable);
//	}
//    }
//
//    @Override
//    public final int hashCode()
//
//    {
//	try {
//	    return ((Integer) this.h.invoke(this, m0, null)).intValue();
//	} catch (Error localError) {
//	    throw localError;
//	} catch (Throwable localThrowable) {
//	    throw new UndeclaredThrowableException(localThrowable);
//	}
//    }
//
//    @Override
//    public final void sleep()
//
//    {
//	try {
//	    this.h.invoke(this, m4, null);
//	    return;
//	} catch (Error localError) {
//	    throw localError;
//	} catch (Throwable localThrowable) {
//	    throw new UndeclaredThrowableException(localThrowable);
//	}
//    }
//
//    @Override
//    public final String toString()
//
//    {
//	try {
//	    return ((String) this.h.invoke(this, m2, null));
//	} catch (Error localError) {
//	    throw localError;
//	} catch (Throwable localThrowable) {
//	    throw new UndeclaredThrowableException(localThrowable);
//	}
//    }
//
//    static {
//	try {
//	    m1 = Class.forName("java.lang.Object").getMethod("equals",
//		    new Class[] { Class.forName("java.lang.Object") });
//	    m3 = Class.forName("com.vavi.proxy.Sleepable").getMethod("eat",
//		    new Class[0]);
//	    m0 = Class.forName("java.lang.Object").getMethod("hashCode",
//		    new Class[0]);
//	    m4 = Class.forName("com.vavi.proxy.Sleepable").getMethod("sleep",
//		    new Class[0]);
//	    m2 = Class.forName("java.lang.Object").getMethod("toString",
//		    new Class[0]);
//	    return;
//	} catch (NoSuchMethodException localNoSuchMethodException) {
//	    throw new NoSuchMethodError(localNoSuchMethodException.getMessage());
//	} catch (ClassNotFoundException localClassNotFoundException) {
//	    throw new NoClassDefFoundError(
//		    localClassNotFoundException.getMessage());
//	}
//    }
// }
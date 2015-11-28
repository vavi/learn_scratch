package com.vavi.test;
import java.lang.reflect.*;
public class ProxyPen implements com.vavi.test.Drawable{
	private com.vavi.test.InvocationHandler handler;
	public ProxyPen(com.vavi.test.DrawHandler handler){
		this.handler = handler;
	}

	public void draw() {
		try{ 
		Method md = com.vavi.test.Drawable.class.getMethod("draw");
		handler.invoke( md,new Object[]{});
		}catch(Exception e){e.printStackTrace();}
	}
}

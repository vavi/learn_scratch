package com.vavi.test;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
	Drawable drawable = new Pen();
	InvocationHandler handler = new DrawHandler(drawable);
	Drawable draw = (Drawable) Proxy.newProxy(Drawable.class,handler);
	draw.draw();

	
	Parent p = new Parent();
	p.setName("aa");
	
	Son s = (Son)p;
	
    }
}

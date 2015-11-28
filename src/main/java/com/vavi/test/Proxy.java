package com.vavi.test;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
@SuppressWarnings("restriction")
public class Proxy {

    public static Object newProxy(Class interfaces, InvocationHandler handler)
	    throws Exception {
	String r = "\n";

	Method[] methods = interfaces.getMethods();

	StringBuffer sb = new StringBuffer("");

	for (int i = 0; i < methods.length; i++) {
	    sb.append("	public void " + methods[i].getName() + "() {" + r
		    + "		try{ " + r + "		Method md = " + interfaces.getName()
		    + ".class.getMethod(\"" + methods[i].getName() + "\");" + r
		    + "		handler.invoke( md,new Object[]{});" + r
		    + "		}catch(Exception e){e.printStackTrace();}" + r + "	}"
		    + r);
	}

	String src = "package com.vavi.test;"
		+ r
		+ "import java.lang.reflect.*;"
		+ r
		+ "public class ProxyPen implements "
		+ interfaces.getName()
		+ "{"
		+ r
		+ "	private com.vavi.test.InvocationHandler handler;"
		+ r + "	public ProxyPen(" + handler.getClass().getName()
		+ " handler){" + r + "		this.handler = handler;" + r + "	}" + r
		+ r + sb.toString() + "}" + r;
	String dir = System.getProperty("user.dir")
		+ "/src/main/java/com/vavi/test/";
	FileWriter writer = new FileWriter(new File(dir + "ProxyPen.java"));
	writer.write(src);
	writer.flush();
	writer.close();
	// 编译动态代理类
	JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null,
		null, null);
	Iterable units = fileMgr.getJavaFileObjects(dir + "ProxyPen.java");
	CompilationTask t = compiler.getTask(null, fileMgr, null, null, null,
		units);
	t.call();
	fileMgr.close();
	// 加载并调用返回代理接口
	URL[] urls = new URL[] { new URL("file:/" + dir) };
	URLClassLoader loader = new URLClassLoader(urls);
	Class c = loader.loadClass("com.vavi.test.ProxyPen");

	Constructor ctr = c.getConstructor(handler.getClass());
	return ctr.newInstance(handler);

    }

}

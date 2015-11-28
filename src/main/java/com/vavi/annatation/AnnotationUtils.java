package com.vavi.annatation; 

import java.lang.reflect.Method;

/**
 * 注解工具类
 * @author zyb
 * @since 2012-8-9
 */
public class AnnotationUtils {

	/**
	 * 打印注解信息
	 */
	public static void printAnnotationInfo() throws Exception {
//		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		
		Method[] methods = User.class.getDeclaredMethods();

		for (Method method : methods) {
			
			RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
			
			System.out.println("Methods from super class:");
			
			for (Method annotationMethod : requestMapping.getClass().getMethods()) {
				System.out.println(annotationMethod.getName());
			}
			
			System.out.println("----------------------------------");
			
			System.out.println("super class:" + requestMapping.getClass().getSuperclass().getName());
			
			System.out.print("super interfaces:");
			
			for (Class interfaceClass : requestMapping.getClass().getInterfaces()) {
				System.out.println(interfaceClass.getName());
			}
			
			System.out.println("----------------------------------");
			System.out.println("InvocationHandler:" + requestMapping.getClass());
			
//			System.out.println(requestMapping.getClass().getMethod("getProxyClass", ClassLoader.class, 
//							RequestMapping.class).
//							invoke(requestMapping, 
//							Thread.currentThread().getContextClassLoader(), RequestMapping.class));
			
		}
	}
	
	/**
	 * 把产生代理类的class文件保存到硬盘上
	 */
	public static void saveProxyClassInHardDisk() {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
	}
}


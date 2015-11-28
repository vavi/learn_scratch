//package com.vavi.thread;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//class InterruptRead extends InterruptSupport {
//
//    private FileInputStream in;
//
//    @Override
//    public void bussiness() {
//	File file = new File("/dev/urandom"); // 读取linux黑洞，永远读不完
//	try {
//	    in = new FileInputStream(file);
//	    byte[] bytes = new byte[1024];
//	    while (in.read(bytes, 0, 1024) > 0) {
//		// Thread.sleep(100);
//		// if (Thread.interrupted()) {// 以前的Interrupt检查方式
//		// throw new InterruptedException("");
//		// }
//	    }
//	} catch (Exception e) {
//	    throw new RuntimeException(e);
//	}
//    }
//
//    public FileInputStream getIn() {
//	return in;
//    }
//
//    @Override
//    public void interrupt() {
//	try {
//	    in.getChannel().close();
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
//    }
//
//    public static void main(String args[]) throws Exception {
//	final InterruptRead test = new InterruptRead();
//	Thread t = new Thread() {
//
//	    @Override
//	    public void run() {
//		long start = System.currentTimeMillis();
//		try {
//		    System.out.println("InterruptRead start!");
//		    test.execute();
//		} catch (InterruptedException e) {
//		    System.out.println("InterruptRead end! cost time : "
//			    + (System.currentTimeMillis() - start));
//		    e.printStackTrace();
//		}
//	    }
//	};
//	t.start();
//	// 先让Read执行3秒
//	Thread.sleep(3000);
//	// 发出interrupt中断
//	t.interrupt();
//    }
// }

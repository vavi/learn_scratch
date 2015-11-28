//package com.vavi.thread;
//
//import sun.nio.ch.Interruptible;
//
//interface InterruptAble { // 定义可中断的接口
//
//    public void interrupt() throws InterruptedException;
//}
//
//abstract class InterruptSupport implements InterruptAble {
//
//    private volatile boolean interrupted = false;
//    private final Interruptible interruptor = new Interruptible() {
//
//	public void interrupt() {
//	    interrupted = true;
//	    InterruptSupport.this.interrupt(); // 位置3
//	}
//
//	public void interrupt(Thread arg0) {
//	    // TODO Auto-generated method stub
//
//	}
//    };
//
//    public final boolean execute() throws InterruptedException {
//	try {
//	    blockedOn(interruptor); // 位置1
//	    if (Thread.currentThread().isInterrupted()) { // 立马被interrupted
//		interruptor.interrupt();
//	    }
//	    // 执行业务代码
//	    bussiness();
//	} finally {
//	    blockedOn(null); // 位置2
//	}
//
//	return interrupted;
//    }
//
//    public abstract void bussiness();
//
//    public abstract void interrupt();
//
//    // -- sun.misc.SharedSecrets --
//    static void blockedOn(Interruptible intr) { // package-private
//	sun.misc.SharedSecrets.getJavaLangAccess().blockedOn(
//		Thread.currentThread(), intr);
//    }
// }
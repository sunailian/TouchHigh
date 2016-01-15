/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-13下午10:11:52
 */
public class WaitAndNotify {

	final static Object obj = new Object();

	// T1
	public static class T1 extends Thread {
		public void run() {
			synchronized (obj) {
				System.out.println(System.currentTimeMillis() + "：T1 Started！");
				try {
					System.out.println(System.currentTimeMillis() + "：T1 wait for object !");
					obj.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + "：T1 end ！");
			}
		}
	}

	// T2
	public static class T2 extends Thread {
		public void run() {
			synchronized (obj) {
				System.out.println(System.currentTimeMillis() + "：T2 start,notify one thread ");
				obj.notify();
				System.out.println(System.currentTimeMillis() + "：T2 end ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}

}

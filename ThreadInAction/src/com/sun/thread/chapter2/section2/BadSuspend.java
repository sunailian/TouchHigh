/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午9:21:31
 */
public class BadSuspend {

	public static Object u = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t1");

	public static class ChangeObjectThread extends Thread {
		public ChangeObjectThread(String name) {
			super.setName(name);
		}

		public void run() {
			synchronized (u) {
				System.out.println("in " + getName());
				Thread.currentThread().suspend();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.resume();
		t2.resume();
		t1.join();
		t2.join();
	}

}

/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.locks.LockSupport;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-23下午4:11:28
 */
public class LockSupportDemo {

	public static Object u = new Object();
	static ChangeObjectThread t1 = new ChangeObjectThread("t1");
	static ChangeObjectThread t2 = new ChangeObjectThread("t2");

	public static class ChangeObjectThread extends Thread {

		public ChangeObjectThread(String name) {
			super.setName(name);
		}

		public void run() {
			synchronized (u) {
				System.out.println("in " + getName());
				LockSupport.park();
				if (Thread.interrupted()) {
					System.out.println(getName() + " 被中断了!");
				}
			}
			System.out.println(getName() + " 执行结束");
		}
	}

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		Thread.sleep(1000);
		t2.start();
		t1.interrupt();
		LockSupport.unpark(t2);
	}

}

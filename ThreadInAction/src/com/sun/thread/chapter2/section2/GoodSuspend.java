/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午9:35:49
 */
public class GoodSuspend {

	public static Object u = new Object();

	public static class ChangeObjectThread extends Thread {
		volatile boolean suspendme = false;

		public void suspendMe() {
			suspendme = true;
		}

		public void resumeMe() {
			suspendme = false;
			synchronized (this) {
				this.notify();
			}
		}

		public void run() {
			while (true) {
				synchronized (this) {
					while (suspendme) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}

				synchronized (u) {
					System.out.println("in ChangeObjectThread");
				}
				Thread.yield();
			}
		}
	}

	public static class ReadObjectThread extends Thread {

		public void run() {
			while (true) {
				synchronized (u) {
					System.out.println("in ReadObjectThread");
				}
				Thread.yield();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ChangeObjectThread t1 = new ChangeObjectThread();
		ReadObjectThread t2 = new ReadObjectThread();
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.suspendMe();
		System.out.println("suspend t1 2 sec");
		Thread.sleep(2000);
		System.out.println("resume t1");
		t1.resumeMe();

	}

}

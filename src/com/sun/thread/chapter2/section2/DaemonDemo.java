/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午10:48:26
 */
public class DaemonDemo {

	public static class DeamonT extends Thread {
		public void run() {
			while (true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		DeamonT t = new DeamonT();
		t.setDaemon(true);
		t.start();
		Thread.sleep(2000);
	}

}

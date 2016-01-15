/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午10:19:55
 */
public class JoinMain {

	public volatile static int i = 0;

	public static class AddThread extends Thread {

		public void run() {
			for (i = 0; i < 1000000; i++)
				;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AddThread at = new AddThread();
		at.start();
		at.join();
		System.out.println(i);

	}

}

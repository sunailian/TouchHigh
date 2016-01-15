/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午10:35:13
 */
public class NoVisibility {

	private static boolean ready;
	private static int number;

	public static class ReaderThread extends Thread {
		public void run() {
			while (!ready)
				;
			System.out.println(number);
		}
	}

	/**
	 * @throws InterruptedException
	 * @Description
	 * @author sunhanbin
	 * @date 2016-1-15下午10:35:13
	 * @param args
	 * @throws
	 */
	public static void main(String[] args) throws InterruptedException {
		ReaderThread t = new ReaderThread();
		t.start();
		Thread.sleep(1000);
		number = 42;
		ready = true;
		Thread.sleep(10000);
	}

}

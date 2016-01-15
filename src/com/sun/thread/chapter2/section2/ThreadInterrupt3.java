/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-13下午9:59:02
 */
public class ThreadInterrupt3 {

	/**
	 * @Description
	 * @author sunhanbin
	 * @date 2016-1-13下午9:59:03
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread() {

			public void run() {
				while (true) {
					if (Thread.currentThread().interrupted()) {
						System.out.println("Interrupted");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted When Sleep");
						// 设置中断状态
						Thread.currentThread().interrupt();
					}
				}
			}
		};
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();

	}

}

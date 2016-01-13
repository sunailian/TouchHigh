/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-12-20下午10:50:50
 */
public class CreateThread1 {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Hello!");
			}
		};
		t1.start();
	}

}

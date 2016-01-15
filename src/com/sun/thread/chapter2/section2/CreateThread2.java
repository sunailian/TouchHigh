/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-12-20下午10:57:09
 */
public class CreateThread2 implements Runnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new CreateThread2());
		t1.start();

	}

	@Override
	public void run() {
		System.out.println("use runnable");

	}

}

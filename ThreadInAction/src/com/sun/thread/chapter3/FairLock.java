/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-19下午10:16:25
 */
public class FairLock implements Runnable {

	public static ReentrantLock fairLock = new ReentrantLock(true);// 公平锁

	/**
	 * @Description
	 * @author sunhanbin
	 * @date 2016-1-19下午10:20:51
	 */
	@Override
	public void run() {
		while (true) {
			try {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + " get lock");
			} finally {
				fairLock.unlock();
			}
		}

	}

	public static void main(String[] args) {
		FairLock f1 = new FairLock();
		Thread t1 = new Thread(f1, "Thread_1");
		Thread t2 = new Thread(f1, "Thread_2");
		t1.start();
		t2.start();

	}

}

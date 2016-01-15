/**
 * 
 */
package com.sun.thread.chapter2.section2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-16上午12:01:22
 */
public class ReenterLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 100000; j++) {
			lock.lock();
			lock.lock();
			try {
				i++;
			} finally {
				lock.unlock();
				lock.unlock();
				
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLock r1 = new ReenterLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);

	}

}

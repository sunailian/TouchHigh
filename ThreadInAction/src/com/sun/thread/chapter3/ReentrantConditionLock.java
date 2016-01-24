/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-19下午11:22:37
 */
public class ReentrantConditionLock implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void main(String[] args) throws InterruptedException {
		ReentrantConditionLock tc = new ReentrantConditionLock();
		Thread t1 = new Thread(tc);
		t1.start();
		Thread.sleep(2000);
		// 通知线程1继续执行
		lock.lock();
		condition.signal();
		lock.unlock();
	}

}

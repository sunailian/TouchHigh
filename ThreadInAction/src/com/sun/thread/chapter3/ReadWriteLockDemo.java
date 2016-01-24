/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-20下午9:35:31
 */
public class ReadWriteLockDemo {

	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;

	public Object handleRead(Lock lock) {

		try {
			lock.lock();// 模拟读操作
			Thread.sleep(1000);// 读操作越耗时,读写锁的优势就越明显
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return value;
	}

	public void handleWrite(Lock lock, int index) {
		try {
			lock.lock();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		value = index;
	}

	public static void main(String[] args) {
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunnable = new Runnable() {

			@Override
			public void run() {
				demo.handleRead(readLock);
				// demo.handleRead(lock);
			}
		};

		Runnable writeRunnable = new Runnable() {
			@Override
			public void run() {
				demo.handleWrite(writeLock, new Random().nextInt());
				//demo.handleWrite(lock, new Random().nextInt());
			}
		};

		// 读线程
		for (int i = 0; i < 18; i++) {
			new Thread(readRunnable).start();
		}

		// 写线程
		for (int i = 18; i < 20; i++) {
			new Thread(writeRunnable).start();
		}
	}
}

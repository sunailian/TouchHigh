/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-19下午9:52:26
 */
public class TryLock implements Runnable {

	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;

	public TryLock(int lock) {
		this.lock = lock;
	}

	public void run() {

		if (lock == 1) {

			while (true) {
				try {
					if (lock1.tryLock()) {
						Thread.sleep(500);

						if (lock2.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId() + "My Job is Done！");
								return;
							} finally {
								lock2.unlock();
							}
						}
					}
				} catch (InterruptedException e) {

				} finally {
					lock1.unlock();
				}
			}
		} else {

			while (true) {
				if (lock2.tryLock()) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					if (lock1.tryLock()) {
						try {
							System.out.println(Thread.currentThread().getId() + "My Job is Done！");
							return;
						} finally {
							lock1.unlock();
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		TryLock l1 = new TryLock(1);
		TryLock l2 = new TryLock(2);
		Thread t1 = new Thread(l1);
		Thread t2 = new Thread(l2);
		t1.start();
		t2.start();
	}
}

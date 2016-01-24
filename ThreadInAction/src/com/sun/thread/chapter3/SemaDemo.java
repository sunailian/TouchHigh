/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-20下午9:19:29
 */
public class SemaDemo implements Runnable {

	final Semaphore semp = new Semaphore(5);

	public void run() {

		try {
			semp.acquire();
			// 以下是临界区
			// 模拟耗时操作
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId() + " done");
			semp.release();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(20);
		final SemaDemo demo = new SemaDemo();
		for (int i = 0; i < 20; i++) {
			exec.submit(demo);
		}

	}

}

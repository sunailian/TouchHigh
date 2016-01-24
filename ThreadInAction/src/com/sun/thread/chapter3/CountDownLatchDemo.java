/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-20下午10:09:11
 */
public class CountDownLatchDemo implements Runnable {

	public static final CountDownLatch end = new CountDownLatch(10);
	public static final CountDownLatchDemo demo = new CountDownLatchDemo();

	@Override
	public void run() {
		// 模拟检查任务
		try {
			Thread.sleep(new Random().nextInt(10) * 1000);
			System.out.println("finish check");
			end.countDown();// 该项任务检查完成，计数器减一
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @Description
	 * @author sunhanbin
	 * @date 2016-1-20下午10:09:11
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			exec.submit(demo);
		}
		// 等待检查任务
		end.await();
		// 发射火箭
		System.out.println("Fire");
		exec.shutdown();
	}

}

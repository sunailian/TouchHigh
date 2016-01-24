/**
 * 
 */
package com.sun.thread.chapter3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-24下午9:10:57
 */
public class ScheduledExecutorServiceDemo {

	public static void main(String[] args) {

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
		// 如果前面的任务没有完成，则调度也不会启动
		ses.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Rate==>>"+System.currentTimeMillis() / 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}, 0, 2, TimeUnit.SECONDS);
		
		ses.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					System.out.println("Delay==>>"+System.currentTimeMillis() / 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}, 0, 2, TimeUnit.SECONDS);
	}
}

/**
 * 
 */
package com.sun.thread.chapter2.section2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午11:36:58
 */
public class HashMapMultiThread {

	static Map<String, String> map = new HashMap<String, String>();

	public static class AddThread extends Thread {
		int start = 0;

		public AddThread(int start) {
			this.start = start;
		}

		public void run() {
			for (int i = start; i < 100000; i += 2) {
				map.put(Integer.toString(i), Integer.toBinaryString(i));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {

		AddThread t1 = new AddThread(0);
		AddThread t2 = new AddThread(1);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(map.size());

	}

}

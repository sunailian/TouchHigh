/**
 * 
 */
package com.sun.thread.chapter2.section2;

import java.util.ArrayList;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2016-1-15下午11:26:03
 */
public class ArrayListMultiThread {
	static ArrayList<Integer> al = new ArrayList<Integer>(10);

	public static class AddThread extends Thread {
		public void run() {
			for (int i = 0; i < 1000000; i++) {
				al.add(i);
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		AddThread t1=new AddThread();
		AddThread t2=new AddThread();
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(al.size());

	}

}

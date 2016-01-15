package com.sun.thread.chapter2.section2;

public class PriorityDemo {

	public static class HighPriority extends Thread {
		private int count = 0;

		public void run() {
			while (true) {
				// 加锁竞争资源，使得差异显现的更加明显些
				synchronized (PriorityDemo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("HighPriority finished！");
						break;
					}
				}
			}
		}
	}

	public static class LowPriority extends Thread {
		private int count = 0;

		public void run() {
			while (true) {
				// 加锁竞争资源，使得差异显现的更加明显些
				synchronized (PriorityDemo.class) {
					count++;
					if (count > 100000000) {
						System.out.println("LowPriority finished！");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		HighPriority high = new HighPriority();
		LowPriority low = new LowPriority();
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		low.start();
		high.start();

	}

}

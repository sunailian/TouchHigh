/**
 * 
 */
package com.sun.thread.chapter2.section2;

/**
 * @Package com.guozha.oms.web.controller.user
 * @Description: TODO
 * @author sunhanbin
 * @date 2015-12-20下午11:03:38
 */
public class StopThreadUnsafe {

	public static User u = new User();

	public static class User {
		private int id;
		private String name;

		public User() {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}

	}

	// 修改数据线程
	public static class ChangeObjectThread extends Thread {

		public void run() {
			while (true) {
				synchronized (u) {
					int v = (int) (System.currentTimeMillis() / 1000);
					u.setId(v);
					// do sth else
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}
				Thread.yield();
			}
		}
	}

	// 读线程
	public static class ReadObjectThread extends Thread {

		public void run() {
			while (true) {
				synchronized (u) {
					if (u.getId() != Integer.parseInt(u.getName())) {
						System.out.println(u.toString());
					}
				}
				Thread.yield();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		new ReadObjectThread().start();
		while (true) {
			Thread t = new ChangeObjectThread();
			t.start();
			Thread.sleep(100);
			t.stop();
		}
	}

}

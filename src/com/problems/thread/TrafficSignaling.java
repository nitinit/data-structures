package com.problems.thread;

public class TrafficSignaling {

	public static void main(String[] args) throws InterruptedException {
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();
		Object o4 = new Object();
		Traffic t1 = new Traffic(o1, o2);
		Traffic t2 = new Traffic(o2, o3);
		Traffic t3 = new Traffic(o3, o4);
		Traffic t4 = new Traffic(o4, o1);

		new Thread(t1, "T1").start();
		new Thread(t2, "T2").start();
		new Thread(t3, "T3").start();
		new Thread(t4, "T4").start();
		Thread.sleep(2000);// making sure , notify is called after execution of wait.
		synchronized (o1) {
			o1.notify();
		}
	}

	public static class Traffic implements Runnable {
		public static int trafficLightNumber;
		public Object o1;
		public Object o2;

		public Traffic(Object o1, Object o2) {
			this.o1 = o1;
			this.o2 = o2;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (o1) {
					try {
						o1.wait();

						System.out.println(Thread.currentThread().getName() + "---" + trafficLightNumber++);
						Thread.currentThread().sleep(100);

					} catch (InterruptedException e) {
						e.printStackTrace();
						Thread.currentThread().interrupted();
					}
				}
				synchronized (o2) {
					o2.notify();
				}
			}
		}
	}

}

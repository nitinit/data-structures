package com.problems.thread;

public class TwoThreadsPrintAlternatively {

	public static void main(String[] args) throws InterruptedException {

		Object obj1 = new Object();
		Object obj2 = new Object();
		Thread t1 = new Thread(new PrintRun(obj1, obj2));
		Thread t2 = new Thread(new PrintRun(obj2, obj1));
		t1.start();
		t2.start();

		Thread.sleep(2000);// making sure , notify is called after execution of wait.
		synchronized (obj1) {
			obj1.notify();
		}
		
	}

}

class PrintRun implements Runnable {

	public Object o1;
	public Object o2;

	public PrintRun(Object o1, Object o2) {
		this.o1 = o1;
		this.o2 = o2;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (o1) {
				try {
					o1.wait();

					System.out.print("RAJA ");
					Thread.currentThread().sleep(100);

				} catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupted();
				}
			}
			synchronized (o2) {
				System.out.println("JAIN ");
				o2.notify();
			}
		}
	}

}

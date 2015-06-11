package com.problems.general;

import java.util.concurrent.atomic.AtomicBoolean;

public class TwoThreadsPrintAlternatively {

	public static void main(String[] args) {

		Object obj = new Object();
		Thread t1 = new Thread(new PrintRun(obj));
		Thread t2 = new Thread(new PrintRun(obj));
		t1.start();
		t2.start();
		
	}

}

class PrintRun implements Runnable {

	private Object obj;
	private AtomicBoolean bool;

	public PrintRun(Object obj) {
		this.obj = obj;
		bool = new AtomicBoolean(false);
	}

	@Override
	public void run() {

		while (true) {
			if (bool.get()) {

				synchronized (obj) {
					System.out.print("RAJA");
					bool.set(false);

				}
			} else {
				synchronized (obj) {
					System.out.println("JAIN\n");
					bool.set(true);

				}
			}

		}
	}

}

package com.problems.general;

/**
 * Created by raja on 07/10/15.
 */
public class NamePrint {

    Object lock = new Object();
    volatile boolean isFirstNamePrinted = false;

    public static void main(String a[]) {
        NamePrint obj = new NamePrint();
        obj.printNameUsingMultipleThreads();
    }

    public void printNameUsingMultipleThreads() {
        Runnable printFirstName = new PrintFirstName();
        Runnable printLastName = new PrintLastName();

        Thread firstThread = new Thread(printFirstName);
        Thread secondThread = new Thread(printLastName);

        firstThread.start();
        secondThread.start();
    }

    class PrintFirstName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while(true) {
                    try {
                        // wait if first name is printed but not the last name
                        if (isFirstNamePrinted) lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Ram ");
                    isFirstNamePrinted = true;
                    lock.notify();
                }
            }
        }
    }

    class PrintLastName implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while(true) {
                    try {
                        // wait if first name is not printed
                        if (!isFirstNamePrinted) lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Swaroop");
                    isFirstNamePrinted = false;
                    lock.notify();
                }
            }
        }
    }
}

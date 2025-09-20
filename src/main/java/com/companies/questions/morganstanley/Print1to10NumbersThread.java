package com.companies.questions.morganstanley;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print1to10NumbersThread {

    private static final int MAX = 10;
    private int counter = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Print1to10NumbersThread printer = new Print1to10NumbersThread();

        Runnable printTask = () -> {
            while (true) {
                printer.printNumber();
            }
        };

        Thread t1 = new Thread(printTask, "T1");
        Thread t2 = new Thread(printTask, "T2");
        Thread t3 = new Thread(printTask, "T3");
        Thread t4 = new Thread(printTask, "T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public void printNumber() {
        lock.lock();
        try {
            if (counter > MAX) return;

            System.out.println(Thread.currentThread().getName() + " => " + counter++);
            condition.signalAll(); // wake other thread(s)

            // Only wait if more numbers are left
            if (counter <= MAX) {
                condition.await();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}

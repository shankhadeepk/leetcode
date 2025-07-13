package com.simple.morganstanley;

public class ThreadPrint1to10 {
    private static final int MAX = 10;
    private int number = 1;

    public synchronized void printNumbers() {
        while (number <= MAX) {
            System.out.println(Thread.currentThread().getName() + " -> " + number++);
            try {
                notify(); // wake up other thread
                if (number <= MAX) wait(); // wait for next turn
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ThreadPrint1to10 printer = new ThreadPrint1to10();

        Runnable task = () -> printer.printNumbers();

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

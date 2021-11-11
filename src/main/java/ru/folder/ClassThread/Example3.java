package ru.folder.ClassThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Example3 {
    private static int a = 0;
    private static Semaphore semaphore = new Semaphore(1);
    private static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                if (a % 2 == 0) {
                    System.out.println(a);
                }
                reentrantLock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                reentrantLock.lock();
                a++;
                reentrantLock.unlock();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

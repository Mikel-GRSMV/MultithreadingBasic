package ru.folder.ClassThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Example4 {
    private static volatile int a = 0;
    private static AtomicInteger b = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            IntStream.range(0, 10).forEach((i) -> b.incrementAndGet());
        });
        Thread thread2 = new Thread(() -> {
            IntStream.range(0, 10).forEach((i) -> b.decrementAndGet());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(b.intValue());
    }
}

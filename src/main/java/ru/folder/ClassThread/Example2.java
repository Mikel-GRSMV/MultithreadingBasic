package ru.folder.ClassThread;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example2 {
    private static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (Example2.class) {
                IntStream.range(0, 10).forEach(i -> System.out.println(a++));
                System.out.println(Thread.currentThread().getName()+" - is end");
            }
        });
        Thread thread2 = new Thread(()->{
            synchronized (Example2.class) {
                IntStream.range(0, 10).forEach(i -> System.out.println(a--));
                System.out.println(Thread.currentThread().getName()+" - is end");
            }
        });

        thread1.start();
        thread2.start();


    }
}

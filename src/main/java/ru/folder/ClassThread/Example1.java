package ru.folder.ClassThread;

public class Example1 {
    private static int a = 2;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                if (a % 2 == 0) {
                    System.out.println(a);
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
                a++;
            }
        });

        System.out.println("Name main thread: " + Thread.currentThread().getName());
        Thread.sleep(5000);

        thread.start();
        thread1.start();
    }
}

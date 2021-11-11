package ru.folder.InterfaceRunnable;

public class HelloMultithreadingRunnable {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, Multithreading!");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}

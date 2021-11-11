package ru.folder.ClassThread;

public class HelloMultithreadingThread {

    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello, Multithreading!");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
    }
}

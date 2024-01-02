package com.sb.learning.threading.simple;

public class UseThreadImplClass {
    public static void main(String[] args){
        System.out.println("Sample to create threads using our custom class");
        System.out.println("Main: " + Thread.currentThread().getId() + ": " + Thread.currentThread().getName());

        int threadCount = 10;

        for (int i = 0; i < threadCount; i++){
            Thread thread = new ThreadImpl();
            thread.setDaemon(true);
            thread.start();
        }

        System.out.println(Thread.currentThread().getId() + " exiting !!");
    }
}

package com.sb.learning.threading.simple;

public class UseRunnableImplClass {
    public static void main (String[] args){
        System.out.println("Sample to create threads using Runnable implementation");

        int threadCount = 10;

        for (int i = 0 ; i < threadCount; i++){
            Thread thread = new Thread(new RunnableImpl());
            thread.start();
        }

        System.out.println(Thread.currentThread().getId() + " exiting !!");
    }
}

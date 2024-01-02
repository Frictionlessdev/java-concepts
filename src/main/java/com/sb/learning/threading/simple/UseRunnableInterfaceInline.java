package com.sb.learning.threading.simple;

public class UseRunnableInterfaceInline {

    public static void main (String[] args){
        System.out.println("Sample to create thread using Runnable");
        System.out.println("Refer ./readme.md");

        int threadCount = 10;

        for (int i = 0 ; i < threadCount; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + ": " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getId() + ": " + Thread.currentThread().getName() + "-> Waking up !" );
                }
            });

            thread.start();
        }

        System.out.println(Thread.currentThread().getId() + " exiting !!");
    }
}

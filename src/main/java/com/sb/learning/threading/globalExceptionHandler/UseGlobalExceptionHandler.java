package com.sb.learning.threading.globalExceptionHandler;

import java.util.concurrent.CountDownLatch;

public class UseGlobalExceptionHandler {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sample to show Global exception handling in multithreading");

        int threadCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getId() + " created");

                    int a = 1/0; //generating exception

                    countDownLatch.countDown(); //latch will not be executed so need to do in exception handler
                }
            });

            thread.setUncaughtExceptionHandler((t, exception) -> {
                System.out.println("Thread " + t + " raised " + exception.getMessage());
                countDownLatch.countDown();
            });

            thread.start();
        }

        countDownLatch.await();
    }
}

package com.sb.learning.threading.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class UseThreadLocalClass {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sample to show how to use ThreadLocal");

        int threadCount = 10;
        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(threadGroup, new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread " + Thread.currentThread().getId() + " created");
                    ThreadLocalUserContext.set(String.valueOf(Thread.currentThread().getId()),
                            "User-" + Thread.currentThread().getId());

                    System.out.println(ThreadLocalUserContext.get());
                    countDownLatch.countDown();
                }
            });

            thread.start();
        }

        countDownLatch.await(5000, TimeUnit.SECONDS);
    }
}

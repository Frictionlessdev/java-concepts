package com.sb.learning.threading.simple;

public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ": " +
                Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getId() + ": " +
                Thread.currentThread().getName() + "-> Waking up !" );
    }
}

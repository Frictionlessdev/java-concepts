package com.sb.learning.classLoader;

public class SimpleDynamicPlugin implements Runnable {
    public void run() {
        System.out.println("This class has been dynamically loaded");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
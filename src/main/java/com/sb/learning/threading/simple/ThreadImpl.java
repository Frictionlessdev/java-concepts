package com.sb.learning.threading.simple;

public class ThreadImpl extends Thread{
    @Override
    public void run(){
        System.out.println(this.getId() + ": " + this.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getId() + ": " + this.getName() + "-> Waking up !" );
    }
}

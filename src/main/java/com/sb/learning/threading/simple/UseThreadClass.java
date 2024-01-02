package com.sb.learning.threading.simple;

public class UseThreadClass {
    public static void main(String[] args){
        System.out.println("Sample to create simple threads");

        int threadCount = 10;
        for (int i = 0; i < threadCount; i++){
            Thread thread = new Thread();
            thread.start();

            System.out.println(thread.getId() + ": " + thread.getName());
        }
    }
}

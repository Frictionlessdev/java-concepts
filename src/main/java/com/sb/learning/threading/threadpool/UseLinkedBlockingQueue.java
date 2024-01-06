package com.sb.learning.threading.threadpool;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class UseLinkedBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Sample to show executor service");

        LinkedBlockingQueue<Task> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Producer Thread: " + Thread.currentThread().getId());
                int count = 1;
                while (!Thread.currentThread().isInterrupted()) {

                        System.out.println("Queuing task id: " + count);
                        linkedBlockingQueue.offer(new Task(String.valueOf(count)));

                        System.out.println("PRODUCER UNBLOCKED size: " + linkedBlockingQueue.size());
                        count++;

                }
            }
        });

        producer.start();

        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNext()){
            //Main thread waiting for program exit;
        }

        producer.interrupt();
        producer.join(10000);
    }

    public static class Task implements Runnable {
        public final String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Executing task: " + this.name);
        }
    }
}

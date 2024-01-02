# ThreadLocal API in Java

## Overview

The `ThreadLocal` class in Java provides a way to create thread-local variables. A thread-local variable is a variable whose value is thread-specific, allowing each thread to have its own copy of the variable without interfering with other threads.

## Key Methods

### `set(T value)`

Sets the current thread's copy of the thread-local variable to the specified value.

```java
ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();
threadLocalVariable.set("Thread-specific value");

```

## Example

```java
public class ThreadLocalExample {
    // Create a ThreadLocal variable
    private static final ThreadLocal<String> threadLocalVariable = new ThreadLocal<>();

    public static void main(String[] args) {
        // Set thread-local variable for the main thread
        threadLocalVariable.set("Main Thread Value");

        // Create and start a new thread
        Thread newThread = new Thread(() -> {
            // Each thread has its own copy of the thread-local variable
            threadLocalVariable.set("New Thread Value");

            // Access the thread-local variable
            String threadValue = threadLocalVariable.get();
            System.out.println("Thread Value: " + threadValue);
        });

        newThread.start();
        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Access the thread-local variable in the main thread
        String mainThreadValue = threadLocalVariable.get();
        System.out.println("Main Thread Value: " + mainThreadValue);
    }
}

# Tuning Thread Pool

The optimum size of the thread pool depends on the number of processors available and the nature of the tasks. On a N processor system for a queue of only computation type processes, a maximum thread pool size of N or N+1 will achieve the maximum efficiency.But tasks may wait for I/O and in such a case we take into account the ratio of waiting time(W) and service time(S) for a request; resulting in a maximum pool size of N*(1+ W/S) for maximum efficiency.

# LinkedBlockingQueue

The `LinkedBlockingQueue` is a thread-safe implementation of the `BlockingQueue` interface in Java. It is backed by a linked node structure and is designed for scenarios where producers and consumers share data in a multithreaded environment.

## Overview

- **Blocking Behavior:**
    - `LinkedBlockingQueue` supports blocking methods for both adding and removing elements, making it suitable for scenarios where synchronization is necessary.

- **FIFO Order:**
    - Elements are stored in a FIFO (First-In-First-Out) order. The order in which elements are added to the queue is the order in which they will be removed.

- **Bounded or Unbounded:**
    - The queue can be created with a specified capacity (bounded) or without a capacity limit (unbounded). In a bounded queue, attempts to add elements beyond the capacity will block.

- **Use Cases:**
    - Commonly used in producer-consumer scenarios where multiple threads are involved in producing and consuming data.

## Usage

### Creating a LinkedBlockingQueue

```java
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Example {
    public static void main(String[] args) {
        // Creating an unbounded LinkedBlockingQueue
        BlockingQueue<String> unboundedQueue = new LinkedBlockingQueue<>();

        // Creating a bounded LinkedBlockingQueue with a capacity of 10
        BlockingQueue<Integer> boundedQueue = new LinkedBlockingQueue<>(10);
    }
}
```

### Adding Elements (Blocking)

```java
BlockingQueue<String> queue = new LinkedBlockingQueue<>();

try {
    queue.put("Element");
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

### Removing Elements (Blocking)

```java
BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

try {
    Integer element = queue.take();
} catch (InterruptedException e) {
    e.printStackTrace();
}
```

## Additional Methods

- **offer(E e)**
    - Adds the specified element to the queue if it is possible to do so immediately without violating capacity restrictions
- **poll()**
    - Retrieves and removes the head of the queue, or returns null if the queue is empty.
- **peek()**
    - Retrieves, but does not remove, the head of the queue, or returns null if the queue is empty.
- **size()**
    - Returns the number of elements in the queue.


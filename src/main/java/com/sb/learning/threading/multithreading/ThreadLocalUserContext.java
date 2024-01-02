package com.sb.learning.threading.multithreading;

public class ThreadLocalUserContext {
    static ThreadLocal<UserContext> threadLocal = new ThreadLocal<>();

    public static void set(String userId, String username) {
        threadLocal.set(new UserContext(userId, username));
    }

    public static UserContext get(){
        return threadLocal.get();
    }
}

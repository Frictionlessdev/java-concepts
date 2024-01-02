package com.sb.learning.threading.multithreading;

public class UserContext {
    private final String id;
    private final String name;

    public UserContext(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.id + ": " + this.name;
    }
}

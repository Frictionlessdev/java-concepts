package com.sb.learning.classLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UseDynamicClassLoader {

    public static void main(String[] args) throws IOException {
        System.out.println("This sample illustrates dynamic class loading in Java");

        String absolutePath = "/Users/rushil/dev/learning/multiThreading/src/main/resources/classes/SimpleDynamicPlugin.class";

        try {
            System.out.println(System.getProperty("user.dir"));

            // Read the bytes of the class file
            byte[] classBytes = Files.readAllBytes(Paths.get(absolutePath));

            // Define a custom class loader
            CustomClassLoader customClassLoader = new CustomClassLoader();

            // Load the class using the custom class loader
            Class<?> dynamicClass = customClassLoader.
                    defineClass("com.sb.learning.classLoader.SimpleDynamicPlugin", classBytes);

            // Create an instance and start a thread
            Thread thread = new Thread((Runnable) dynamicClass.getDeclaredConstructor().newInstance());
            thread.start();

            System.out.println("Context Class Loader: " + thread.getContextClassLoader());

            // Wait for the thread to finish
            thread.join();
        } catch (IOException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // CustomClassLoader to load classes from byte arrays
    static class CustomClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }
}

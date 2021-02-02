package com.example.demo.day.day05;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-02 16:05
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static synchronized void method() {

    }
}

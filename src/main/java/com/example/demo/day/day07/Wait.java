package com.example.demo.day.day07;

import java.util.Date;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 11:01
 */
public class Wait {
    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(new Date() + " Thread1 is running");
                    Wait.class.wait();
                    System.out.println(new Date() + " Thread1 ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread( () -> {
            synchronized (Wait.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Wait.class.notify();
                    // Don't use sleep method to avoid confusing
                    for(long i = 0; i < 200000; i++) {
                        for(long j = 0; j < 100000; j++) {}
                    }
                    System.out.println(new Date() + " Thread2 release lock");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            for(long i = 0; i < 200000; i++) {
                for(long j = 0; j < 100000; j++) {}
            }
            System.out.println(new Date() + " Thread2 ended");
        });

        // Don't use sleep method to avoid confusing
        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }
        thread2.start();
    }
}

package com.example.demo.day.day07;

import java.util.Date;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 11:21
 */
public class Sleep {
    public static void main(String[] args) {
        Thread thread1 = new Thread( () -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(new Date() + " Thread1 is running");
                    Thread.sleep(2000);
                    System.out.println(new Date() + " Thread1 ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread( () -> {
            synchronized (Sleep.class) {
                try {
                    System.out.println(new Date() + " Thread2 is running");
                    Thread.sleep(2000);
                    System.out.println(new Date() + " Thread2 ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(long i = 0; i < 200000; i++) {
                for(long j = 0; j < 100000; j++) {}
            }
            System.out.println(new Date() + " Thread2 loop ended");
        });

        for(long i = 0; i < 200000; i++) {
            for(long j = 0; j < 100000; j++) {}
        }
        System.out.println("auto loop ended");

        thread2.start();
    }
}

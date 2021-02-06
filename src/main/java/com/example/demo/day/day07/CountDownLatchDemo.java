package com.example.demo.day.day07;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 22:29
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for (int i = 0; i < totalThread; i++) {
            final String threadName = "Thread " + i;
            new Thread( () -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                try {
                    if (threadName.equals("Thread 1")) {
                        Thread.sleep(2000);
                    } else {
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
                countDown.countDown();
            }).start();
        }
        countDown.await();
        System.out.println(String.format("%s\t%s %s", new Date(), Thread.currentThread().getName(), "all ended"));
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }
}

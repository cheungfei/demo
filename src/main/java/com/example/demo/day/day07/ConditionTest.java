package com.example.demo.day.day07;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 21:44
 */
public class ConditionTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread( () -> {
            lock.lock();
            try {
                System.out.println(new Date() + "\tThread 1 is waiting");
                try {
                    long waitTime = condition.awaitNanos(TimeUnit.SECONDS.toNanos(2));
                    System.out.println(new Date() + "\tThread 1 remaining time " + waitTime);
                } catch (InterruptedException e) {
                    System.out.println(new Date() + "\tThread 1 is interrupted");
                    e.printStackTrace();
                }
                System.out.println(new Date() + "\tThread 1 is waken up");
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread( () -> {
            lock.lock();
            try {
                System.out.println(new Date() + "\tThread 2 is running");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition.signal();
                System.out.println(new Date() + "\tThread 2 ended");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}

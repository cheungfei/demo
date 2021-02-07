package com.example.demo.day.day07;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 11:53
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        new Thread( () -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(new Date() + "\tThread 1 started with read lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "\tThread 1 ended");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();

        new Thread( () -> {
            readWriteLock.readLock().lock();
            try {
                System.out.println(new Date() + "\tThread 2 started with read lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "\tThread 2 ended");
            } finally {
                readWriteLock.readLock().unlock();
            }
        }).start();

        new Thread( () -> {
            Lock lock = readWriteLock.writeLock();
            lock.lock();
            try {
                System.out.println(new Date() + "\tThread 3 started with write lock");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date() + "\tThread 3 ended");
            } finally {
                lock.unlock();
            }
        }).start();
    }
}

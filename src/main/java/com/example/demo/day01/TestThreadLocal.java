package com.example.demo.day01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 15:58
 */
public class TestThreadLocal {
    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(nextId::getAndIncrement);

    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) {
        System.out.println(TestThreadLocal.get());

        new Thread(()->{
            System.out.println(TestThreadLocal.get());}
        ).start();   // 1

        new Thread(()->{
            System.out.println(TestThreadLocal.get());   // 0
            try {
                Thread.sleep(1000);
                System.out.println(TestThreadLocal.get());   // 0
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            System.out.println(TestThreadLocal.get());}
        ).start();   // 1

        new Thread(()->{
            System.out.println(TestThreadLocal.get());}
        ).start();   // 1
    }
}

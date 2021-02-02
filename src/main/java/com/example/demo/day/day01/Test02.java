package com.example.demo.day.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 16:59
 */
public class Test02 {
    // 类锁A
    public synchronized static void classLockA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    // 类锁B
    public synchronized static void classLockB() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");
    }

    // 对象锁
    public synchronized void objectLock() {
        System.out.println("name = " + Thread.currentThread().getName() + ", begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end");

    }

    public static void main(String[] args) {
//        Test02 test02 = new Test02();
//        ThreadA ta = new ThreadA(test02);
//        ThreadB tb = new ThreadB(test02);
//        ThreadC tc = new ThreadC(test02);
//
//        ta.setName("A");
//        tb.setName("B");
//        tc.setName("C");
//
//        ta.start();
//        tb.start();
//        tc.start();


//        Test02 test02 = new Test02();
//        Test02 test03 = new Test02();
//        ThreadA ta = new ThreadA(test02);
//        ThreadB tb = new ThreadB(test03);
//
//        ta.setName("A");
//        tb.setName("B");
//
//        ta.start();
//        tb.start();
    }
}

// synchronized对象锁和类锁
// https://www.tuicool.com/articles/JfuqqyJ


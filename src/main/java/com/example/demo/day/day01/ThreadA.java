package com.example.demo.day.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 16:59
 */
public class ThreadA extends Thread {
    private Test02 test02;

    public ThreadA(Test02 tk) {
        test02 = tk;
    }

    // 调用类锁
    @Override
    public void run() {
        test02.classLockA();
    }
}

package com.example.demo.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 17:00
 */
public class ThreadB extends Thread {
    private Test02 test02;

    public ThreadB(Test02 tk) {
        test02 = tk;
    }

    // 调用类锁
    @Override
    public void run() {
        test02.classLockB();
    }
}

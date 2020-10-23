package com.example.demo.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 17:01
 */
public class ThreadC extends Thread {
    private Test02 test02;

    public ThreadC(Test02 tk) {
        test02 = tk;
    }

    // 调用对象锁
    @Override
    public void run() {
        test02.objectLock();
    }
}

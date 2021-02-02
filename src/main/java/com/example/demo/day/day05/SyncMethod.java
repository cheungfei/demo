package com.example.demo.day.day05;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-02 16:18
 */
public class SyncMethod {
    public int i;
    public synchronized void syncTask() {
        i++;
    }
}

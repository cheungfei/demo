package com.example.demo.day.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 14:16
 */
interface IMessage extends AutoCloseable {
    /**
     * 消息发送
     */
    public void send();
}

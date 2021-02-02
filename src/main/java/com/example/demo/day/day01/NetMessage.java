package com.example.demo.day.day01;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 14:18
 */
public class NetMessage implements IMessage {
    private String msg;

    public NetMessage(String msg) {
        this.msg = msg;
    }

    @Override
    public void send() {
        if (this.open()) {
            System.out.println("【**发送消息**】" + this.msg);
        }
    }

    //获取资源连接
    public boolean open() {
        System.out.println("【OPEN】获取资源发送连接资源");
        return true;
    }

    @Override
    public void close() throws Exception {
        System.out.println("【CLOSE】关闭消息发送通道");
    }

    public static void main(String[] args) {
        try (IMessage message = new NetMessage("Hello World")) {
            message.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

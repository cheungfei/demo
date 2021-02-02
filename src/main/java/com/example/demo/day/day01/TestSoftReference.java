package com.example.demo.day.day01;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 14:50
 */
public class TestSoftReference {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        // m强引用指向softReference, softReference软指向byte[]
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10], queue);
        // 打印结果:[B@1e643faf
        System.out.println(m.get());
        System.gc();
        Thread.sleep(1000);
        // 打印结果:[B@1e643faf 表示没有被垃圾回收
        System.out.println(m.get());
        // 给出一个强引用
        byte[] bytes = new byte[1024 * 1024 * 15];
        // 不规定最大堆内存大小时，打印结果:[B@1e643faf
        // 指定最大堆内存-Xmx20M时，打印输出null
        System.out.println(m.get());
        //打印结果:java.lang.ref.SoftReference@6e8dacdf
        System.out.println(queue.poll());
    }
}

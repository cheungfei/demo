package com.example.demo.day.day01;

import java.lang.ref.WeakReference;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 15:04
 */
public class TestWeakReference {
    public static void main(String[] args) {
        WeakReference<byte[]> m = new WeakReference<>(new byte[1024*1024*10]);
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
    }
}

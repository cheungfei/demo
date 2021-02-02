package com.example.demo.day.day03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-28 11:33
 */
public class AcquireResultTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //getNow方法测试
        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(60 * 1000 * 60 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "hello world";
        });

        System.out.println(cp1.getNow("hello h2t"));

        //join方法测试
        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp2.join());

        //get方法测试
        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp3.get());
    }
}

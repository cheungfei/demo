package com.example.demo.controller;

import com.example.demo.config.RedisLockConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-10-23 17:21
 */
@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    private int num = 20;

    /**
     * 测试redis分布式锁(没有锁)
     */
    @GetMapping("testUnLock")
    public void testUnLock() throws InterruptedException {
        String s = Thread.currentThread().getName();
        if (num > 0) {
            System.out.println(s + "排号成功，号码是：" + num);
            num--;
        } else {
            System.out.println(s + "排号失败,号码已经被抢光");
        }
    }

    /**
     * 测试redis分布式锁(有锁)
     */
    @GetMapping("testLock")
    public void testLock() throws InterruptedException {
        Lock lock = redisLockRegistry.obtain("lock");
        boolean isLock = lock.tryLock(1, TimeUnit.SECONDS);
        String s = Thread.currentThread().getName();
        if (num > 0 && isLock) {
            System.out.println(s + "排号成功，号码是：" + num);
            num--;
        } else {
            System.out.println(s + "排号失败,号码已经被抢光");
        }
        lock.unlock();
    }
}

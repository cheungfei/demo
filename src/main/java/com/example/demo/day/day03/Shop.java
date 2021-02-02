package com.example.demo.day.day03;

import java.util.Random;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-28 11:24
 */
public class Shop {
    public String name;
    public String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private final Random random = new Random();

    public Shop(String price) {
        this.price = price;
    }

    /**
     * 根据产品名查找价格
     * */
    public double getPrice(String product) {
        return calculatePrice(product);
    }

    /**
     * 计算价格
     *
     * @param product
     * @return
     * */
    private double calculatePrice(String product) {
        delay();
        //random.nextDouble()随机返回折扣
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    /**
     * 通过睡眠模拟其他耗时操作
     * */
    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

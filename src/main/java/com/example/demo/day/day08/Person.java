package com.example.demo.day.day08;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-07 14:28
 */
public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}

package com.example.demo.basic.generic;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-24 10:41
 */
@Data
@NoArgsConstructor
public class A<T> {
    private T value;
    public A(T value) {
        this.value = value;
    }
}

package com.example.demo.day.day07;

import java.util.Locale;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-06 8:15
 */
@Component(identifier = "upper")
public class UpperCaseComponent {
    public String doWork(String input) {
        if (input != null) {
            return input.toUpperCase(Locale.ROOT);
        } else {
            return null;
        }
    }
}
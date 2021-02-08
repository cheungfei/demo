package com.example.demo.day.day08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-07 9:40
 */
public class Stream01 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        // 创建流
        // 执行过滤，过滤出以 c 为前缀的字符串
        // 转换成大写
        // 排序
        // for 循环打印
        myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

        // 创建流
        // 找到第一个元素
        // 如果存在，即输出
        Arrays.asList("a1", "a2", "a3").stream().findFirst().ifPresent(System.out::println);
        Stream.of("a3", "a2", "a1").findFirst().ifPresent(System.out::println);
        Stream.empty().findFirst().ifPresent(System.out::println);
        Stream.of("a3", "a2", "a1").findAny().ifPresent(System.out::println);

        // 相当于 for (int i = 1; i < 4; i++) {}
        IntStream.range(1, 4).forEach(System.out::println);

        // 对数值中的每个对象执行 2 * n + 1 操作
        // 求平均值
        // 如果值不为空，则输出
        Arrays.stream(new int[] {1, 2, 3}).map(n -> 2 * n + 1).average().ifPresent(System.out::println);
        IntStream.of(1, 2, 3).map(n -> 2 * n + 1).average().ifPresent(System.out::println);

        // 对每个字符串元素从下标1位置开始截取
        // 转成 int 基础类型类型流
        // 取最大值
        // 不为空则输出
        Stream.of("a1", "a2", "a3").map(s -> s.substring(1)).mapToInt(Integer::parseInt).max().ifPresent(System.out::println);

        // for 循环 1->4, 拼接前缀 a
        // for 循环打印
        IntStream.range(1, 4).mapToObj(i -> "a" + i).forEach(System.out::println);

        // double 类型转 int
        // 对值拼接前缀 a
        // for 循环打印
        Stream.of(1.0, 2.0, 3.0).mapToInt(Double::intValue).mapToObj(i -> "a" + i).forEach(System.out::println);
    }
}

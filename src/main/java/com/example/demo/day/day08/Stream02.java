package com.example.demo.day.day08;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-07 13:44
 */
public class Stream02 {
    public static void main(String[] args) {
//        Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
//            System.out.println("filter: " + s);
//            return true;
//        });

//        Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> {
//            System.out.println("filter: " + s);
//            return true;
//        }).forEach(s -> System.out.println("forEach: " + s));

//        Stream.of("d2", "a2", "b1", "b3", "c")
//            .map(s -> {
//                System.out.println("map: " + s);
//                return s.toUpperCase(); // 转大写
//            })
//            .anyMatch(s -> {
//                System.out.println("anyMatch: " + s);
//                return s.startsWith("A"); // 过滤出以 A 为前缀的元素
//            });

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase(); // 转大写
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("A"); // 过滤出以 A 为前缀的元素
//                })
//                .forEach(s -> System.out.println("forEach: " + s)); // for 循环输出

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a"); // 过滤出以 a 为前缀的元素
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase(); // 转大写
//                })
//                .forEach(s -> System.out.println("forEach: " + s)); // for 循环输出

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2); // 排序
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a"); // 过滤出以 a 为前缀的元素
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase(); // 转大写
//                })
//                .forEach(s -> System.out.println("forEach: " + s)); // for 循环输出

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2); // 排序
//                })
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a"); // 过滤出以 a 为前缀的元素
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase(); // 转大写
//                })
//                .forEach(s -> System.out.println("forEach: " + s)); // for 循环输出

//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    System.out.println("filter: " + s);
//                    return s.startsWith("a");
//                })
//                .sorted((s1, s2) -> {
//                    System.out.printf("sort: %s; %s\n", s1, s2);
//                    return s1.compareTo(s2);
//                })
//                .map(s -> {
//                    System.out.println("map: " + s);
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));

        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);    // ok
//        stream.noneMatch(s -> true);   // exception

        Supplier<Stream<String>> streamSupplier = () -> Stream.of("d2", "a2", "b1", "b3", "c").filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);


    }
}

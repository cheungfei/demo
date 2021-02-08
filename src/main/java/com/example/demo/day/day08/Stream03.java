package com.example.demo.day.day08;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-07 14:29
 */
public class Stream03 {
    public static void main(String[] args) {
        // 构建一个 Person 集合
        List<Person> persons = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 23),
                new Person("David", 12));

//        List<Person> filtered = persons
//                        .stream() // 构建流
//                        .filter(p -> p.name.startsWith("P")) // 过滤出名字以 P 开头的
//                        .collect(Collectors.toList()); // 生成一个新的 List
//        System.out.println(filtered);    // [Peter, Pamela]

//        // 以年龄为 key,进行分组
//        Map<Integer, List<Person>> personsByAge = persons.stream().collect(Collectors.groupingBy(p -> p.age));
//        personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

//        // 聚合出平均年龄
//        Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
//        // 19.0
//        System.out.println(averageAge);

//        // 生成摘要统计
//        IntSummaryStatistics ageSummary = persons.stream().collect(Collectors.summarizingInt(p -> p.age));
//        // IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}
//        System.out.println(ageSummary);

//        // 过滤出年龄大于等于18的
//        // 提取名字
//        // 以 In Germany 开头，and 连接各元素，再以 are of legal age. 结束
//        String phrase = persons
//                .stream()
//                .filter(p -> p.age >= 18)
//                .map(p -> p.name)
//                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
//        // In Germany Max and Peter and Pamela are of legal age.
//        System.out.println(phrase);

//        // 对于同样 key 的，将值拼接
//        Map<Integer, String> map = persons
//                .stream()
//                .collect(Collectors.toMap(
//                        p -> p.age,
//                        p -> p.name,
//                        (name1, name2) -> name1 + ";" + name2));
//        // {18=Max, 23=Peter;Pamela, 12=David}
//        System.out.println(map);

        // supplier 供应器
        // accumulator 累加器
        // combiner 组合器
        // finisher 终止器
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(
                () -> new StringJoiner(" | "),
                (j, p) -> j.add(p.name.toUpperCase()),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString);
        // 传入自定义的收集器
        String names = persons.stream().collect(personNameCollector);
        // MAX | PETER | PAMELA | DAVID
        System.out.println(names);


    }
}

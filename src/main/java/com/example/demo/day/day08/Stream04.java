package com.example.demo.day.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-02-07 16:08
 */
public class Stream04 {
    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        // 创建 foos 集合
        IntStream.range(1, 4).forEach(i -> foos.add(new Foo("Foo" + i)));

        // 创建 bars 集合
        foos.forEach(f -> IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));


    }
}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}

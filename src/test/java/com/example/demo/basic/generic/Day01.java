package com.example.demo.basic.generic;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-24 10:32
 */
public class Day01 {
    public static void main(String[] args) {
//        Integer[] integers = new Integer[1];
//        Object[] objects = integers;
//        objects[0] = "xxx";
//        System.out.println(objects);

//        A<String>[] arr = new A<String>[1]; // 编译错误
//        Object[] objArr = arr;
//        objArr[0] = new A<Integer>();
//        System.out.println(new A<String>().getClass() == new A<Integer>().getClass());

        A<String>[] arr = (A<String>[]) new A[1];
        Object[] objArr = arr;
        objArr[0] = new A<Integer>(1);
        A<String> a = arr[0];
        String s = a.getValue();

    }
}

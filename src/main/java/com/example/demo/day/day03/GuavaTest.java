package com.example.demo.day.day03;


import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Collections2;
import com.sun.istack.internal.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2021-01-28 18:21
 */
public class GuavaTest {
    private static final Logger logger = LoggerFactory.getLogger(GuavaTest.class);

    /**
     * 连接器
     */
    private static final Joiner joiner = Joiner.on(",").skipNulls();
    /**
     * 分割器
     */
    private static final Splitter splitter = Splitter.on(",").trimResults().omitEmptyStrings();

    public static void main(String[] args) {
//        logger.info("测试joiner方法");
//        String join = joiner.join(Lists.newArrayList("a",null,"b"));
//        System.out.println(join);
//
//        logger.info("测试splitter方法");
//        String string = "111, ,222,,33";
//        for (String s : splitter.split(string)) {
//            System.out.println(s);
//        }

//        //快速创建集合
//        List<Integer> list = Ints.asList(1,2,3,4);
//        System.out.println(Ints.join(",",1,2,3));
//        //数组合并
//        int[] newArray = Ints.concat(new int[]{1,2},new int[]{3,4});
//        System.out.println(newArray.length);
//        //选出最大最小
//        System.out.println(Ints.max(newArray)+","+Ints.min(newArray));
//        System.out.println(Ints.contains(newArray,3));
//        //集合转成数组
//        int[] ints = Ints.toArray(list);
//        System.out.println("打印数组元素：" + Arrays.toString(ints));


//        Multiset<Integer> multiset = HashMultiset.create();
//        multiset.add(1);
//        multiset.add(2);
//        multiset.add(3);
//        multiset.add(3);
//        //计算元素个数
//        //2
//        System.out.println(multiset.count(3));

//        Multimap<String, String> multimap = ArrayListMultimap.create();
//        multimap.put("a","1");
//        multimap.put("a","2");
//        System.out.println(multimap.get("a"));
//        [1, 2]

//        //1
//        //a
//        BiMap<String, Integer> biMap = HashBiMap.create();
//        biMap.put("a",1);
//        biMap.put("b",2);
//        System.out.println(biMap.get("a"));
//        System.out.println(biMap.inverse().get(1));


        List<String> list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("hello world");
        list1.add("testt");
        Function<String,String> f1 = new Function<String, String>() {
            @NotNull
            @Override
            public String apply(@NotNull String s) {
                return s.toUpperCase();
            }
        };

        Function<String,String> f2 = new Function<String, String>() {
            @NotNull
            @Override
            public String apply(@NotNull String s) {
                return s.length() < 5 ? s : s.substring(0, 5);
            }
        };

        Function f3 = Functions.compose(f1, f2);

        Collection transform = Collections2.transform(list1, f3);
        transform.stream().forEach(s-> System.out.println(s));
    }
}

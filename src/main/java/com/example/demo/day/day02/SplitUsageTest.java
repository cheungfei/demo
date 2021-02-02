package com.example.demo.day.day02;

/**
 * @author zhangfei
 * @version 1.0
 * @date 2020-12-22 21:15
 */
public class SplitUsageTest {
    public static void main(String[] args) {
        // 特殊情况有 * ^ : | . \

/*        使用spring MVC模式编写action时候，出现 Illegal escape character in string literal 错误，
        经查是由于使用了 “\” 作为路径分隔符，如 "Index\index" ，这个斜杠用的时候需要在前面再加一个 \ 转义，
        并且这个分隔符只对windows系统有用，局限性比较严重。推荐使用 “/” 作为分隔符或者File.separator，最好不要使用 “\”*/

        // 一、单个符号作为分隔符
//        File.separator
//        String address = "上海\\上海市|闵行区\\吴中路";
//        String[] splitAddress = address.split("\\\\");
//        System.out.println(splitAddress[0] + " " + splitAddress[1] + " " + splitAddress[2]);


        String address="上海|上海市|闵行区|吴中路";
        String[] splitAddress=address.split("\\|"); //如果以竖线为分隔符，则split的时候需要加上两个斜杠【\\】进行转义
        System.out.println(splitAddress[0]+splitAddress[1]+splitAddress[2]+splitAddress[3]);


//        总结：（1）split表达式，其实就是一个正则表达式。*  ^ | 等符号在正则表达式中属于一种有特殊含义的字符，
//        如果使用此种字符作为分隔符，必须使用转义符即\\加以转义。
//          （2）如果使用多个分隔符则需要借助 | 符号，如二所示，但需要转义符的仍然要加上分隔符进行处理

    }
}

package com.zhimazg.javatest.正则表达式;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by haoyundong on 2016/12/12.
 */

public class RegularSample {
    private static String night = "Then,when you have found the shrubbery,you must cut down the ightiest tree in the forest";

    public void client() {
        inputLine("test1");
        test1();

        inputLine("test2");
        test2();

        inputLine("test3");
        test3();

        inputLine("test4");
        test4();

        inputLine("test5");
        test5();


    }

    private void test1() {
        System.out.println("找一个首位可能是\"-\"号的表达式-1234：" + "-1234".matches("-?\\d+"));
        System.out.println("找一个首位可能是\"-\"号的表达式1234：" + "1234".matches("-?\\d+"));
        System.out.println("找一个首位可能是\"-\"号的表达式+1234：" + "+1234".matches("-?\\d+"));
        System.out.println("找一个首位可能是\"-\"号或\"+\"号的表达式+1234：" + "+1234".matches("(-|\\+)?\\d+"));
        System.out.println("输入的是否全是数字,或者说有一位或者多位数字2：" + "2".matches("\\d+"));
        System.out.println("输入的是否全是数字234：" + "234".matches("\\d+"));
        System.out.println("输入的是否全是数字23m：" + "23m".matches("\\d+"));

    }

    private void test2() {
        split(" ");
        split(",");
        split("\\w+");
        split("n\\w+");
    }

    private void test3() {
        //   \W：非单词字符  \w：一个单词字符
        print(night.replaceFirst("f\\w+", "located"));
        print(night.replaceAll("found|the|shrubbery", "banana"));

    }

    private void test4() {
        print("检查一个句子以大写字母开头，以句号结尾（This is a dog.）" + "This is a dog.".matches("^[A-Z].*[\\\\.]$"));
        split("the|you");
        print("下滑线替换所有的字母：" + night.replaceAll("\\w", "_"));
    }

    private void split(String regex) {
        System.out.println(Arrays.toString(night.split(regex)));
    }

    private void test5() {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("Evening is full of the linnet's wings");
        while (matcher.find()) {
            System.out.print(matcher.group() + "  ");
        }
    }

    private void inputLine(String secName) {
        System.out.println();
        System.out.println("----------------------" + secName + "-------------------------");
        System.out.println();

    }

    private void print(String string) {
        System.out.println(string);
    }
}

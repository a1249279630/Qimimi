package com.example.qimimi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args) {
        //定义一个正则表达式的规则
        String reg = "星的期[.]*";
//待检验的字符串
        String str = "星期三";
//获取一个Pattern对象
        Pattern p = Pattern.compile(reg);
//调用matcher方法
        Matcher m = p.matcher(str);
//查看匹配结果
        boolean flag = m.find();
//打印结果
        System.out.println(flag);
    }
}

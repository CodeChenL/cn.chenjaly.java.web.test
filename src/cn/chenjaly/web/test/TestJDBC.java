package cn.chenjaly.web.test;

import java.util.List;

import cn.chenjaly.web.test.*;

public class TestJDBC {
    public static void main(String[] args) {
        //<T>表示的泛型的概念，表示参数化类型，简单理解就是 指定这个DBUtil里面的<T>是可以替换的类型
        //我们这里将T替换成Book类型 ，这个类里面的T在编译时期就替换成Book
        DBUtil<Book> bookUtils = new DBUtil<Book>();
        //query就是我们封装好的查询方法 可以传入多个参数，第一个参数指的sql语句，第二个参数指的是查询条件
        List<Book> books = bookUtils.query("select * from book");
        //使用循环查看一下我们查询出来的图书信息
        for (Book book : books) {
            System.out.println(book);
        }

    }
}

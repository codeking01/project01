package com.codeking.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import org.junit.Test;

/**
 * @author king_xiong
 * @date 2021-12-27 15:05
 * <p>
 * 1.单元测试：
 * 要求： ①public ②此类提供公共的无参的构造器
 * 权限是public，没有返回值，没有形参
 * 需要声明注解：@Test ,并且导入相应的包：import org.junit.Test;
 * 在方法体内写测试相关的代码，然后run
 * 操作步骤：
 * 1.写注解：@Test
 * 2.导包：import org.junit.Test;
 */
public class Dom4jTest {
    @Test
    public void test1() throws Exception {  //把DocumentException改成了Exception，抛出了一个大的异常
        SAXReader render = new SAXReader();
        try {
            Document document = render.read("src/books.xml");
            System.out.println(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //ctrl+j代码提示
    //surround with 的快捷键是ctrl+alt+t
    /*
    1.需要复习一下List的知识点
    2.还有的就是 复习一下基本数据类型转化为String类型的方法，
    3.了解一下：包装类转换为基本数据类型，还有新特性：自动装箱与自动拆箱[day13_面向对象(中)]
     */
}
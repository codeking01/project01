package com.codeking.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author king_xiong
 * @date 2022-01-18 11:42
 */
public class Servlet2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        // 获取请求的参数（办事的材料）查看
        String username = req.getParameter("username");
        System.out.println("在 Servlet2（柜台 2）中查看参数（材料）：" + username);
        // 查看 柜台 1 是否有盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台 1 是否有章：" + key1);

        // 处理自己的业务
        System.out.println("Servlet2 处理自己的业务 ");

        // 它会同时设置服务器和客户端都使用 UTF-8 字符集，还设置了响应头
        // 此方法一定要在获取流对象之前调用才有效
        //把服务器的字符集和这个 下载的字符的字符集 都设置程统一的 UTF-8
        resp.setContentType("text/html; charset=UTF-8");
        // 要求 ： 往客户端回传 字符串 数据。
        PrintWriter writer = resp.getWriter();
        writer.write("测试");

         //请求重定向的第一种方案：
        // 设置响应状态码 302 ，表示重定向，（已搬迁）
        /// resp.setStatus(302);
        //设置响应头，说明 新的地址在哪里
        resp.setStatus(302);
        //resp.setHeader("location","http://localhost:8080/06_servlet/response2");
        resp.setHeader("location","http://www.baidu.com");

        //请求重定向的第二种方案（推荐使用）：
        //resp.sendRedirect("http://localhost:8080");
    }
}

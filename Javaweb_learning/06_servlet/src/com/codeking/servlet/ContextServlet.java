package com.codeking.servlet; /**
 * @author king_xiong
 * @date 2022-01-13 20:43
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取 web.xml 中配置的上下文参数 context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("username是这个----" + username);
        //2、获取当前的工程路径，格式: /工程路径
        System.out.println("当前的路径：" + context.getContextPath());
        //3、获取工程部署后在服务器硬盘上的绝对路径
        System.out.println("绝对路径:" + context.getRealPath("/"));
        System.out.println("css的路径:" + context.getRealPath("/css"));
        //4、像 Map 一样存取数
        ServletContext context2 = getServletContext();
        System.out.println("context2的值为；"+context.getAttribute("key01"));
        context2.setAttribute("key01","codekingzero");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

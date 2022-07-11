package com.codeking.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author king_xiong
 * @date 2022-01-13 11:31
 */
public class HelloServlet  implements Servlet {//在标红处 按住 alt+insert显示 重写方法;或者也可以直接按住ctrl+o显示重写选项

    public HelloServlet() {
        System.out.println("1.先进入构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2. 进入init方法");
        System.out.println("username为："+ servletConfig.getInitParameter("username"));
        System.out.println("url为："+ servletConfig.getInitParameter("url"));
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    //ctrl+H 查看子类
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3. 执行service的方法中的打印一下：hello,你好，我进来了");
        //子类接口提供了一些方法getMethod()等，所以这里我们向下转型  servletRequest-->httpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if (method.equals("GET")){
            doGet();
        }else if (method.equals("POST")){
            doPost();
        }
    }

    private void doPost() {
        System.out.println("这个是POST请求");
    }

    public void doGet(){
        System.out.println("这个是GET请求");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4. web工程停止的时候调用");
    }

}
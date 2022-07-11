package com.codeking.servlet; /**
 * @author king_xiong
 * @date 2022-01-18 12:28
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class response2IOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("response2's result!!!!!!!");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

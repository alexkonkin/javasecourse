package com.globallogic.javaee;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/9/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Redirect extends HttpServlet {
    //private static int count = 0;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //count++;
        ServletContext context = getServletContext();
        //context.getAttribute("count");
        System.out.println("count is : "+context.getAttribute("count"));
        Integer tmpcnt = new Integer(context.getAttribute("count").toString());
        tmpcnt++;
        context.setAttribute("count", tmpcnt);
        request.setAttribute("current_count", context.getAttribute("count"));
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}

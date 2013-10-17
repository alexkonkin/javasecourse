package com.globallogic.javaee;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.*;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/9/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{

        if(request.getParameter("login")!= null && request.getParameter("password")!= null ){
            request.setAttribute("current_login",request.getParameter("login"));
            request.setAttribute("current_password",request.getParameter("password"));

            ServletContext context = getServletContext();
            System.out.println("count is : "+context.getAttribute("count"));
            Integer tmpcnt = new Integer(context.getAttribute("count").toString());
            tmpcnt++;
            context.setAttribute("count", tmpcnt);
            request.setAttribute("current_count", context.getAttribute("count"));


            request.getRequestDispatcher("index.jsp").forward(request,response);
        }



        /*
        if(request.getAttribute("login")!= null && request.getAttribute("password")!= null ){
            String login = request.getAttribute("login").toString();
            String password = request.getAttribute("password").toString();
            request.setAttribute("current_login",login);
            request.setAttribute("current_password",password);
            //request.getRequestDispatcher("/simple_webapp/index.jsp").forward(request,response);
            //response.sendRedirect("/simple_webapp/index.jsp");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>test page</title></head>");
            out.println("<body>");
            out.println("<p>The servlet has received a POST1. This is the reply.1</p>");
            out.println("<p>the login is :" + login+"</p>");
            //out.println(login);
            //out.println(password);
            out.println("</body></html>");
            out.close();
        }else{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>demolet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        String login = "test";
            Enumeration headerNames = request.getHeaderNames();
            while(headerNames.hasMoreElements()) {
                String headerName = (String)headerNames.nextElement();
                out.println("<TR><TD>" + headerName);
                out.println("    <TD>" + request.getHeader(headerName));
            }

            out.println("<p>param names request</p>");
            Enumeration paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
                out.println("<TR><TD>" + paramName);
                out.println("    <TD>" + request.getHeader(paramName));
            }
            out.println("<p>the login is : "+request.getParameter("login")+"</p>");

            //ServletContext context = this.getServletContext();

            //ServletContext context = getServletContext();
            //Redirect redirect = (Redirect)context.getAttribute("redirect");

            //Redirect redirect = (Redirect)getServletContext().getAttribute("redirect");
            //Redirect redirect = (Redirect)context.getAttribute("Redirect");

            //ServletContext context = request.getSession().getServletContext();
            //context.getAttribute("count").toString();
            //out.println("<p>the count is : "+ redirect.incCounter().toString() +"</p>");
        out.println("</body></html>");
        out.close();
        }
        */
    }
}


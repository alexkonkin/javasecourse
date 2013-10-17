package com.globallogic.javaee;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import com.globallogic.javase.*;


/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/15/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginToUserAccount extends HttpServlet {
    //private static int count = 0;

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Login to user account</title></head>");
        out.println("<body>");
        out.println("<p>the login is : "+request.getParameter("login")+"</p>");
        out.println("<p>the password is : "+request.getParameter("password")+"</p>");

        String login = new String(request.getParameter("login"));
        String password = new String(request.getParameter("password"));

        ServletContext context = getServletContext();
        UserXmlService tmpUserXmlService = (UserXmlService)context.getAttribute("aUserXmlService");
        Integer tmpcnt = (Integer)context.getAttribute("count");
        tmpcnt++;
        context.setAttribute("count", tmpcnt);
        request.setAttribute("current_count", context.getAttribute("count"));
        System.out.println("tmpcount is "+tmpcnt);

        User aUser = new User(login,password);
        try{
            tmpUserXmlService.authenticateUser(aUser);
            out.println("<p>the user "+login+" and password "+password+" logged in to the system</p>");
            context.setAttribute("aUserXmlService",tmpUserXmlService);

        }
        catch(UserNotFound e){
            System.out.println(e.toString());
            out.println("<p>the user "+login+" and password "+password+" is not found in the database</p>");
        }
        catch(BadCredentialsPassed e){
            System.out.println(e.toString());
            out.println("<p>the user "+login+" and passowrd " +password+"tried to login with the wrong password</p>");
        }

        out.println("<p><a href=index.jsp>return to the main page</a><p>");

        out.println("</body></html>");
        out.close();
    }
}

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

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String login = new String(request.getParameter("login"));
        String password = new String(request.getParameter("password"));

        ServletContext context = getServletContext();
        UserXmlService tmpUserXmlService = (UserXmlService)context.getAttribute("aUserXmlService");
        Integer tmpcnt = (Integer)context.getAttribute("count");
        tmpcnt++;
        context.setAttribute("count", tmpcnt);
        request.setAttribute("current_count", context.getAttribute("count"));
        System.out.println("tmpcount is "+tmpcnt);

        request.setAttribute("login",login);
        request.setAttribute("password",password);
        context.setAttribute("aUserXmlService",tmpUserXmlService);

        User aUser = new User(login,password);
        try{
            tmpUserXmlService.authenticateUser(aUser);
            context.getRequestDispatcher("/registered.jsp").forward(request, response);
        }
        catch(UserNotFound e){
            context.getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
        catch(BadCredentialsPassed e){
            context.getRequestDispatcher("/badcredentials.jsp").forward(request, response);
        }
    }
}

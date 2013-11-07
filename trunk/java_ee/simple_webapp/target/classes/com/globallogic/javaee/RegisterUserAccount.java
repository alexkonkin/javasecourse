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
public class RegisterUserAccount extends HttpServlet {

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        response.setContentType("text/html");

        String login = new String(request.getParameter("login"));
        String password = new String(request.getParameter("password"));

        ServletContext context = getServletContext();
        UserXmlService tmpUserXmlService = (UserXmlService)context.getAttribute("aUserXmlService");

        /*
        Integer tmpcnt = (Integer)context.getAttribute("count");
        tmpcnt++;
        context.setAttribute("count", tmpcnt);
        request.setAttribute("current_count", context.getAttribute("count"));
        System.out.println("tmpcount is "+tmpcnt);
         */

        request.setAttribute("login",login);
        request.setAttribute("password",password);
        context.setAttribute("aUserXmlService",tmpUserXmlService);

        User aUser = new User(login,password);
        try{
            tmpUserXmlService.registerUser(aUser);
            context.getRequestDispatcher("/registersuccess.jsp").forward(request, response);
        }
        catch(PasswordToSimple e){
            //System.out.println(e.toString());
            //out.println("<p>the user "+login+" and password "+password+" has not been registered</p>");
            //out.println("<p>the password "+password+" is too simple</p>");
            context.getRequestDispatcher("/simplepassword.jsp").forward(request, response);
        }
        catch(UserAlreadyExists e){
            //System.out.println(e.toString());
            //out.println("<p>the user "+login+" already exists in the database</p>");
            context.getRequestDispatcher("/userexists.jsp").forward(request, response);
        }

        //out.println("<p><a href=index.jsp>return to the main page</a><p>");

        //out.println("</body></html>");
        //out.close();
    }
}

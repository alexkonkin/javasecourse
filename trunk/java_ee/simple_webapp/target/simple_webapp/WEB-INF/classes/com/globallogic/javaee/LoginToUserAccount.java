package com.globallogic.javaee;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ListIterator;

import com.globallogic.javase.*;


/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/15/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginToUserAccount extends HttpServlet {
    HttpSession session;

    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
        String login = new String(request.getParameter("login"));
        String password = new String(request.getParameter("password"));

        ServletContext context = getServletContext();
        UserXmlService tmpUserXmlService = (UserXmlService)context.getAttribute("aUserXmlService");

        UserRegistrationInfo aUserRegistrationInfo = new UserRegistrationInfo();

        session = request.getSession();

        request.setAttribute("login",login);
        request.setAttribute("password",password);
        context.setAttribute("aUserXmlService",tmpUserXmlService);

        User aUser = new User(login,password);
        try{
            tmpUserXmlService.authenticateUser(aUser);
            //context.getRequestDispatcher("/registered.jsp").forward(request, response);

            aUserRegistrationInfo.setLogin(login);
            aUserRegistrationInfo.setPassword(password);
            aUserRegistrationInfo.setRegistrationStatus(RegistrationStatus.USER_CREDENTIALS_ACCEPTED);

            UserXmlDAO ua = new UserXmlDAO("D:\\oleksiy.konkin\\Documents\\JAVA\\JAVA\\JAVA\\apache-tomcat-6.0.36\\bin\\test_xml_db.xml");

            ArrayList<User> arr = new ArrayList<User>();
            arr = ua.getUserList();
            /*
            ListIterator<User> listIterator = arr.listIterator();
            while(listIterator.hasNext()) {
                System.out.println("Value of element(" +  listIterator.nextIndex() + "): " + listIterator.next().getLogin());
            }
            */

            session.setAttribute("aUserRegistrationInfo",aUserRegistrationInfo);
            session.setAttribute("arr",arr);

            response.sendRedirect("/simple_webapp/registered.jsp");
        }
        catch(UserNotFound e){
            //context.getRequestDispatcher("/notfound.jsp").forward(request, response);

            aUserRegistrationInfo.setLogin(login);
            aUserRegistrationInfo.setPassword(password);
            aUserRegistrationInfo.setRegistrationStatus(RegistrationStatus.USER_NOT_FOUND);

            session.setAttribute("aUserRegistrationInfo",aUserRegistrationInfo);

            response.sendRedirect("/simple_webapp/index.jsp");
        }
        catch(BadCredentialsPassed e){
            //context.getRequestDispatcher("/badcredentials.jsp").forward(request, response);

            aUserRegistrationInfo.setLogin(login);
            aUserRegistrationInfo.setPassword(password);
            aUserRegistrationInfo.setRegistrationStatus(RegistrationStatus.BAD_CREDENTIALS);

            session.setAttribute("aUserRegistrationInfo",aUserRegistrationInfo);

            response.sendRedirect("/simple_webapp/index.jsp");
        }
    }
}

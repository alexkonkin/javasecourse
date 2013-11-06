package com.globallogic.javaee;

import com.globallogic.javase.UserXmlService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/15/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */

public class SimpleWebappContextListener implements ServletContextListener{
    ServletContext context;
    HttpSession session;

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("Context Created");
        context = contextEvent.getServletContext();

        Counter count = new Counter();
        context.setAttribute("count", count);

        String current = null;
        try {
            current = new java.io.File( "." ).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println("Current dir:"+current);

        UserXmlService aUserXmlService = new UserXmlService("test_xml_db.xml");
        context.setAttribute("aUserXmlService",aUserXmlService);
}

    public void contextDestroyed(ServletContextEvent contextEvent) {
        context = contextEvent.getServletContext();
        System.out.println("Context Destroyed"); }
}
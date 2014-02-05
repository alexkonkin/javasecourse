package com.globallogic.javaee;

import com.globallogic.javaee.dao.MessageDao;
import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.dao.UserDao;
import com.globallogic.javaee.dao.UserRolesDao;
import com.globallogic.javaee.service.MessageService;
import com.globallogic.javaee.service.TopicService;
import com.globallogic.javaee.service.UserService;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.BeforeClass;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.SQLException;

//@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public abstract class AbstractTest
{
    private static SessionFactory sessionFactory;
    protected static UserDao userDao;
    protected static TopicDao topicDao;
    protected static MessageDao messageDao;
    protected static UserRolesDao userRolesDao;
    protected static UserService userService;
    protected static TopicService topicService;
    protected static MessageService messageService;
    private static ServiceFactory serviceFactory;

    @BeforeClass
    public static void initAbstractTestClass()
    {
        serviceFactory = new ServiceFactory()
        {
            @Override
            protected void initialize()
            {
                try
                {
                    // Let's assume that the test is running from IDE. In this
                    // case the configuration file is in the class-path
                    super.initialize();
                }
                catch ( BeanDefinitionStoreException e )
                {
                    // if the configuration file is not found in the class-path
                    // then it is likely that the test is running from Ant. In
                    // this case the configuration file in root folder.
                    //context = new ClassPathXmlApplicationContext( "applicationContext.xml" );
                    context = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/applicationContext.xml");
                    //context = new StaticApplicationContext();
                }
            }
        };

        userDao = serviceFactory.getUserDao();
        topicDao = serviceFactory.getTopicDao();
        messageDao = serviceFactory.getMessageDao();
        userRolesDao = serviceFactory.getUserRolesDao();

        userService = serviceFactory.getUserService();
        topicService = serviceFactory.getTopicService();
        messageService = serviceFactory.getMessageService();

        sessionFactory = serviceFactory.getSessionFactory();
    }

    /**
     * Sequentially executes SQL update expressions (INSERT, UPDATE, DELETE).
     * Use this method instead of DbUnit framework.
     * 
     * @param expressions
     *            the SQL insert expressions
     * @throws java.sql.SQLException
     *             if a database access error occurs or the given SQL statement
     *             produces a ResultSet object
     */
    protected void executeUpdateExpressions( String... expressions ) throws SQLException
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            for ( String expression : expressions )
            {
                SQLQuery sqlQuery = session.createSQLQuery( expression );
                sqlQuery.executeUpdate();
            }
            session.getTransaction().commit();
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            if ( session.getTransaction().isActive() )
                session.getTransaction().rollback();
        }
        session.flush();
        session.close();
    }
}

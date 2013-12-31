package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.MessageDao;
import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Initializes and contains application service.
 */
public class ServiceFactory
{
    protected ApplicationContext context;

    /**
     * Constructs and initializes SessionFactory.
     */
    public ServiceFactory()
    {
        initialize();
    }

    /**
     * All initialization logic resides here. If descendant classes want to
     * change initialization process they should override this method.
     */
    protected void initialize()
    {
        context = new ClassPathXmlApplicationContext( "WEB-INF/applicationContext.xml" );
    }

    /**
     * Returns user service
     */
    public UserService getUserService()
    {
        return context.getBean( "userService", UserService.class );
    }

    /**
     * Returns topic service
     */
    public TopicService getTopicService()
    {
        return context.getBean( "topicService", TopicService.class );
    }

    public MessageService getMessageService() {
        return context.getBean( "messageService", MessageService.class );
    }

    /**
     * Returns user dao
     */
    public UserDao getUserDao()
    {
        return context.getBean( "userDao", UserDao.class );
    }

    /**
     * Returns topic dao
     */
    public TopicDao getTopicDao()
    {
        return context.getBean( "topicDao", TopicDao.class );
    }

    public MessageDao getMessageDao() {
        return context.getBean( "messageDao", MessageDao.class );
    }

    /**
     * Returns session factory
     */
    public SessionFactory getSessionFactory()
    {
        return context.getBean( "sessionFactory", SessionFactory.class );
    }

}

package com.globallogic.javaee.dao;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */


import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;


public class MessageDao extends HibernateDaoSupport
{

    /**
     * Returns all stored users in the database
     *
     * @return the list of all users, empty list if there are no users.
     */

    @SuppressWarnings("unchecked")
    public List<Message> findAllMessages()
    {
        Criteria allMessagesCriteria = getSession().createCriteria(Message.class);

        return (List<Message>)allMessagesCriteria.list();
    }

    public int createMessage(Message aMessage)
    {
        //getSessionFactory->Session
        //Session session = getSessionFactory().getCurrentSession();
        //session.save(aMessage);

        //this.getSession().save(aMessage);     //getCurrentSession().save(aMessage);

        getHibernateTemplate().save(aMessage);
        int Id = aMessage.getId();
        //this.getSession().close();

        return Id;
    }

    public Message getMessageById(Integer anId){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from MESSAGES m where m.id = :id";
        List<Message> message = aSession.createQuery(hql)
                .setParameter("id", anId)
                .list();
        //aSession.close();
        return message.get(0);
    }

    public List<Message> getMessagesListByTopicId(Topic aTopic){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from MESSAGES m where m.topic = :topic";
        //Expression?
        List<Message> message = aSession.createQuery(hql)
                .setParameter("topic", aTopic)
                .list();
        //aSession.close();
        return message;
    }

}
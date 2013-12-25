package com.globallogic.javaee.dao;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */


import com.globallogic.javaee.model.Message;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

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
        getHibernateTemplate().persist(aMessage);
        //getHibernateTemplate().saveOrUpdate(topic);
        return aMessage.getId();
    }

    public Message getMessageById(Integer anId){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from MESSAGES m where m.id = :id";
        List<Message> message = aSession.createQuery(hql)
                .setParameter("id", anId)
                .list();
        aSession.close();
        return message.get(0);
    }

    public List<Message> getMessagesListByTopicId(Integer aTopicId){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from MESSAGES m where m.id_topic = :id_topic";
        List<Message> message = aSession.createQuery(hql)
                .setParameter("id_topic", aTopicId)
                .list();
        aSession.close();
        return message;
    }

}

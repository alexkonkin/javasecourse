package com.globallogic.javaee.dao;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */


import com.globallogic.javaee.model.Topic;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class TopicDao extends HibernateDaoSupport
{

    /**
     * Returns all stored users in the database
     *
     * @return the list of all users, empty list if there are no users.
     */
    @SuppressWarnings("unchecked")
    public List<Topic> findAllTopics()
    {
        Criteria allTopicsCriteria = getSession().createCriteria(Topic.class);

        return (List<Topic>)allTopicsCriteria.list();
    }

    public int createTopic(String topicName)
    {
        Topic topic = new Topic();
        topic.setName(topicName);
        getHibernateTemplate().persist(topic);
        //getHibernateTemplate().saveOrUpdate(topic);
        return topic.getId();
    }

    public Topic getTopicById(Integer anId){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from TOPICS t where t.id = :id";
        List<Topic> topic = aSession.createQuery(hql)
                .setParameter("id", anId)
                .list();
        aSession.close();
        return topic.get(0);
    }
}

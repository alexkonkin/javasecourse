package com.globallogic.javaee.dao;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */


import com.globallogic.javaee.exceptions.TopicEmptyNameProhibited;
import com.globallogic.javaee.exceptions.TopicWithGivenNameAlreadyExists;
import com.globallogic.javaee.exceptions.TopicWithGivenNameNotFound;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserRolesDao extends HibernateDaoSupport
{

    /**
     * Returns all stored users in the database
     *
     * @return the list of all users, empty list if there are no users.
     */
    @SuppressWarnings("unchecked")
    public List<UserRoles> findAllUserRoles()
    {
        Criteria allUserRolesCriteria = getSession().createCriteria(UserRoles.class);

        return (List<UserRoles>)allUserRolesCriteria.list();
    }

    //public int createTopic(String topicName)
    public int createUserRoles(UserRoles aUserRoles)
    {
        //Topic topic = new Topic();
        //topic.setName(topicName);
        getHibernateTemplate().save(aUserRoles);
        //getHibernateTemplate().save(aTopic);
        //getHibernateTemplate().saveOrUpdate(topic);

        //return aTopic.getId();
        int Id = aUserRoles.getId();
        return Id;
    }

    public List<UserRoles> getUserRoleByUserId(User aUser){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from USER_ROLES ur where ur.user = :user";
        List<UserRoles> userRoles = aSession.createQuery(hql)
                .setParameter("user", aUser)
                .list();
        aSession.close();
        return userRoles;
    }
}

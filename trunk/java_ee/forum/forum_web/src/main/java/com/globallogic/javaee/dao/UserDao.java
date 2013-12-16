package com.globallogic.javaee.dao;

import com.globallogic.javaee.model.User;
import org.hibernate.Criteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class UserDao extends HibernateDaoSupport
{

    /**
     * Returns all stored users in the database
     * 
     * @return the list of all users, empty list if there are no users.
     */
    @SuppressWarnings("unchecked")
    public List<User> findAllUsers()
    {
        Criteria allUsersCriteria = getSession().createCriteria(User.class);

        return (List<User>)allUsersCriteria.list();
    }

    public void createUser(User user)
    {
        getHibernateTemplate().persist(user);
    }

}

package com.globallogic.javaee.dao;

import com.globallogic.javaee.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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


    public List<User> findUser(User aUser){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from USERS s where s.login = :login and s.password = :password";
        List<User> result = aSession.createQuery(hql)
                .setParameter("login", aUser.getLogin())
                .setParameter("password",aUser.getPassword())
                .list();
        aSession.close();
        return result;
    }

    public List<User> findUserByLogin(String aLogin){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from USERS s where s.login = :login";
        List<User> result = aSession.createQuery(hql)
                .setParameter("login", aLogin)
                .list();
        aSession.close();
        return result;
    }


}

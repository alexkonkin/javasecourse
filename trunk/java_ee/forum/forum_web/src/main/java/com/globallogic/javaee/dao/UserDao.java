package com.globallogic.javaee.dao;

import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.globallogic.javaee.exceptions.*;
import org.springframework.transaction.annotation.Transactional;

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
        user.setEnabled(true);
        getHibernateTemplate().persist(user);
        //Session session = getSession();
        //session.close();
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

    public User findUserByLogin(String aLogin) throws UserWithGivenLoginNotFound, UserWithGivenLoginAlreadyExists{
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from USERS s where s.login = :login";
        List<User> result = aSession.createQuery(hql)
                .setParameter("login", aLogin)
                .list();
        aSession.close();
        if(result.size() == 0) {
            throw new UserWithGivenLoginNotFound(aLogin);
        }else if(result.get(0).getLogin().equals(aLogin)){
            throw new UserWithGivenLoginAlreadyExists(aLogin);
        }

        return result.get(0);
    }

    public User findUserById(Integer userId)throws UserWithGivenIdNotFound{
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        String hql = "from USERS s where s.id = :id";
        List<User> result = aSession.createQuery(hql)
                .setParameter("id", userId)
                .list();
        aSession.close();
        if(result.size() == 0) {
            throw new UserWithGivenIdNotFound(userId);
        }else
            return result.get(0);
    }


    public void setAccountStatus(User aUser){
        SessionFactory sessionFactory = getSessionFactory();
        Session aSession = sessionFactory.openSession();
        aSession.beginTransaction();
        aSession.saveOrUpdate(aUser);
        aSession.getTransaction().commit();
        aSession.close();
    }
}

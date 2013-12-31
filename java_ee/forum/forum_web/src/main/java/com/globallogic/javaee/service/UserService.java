package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.UserDao;
import com.globallogic.javaee.model.User;
import org.apache.commons.lang.NotImplementedException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represents the services related with the User.
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UserService
{
    private UserDao userDao;

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }

    /**
     * Returns all users.
     */
    public List<User> findAllUsers()
    {
        return userDao.findAllUsers();
    }

    /**
     * Registers new user.
     * 
     * @param user the user to register
     * @throws ServiceException if user with the same name already exists
     */
    public void register(User user) throws ServiceException
    {
        // if user already exists
        //throw new ServiceException("Unable to register new user. The user with name " + user.getLogin()+ " already exists.");
        // else
        // register new user
        //List<User> usersList = userDao.findUser()
        List<User> usersList = userDao.findUserByLogin(user.getLogin());
        if (usersList.size() == 0){
            userDao.createUser(user);
        }else
            throw new ServiceException("Unable to register new user. The user with name " + user.getLogin()+ " already exists.");
    }

    public boolean login( User aUser )
    {
        List<User> usersList = userDao.findUser(aUser);
        if (usersList.size() == 0)
                return false;
            else
                return true;
    }

    public User findUserByLoginPassword(User aUser){
        User result;
        return result = userDao.findUser(aUser).get(0);
    }
}

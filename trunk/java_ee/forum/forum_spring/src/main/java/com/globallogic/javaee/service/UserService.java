package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.UserDao;
import com.globallogic.javaee.model.User;
import org.apache.commons.lang.NotImplementedException;

import java.util.List;

/**
 * Represents the services related with the User.
 */
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
        throw new ServiceException("Unable to register new user. The user with name " + user.getLogin()
            + " already exists.");
        // else
        // register new user
    }

    public void login( String user, String password )
    {
        throw new NotImplementedException("Loging is not implemented, yet" );
    }
}

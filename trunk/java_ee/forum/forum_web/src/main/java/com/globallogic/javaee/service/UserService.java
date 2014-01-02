package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.UserDao;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.exceptions.*;
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
    public void register(User user)
    {
        userDao.createUser(user);
    }

    public void findUserByLogin(String aLogin) throws UserWithGivenLoginNotFound, UserWithGivenLoginAlreadyExists
    {
        userDao.findUserByLogin(aLogin);
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

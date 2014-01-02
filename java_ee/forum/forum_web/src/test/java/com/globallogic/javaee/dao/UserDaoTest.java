package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.exceptions.UserWithGivenLoginAlreadyExists;
import com.globallogic.javaee.exceptions.UserWithGivenLoginNotFound;
import com.globallogic.javaee.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDaoTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions(
                "delete from MESSAGES",
                "delete from TOPICS",
                "delete from USERS");
    }

    @Test
    public void testFindAllUsers_EmptyList()
    {
        List<User> allUsers = userDao.findAllUsers();
        Assert.assertNotNull(allUsers);
        Assert.assertEquals(0, allUsers.size());
    }

    @Test
    public void testCreateAndFindAllUsers()
    {
        User user = new User();
        user.setLogin("petya");
        user.setPassword("123456");
        user.setId(0);
        userDao.createUser(user);

        List<User> allUsers = userDao.findAllUsers();
        Assert.assertTrue(allUsers.size() >= 1);

        User storedUser = allUsers.get(0);
        Assert.assertEquals(user.getLogin(), storedUser.getLogin());
    }

    @Test
    public void testFindUser(){
        User user = new User();
        user.setLogin("SENYA");
        user.setPassword("123456");
        user.setId(0);
        userDao.createUser(user);
        List<User> user1 = userDao.findUser(user);
        Assert.assertEquals(user.getLogin(),user1.get(0).getLogin());
        Assert.assertEquals(user.getPassword(),user1.get(0).getPassword());
    }

    @Test
    public void testFindUserByLogin(){
        User user = new User();
        user.setLogin("SENYA");
        user.setPassword("123456");
        user.setId(0);
        userDao.createUser(user);
        User user1 = null;
        try {
            user1 = userDao.findUserByLogin(user.getLogin());
        } catch (UserWithGivenLoginNotFound userWithGivenLoginNotFound) {
            System.out.println(userWithGivenLoginNotFound.toString());
        } catch (UserWithGivenLoginAlreadyExists userWithGivenLoginAlreadyExists) {
            System.out.println(userWithGivenLoginAlreadyExists.toString());
        }
        Assert.assertEquals(user.getLogin(),user1.getLogin());
    }

}

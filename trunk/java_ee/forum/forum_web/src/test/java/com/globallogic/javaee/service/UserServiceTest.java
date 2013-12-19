package com.globallogic.javaee.service;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.SQLException;
import java.util.List;

public class UserServiceTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions(
            "delete from USERS",
            "insert into USERS (ID,LOGIN, PASSWORD) values (0,'PETYA','123456')",
            "insert into USERS (ID,LOGIN, PASSWORD) values (1,'VASYA','123456')",
            "insert into USERS (ID,LOGIN, PASSWORD) values (2,'SENYA','123456')");
    }

    @Test
    public void testFindAllUsers_EmptyList() throws SQLException
    {
        executeUpdateExpressions("delete from USERS");

        List<User> allUsers = userService.findAllUsers();
        Assert.assertEquals(0, allUsers.size());
    }

    @Test
    public void testRegisterNewUser() throws Exception
    {
        User user = makeUser(0,"ALEX","123456");
        userService.register(user);
    }

    @Test(expected = ServiceException.class)
    public void testRegisterWithTheSameName() throws Exception
    {
        User user = makeUser(0,"SENYA","123456");
        userService.register(user);
    }

    private User makeUser(int id, String name, String password)
    {
        User user = new User();
        user.setId(id);
        user.setLogin(name);
        user.setPassword(password);
        return user;
    }
}

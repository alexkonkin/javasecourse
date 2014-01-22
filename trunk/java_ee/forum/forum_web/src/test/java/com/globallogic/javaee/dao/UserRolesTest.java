package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.exceptions.UserWithGivenLoginAlreadyExists;
import com.globallogic.javaee.exceptions.UserWithGivenLoginNotFound;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserRolesTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions("delete from MESSAGES");
        executeUpdateExpressions("delete from TOPICS");
        executeUpdateExpressions("delete from USER_ROLES");
        executeUpdateExpressions("delete from USERS");
    }

    @Test
    public void testCreateAndFindAllUserRoles()
    {
        User aUser = new User();
        //aUser.setId(0);
        aUser.setLogin("test");
        aUser.setPassword("123456");
        userDao.createUser(aUser);

        UserRoles aUsersRoleUser = new UserRoles();
        aUsersRoleUser.setRole("ROLE_USER");
        aUsersRoleUser.setUser(aUser);
        userRolesDao.createUserRoles(aUsersRoleUser);

        UserRoles aUsersRoleAdministrator = new UserRoles();
        aUsersRoleAdministrator.setRole("ROLE_ADMINISTRATOR");
        aUsersRoleAdministrator.setUser(aUser);
        userRolesDao.createUserRoles(aUsersRoleAdministrator);

        List<UserRoles> allUserRoles = userRolesDao.getUserRoleByUserId(aUser);

        Assert.assertEquals(1, allUserRoles.get(0).getUser().getId());
        Assert.assertEquals("ROLE_USER", allUserRoles.get(0).getRole());
        Assert.assertEquals("ROLE_ADMINISTRATOR", allUserRoles.get(1).getRole());
    }
}
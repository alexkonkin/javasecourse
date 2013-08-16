package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/25/13
 * Time: 3:43 PM
 * To change this template use File | Settings | File Templates.
 */

import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.*;

import static junit.framework.Assert.assertEquals;



public class UserDaoTest {
    @Test
    public void testUserDAOPutUser() throws Exception {
        Path aPath = FileSystems.getDefault().getPath(".", "usersIoDAOTestDb.txt");
        Files.delete(aPath);

        AbstractDAO aUserDAO = new UserDAO("usersIoDAOTestDb.txt");
        User testUser = new User("user","mkyong1A@");
        aUserDAO.putUser(testUser);
        User testUser1 =  aUserDAO.getUser("user");
        assertEquals(testUser.getLogin(),testUser1.getLogin());
        assertEquals(testUser.getPassword(),testUser1.getPassword());
    }

    @Test
    public void testUserDAOInMemoryPutUser() throws Exception {
        AbstractDAO aUserDAOInMemory = new UserDAOInMemory();
        User testUser = new User("user","mkyong1A@");

        aUserDAOInMemory.putUser(testUser);
        assertEquals(testUser,aUserDAOInMemory.getUser("user"));
    }

    @Test
    public void testUserXmlDAOPutUser() throws Exception {
        Path aPath = FileSystems.getDefault().getPath(".", "usersIoDAOTestDb.xml");
        if(Files.exists(aPath))
            Files.delete(aPath);

        AbstractDAO aUserXmlDAO = new UserXmlDAO("usersIoDAOTestDb.xml");
        User testUser = new User("user","mkyong1A@");
        aUserXmlDAO.putUser(testUser);
        User testUser1 =  aUserXmlDAO.getUser("user");
        assertEquals(testUser.getLogin(),testUser1.getLogin());
        assertEquals(testUser.getPassword(),testUser1.getPassword());
    }
}

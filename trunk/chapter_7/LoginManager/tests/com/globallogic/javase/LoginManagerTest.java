package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:17 PM
 * To change this template use File | Settings | File Templates.
 */

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LoginManagerTest {
    @Test
    public void testUserDAOregisterUser(){
        User testUser = new User("user","123456");

        //given
        UserDAO aUserDAO =    mock(UserDAO.class);
        //when
        when(aUserDAO.registerUser(testUser)).thenReturn(true);
        //then
        assertEquals(true, aUserDAO.registerUser(testUser));
    }

    @Test
    public void testUserDAOgetUser(){
        User testUser = new User("user","123456");
        //given
        UserDAO aUserDAO =    mock(UserDAO.class);
        //when
        when(aUserDAO.authenticateUser("user")).thenReturn(true);
        //then
        assertEquals(true, aUserDAO.authenticateUser("user"));
    }



}

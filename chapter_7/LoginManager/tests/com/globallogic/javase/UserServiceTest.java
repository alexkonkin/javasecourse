package com.globallogic.javase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/14/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest {
    @InjectMocks
    private UserService service;

    @Mock
    private UserDAO userDAO;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() throws Exception {
        // given
        User testUser = new User("user","mkyong1A@");
        when(userDAO.putUser(testUser)).thenReturn(true);

        // when
        service.registerUser(testUser);

        // then
        verify(userDAO).putUser(testUser);
    }

    @Test
    public void testCheckComplexityComplexCredentials()throws Exception{
        // given
        User testUser = new User("user","mkyong1A@");
        UserService aUserService = new UserService();
        aUserService.registerUser(testUser);

        assertEquals(true, aUserService.authenticateUser(testUser));
    }

    @Test
    public void testCheckComplexityEasyCredentials()throws Exception{
        User testEasyUser = new User("user1","111111");
        UserService aUserService = new UserService();
        assertEquals(false, aUserService.checkComplexity(testEasyUser));
    }

    @Test
    public void testAuthenticateUser()throws Exception{
        User testUser = new User("user","mkyong1A@");
        when(userDAO.getUser(testUser.getLogin())).thenReturn("user");
        service.registerUser(testUser);

        // when
        service.authenticateUser(testUser);

        // then
        verify(userDAO).getUser(testUser.getLogin());
        assertEquals("user", userDAO.getUser(testUser.getLogin()));
    }

    @Test
    public void testAuthenticateUserBadCredentials() throws Exception{
        User testUser = new User("user","123457");
        when(userDAO.getUser(testUser.getLogin())).thenReturn("no_user");

        // when
        service.authenticateUser(testUser);

        // then
        verify(userDAO).getUser(testUser.getLogin());
        assertEquals("no_user", userDAO.getUser(testUser.getLogin()));
    }

}

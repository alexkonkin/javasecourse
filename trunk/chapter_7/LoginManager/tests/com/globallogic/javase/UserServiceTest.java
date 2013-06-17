package com.globallogic.javase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.file.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/14/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceTest {
    @InjectMocks
    private UserService service = new UserService("usersIoTestDb.txt");

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
        //
        // when
        service.registerUser(testUser);

        // then
        verify(userDAO).putUser(testUser);

    }

    @Test (expected=UserAlreadyExists.class) public void testUserAlreadyExists()throws Exception{
        User testUserAlreadyInTheDatabase = new User("user1","mkyong1A@");
        UserService service2 = new UserService();
        service2.registerUser(testUserAlreadyInTheDatabase);

        //public void testUserAlreadyExists() throws Exception {

        /*
        // given
        User testUser = new User("user1","mkyong1A@");
        //

        // when
        service.registerUser(testUser);

        // then
        verify(userDAO).putUser(testUser);
        */


    }



    @Test
    public void testCheckComplexityComplexCredentials()throws Exception{
        //given
        User testUser = new User("user","mkyong1A@");
        UserService aUserService = new UserService();

        //when
        //service.registerUser(testUser);
        userDAO.getUser(testUser.getLogin());

        //then
        verify(userDAO).getUser(testUser.getLogin());
        //assertEquals("user",userDAO.getUser(testUser.getLogin()));
    }

    @Test (expected=PasswordToSimple.class) public void testCheckComplexityEasyCredentials()throws Exception{
        User testEasyUser = new User("user1","111111");
        service.registerUser(testEasyUser);
    }

    @Test
    public void testAuthenticateUser()throws Exception{
        User testUser = new User("user","mkyong1A@");
        when(userDAO.getUser(testUser.getLogin())).thenReturn(testUser);
        service.registerUser(testUser);

        // when
        service.authenticateUser(testUser);

        // then
        verify(userDAO).getUser(testUser.getLogin());
        //assertEquals("user", userDAO.getUser(testUser.getLogin()));
    }
    /*
    @Test
    public void testAuthenticateUserBadCredentials() throws Exception{
        User testUser = new User("user1","123457");
        //when(userDAO.getUser(testUser.getLogin())).thenReturn(null);

        // when
        //service.authenticateUser(testUser);

        // then
        //verify(userDAO).getUser(testUser.getLogin());
        //assertEquals("no_user", userDAO.getUser(testUser.getLogin()));
    }
    */
    @Test (expected=BadCredentialsPassed.class) public void testAuthenticateUserBadCredentials()throws Exception{
        User testUserBadCredentials = new User("user1","mkoong1A@");
        UserService service2 = new UserService();
        service2.authenticateUser(testUserBadCredentials);
    }

    @Test
    public void testRegisterUserIOTest()throws Exception{
        //remove user db file before the test
        try {
            Path aPath = FileSystems.getDefault().getPath(".", "usersIoTestDb.txt");
            Files.delete(aPath);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", "usersIoTestDb.txt");
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", "usersIoTestDb.txt");
        } catch (IOException x) {
            System.err.println(x);
        }
        User testUser = new User("user","mkyong1A@");

        service.registerUser(testUser);
        service.authenticateUser(testUser);
        verify(userDAO).putUser(testUser);
    }
}

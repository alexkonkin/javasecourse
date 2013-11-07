package com.globallogic.javaee;

import org.junit.Before;
import org.junit.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/17/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */

public class LoginToUserAccountTest {

    @Before
    public void prepare() {
        setBaseUrl("http://localhost:8181/simple_webapp/");
    }

    @Test
    public void LoginToUserAccountTest() {
        beginAt("index.jsp");
        assertTitleEquals("Simple web application main page");
        assertFormElementMatch("login", "");
        assertFormElementMatch("password", "");
        assertTextPresent("Please register to continue your work with the application");
        assertLinkPresentWithText("Don't have account? Click here to register");
    }

    @Test
    public void LoginToUserAccountCorrectCredentialsTest() {
        beginAt("index.jsp");
        setTextField("login", "alex");
        setTextField("password", "mkyong1A@");
        submit();
        assertTitleEquals("Login to user account");
        assertTextPresent("the login is : alex");
        assertTextPresent("the password is : mkyong1A@");
        assertTextPresent("the user alex with the password mkyong1A@ logged in to the system");
        assertTextPresent("List of the users that are present in the system storage:");
        assertLinkPresentWithText("return to the main page");
    }

    @Test
    public void LoginToUserAccountIncorrectCredentialsTest() {
        beginAt("index.jsp");
        setTextField("login", "alex");
        setTextField("password", "mkyong1A@1");
        submit();
        assertTitleEquals("Simple web application main page");
        assertTextPresent("Error:");
        assertTextPresent("the user alex with password mkyong1A@1 tried to login with the wrong password");
        assertLinkPresentWithText("Don't have account? Click here to register");
    }

    @Test
    public void LoginToUserAccountEmptyCredentialsTest() {
        beginAt("index.jsp");
        setTextField("login", "");
        setTextField("password", "");
        submit();
        assertTitleEquals("Simple web application main page");
        assertTextPresent("Error:");
        assertTextPresent("the user with password is not found in the database");
        assertLinkPresentWithText("Don't have account? Click here to register");
    }

    @Test
    public void LoginToUserAccountUnexistingUserTest() {
        beginAt("index.jsp");
        setTextField("login", "alex111111");
        setTextField("password", "mkyong1A@");
        submit();
        assertTitleEquals("Simple web application main page");
        assertTextPresent("Error:");
        assertTextPresent("the user alex111111 with password mkyong1A@ is not found in the database");
        assertLinkPresentWithText("Don't have account? Click here to register");
    }
}
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
        assertLinkPresentWithText("return to the main page");
        assertTextPresent("the login is : alex");
        assertTextPresent("the password is : mkyong1A@");
        assertTextPresent("the user alex and password mkyong1A@ logged in to the system");
    }

    @Test
    public void LoginToUserAccountIncorrectCredentialsTest() {
        beginAt("index.jsp");
        setTextField("login", "alex");
        setTextField("password", "mkyong1A@1");
        submit();
        assertTitleEquals("Login to user account");
        assertTextPresent("the login is : alex");
        assertTextPresent("the password is : mkyong1A@1");
        assertTextPresent("the user alex and passowrd mkyong1A@1 tried to login with the wrong password");
        assertLinkPresentWithText("return to the main page");
    }

    @Test
    public void LoginToUserAccountEmptyCredentialsTest() {
        beginAt("index.jsp");
        setTextField("login", "");
        setTextField("password", "");
        submit();
        assertTitleEquals("Login to user account");
        assertTextPresent("the login is :");
        assertTextPresent("the password is :");
        assertTextPresent("the user and password is not found in the database");
        assertLinkPresentWithText("return to the main page");
    }

    @Test
    public void LoginToUserAccountUnexistingUserTest() {
        beginAt("index.jsp");
        setTextField("login", "alex111111");
        setTextField("password", "mkyong1A@");
        submit();
        assertTitleEquals("Login to user account");
        assertTextPresent("the login is : alex111111");
        assertTextPresent("the password is : mkyong1A@");
        assertTextPresent("the user alex111111 and password mkyong1A@ is not found in the database");
        assertLinkPresentWithText("return to the main page");
    }
}
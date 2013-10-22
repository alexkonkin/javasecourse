package com.globallogic.javaee;

import org.junit.Before;
import org.junit.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/22/13
 * Time: 11:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class RegisterUserAccountTest {
    @Before
    public void prepare() {
        setBaseUrl("http://localhost:8181/simple_webapp/");
        beginAt("register.jsp");
    }

    @Test
    public void RegisterUserThatAlreadyPresentTest() {
        assertTitleEquals("Register your account");
        setTextField("login", "alex");
        setTextField("password", "mkyong1A@");
        submit();
        assertTitleEquals("Register user account");
        assertTextPresent("the login is : alex");
        assertTextPresent("the password is : mkyong1A@");
        assertTextPresent("the user alex already exists in the database");
        assertLinkPresentWithText("return to the main page");
    }

    @Test
    public void RegisterUserThePasswordIsTooSimpleTest() {
        assertTitleEquals("Register your account");
        setTextField("login", "alex");
        setTextField("password", "123456");
        submit();
        assertTitleEquals("Register user account");
        assertTextPresent("the login is : alex");
        assertTextPresent("the password is : 123456");
        assertTextPresent("the user alex and password 123456 has not been registered");
        assertTextPresent("the password 123456 is too simple");
        assertLinkPresentWithText("return to the main page");
    }


}

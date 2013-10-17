package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/14/13
 * Time: 9:37 AM
 * To change this template use File | Settings | File Templates.
 */

public class BadCredentialsPassed extends ServiceException {

    private User tmpUser;

    BadCredentialsPassed(User aUser) {
        tmpUser = aUser;
    }

    public String toString() {
        return "Bad credentials username [" + tmpUser.getLogin() + "] password "+ tmpUser.getPassword() +"";
    }

}
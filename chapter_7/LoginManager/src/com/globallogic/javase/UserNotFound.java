package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/31/13
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */

public class UserNotFound extends ServiceException {

    private String userName;

    UserNotFound(String aUserLogin) {
        userName = aUserLogin;
    }

    public String toString() {
        return "The user has not been found in the database[" + userName + "]";
    }

}
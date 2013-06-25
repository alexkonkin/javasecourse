package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/13/13
 * Time: 12:39 PM
 * To change this template use File | Settings | File Templates.
 */

public class UserAlreadyExists extends ServiceException {

    private String userName;

    UserAlreadyExists(String aUserLogin) {
        userName = aUserLogin;
    }

    public String toString() {
        return "Such user already exists in the database[" + userName + "]";
    }

}
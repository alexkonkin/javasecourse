package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/3/13
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasswordToSimple extends ServiceException {

    private User tmpUser;

    PasswordToSimple(User aUser) {
        tmpUser = aUser;
    }

    public String toString() {
        return "The password for user [" + tmpUser.getLogin() + "] is too simple "+ tmpUser.getPassword() +"";
    }

}
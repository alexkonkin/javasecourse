package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserWithGivenLoginNotFound extends WebForumException {
    private String userLogin;

    public UserWithGivenLoginNotFound(String aLogin){
        userLogin = aLogin;
    }

    public String toString(){
        return "User with login  "+ userLogin +" not found in the database";
    }

}

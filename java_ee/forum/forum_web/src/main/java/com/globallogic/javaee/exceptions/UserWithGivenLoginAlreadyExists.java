package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserWithGivenLoginAlreadyExists extends WebForumException {
    private String userLogin;

    public UserWithGivenLoginAlreadyExists(String aLogin){
        userLogin = aLogin;
    }

    public String toString(){
        return "User with login  "+ userLogin +" already exists in the database. Please select another login";
    }

}

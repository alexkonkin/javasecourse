package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String userLogin = "";
    private String userPassword = "";

    User (){
    }

    public User(String uLogin, String uPassword){
        userLogin = uLogin;
        userPassword = uPassword;
    }

    public void setLogin (String aLogin){
        userLogin = aLogin;
    }

    public void setPassword(String aPassword){
        userPassword = aPassword;
    }

    public String getLogin(){
        return userLogin;
    }

    public String getPassword(){
        return userPassword;
    }

}

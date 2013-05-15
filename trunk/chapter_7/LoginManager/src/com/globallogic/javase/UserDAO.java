package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //User daoUser;
    List<User> userDB = new ArrayList<User>();

    UserDAO(User aUser){
        //daoUser = aUser;
    }

    public String getUser(String aLogin){
        if (aLogin.equals("user"))
                return "user";
            else
                return "user1";
    }

    public boolean putUser (User aUser){
        if(aUser.getPassword().equals("123456"))
                return true;
            else
                return false;
    }

}

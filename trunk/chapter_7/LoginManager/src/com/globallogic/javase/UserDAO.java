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
    User daoUser;
    List<User> userDB = new ArrayList<User>();

    UserDAO(User aUser){
        daoUser = aUser;
    }

    public boolean authenticateUser(String aLogin){
        if (aLogin == "user")
                return true;
            else
                return false;
    }

    public boolean registerUser (User aUser){
        if(aUser.getPassword() == "123456")
                return true;
            else
                return false;
    }

}

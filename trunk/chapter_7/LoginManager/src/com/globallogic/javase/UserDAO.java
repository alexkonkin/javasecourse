package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

import com.globallogic.javase.User;
import com.globallogic.javase.UserStorage;

public class UserDAO {
    User daoUser;
    UserDAO(User aUser){
        daoUser = aUser;
    }

    public User getUser(UserStorage aStorage, String aLogin){
        //User aUser = aStorage.getUser(aLogin);
        User aUser = new User("user","123456");
        return aUser;
    }

    public boolean registerUser (UserStorage aStorage, User aUser){

        return true;
    }

}

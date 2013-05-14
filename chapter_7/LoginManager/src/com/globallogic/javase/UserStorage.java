package com.globallogic.javase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserStorage {
    List<User> userDB = new ArrayList<User>();

    public User getUser(String aLogin){
        User aUser = new User("test","test");
        return aUser;
    }

    public boolean putUser(User aUser){
        boolean res = true;
        return res;
    }

}

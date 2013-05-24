package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class UserDAO {
    private List<User> userDB = new ArrayList<User>();

    UserDAO(User aUser){
        //daoUser = aUser;
    }

    public User getUser(String aLogin){
        Iterator<User> iterator = userDB.iterator();
        User aUser;
        User result = new User();
        while(iterator.hasNext()){
            aUser = iterator.next();
            if (aUser.getLogin().equals(aLogin))
                result = aUser;
        }
        return result;
    }

    public boolean putUser (User aUser){
        return userDB.add(aUser);

    }

}

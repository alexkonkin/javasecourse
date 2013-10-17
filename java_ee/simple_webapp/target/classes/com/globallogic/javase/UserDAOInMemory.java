package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/25/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class UserDAOInMemory implements AbstractDAO {
    private List<User> userDB = new ArrayList<User>();

    UserDAOInMemory(){
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

    public void putUser (User aUser)throws UserAlreadyExists{
        //if(getUser(aUser.getLogin()) == null){
        if(!userDB.contains(aUser)){
            userDB.add(aUser);
        }
        else{
            throw new UserAlreadyExists(aUser.getLogin());
        }
    }

}


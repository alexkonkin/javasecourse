package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO(new User("test","test"));

    protected boolean checkComplexity(User usUser){
        if (usUser.getPassword() == "123456")
                return true;
            else
                return false;
    }

    public boolean registerUser(User aUser){
        boolean result = false;
        if (checkComplexity(aUser)){
            result = userDAO.registerUser(aUser);
        }
        return result;
    }

    public boolean authenticateUser(User aUser){
        boolean result = false;
        if(userDAO.authenticateUser(aUser.getLogin()))
            result = true;
        return result;
    }

}

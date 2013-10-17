package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:15 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.regex.*;

public class UserService {
    private UserDAO userDAO; /* = new UserDAO();*/
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private String dbFileName;


    public UserService(){
        //UserDAO ud = new UserDAO(/*new User("test","test")*/);
        userDAO =  new UserDAO();
    }

    public UserService(String aDbStorageName){
        userDAO = new UserDAO(aDbStorageName);
    }



    protected void checkComplexity(User usUser) throws PasswordToSimple {
        // Validation rules for the user's password
        /*
            (			        # Start of group
                (?=.*\d)		#   must contains one digit from 0-9
                (?=.*[a-z])		#   must contains one lowercase characters
                (?=.*[A-Z])		#   must contains one uppercase characters
                (?=.*[@#$%])	#   must contains one special symbols in the list "@#$%"
                .		        #     match anything with previous condition checking
                {6,20}	        #        length at least 6 characters and maximum of 20
            )			        # End of group
        */
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(usUser.getPassword());
        boolean result = matcher.matches();
        if (result == false)
        {
            throw new PasswordToSimple(usUser);
        }
    }

    public void registerUser(User aUser) throws PasswordToSimple,UserAlreadyExists {
            checkComplexity(aUser);
            userDAO.putUser(aUser);
    }

    public void authenticateUser(User aUser) throws UserNotFound, BadCredentialsPassed {
        User tmpUser = userDAO.getUser(aUser.getLogin());
        if (tmpUser != null){
            if (tmpUser.getLogin().equals(aUser.getLogin())&& tmpUser.getPassword().equals(aUser.getPassword()))
                ;//System.out.println(aUser.getLogin()+" has been authenticated");
            else
                throw new BadCredentialsPassed(aUser);
            if (tmpUser.getLogin().equals(aUser.getLogin())&& !tmpUser.getPassword().equals(aUser.getPassword()))
                throw new UserNotFound(aUser.getLogin());
        }
        //else
        //    throw new UserNotFound(aUser.getLogin());
    }
}

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
    private UserDAO userDAO = new UserDAO(new User("test","test"));
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    protected boolean checkComplexity(User usUser){
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
        return result;
    }

    public boolean registerUser(User aUser){
        boolean result = false;
        if (checkComplexity(aUser)){
            result = userDAO.putUser(aUser);
        }
        return result;
    }

    public boolean authenticateUser(User aUser){
        boolean result;
        return result =  (userDAO.getUser(aUser.getLogin()).equals(aUser));
    }

}

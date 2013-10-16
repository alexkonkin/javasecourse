package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 10/16/13
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.regex.*;

public class UserXmlService {
    private UserXmlDAO userXmlDAO; /* = new UserDAO();*/
    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    private String dbFileName;


    public UserXmlService(String aPathToXmlFile){
        //UserDAO ud = new UserDAO(/*new User("test","test")*/);
        userXmlDAO =  new UserXmlDAO(aPathToXmlFile);
    }

    protected void checkComplexity(User aUser) throws PasswordToSimple {
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
        matcher = pattern.matcher(aUser.getPassword());
        boolean result = matcher.matches();
        if (result == false)
        {
            throw new PasswordToSimple(aUser);
        }
    }

    public void registerUser(User aUser) throws PasswordToSimple,UserAlreadyExists {
        checkComplexity(aUser);
        userXmlDAO.putUser(aUser);
    }

    public void authenticateUser(User aUser) throws UserNotFound, BadCredentialsPassed {
        User tmpUser = userXmlDAO.getUser(aUser.getLogin());
        if (tmpUser != null){
            if (tmpUser.getLogin().equals(aUser.getLogin())&& tmpUser.getPassword().equals(aUser.getPassword()))
                ;//System.out.println(aUser.getLogin()+" has been authenticated");
            else
                throw new BadCredentialsPassed(aUser);
            if (tmpUser.getLogin().equals(aUser.getLogin())&& !tmpUser.getPassword().equals(aUser.getPassword()))
                throw new UserNotFound(aUser.getLogin());
        }
        else
            throw new UserNotFound(aUser.getLogin());
    }
}


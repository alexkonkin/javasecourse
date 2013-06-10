import com.globallogic.javase.User;
import com.globallogic.javase.UserService;
import com.globallogic.javase.PasswordToSimple;
import com.globallogic.javase.UserNotFound;

public class Main {

    public static void main(String[] args) {
        System.out.println("the program is started");
        UserService aUserService = new UserService();
        User aUser1 = new User("user1","mkyong1A@");
        User aUser2 = new User("user2","aaaaaaaaa");


        //if(aUserService.registerUser(aUser1)!=true)
        //    System.out.println(aUser1.getLogin()+" the password is to simple");

        try{
            aUserService.registerUser(aUser1);
        }
        catch(PasswordToSimple e){
            e.toString();
        }

        //if(aUserService.registerUser(aUser2)!= true)
        //    System.out.println(aUser2.getLogin()+" the password is to simple");

        try{
            aUserService.registerUser(aUser2);
        }
        catch(PasswordToSimple e){
            System.out.println(e);
        }

        /*
        if(aUserService.authenticateUser(aUser1))
                System.out.println(aUser1.getLogin()+" has been authenticated");
            else
                System.out.println(aUser1.getLogin()+" has not found in user db");
        */

        try{
            aUserService.authenticateUser(aUser1);
            System.out.println(aUser1.getLogin()+" has been authenticated");
        }
        catch(UserNotFound e){
            System.out.println(e);
        }

        /*
        if(aUserService.authenticateUser(aUser2))
                System.out.println(aUser2.getLogin()+" has been authenticated");
            else
            System.out.println(aUser2.getLogin()+" has not found in user db");
        */
        try{
            aUserService.authenticateUser(aUser2);
            System.out.println(aUser2.getLogin()+" has been authenticated");
        }
        catch(UserNotFound e){
            System.out.println(e);
        }


    }
}
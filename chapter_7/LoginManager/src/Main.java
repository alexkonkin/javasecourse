import com.globallogic.javase.User;
import com.globallogic.javase.UserService;

public class Main {

    public static void main(String[] args) {
        System.out.println("the program is started");
        UserService aUserService = new UserService();
        User aUser1 = new User("user1","mkyong1A@");
        User aUser2 = new User("user2","aaaaaaaaa");


        if(aUserService.registerUser(aUser1)!=true)
            System.out.println(aUser1.getLogin()+" the password is to simple");

        if(aUserService.registerUser(aUser2)!= true)
            System.out.println(aUser2.getLogin()+" the password is to simple");

        if(aUserService.authenticateUser(aUser1))
                System.out.println(aUser1.getLogin()+" has been authenticated");
            else
                System.out.println(aUser1.getLogin()+" has not found in user db");

        if(aUserService.authenticateUser(aUser2))
                System.out.println(aUser2.getLogin()+" has been authenticated");
            else
            System.out.println(aUser2.getLogin()+" has not found in user db");

    }
}

import com.globallogic.javase.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("the program is started");
        UserService aUserService = new UserService();
        UserXmlService aUserXmlService = new UserXmlService("test_xml_db.xml");

        User aUser1 = new User("user1","mkyong1A@");
        User aUser2 = new User("user2","aaaaaaaaa");
        User aUser3 = new User("user1","mkyong2A@");

        //txt file related tests
        try{
            aUserService.registerUser(aUser1);
        }
        catch(PasswordToSimple e){
            System.out.println(e.toString());
        }
        catch(UserAlreadyExists e){
            System.out.println(e.toString());
        }

        try{
            aUserService.registerUser(aUser2);
        }
        catch(PasswordToSimple e){
            System.out.println(e);
        }
        catch(UserAlreadyExists e){
            System.out.println(e);
        }

        try{
            aUserService.authenticateUser(aUser1);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }

        try{
            aUserService.authenticateUser(aUser2);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }


        try{
            aUserService.authenticateUser(aUser3);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }

        //xml related tests
        try{
            aUserXmlService.registerUser(aUser1);
        }
        catch(PasswordToSimple e){
            System.out.println(e.toString());
        }
        catch(UserAlreadyExists e){
            System.out.println(e.toString());
        }

        try{
            aUserXmlService.registerUser(aUser2);
        }
        catch(PasswordToSimple e){
            System.out.println(e.toString());
        }
        catch(UserAlreadyExists e){
            System.out.println(e.toString());
        }

        try{
            aUserXmlService.authenticateUser(aUser1);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }

        try{
            aUserXmlService.authenticateUser(aUser2);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }

        try{
            aUserXmlService.authenticateUser(aUser3);
        }
        catch(UserNotFound e){
            System.out.println(e);
        }
        catch(BadCredentialsPassed e){
            System.out.println(e);
        }

    }
}
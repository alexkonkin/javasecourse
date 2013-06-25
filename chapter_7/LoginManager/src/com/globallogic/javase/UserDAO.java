package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 5/9/13
 * Time: 2:12 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

public class UserDAO implements AbstractDAO {
    private List<User> userDB = new ArrayList<User>();
    private String aDbFileName;
    UserDAO(/*User aUser*/){
        initUserStorage();
    }


    UserDAO(String aDbStorageName){
        aDbFileName = aDbStorageName;
        initUserStorage(aDbStorageName);
    }


    private void initUserStorage(){
        aDbFileName = "users.txt";
        boolean flag = false;

        File usersDB = new File(aDbFileName);
        try {
            if (!usersDB.exists())
                flag = usersDB.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);
        }
    }


    private void initUserStorage(String aDbStorageName){
        boolean flag = false;

        File usersDB = new File(aDbStorageName);
        try {
            if (!usersDB.exists())
                flag = usersDB.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);
        }
    }


    public User getUser(String aLogin){
        //Iterator<User> iterator = userDB.iterator();
        User aUser;
        User result = new User();
        try{
            BufferedReader in = new BufferedReader(new FileReader(aDbFileName));
            while (in.ready()) {
                String s = in.readLine();
                String[] uLogin = s.split(" ");
                if (uLogin[0].equals(aLogin)){
                    result.setLogin(uLogin[0]);
                    result.setPassword(uLogin[1]);
                    continue;
                }
            }
            in.close();
        }catch (IOException ioe) {
            System.out.println("Error while reading db file" + ioe);
        }
        if (result.getLogin().equals(""))
            return null;
        else
            return result;
    }

    public void putUser (User aUser) throws UserAlreadyExists{
        boolean result = false;
        if(getUser(aUser.getLogin()) == null){
            try{
                FileWriter fileWriter = new FileWriter(aDbFileName,true);
                BufferedWriter out = new BufferedWriter(fileWriter);
                fileWriter.append(aUser.getLogin()+" "+aUser.getPassword());
                out.newLine();
                out.close();
                result = true;
            }catch (IOException ioe) {
                System.out.println("Error while reading db file" + ioe);
            }
        }
        else{
            throw new UserAlreadyExists(aUser.getLogin());
        }
    }
}

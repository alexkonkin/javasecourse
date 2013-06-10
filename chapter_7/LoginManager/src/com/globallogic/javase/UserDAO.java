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

public class UserDAO {
    private List<User> userDB = new ArrayList<User>();

    UserDAO(User aUser){
        //daoUser = aUser;
        initUserStorage();
    }
    private void initUserStorage(){
        boolean flag = false;

        File usersDB = new File("users.txt");
        try {
            if (!usersDB.exists())
                flag = usersDB.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);
        }


        /*
        try {
            if (!usersDB.exists())
                flag = usersDB.createNewFile();


            BufferedWriter writer = new BufferedWriter(new FileWriter(usersDB));
            writer.write("ID, Date, Address, Body");
            writer.newLine();
            writer.write("ID, Date, Address, Body");
            writer.newLine();
            writer.flush();
            writer.close();
        } catch (IOException ioe) {
            System.out.println("Error while Creating File in Java" + ioe);
        }
        */
    }

    public User getUser(String aLogin){
        Iterator<User> iterator = userDB.iterator();
        User aUser;
        User result = new User();
        /*
        while(iterator.hasNext()){
            aUser = iterator.next();
            if (aUser.getLogin().equals(aLogin))
                result = aUser;
        }
        if (result.getLogin().equals(""))
            return null;
           else
            return result;
        */
        try{
            BufferedReader in = new BufferedReader(new FileReader("users.txt"));
            while (in.ready()) {
                String s = in.readLine();
                String[] uLogin = s.split(" ");
                if (uLogin[0].equals(aLogin)){
                    result.setLogin(uLogin[0]);
                    result.setPassword(uLogin[1]);
                    continue;
                }

                //System.out.println(s);

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

    public boolean putUser (User aUser){
        //return userDB.add(aUser);
        boolean result = false;
        if(getUser(aUser.getLogin()) == null){
            try{
                FileWriter fileWriter = new FileWriter("users.txt",true);
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
            System.out.println("The user with such password already exists in the database");
            result = false;
        }
        return result;
    }
}

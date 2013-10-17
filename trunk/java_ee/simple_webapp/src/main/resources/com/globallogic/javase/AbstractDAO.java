package com.globallogic.javase;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 6/25/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface AbstractDAO {
    public User getUser(String aLogin);
    public void putUser (User aUser) throws UserAlreadyExists;
}

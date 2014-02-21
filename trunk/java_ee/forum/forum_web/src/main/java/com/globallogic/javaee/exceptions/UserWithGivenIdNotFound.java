package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserWithGivenIdNotFound extends WebForumException {
    private Integer userId;

    public UserWithGivenIdNotFound(Integer anId){
        userId = anId;
    }

    public String toString(){
        return "User with id  "+ userId +" not found in the database";
    }

}

package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class MessageWithGivenIdNotFound extends WebForumException {
    private Integer messageId;

    public MessageWithGivenIdNotFound(Integer anId){
        messageId = anId;
    }

    public String toString(){
        return "Message with the given Id "+ messageId +" not found in the database";
    }

}

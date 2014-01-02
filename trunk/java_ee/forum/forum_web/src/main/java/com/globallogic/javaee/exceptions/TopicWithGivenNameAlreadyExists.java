package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopicWithGivenNameAlreadyExists extends WebForumException {
    private String topicName;

    public TopicWithGivenNameAlreadyExists(String aTopicName){
        topicName = aTopicName;
    }

    public String toString(){
        return "Topic with a given name "+ topicName +" already exists in the database";
    }

}

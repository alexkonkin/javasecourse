package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopicWithGivenNameNotFound extends WebForumException {
    private String topicName;

    public TopicWithGivenNameNotFound(String aTopicName){
        topicName = aTopicName;
    }

    public String toString(){
        return "Topic with a given name "+ topicName +" not found in the database";
    }

}

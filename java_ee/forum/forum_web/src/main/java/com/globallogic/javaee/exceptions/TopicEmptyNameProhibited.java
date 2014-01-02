package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopicEmptyNameProhibited extends WebForumException {
    private String topicName;

    public TopicEmptyNameProhibited(){
        ;
    }

    public String toString(){
        return "Topic with empty name prohibited. Please enter non-empty topic name";
    }

}

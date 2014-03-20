package com.globallogic.javaee.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 1/2/14
 * Time: 10:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class TopicWithGivenIdNotFound extends WebForumException {
    private Integer topicId;

    public TopicWithGivenIdNotFound(Integer anId){
        topicId = anId;
    }

    public String toString(){
        return "Topic with a given Id "+ topicId +" not found in the database";
    }

}

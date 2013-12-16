package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.model.Topic;

import java.util.List;

/**
 * Represents the services related with the Topic.
 */
public class TopicService
{
    private TopicDao topicDao;

    public void setTopicDao(TopicDao topicDao)
    {
        this.topicDao = topicDao;
    }

    /**
     * Returns all topics.
     */
    public List<Topic> findAllTopics()
    {
        return topicDao.findAllTopics();
    }

    public Integer createTopic(String topicName){
        return topicDao.createTopic(topicName);
    }

}

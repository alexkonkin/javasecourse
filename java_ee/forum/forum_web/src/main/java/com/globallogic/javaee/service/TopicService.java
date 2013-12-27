package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.model.Topic;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represents the services related with the Topic.
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
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

    public Integer createTopic(Topic aTopic){
        return topicDao.createTopic(aTopic);
    }

    public Topic getTopicById (Integer anId){
        return topicDao.getTopicById(anId);
    }

}

package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.Topic;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TopicDaoTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions("delete from TOPICS");
    }

    @Test
    public void testFindAllTopics_EmptyList()
    {
        List<Topic> allTopics = topicDao.findAllTopics();
        Assert.assertNotNull(allTopics);
        Assert.assertEquals(0, allTopics.size());
    }

    @Test
    public void testCreateAndFindAllTopics()
    {
        //Topic topic = new Topic();
        //topic.setName("NEWS");
        //topicDao.createTopic(topic);
        topicDao.createTopic("NEWS");

        List<Topic> allTopics = topicDao.findAllTopics();
        Assert.assertEquals(1, allTopics.size());

        Topic storedTopic = allTopics.get(0);
        Assert.assertEquals("NEWS", storedTopic.getName());
    }
}
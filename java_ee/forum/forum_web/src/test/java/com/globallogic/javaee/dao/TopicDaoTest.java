package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;

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
        Assert.assertTrue(allTopics.size() >= 0);
    }

    @Test
    public void testCreateAndFindAllTopics()
    {
        //Topic topic = new Topic();
        //topic.setName("NEWS");
        //topicDao.createTopic(topic);
        User aUser = new User();
        aUser.setId(0);
        aUser.setLogin("test");
        aUser.setPassword("123456");
        userDao.createUser(aUser);

        Topic aTopic = new Topic();
        aTopic.setId(0);
        aTopic.setName("NEWS");
        aTopic.setUser(aUser);
        topicDao.createTopic(aTopic);

        List<Topic> allTopics = topicDao.findAllTopics();
        Assert.assertTrue(allTopics.size() > 0);

        Topic storedTopic = allTopics.get(0);
        Assert.assertEquals("NEWS", storedTopic.getName());
    }
}
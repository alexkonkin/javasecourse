package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import java.sql.SQLException;
import java.util.List;

@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MessageDaoTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions(
                "delete from USERS",
                "insert into USERS (ID, LOGIN, PASSWORD) values (0,'PETYA','123456')",
                "insert into USERS (ID, LOGIN, PASSWORD) values (1,'VASYA','123456')",
                "insert into USERS (ID, LOGIN, PASSWORD) values (2,'SENYA','123456')");
        executeUpdateExpressions(
                "delete from TOPICS",
                "insert into TOPICS (ID,NAME) values (0,'NEWS')");
        executeUpdateExpressions("delete from MESSAGES");

    }

    @Test
    public void testFindAllMessages_EmptyList()
    {
        List<Message> allMessages = messageDao.findAllMessages();
        Assert.assertNotNull(allMessages);
        Assert.assertEquals(0, allMessages.size());
    }


    @Test
    public void testCreateMessage()
    {
        List<Topic> allTopics = topicDao.findAllTopics();
        List<User> allUsers = userDao.findAllUsers();

        Message aMessage = new Message();
        aMessage.setId(0);
        aMessage.setIdTopic(allTopics.get(0).getId());
        aMessage.setIdUser(allUsers.get(0).getId());
        aMessage.setContent("test content");
        Integer messageId = messageDao.createMessage(aMessage);
        Assert.assertNotNull(messageId);
    }

    @Test
    public void testGetMessageById()
    {
        List<Topic> allTopics = topicDao.findAllTopics();
        List<User> allUsers = userDao.findAllUsers();

        Message aMessage = new Message();
        aMessage.setId(0);
        aMessage.setIdTopic(allTopics.get(0).getId());
        aMessage.setIdUser(allUsers.get(0).getId());
        aMessage.setContent("test content");
        Integer messageId = messageDao.createMessage(aMessage);

        List<Message> allMessages = messageDao.findAllMessages();

        Message aTempMessage = new Message();
        aTempMessage = messageDao.getMessageById(allMessages.get(0).getId());

        Assert.assertEquals(allMessages.get(0).getId() , aTempMessage.getId());
    }

    @Test
    public void testGetMessagesByTopicId()
    {
        List<Topic> allTopics = topicDao.findAllTopics();
        List<User> allUsers = userDao.findAllUsers();

        Message aMessage = new Message();
        aMessage.setId(0);
        aMessage.setIdTopic(allTopics.get(0).getId());
        aMessage.setIdUser(allUsers.get(0).getId());
        aMessage.setContent("test content");
        Integer messageId = messageDao.createMessage(aMessage);

        List<Topic> allTopics1 = topicDao.findAllTopics();
        List<Message> allMessages = messageDao.getMessagesListByTopicId(allTopics1.get(0).getId());

        Assert.assertEquals("test content",allMessages.get(0).getContent());
    }


}
package com.globallogic.javaee.dao;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
public class MessageDaoTest extends AbstractTest
{

    @Before
    public void init() throws SQLException
    {
        /*
        executeUpdateExpressions(
                "delete from TOPICS",
                "delete from USERS",
                "insert into USERS (ID, LOGIN, PASSWORD) values (0,'PETYA','123456')",
                "insert into USERS (ID, LOGIN, PASSWORD) values (1,'VASYA','123456')",
                "insert into USERS (ID, LOGIN, PASSWORD) values (2,'SENYA','123456')");
        executeUpdateExpressions(
                "insert into TOPICS (ID,NAME, ID_USER) values (0,'NEWS',0)");
        executeUpdateExpressions("delete from MESSAGES");
        */


        executeUpdateExpressions(
                "delete from MESSAGES",
                "delete from TOPICS",
                "delete from USERS");


    }

    @Test
    public void testFindAllMessages_EmptyList()
    {
        List<Message> allMessages = messageDao.findAllMessages();
        Assert.assertNotNull(allMessages);
        Assert.assertEquals (0, allMessages.size());
    }


    @Test
    public void testCreateMessage()
    {

        User user = new User();
        user.setLogin("petya");
        user.setPassword("123456");
        userDao.createUser(user);

        Topic topic = new Topic();
        topic.setName("NEWS");
        topic.setUser(user);
        topicDao.createTopic(topic);

        Message aMessage = new Message();
        aMessage.setId(0);

        aMessage.setUser(user);
        aMessage.setTopic(topic);

        aMessage.setContent("test content");

        Integer messageId = messageDao.createMessage(aMessage);

        Assert.assertNotNull(messageId);
    }

    @Test
    public void testCreateMessageExistingUserAndTopic()
    {
        User user = new User();
        user.setLogin("petya");
        user.setPassword("123456");
        userDao.createUser(user);

        Topic topic = new Topic();
        topic.setName("NEWS");
        topic.setUser(user);
        topicDao.createTopic(topic);


        User user1 = userService.findAllUsers().get(0);
        Topic topic1 = topicService.findAllTopics().get(0);

        Message aMessage = new Message();
        aMessage.setId(0);

        aMessage.setUser(user1);
        aMessage.setTopic(topic1);

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

        //aMessage.setUser(allUsers.get(0));
        //aMessage.setTopic(allTopics.get(0));

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
        User user = new User();
        user.setLogin("petya");
        user.setPassword("123456");
        userDao.createUser(user);

        Topic topic = new Topic();
        topic.setName("NEWS");
        topic.setUser(user);
        topicDao.createTopic(topic);


        User user1 = userService.findAllUsers().get(0);
        Topic topic1 = topicService.findAllTopics().get(0);

        Message aMessage = new Message();
        aMessage.setId(0);

        aMessage.setUser(user1);
        aMessage.setTopic(topic1);

        aMessage.setContent("test content");
        messageDao.createMessage(aMessage);


        List<Topic> allTopics1 = topicDao.findAllTopics();
        //List<Message> allMessages = messageDao.getMessagesListByTopicId(allTopics1.get(0));
        List<Message> allMessages = messageService.getMessageByTopicId(allTopics1.get(0));
        User user2 = new User();
        user2 = allMessages.get(0).getUser();
        Topic topic2 = allMessages.get(0).getTopic();

        Assert.assertEquals("test content",allMessages.get(0).getContent());
        Assert.assertEquals("petya",user2.getLogin());
        Assert.assertEquals("NEWS",topic2.getName());
    }


}
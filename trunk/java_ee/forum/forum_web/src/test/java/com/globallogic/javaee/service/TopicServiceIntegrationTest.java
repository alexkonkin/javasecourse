package com.globallogic.javaee.service;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/applicationContext.xml")
//@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class TopicServiceIntegrationTest extends AbstractTest {

    //@Resource
    //TopicService topicService;

    @Before
    public void init() throws SQLException
    {
        //executeUpdateExpressions("delete from MESSAGES",
        //        "delete from TOPICS");
    }

    @Test
    public void TopicServiceNotNullTest(){
        assertNotNull(topicService);
    }

    @Test
    public void TopicDaoNotNullTest(){
        //topicService.createTopic("NEWS");
        //at this point the list should be empty because all records are deleted, however it should not
        //be equal to NULL
        List<Topic> topicsList = topicService.findAllTopics();
        assertEquals(0, topicsList.size());
    }

    @Test
    public void CreateTopicTest(){
        User aUser = new User();
        aUser.setId(0);
        aUser.setLogin("test");
        aUser.setPassword("123456");
        try {
            userService.register(aUser);
        } catch (ServiceException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        /*
        Topic aTopic = new Topic();
        aTopic.setUser(aUser);

        topicService.createTopic(aTopic);
        List<Topic> topicsList = topicService.findAllTopics();
        assertEquals("NEWS", topicsList.get(0).getName());
        */
    }
}
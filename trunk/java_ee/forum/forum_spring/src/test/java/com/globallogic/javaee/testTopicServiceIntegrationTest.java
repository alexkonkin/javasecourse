package com.globallogic.javaee;

import com.globallogic.javaee.AbstractTest;
import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.service.TopicService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;


import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
public class testTopicServiceIntegrationTest extends AbstractTest {

    @Before
    public void init() throws SQLException
    {
        executeUpdateExpressions("delete from TOPICS");
    }

    @Autowired
    private TopicDao topicDAO;

    /*
    @Test
    public void testGetAllTopics() {
        List<Topic> topicsList = topicDAO.findAllTopics();
        assertNotNull(topicsList.get(0));
    }


    @Test
    public void testCreateTopic()
    {
        //Topic aTopic = new Topic();
        //aTopic.setName("New topic");
        //Integer key = topicDAO.createTopic(aTopic);
        Integer key = topicDAO.createTopic("New Topic");
        assertNotNull(key.intValue());
    }
    */

    @Test
    public void testTopicService(){
        TopicService topicService = new TopicService();
        topicService.setTopicDao(topicDAO);
        topicService.createTopic("NEWS");
        List<Topic> topicsList = topicDAO.findAllTopics();
        assertEquals("NEWS", topicsList.get(0).getName());
    }

}
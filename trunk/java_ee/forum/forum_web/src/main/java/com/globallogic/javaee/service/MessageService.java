package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.MessageDao;
import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represents the services related with the User.
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class MessageService
{
    //@Autowired
    //private MessageDao messageDao;
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao)
    {
        this.messageDao = messageDao;
    }

    /**
     * Returns all users.
     */
    public List<Message> findAllMessages()
    {
        return messageDao.findAllMessages();
    }

    public Message getMessageById (Integer anId){
        return messageDao.getMessageById(anId);
    }

    public List<Message> getMessageByTopicId (Topic aTopic){
        return messageDao.getMessagesListByTopicId(aTopic);
    }

    public int createMessage(Message aMessage){
        return messageDao.createMessage(aMessage);
    }

    public int deleteMessagesByTopicId (Integer aTopicId){
        return messageDao.deleteMessagesByTopicId(aTopicId);
    }

    public int deleteMessageById (Integer aMessageId){
        return messageDao.deleteMessagesById(aMessageId);
    }
}

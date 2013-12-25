package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.MessageDao;
import com.globallogic.javaee.model.Message;

import java.util.List;

/**
 * Represents the services related with the User.
 */
public class MessageService
{
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

    public List<Message> getMessageByTopicId (Integer aTopicId){
        return messageDao.getMessagesListByTopicId(aTopicId);
    }

}

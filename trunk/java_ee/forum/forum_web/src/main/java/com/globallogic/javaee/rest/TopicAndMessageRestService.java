package com.globallogic.javaee.rest;

import com.globallogic.javaee.dto.*;
import com.globallogic.javaee.dto.User;
import com.globallogic.javaee.exceptions.*;
import com.globallogic.javaee.model.*;
import com.globallogic.javaee.model.Message;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.service.MessageService;
import com.globallogic.javaee.service.TopicService;
import com.globallogic.javaee.service.UserRolesService;
import com.globallogic.javaee.service.UserService;
import com.sun.jersey.api.core.InjectParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.List;

@Path("/topics")
@Component
@Produces(MediaType.APPLICATION_XML)
public class TopicAndMessageRestService {
    @InjectParam
    TopicService topicService;
    @InjectParam
    MessageService messageService;
    @InjectParam
    UserService userService;

    @GET
    @Path("/")
    public Response getAllTopics() {
        List<Topic> aTopics = topicService.findAllTopics();
        System.out.println(aTopics.size());

        Forum aForum = new Forum();
        Topics aDtoTopics = new Topics();

        for (int i = 0; i< aTopics.size(); i++){
            com.globallogic.javaee.dto.Topic aDtoTopic = new com.globallogic.javaee.dto.Topic();
            aDtoTopic.setTopicId(BigInteger.valueOf(aTopics.get(i).getId()));
            aDtoTopic.setTopicName(aTopics.get(i).getName());
            aDtoTopics.addTopic(aDtoTopic);
        }


        aForum.setTopics(aDtoTopics);
        return Response.status(200).entity(aForum).build();

    }


    @GET
    @Path("/{topicId}")
    public Response getTopicById(@PathParam("topicId") Integer topicId) {

        Topic aTopic = null;
        try {
            aTopic = topicService.getTopicById(topicId);
        } catch (TopicWithGivenIdNotFound userWithGivenIdNotFound) {
            String output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified Id : " +topicId+ " not found in the database</message>";
            return Response.status(404).entity(output).build();
        }

        com.globallogic.javaee.dto.User aDtoUser = new com.globallogic.javaee.dto.User();
        com.globallogic.javaee.dto.Topic aDtoTopic = new com.globallogic.javaee.dto.Topic();

        aDtoUser.setLogin(aTopic.getUser().getLogin());
        aDtoUser.setUserId(BigInteger.valueOf(aTopic.getUser().getId()));
        aDtoUser.setEnabled(aTopic.getUser().getEnabled());

        aDtoTopic.setTopicId(BigInteger.valueOf(aTopic.getId()));
        aDtoTopic.setTopicName(aTopic.getName());
        aDtoTopic.setUser(aDtoUser);
        return Response.status(200).entity(aDtoTopic).build();
    }

    @GET
    @Path("/{topicId}/messages/")
    public Response getAllMessagesByTopicId(@PathParam("topicId") Integer topicId) {

        Topic aTopic = null;
        try {
            aTopic = topicService.getTopicById(topicId);
        } catch (TopicWithGivenIdNotFound userWithGivenIdNotFound) {
            String output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified Id : " +topicId+ " not found in the database</message>";
            return Response.status(404).entity(output).build();
        }

        List<Message> aMessages = messageService.getMessageByTopicId(aTopic);

        com.globallogic.javaee.dto.Messages aDtoMessages = new com.globallogic.javaee.dto.Messages();
        com.globallogic.javaee.dto.Topic aDtoTopic = new com.globallogic.javaee.dto.Topic();

        for (int i = 0; i< aMessages.size(); i++){
            com.globallogic.javaee.dto.Message aDtoMessage = new com.globallogic.javaee.dto.Message();
            com.globallogic.javaee.dto.User aDtoUser = new com.globallogic.javaee.dto.User();
            aDtoUser.setLogin(aMessages.get(i).getUser().getLogin());
            aDtoUser.setUserId(BigInteger.valueOf(aMessages.get(i).getUser().getId()));
            aDtoUser.setEnabled(aMessages.get(i).getUser().getEnabled());

            aDtoMessage.setMessageId(BigInteger.valueOf(aMessages.get(i).getId()));
            aDtoMessage.setText(aMessages.get(i).getContent());
            aDtoMessage.setUser(aDtoUser);
            aDtoMessages.setMessage(aDtoMessage);
        }
        return Response.status(200).entity(aDtoMessages).build();
    }



    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putTopic(com.globallogic.javaee.dto.Topic aDtoTopic) {
        Topic aDaoTopic = new Topic();
        com.globallogic.javaee.model.User aDaoUser = new com.globallogic.javaee.model.User();

        try {
            aDaoUser = userService.findUserById(aDtoTopic.getUser().getUserId().intValue());
        } catch (UserWithGivenIdNotFound userWithGivenIdNotFound) {
            userWithGivenIdNotFound.printStackTrace();
        }

        aDaoUser.setId(aDtoTopic.getUser().getUserId().intValue());

        aDaoTopic.setUser(aDaoUser);
        aDaoTopic.setName(aDtoTopic.getTopicName());

        String output = new String();
        Integer responseCode = 0;
        try {
            topicService.getTopicByName(aDtoTopic.getTopicName());
        } catch (TopicWithGivenNameNotFound topicWithGivenNameNotFound) {
            topicService.createTopic(aDaoTopic);
            output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified name successfully created</message>";
            responseCode = 200;
        } catch (TopicWithGivenNameAlreadyExists topicWithGivenNameAlreadyExists) {
            output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified name already exists</message>";
            responseCode = 400;
        } catch (TopicEmptyNameProhibited topicEmptyNameProhibited) {
            output = "<?xml version=\"1.0\"?>" + "<message> Creation of Topic with an empty name prohibited</message>";
            responseCode = 400;
        }

        return Response.status(responseCode).entity(output).build();
    }

    @DELETE
    @Path("/{topicId}")
    public Response deleteTopicWithId(@PathParam("topicId") Integer topicId) {
        Topic aTopic = new Topic();
        try {
            aTopic = topicService.getTopicById(topicId);
        } catch (TopicWithGivenIdNotFound topicWithGivenIdNotFound) {
            topicWithGivenIdNotFound.printStackTrace();
        }

        List<Message> aMessagesList =  messageService.getMessageByTopicId(aTopic);

        String output = new String();
        Integer responseCode = 0;
        if(aMessagesList.size() == 0){
            topicService.deleteTopicById(topicId);
            output = "<?xml version=\"1.0\"?>" + "<message> Topic "+aTopic.getName()+" has been successfully deleted</message>";
            responseCode = 200;
        }
        else{
            output = "<?xml version=\"1.0\"?>" + "<message> Topic has the nested messages. Delete the nested messages before deleting this topic</message>";
            responseCode = 400;
        }
        return Response.status(responseCode).entity(output).build();
    }

    @PUT
    @Path("/{topicId}/messages")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putMessage(@PathParam("topicId") Integer topicId,com.globallogic.javaee.dto.Message aDtoMessage) {
        Message aDaoMessage = new Message();
        com.globallogic.javaee.model.User aDaoUser = new com.globallogic.javaee.model.User();
        com.globallogic.javaee.model.Topic aDaoTopic = new com.globallogic.javaee.model.Topic();

        String output = new String();
        Integer responseCode = 0;

        try {
            aDaoUser = userService.findUserById(aDtoMessage.getUser().getUserId().intValue());
        } catch (UserWithGivenIdNotFound userWithGivenIdNotFound) {
            output = "<?xml version=\"1.0\"?>" + "<message> User with specified Id "+aDaoMessage.getUser().getId()+" has not found in the database</message>";
            responseCode = 404;
        }

        try {
            aDaoTopic = topicService.getTopicById(topicId);
        } catch (TopicWithGivenIdNotFound topicWithGivenIdNotFound) {
            output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified Id "+topicId+" has not found in the database</message>";
            responseCode = 404;
        }

        aDaoMessage.setUser(aDaoUser);
        aDaoMessage.setTopic(aDaoTopic);
        aDaoMessage.setContent(aDtoMessage.getText());

        Integer messageId = messageService.createMessage(aDaoMessage);

        output = "<?xml version=\"1.0\"?>" + "<message> Message with Id "+messageId+" has been added to the database</message>";
        responseCode = 200;

        return Response.status(responseCode).entity(output).build();
    }

}

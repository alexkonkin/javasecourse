package com.globallogic.javaee.rest;

import com.globallogic.javaee.dto.*;
import com.globallogic.javaee.dto.User;
import com.globallogic.javaee.exceptions.TopicWithGivenIdNotFound;
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
public class TopicRestService {
    @InjectParam
    TopicService topicService;
    @InjectParam
    MessageService messageService;

    @GET
    @Path("/")
    public Response getAllTopics() {
        List<Topic> aTopics = topicService.findAllTopics();
        System.out.println(aTopics.size());

        Forum aForum = new Forum();
        Topics aDtoTopics = new Topics();

        System.out.println("number of topics is "+ aTopics.size());

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
    public Response getMessagesByTopicId(@PathParam("topicId") Integer topicId) {

        Topic aTopic = null;
        try {
            aTopic = topicService.getTopicById(topicId);
        } catch (TopicWithGivenIdNotFound userWithGivenIdNotFound) {
            String output = "<?xml version=\"1.0\"?>" + "<message> Topic with specified Id : " +topicId+ " not found in the database</message>";
            return Response.status(404).entity(output).build();
        }

        List<Message> aMessages = messageService.getMessageByTopicId(aTopic);
        System.out.println("number of messages is "+aMessages.size());

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


    /*
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_XML)
    public Response putUserById(com.globallogic.javaee.dto.User aUser) {
        //String inputXmlString = new Scanner(input,"UTF-8").useDelimiter("\\A").next();
        Roles aDtoRoles = aUser.getRoles();
        String output = "";
        Integer statusCode = 0;
        if (aDtoRoles == null){
            output = "<?xml version=\"1.0\"?>" + "<message> PUT method : please add roles to the user's description</message>";
            statusCode = 404;
        }
        else
        if(aDtoRoles.size() > 0){
            User daoUser = new User();
            daoUser.setEnabled(aUser.isEnabled());
            daoUser.setLogin(aUser.getLogin());
            daoUser.setPassword(aUser.getPassword());
            userService.register(daoUser);

            User addedUser = userService.findUserByLoginPassword(daoUser);

            UserRoles aUserRoles = new UserRoles();

            for (int userRoles = 0; userRoles < aDtoRoles.size(); userRoles++){
                aUserRoles.setRole(aDtoRoles.getRole(userRoles).getRoleName());
                aUserRoles.setUser(addedUser);
                userRolesService.createUserRole(aUserRoles);
            }
            output = "<?xml version=\"1.0\"?>" + "<message> User with login " + aUser.getLogin() + " successfully added to the database</message>";
            statusCode = 200;
        }
        return Response.status(statusCode).entity(output).build();
    }

    @POST
    @Path("/{userId}")
    @Consumes(MediaType.APPLICATION_XML)
    public Response manageUserById(@PathParam("userId") Integer userId, @QueryParam("isEnabled") Boolean isEnabled) {
        //http://localhost:8181/rest/users/11?isEnabled=true
        User daoUser = new User();
        try {
            daoUser = userService.findUserById(userId);
        } catch (UserWithGivenIdNotFound userWithGivenIdNotFound) {
            return Response.status(404).entity("<error>User with given indentified not found</error>").build();
        }
        daoUser.setEnabled(isEnabled);
        userService.setAccountStatus(daoUser);
        return Response.status(201).entity("<message>User with login"+daoUser.getLogin()+" enabled status is "+daoUser.getEnabled()+"</message>").build();
    }
    */
}

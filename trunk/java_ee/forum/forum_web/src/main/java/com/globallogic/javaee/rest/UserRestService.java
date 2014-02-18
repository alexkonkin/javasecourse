package com.globallogic.javaee.rest;

import com.globallogic.javaee.dto.*;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import com.globallogic.javaee.service.UserRolesService;
import com.globallogic.javaee.service.UserService;
import com.sun.jersey.api.core.InjectParam;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Path("/users")
@Component
@Produces(MediaType.APPLICATION_XML)
public class UserRestService {
    @InjectParam
    UserService userService;
    @InjectParam
    UserRolesService userRolesService;

    @GET
    @Path("/")
    public Response getAllUsers() {
        List<User> aUsers = userService.findAllUsers();
        System.out.println(aUsers.size());

        Forum aForum = new Forum();
        Users aDtoUsers = new Users();

        System.out.println("number of users is "+ aUsers.size());

        Roles aDtoRoles;
        for (int i = 0; i< aUsers.size(); i++){
            com.globallogic.javaee.dto.User aDtoUser = new com.globallogic.javaee.dto.User();
            aDtoUser.setUserId(BigInteger.valueOf(aUsers.get(i).getId()));
            aDtoUser.setLogin(aUsers.get(i).getLogin());
            aDtoUser.setPassword(aUsers.get(i).getPassword());
            aDtoUser.setEnabled(aUsers.get(i).getEnabled());

            aDtoRoles = new Roles();
            List<UserRoles> aUserRoles = userRolesService.getUserRolesByUserId(aUsers.get(i));

            for (int m = 0; m < aUserRoles.size(); m++){
                Role aDtoRole = new Role();
                aDtoRole.setRoleId(BigInteger.valueOf(aUserRoles.get(m).getId()));
                aDtoRole.setRoleName(aUserRoles.get(m).getRole());
                aDtoRoles.setOneRole(aDtoRole);
            }
            aDtoUser.setRoles(aDtoRoles);
            aDtoUsers.setUser(aDtoUser);
        }
        aForum.setUsers(aDtoUsers);
        //String output = "<?xml version=\"1.0\"?>" + "<user>" +userId+ "</user>";

        ForumWebXmlProcessor aForumWebXmlProcessor = new ForumWebXmlProcessor(aForum);
        String output = aForumWebXmlProcessor.marshalToXmlString();

        System.out.println("output : "+ output);


        return Response.status(200).entity(output).build();

    }

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer userId) {
        User aUser = userService.findUserById(userId);
        List<UserRoles> aUserRoles = userRolesService.getUserRolesByUserId(aUser);

        System.out.println(aUser.getLogin());

        Forum aForum = new Forum();
        Users aUsers = new Users();
        com.globallogic.javaee.dto.User aDtoUser = new com.globallogic.javaee.dto.User();

        aDtoUser.setLogin(aUser.getLogin());
        aDtoUser.setPassword(aUser.getPassword());
        aDtoUser.setEnabled(aUser.getEnabled());
        aDtoUser.setUserId(BigInteger.valueOf(aUser.getId()));
        Roles aDtoRoles = new Roles();
        for (int i = 0; i< aUserRoles.size(); i++){
            Role aDtoRole = new Role();
            aDtoRole.setRoleId(BigInteger.valueOf(aUserRoles.get(i).getId()));
            aDtoRole.setRoleName(aUserRoles.get(i).getRole());
            aDtoRoles.setOneRole(aDtoRole);
        }

        aDtoUser.setRoles(aDtoRoles);
        aUsers.setUser(aDtoUser);
        aForum.setUsers(aUsers);
        //String output = "<?xml version=\"1.0\"?>" + "<user>" +userId+ "</user>";

        ForumWebXmlProcessor aForumWebXmlProcessor = new ForumWebXmlProcessor(aForum);
        String output = aForumWebXmlProcessor.marshalToXmlString();

        System.out.println("output : "+ output);

        return Response.status(200).entity(output).build();

    }



    /*
    public void setUserService(UserService userService) {
        this.usrService = userService;
    }
    */
}
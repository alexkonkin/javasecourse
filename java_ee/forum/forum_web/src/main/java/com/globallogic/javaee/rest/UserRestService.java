package com.globallogic.javaee.rest;

import com.globallogic.javaee.dto.*;
import com.globallogic.javaee.exceptions.UserWithGivenIdNotFound;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import com.globallogic.javaee.service.UserRolesService;
import com.globallogic.javaee.service.UserService;
import com.sun.jersey.api.core.InjectParam;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
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
        return Response.status(200).entity(aForum).build();
    }

    @GET
    @Path("/{userId}")
    public Response getUserById(@PathParam("userId") Integer userId) {

        User aUser = null;
        try {
            aUser = userService.findUserById(userId);
        } catch (UserWithGivenIdNotFound userWithGivenIdNotFound) {
            String output = "<?xml version=\"1.0\"?>" + "<message> User with specified Id : " +userId+ " not found in the database</message>";
            return Response.status(404).entity(output).build();
        }

        List<UserRoles> aUserRoles = userRolesService.getUserRolesByUserId(aUser);

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
        return Response.status(200).entity(aDtoUser).build();
    }

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

}
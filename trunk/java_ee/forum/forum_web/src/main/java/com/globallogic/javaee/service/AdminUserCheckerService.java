package com.globallogic.javaee.service;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/5/14
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */

//public class AdminUserCheckerService {
//}

import com.globallogic.javaee.exceptions.UserWithGivenLoginAlreadyExists;
import com.globallogic.javaee.exceptions.UserWithGivenLoginNotFound;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

public class AdminUserCheckerService
{
    String login;
    String password;
    Boolean enabled;
    List<String> roles;
    UserService usrService;
    UserRolesService usrRolesService;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setRoles(List<String> roles){
        this.roles = roles;
    }

    public List<String> getRoles (){
        return roles;
    }

    public void setUserService(UserService userService) {
        usrService = userService;
    }

    public void setUserRolesService(UserRolesService userRolesService) {
        usrRolesService = userRolesService;
    }

    @PostConstruct
    public void init() throws Exception {

        System.out.println("Init method after properties are set : " + login);
        System.out.println("Init method after properties are set : " + roles.get(0).toString());
        System.out.println("Init method after properties are set : " + roles.get(1).toString());

        try {
            usrService.findUserByLogin(login);
        } catch (UserWithGivenLoginNotFound userWithGivenLoginNotFound) {
            User adminUser = new User();
            adminUser.setLogin(login);
            adminUser.setPassword(password);
            adminUser.setEnabled(true);
            usrService.register(adminUser);

            UserRoles aUserRoles1 = new UserRoles();
            aUserRoles1.setUser(adminUser);
            aUserRoles1.setRole(roles.get(0).toString());
            usrRolesService.createUserRole(aUserRoles1);

            UserRoles aUserRoles2 = new UserRoles();
            aUserRoles2.setUser(adminUser);
            aUserRoles2.setRole(roles.get(1).toString());
            usrRolesService.createUserRole(aUserRoles2);

        } catch (UserWithGivenLoginAlreadyExists userWithGivenLoginAlreadyExists) {
            System.out.println("admin's mandatory account is checked and present in the database");
        }

    }

    @PreDestroy
    public void cleanUp() throws Exception {
        System.out.println("Spring Container is destroy! Customer clean up");
    }
}
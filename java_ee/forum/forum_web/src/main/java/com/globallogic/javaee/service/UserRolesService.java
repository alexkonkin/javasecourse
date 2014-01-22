package com.globallogic.javaee.service;

import com.globallogic.javaee.dao.TopicDao;
import com.globallogic.javaee.dao.UserRolesDao;
import com.globallogic.javaee.exceptions.TopicEmptyNameProhibited;
import com.globallogic.javaee.exceptions.TopicWithGivenNameAlreadyExists;
import com.globallogic.javaee.exceptions.TopicWithGivenNameNotFound;
import com.globallogic.javaee.model.Topic;
import com.globallogic.javaee.model.User;
import com.globallogic.javaee.model.UserRoles;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Represents the services related with the Topic.
 */

@Transactional(propagation= Propagation.REQUIRED, readOnly=false)
public class UserRolesService
{
    private UserRolesDao userRolesDao;

    public void setUserRolesDao(UserRolesDao userRolesDaoDao)
    {
        this.userRolesDao = userRolesDaoDao;
    }

    /**
     * Returns all topics.
     */
    public List<UserRoles> findAllUserRoles()
    {
        return userRolesDao.findAllUserRoles();
    }

    public Integer createUserRole(UserRoles aUserRoles){
        return userRolesDao.createUserRoles(aUserRoles);
    }

    public List<UserRoles> getUserRolesByUserId (User aUser){
        return userRolesDao.getUserRoleByUserId(aUser);
    }

    //TODO
    // implement getUserRolesByUserLogin

}

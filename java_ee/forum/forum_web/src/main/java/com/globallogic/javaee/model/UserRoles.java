package com.globallogic.javaee.model;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Contains user data.
 */

@Entity(name = "USER_ROLES")
@Proxy(lazy=false)
public class UserRoles
{


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_user_roles_seq")
    @SequenceGenerator(name="id_user_roles_seq", sequenceName="id_user_roles_seq", allocationSize=1)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER")
    private User user;
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name="role")
    private String role;

    /**
     * Returns user name. Every user must have unique name.
     */
    public String getRole()
    {
        return role;
    }

    /**
     * Sets user name. Every user must have unique name.
     */
    public void setRole(String role)
    {
        this.role = role;
    }
}

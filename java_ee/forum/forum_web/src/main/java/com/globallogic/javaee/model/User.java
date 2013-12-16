package com.globallogic.javaee.model;

import javax.persistence.*;

/**
 * Contains user data.
 */
@Entity(name = "USERS")
public class User
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_seq")
    @SequenceGenerator(name="id_seq", sequenceName="id_seq", allocationSize=1)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    private String login;

    /**
     * Returns user name. Every user must have unique name.
     */
    public String getLogin()
    {
        return login;
    }

    /**
     * Sets user name. Every user must have unique name.
     */
    public void setLogin(String login)
    {
        this.login = login;
    }

    @Column
    private String password;

    /**
     * Returns user name. Every user must have unique name.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets user name. Every user must have unique name.
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

}

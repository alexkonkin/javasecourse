package com.globallogic.javaee.model;

import org.hibernate.annotations.Proxy;

import javax.annotation.Resource;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains user data.
 */
@Entity(name = "USERS")
@Proxy(lazy=false)
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


    //	@OneToMany(fetch=FetchType.LAZY, targetEntity=Book.class, cascade=CascadeType.ALL)
    //@JoinColumn(name = "book_studentid", referencedColumnName="studentid")
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "USERS", targetEntity = Topic.class)
    //@JoinColumn(name = "id", referencedColumnName="user_id")

    /*
    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "user")
    private Set<Topic> Topics;
    public Set<Topic> getTopics() {
        return this.Topics;
    }

    public void setTopics(Set<Topic> Topics) {
        this.Topics = Topics;
    }


    @OneToMany(fetch = FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "user")
    private Set<Message> Messages;

    public Set<Message> getMessages() {
        return this.Messages;
    }

    public void setMessages(Set<Message> Messages) {
        this.Messages = Messages;
    }
    */
}

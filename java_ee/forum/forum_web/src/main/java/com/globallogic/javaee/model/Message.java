package com.globallogic.javaee.model;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 12/3/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
import javax.persistence.*;

/**
 * Contains user data.
 */
@Entity(name = "MESSAGES")
public class Message
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_msg_seq")
    @SequenceGenerator(name="id_msg_seq", sequenceName="id_msg_seq", allocationSize=1)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    @Column(name = "id_topic")
    private int id_topic;

    public int getIdTopic() {
        return id_topic;
    }

    public void setIdTopic(int id_topic) {
        this.id = this.id_topic;
    }

    @Column(name = "id_user")
    private int id_user;

    public int getIdUser() {
        return id_user;
    }

    public void setIdUser(int id_user) {
        this.id = id_user;
    }
    */

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER")
    private User user;
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_TOPIC")
    private Topic topic;
    public Topic getTopic() {
        return this.topic;
    }


    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Column(name="content")
    private String content;

    /**
     * Returns user name. Every user must have unique name.
     */
    public String getContent()
    {
        return content;
    }

    /**
     * Sets user name. Every user must have unique name.
     */
    public void setContent(String content)
    {
        this.content = content;
    }
}

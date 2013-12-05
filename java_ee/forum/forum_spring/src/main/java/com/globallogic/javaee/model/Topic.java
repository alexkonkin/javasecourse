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
@Entity(name = "TOPICS")
public class Topic
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="id_topic_seq")
    @SequenceGenerator(name="id_topic_seq", sequenceName="id_topic_seq", allocationSize=1)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column
    private String name;

    /**
     * Returns user name. Every user must have unique name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets user name. Every user must have unique name.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}

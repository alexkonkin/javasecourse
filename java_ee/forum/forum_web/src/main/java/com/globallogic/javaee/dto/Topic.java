//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.13 at 04:40:37 PM EET 
//


package com.globallogic.javaee.dto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}topic_name" maxOccurs="unbounded"/>
 *         &lt;element ref="{}user" maxOccurs="unbounded"/>
 *         &lt;element ref="{}messages" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="topic_id" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "topicName",
    "user",
    "messages"
})
@XmlRootElement(name = "topic")
public class Topic {

    @XmlElement(name = "topic_name", required = true)
    protected String topicName;
    @XmlElement(required = true)
    protected User user;
    protected List<Messages> messages;
    @XmlAttribute(name = "topic_id")
    protected BigInteger topicId;

    /**
     * Gets the value of the topicName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the topicName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTopicName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public String getTopicName() {
        if (topicName == null) {
            topicName = new String();
        }
        return this.topicName;
    }

    public void setTopicName(String aTopicName){
        this.topicName = aTopicName;
    }

    /**
     * Gets the value of the user property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the user property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUser().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link User }
     * 
     * 
     */
    public User getUser() {
        if (user == null) {
            user = new User();
        }
        return this.user;
    }

    public void setUser(User aUser) {
        if (user == null) {
            user = new User();
        }
        this.user = aUser;
    }


    /**
     * Gets the value of the messages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Messages }
     * 
     * 
     */
    public List<Messages> getMessages() {
        if (messages == null) {
            messages = new ArrayList<Messages>();
        }
        return this.messages;
    }

    /**
     * Gets the value of the topicId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTopicId() {
        return topicId;
    }

    /**
     * Sets the value of the topicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTopicId(BigInteger value) {
        this.topicId = value;
    }

}

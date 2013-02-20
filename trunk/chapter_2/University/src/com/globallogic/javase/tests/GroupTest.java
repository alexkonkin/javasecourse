package com.globallogic.javase.tests;

import com.globallogic.javase.university.businessObjects.Group;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 3:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroupTest {
    Group aGroup = new Group();
    Group aGroupTwoParams = new Group(1,"GL");

    @Test
    public void testSetGroupId() throws Exception {
        aGroup.setGroupId(10);
        assertEquals(10,(int)aGroup.getGroupId());
    }

    @Test
    public void testSetGroupName() throws Exception {
        aGroup.setGroupName("LG");
        assertEquals("LG",aGroup.getGroupName());
    }

    @Test
    public void testGroupName() throws Exception {
        assertEquals(0,(int)aGroup.getGroupId());
        assertEquals("-",aGroup.getGroupName());
    }

    @Test
    public void testGroupNameTwoParams() throws Exception {
        assertEquals(1,(int)aGroupTwoParams.getGroupId());
        assertEquals("GL",aGroupTwoParams.getGroupName());
    }

}

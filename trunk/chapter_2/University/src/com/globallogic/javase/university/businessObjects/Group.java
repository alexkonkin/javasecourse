package com.globallogic.javase.university.businessObjects;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Group {
    private Integer groupId;
    private String groupName;

    public Group(){
        groupId = 0;
        groupName = "-";
    }

    public Group(Integer gId, String gName){
        groupId = gId;
        groupName = gName;
    }

    public void setGroupId(Integer gId){
        groupId = gId;
    }

    public void setGroupName(String gName){
        groupName = gName;
    }

    public Integer getGroupId(){
        return groupId;
    }

    public String getGroupName(){
        return groupName;
    }

}

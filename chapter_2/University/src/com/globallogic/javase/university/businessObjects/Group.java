package com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.staff.Student;

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
    private Student[] studentsFile;

    public Group(){
        groupId = 0;
        groupName = "-";
        studentsFile = new Student[10];
        /*
        for(int i = 0; i < studentsFile.length ; i++)
            studentsFile[i] = new Student();
        */
    }

    public Group(Integer gId, String gName){
        groupId = gId;
        groupName = gName;
        studentsFile = new Student[10];
        /*
        for(int i = 0; i < studentsFile.length ; i++)
            studentsFile[i] = new Student();
        */
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

    public Student getStudent(Integer stId){
        return this.studentsFile[stId];
    }

    public void setStudent(Integer stId, Student aStudent){
        this.studentsFile[stId] = aStudent;
    }

    public Integer getStudentsCount(){
        return studentsFile.length;
    }

    public void delStudent(Integer stId){
        studentsFile[stId] = null;
    }

    public boolean isThePlaceEmpty(Integer stId){
        if(studentsFile[stId] == null)
                return true;
            else
                return false;
    }

}

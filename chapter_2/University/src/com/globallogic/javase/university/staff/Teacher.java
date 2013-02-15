package com.globallogic.javase.university.staff;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Teacher {
    private Integer teacherId;

    public Teacher(){
        teacherId = 0;
    }

    public Teacher(Integer tId){
        teacherId = tId;
    }

    public void setTeacherId(Integer tId){
        teacherId = tId;
    }

    public Integer getTeacherId(){
        return teacherId;
    }

}

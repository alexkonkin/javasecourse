package com.globallogic.javase.university.staff;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/28/13
 * Time: 11:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private Integer studentId;

    public Student(){
        studentId = 0;
    }

    public Student(Integer sId){
        studentId = sId;
    }

    public void setStudentId(Integer sId){
        studentId = sId;
    }

    public Integer getStudentId(){
        return studentId;
    }

    public Student getStudent(){
        return this;
    }
}

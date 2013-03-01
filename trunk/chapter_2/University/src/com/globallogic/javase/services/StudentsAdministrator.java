package com.globallogic.javase.services;

import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.staff.Student;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/28/13
 * Time: 11:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class StudentsAdministrator {


    public void enrollStudentIntoTheGroup(Student aStudent, Group aGroup){
        for(int n=0; n < aGroup.getStudentsCount();n++){
            if(aGroup.getStudent(n) == null){
                aGroup.setStudent(n,aStudent);
                break;
            }
        }
    }

    public void deductStudentFromTheGroup(Student aStudent, Group aGroup){
        for(int n=0; n < aGroup.getStudentsCount();n++){
            if(aGroup.getStudent(n) == aStudent){
                aGroup.delStudent(n);
                break;
            }
        }
    }
}

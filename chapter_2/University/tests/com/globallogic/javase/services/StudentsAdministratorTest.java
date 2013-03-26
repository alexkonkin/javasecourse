package com.globallogic.javase.services;

import com.globallogic.javase.services.StudentsAdministrator;
import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.staff.Student;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/28/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class StudentsAdministratorTest {

    StudentsAdministrator studentsAdministrator = new StudentsAdministrator();
    Group aGroup = new Group(1,"First group");

    @Test
    public void testEnrollStudentIntoTheGroup() throws Exception {
        ArrayList<Student> studentsTeam = new ArrayList<Student>();

        for (int i = 0; i < 10 ; i++)
            studentsTeam.add(new Student(i));
        for (int i = 0; i < studentsTeam.size() ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam.get(i).getStudent(),aGroup);

        for (int i = 0; i < studentsTeam.size() ; i++)
            assertEquals(studentsTeam.get(i),(Student)aGroup.getStudent(i));
    }

    @Test
    public void testDeductStudentFromTheGroup() throws Exception {
        ArrayList<Student> studentsTeam = new ArrayList<Student>();
        for (int i = 0; i < 10 ; i++)
            studentsTeam.add(new Student(i));
        for (int i = 0; i < studentsTeam.size() ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam.get(i).getStudent(),aGroup);

        studentsAdministrator.deductStudentFromTheGroup(studentsTeam.get(3),aGroup);
        assertNull(aGroup.getStudent(3));

    }
}

package tests.com.globallogic.javase.services;

import com.globallogic.javase.services.StudentsAdministrator;
import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.staff.Student;
import com.globallogic.javase.university.staff.Teacher;
import org.junit.Test;

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
        Student[] studentsTeam = new Student[10];
        for (int i = 0; i < studentsTeam.length ; i++)
            studentsTeam[i] = new Student(i);
        for (int i = 0; i < studentsTeam.length ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam[i].getStudent(),aGroup);

        for (int i = 0; i < studentsTeam.length ; i++)
            assertEquals(studentsTeam[i],(Student)aGroup.getStudent(i));
    }

    @Test
    public void testDeductStudentFromTheGroup() throws Exception {
        Student[] studentsTeam = new Student[10];
        for (int i = 0; i < studentsTeam.length ; i++)
            studentsTeam[i] = new Student(i);
        for (int i = 0; i < studentsTeam.length ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam[i].getStudent(),aGroup);

        studentsAdministrator.deductStudentFromTheGroup(studentsTeam[3],aGroup);
        assertNull(aGroup.getStudent(3));

    }
}

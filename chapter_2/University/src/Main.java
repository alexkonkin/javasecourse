import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.*;
import com.globallogic.javase.services.*;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("--==<The program is started>==--");

        Teacher[] teachersTeam = new Teacher[3];
        for(int i = 0; i < teachersTeam.length ; i++)
            teachersTeam[i] = new Teacher(i+1);

        Lesson[] lessonsStorage = new Lesson[5];
        for(int i = 0; i < lessonsStorage.length ; i++)
            lessonsStorage[i] = new Lesson(i,new String("Lesson "+(i+1)),new String("Lesson "+(i+1)+" info"));

        Student[] studentsTeam = new Student[5];
        for(int i = 0; i < studentsTeam.length ; i++)
            studentsTeam[i] = new Student(i);

        Group[] groupsStorage = new Group[3];
        for(int i = 0; i < groupsStorage.length ; i++)
            groupsStorage[i] = new Group(i,new String("Group "+(i+1)));

        StudentsAdministrator studentsAdministrator = new StudentsAdministrator();

        for (int i = 0; i < studentsTeam.length ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam[i].getStudent(),groupsStorage[0]);

        Auditorium[] auditoriumsFile = new Auditorium[1];
        auditoriumsFile[0] = new Auditorium(1,1,1,1,"Test auditorium");

        Lesson[] lessonsFile = new Lesson[1];
        lessonsFile[0] = new Lesson(1,"Math","Mathematics lesson");

        Curriculum curriculum = new Curriculum(3);


        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        long incMinutes = new Date().getTime();
        Date d;
        for(int i = 0; i < curriculum.getItemCount() ; i++){
            if(i>0)
                //define time interval equal to 50 minutes
                incMinutes = incMinutes + (5*600000);
            d = new Date(incMinutes);
            teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam[0],groupsStorage[0],auditoriumsFile[0],lessonsFile[0], 45,d,curriculum.getCurriculumItem(i));
        }

        for(int i = 0; i < curriculum.getItemCount() ; i++){
            System.out.println("curriculum item "+(i+1)+" "+ curriculum.printInfo(i));
            Group aGroup1 = curriculum.getGroup(i);
            for(int n= 0; n < aGroup1.getStudentsCount();n++){
                if(!aGroup1.isThePlaceEmpty(n))
                    System.out.println("in this group enrolled student with Id: "+ aGroup1.getStudent(n).getStudentId());
            }
        }


        /*
        for(int i = 0; i < curriculum.getItemCount() ; i++){
            teachersCurriculumBuilder.deleteTeachersRecordFromCurriculumItem(curriculum.getCurriculumItem(i));
        }

        for(int i = 0; i < curriculum.getItemCount() ; i++){
            System.out.println("curriculum item "+(i+1)+" "+ curriculum.printInfo(i));
        }
        */

    }
}

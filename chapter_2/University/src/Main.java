import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.*;
import com.globallogic.javase.services.*;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("--==<The program is started>==--");

        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();

        for(int i = 0; i < 3 ; i++)
            teachersTeam.add(new Teacher(i+1));

        ArrayList<Lesson> lessonsStorage = new ArrayList<Lesson>();
        for(int i = 0; i < 5 ; i++)
            lessonsStorage.add(new Lesson(i,new String("Lesson "+(i+1)),new String("Lesson "+(i+1)+" info")));

        ArrayList<Student> studentsTeam = new ArrayList<Student>();
        for(int i = 0; i < 5 ; i++)
            studentsTeam.add(new Student(i));

        ArrayList<Group> groupsStorage = new ArrayList<Group>();
        for(int i = 0; i < 3 ; i++)
            groupsStorage.add(new Group(i,new String("Group "+(i+1))));

        StudentsAdministrator studentsAdministrator = new StudentsAdministrator();

        for (int i = 0; i < studentsTeam.size() ; i++)
            studentsAdministrator.enrollStudentIntoTheGroup(studentsTeam.get(i).getStudent(),groupsStorage.get(0));

        ArrayList<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1,1,1,1,"Test auditorium"));

        ArrayList<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Curriculum curriculum = new Curriculum(3);


        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        long incMinutes = new Date().getTime();
        Date d;
        for(int i = 0; i < curriculum.getItemCount() ; i++){
            if(i>0)
                //define time interval equal to 50 minutes
                incMinutes = incMinutes + (5*600000);
            d = new Date(incMinutes);
            teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam.get(0),
                                                                        groupsStorage.get(0),
                                                                        auditoriumsFile.get(0),
                                                                        lessonsFile.get(0),
                                                                        45,
                                                                        d,
                                                                        curriculum.getCurriculumItem(i));
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

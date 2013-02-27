import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.*;
import com.globallogic.javase.services.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("--==<The program is started>==--");

        Teacher[] teachersTeam = new Teacher[3];
        for(int i = 0; i < teachersTeam.length ; i++)
            teachersTeam[i] = new Teacher(i+1);

        Lesson[] lessonsStorage = new Lesson[5];
        for(int i = 0; i < lessonsStorage.length ; i++)
            lessonsStorage[i] = new Lesson(i,new String("Lesson "+(i+1)),new String("Lesson "+(i+1)+" info"));

        Group[] groupsStorage = new Group[3];
        for(int i = 0; i < groupsStorage.length ; i++)
            groupsStorage[i] = new Group(i,new String("Group "+(i+1)));

        Auditorium[] auditoriumsFile = new Auditorium[1];
        auditoriumsFile[0] = new Auditorium(1,1,1,1,"Test auditorium");

        Lesson[] lessonsFile = new Lesson[1];
        lessonsFile[0] = new Lesson(1,"Math","Mathematics lesson");

        Curriculum curriculum = new Curriculum(3);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();


        for(int i = 0; i < curriculum.getItemCount() ; i++){
            teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam[0],groupsStorage[0],auditoriumsFile[0],lessonsFile[0], 45, curriculum.getCurriculumItem(i));
        }

        for(int i = 0; i < curriculum.getItemCount() ; i++){
            System.out.println("curriculum item "+(i+1)+" "+ curriculum.printInfo(i));
        }

        for(int i = 0; i < curriculum.getItemCount() ; i++){
            teachersCurriculumBuilder.deleteTeachersRecordFromCurriculumItem(curriculum.getCurriculumItem(i));
        }

        for(int i = 0; i < curriculum.getItemCount() ; i++){
            System.out.println("curriculum item "+(i+1)+" "+ curriculum.printInfo(i));
        }


    }
}

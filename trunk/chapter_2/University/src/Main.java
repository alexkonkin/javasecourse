import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("--==<The program is started>==--");

        Teacher[] teachersTeam = new Teacher[3];
        for(int i = 0; i < teachersTeam.length ; i++)
            teachersTeam[i] = new Teacher(i);

        Lesson[] lessonsStorage = new Lesson[5];
        for(int i = 0; i < lessonsStorage.length ; i++)
            lessonsStorage[i] = new Lesson(i,new String("Lesson "+(i+1)),new String("Lesson "+(i+1)+" info"));

        Group[] groupsStorage = new Group[3];
        for(int i = 0; i < groupsStorage.length ; i++)
            groupsStorage[i] = new Group(i,new String("Group "+(i+1)));




    }
}

package com.globallogic.javase.services;

import com.globallogic.javase.services.TeachersCurriculumBuilder;
import com.globallogic.javase.university.businessObjects.Curriculum;
import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.businessObjects.Lesson;
import com.globallogic.javase.university.businessObjects.Auditorium;
import com.globallogic.javase.university.staff.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/21/13
 * Time: 3:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeachersCurriculumBuilderTest {
    @Test
    public void testAddTeachersRecordToCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        ArrayList<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        ArrayList<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Date aDate = new Date();

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam.get(0),
                                                                    groupFile.get(0),
                                                                    auditoriumsFile.get(0),
                                                                    lessonsFile.get(0),
                                                                    45 ,
                                                                    aDate,
                                                                    curriculum.getCurriculumItem(0));

        assertEquals(teachersTeam.get(0),(Teacher)curriculum.getTeacher(0));
        assertEquals(groupFile.get(0),(Group)curriculum.getGroup(0));
        assertEquals(auditoriumsFile.get(0),(Auditorium)curriculum.getAuditorium(0));
        assertEquals(45,(int)curriculum.getDurationTime(0));
    }



    @Test
    public void testSetTeacherIdCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(20));

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam.get(0), curriculum.getCurriculumItem(0));

        assertEquals(teachersTeam.get(0),(Teacher)curriculum.getTeacher(0));
    }

    @Test
    public void testSetGroupIdCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));
        groupFile.add(new Group(20,"Test group"));

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile.get(0), curriculum.getCurriculumItem(0));

        assertEquals(groupFile.get(0),(Group)curriculum.getGroup(0));
    }

    @Test
    public void testSetDurationTimeCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(90, curriculum.getCurriculumItem(0));

        assertEquals(90,(int)curriculum.getDurationTime(0));
    }

    @Test
    public void testDeleteTeachersRecordFromCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        ArrayList<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        ArrayList<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        Date aDate = new Date();

        teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam.get(0),
                groupFile.get(0),
                auditoriumsFile.get(0),
                lessonsFile.get(0),
                45 ,
                aDate,
                curriculum.getCurriculumItem(0));

        teachersCurriculumBuilder.deleteTeachersRecordFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getTeacher(0));
        assertNull(curriculum.getGroup(0));
        assertEquals(0,(int)curriculum.getDurationTime(0));
    }


    @Test
    public void testDelTeacherFromCurriculumItem() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam.get(0),curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delTeacherFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getTeacher(0));
    }

    @Test
    public void testDelGroupIdFromCurriculumItem() throws Exception {
        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"test"));

        Curriculum curriculum = new Curriculum(1);
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delGroupFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getGroup(0));
    }

    @Test
    public void testDelAuditoriumFromCurriculumItem() throws Exception {
        ArrayList<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setAuditoriumCurriculumItem(auditoriumsFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delAuditoriumFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getAuditorium(0));
    }


    @Test
    public void testDelLessonFromCurriculumItem() throws Exception {
        ArrayList<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setLessonCurriculumItem(lessonsFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delLessonFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getLesson(0));
    }



    @Test
    public void testDelDurationTimeFromCurriculumItem() throws Exception {
        Curriculum curriculum = new Curriculum(1);
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(100,curriculum.getCurriculumItem(0));

        teachersCurriculumBuilder.delDurationTimeFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(0,(int)curriculum.getDurationTime(0));
    }

    @Test
    public void testTeachersCurriculum() throws Exception {
        ArrayList<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        ArrayList<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        ArrayList<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));
        lessonsFile.add(new Lesson(2,"English","English lesson"));
        lessonsFile.add(new Lesson(3,"Chemistry","Chemistry lesson"));

        Date currDate = new Date();
        Date aDate;
        long incMinutes = currDate.getTime();
        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        for(int n = 0; n < lessonsFile.size();n++){
            if(n>0)
                incMinutes = incMinutes + (5*600000);
            aDate = new Date(incMinutes);
            teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam.get(0),
                groupFile.get(0),
                auditoriumsFile.get(0),
                lessonsFile.get(n),
                45 ,
                aDate,
                curriculum.getCurriculumItem(n));
        }

        incMinutes = currDate.getTime();
        for(int i = 0; i < curriculum.getItemCount() ; i++){
            if(!curriculum.isEmpty(i)){
                //System.out.println("curriculum item "+(i+1)+" "+ curriculum.printInfo(i));
                if(i>0)
                    incMinutes = incMinutes + (5*600000);
                //check that the teachers time table equal to the current date with the 50 min step
                assertEquals(incMinutes, curriculum.getDateTime(i).getTime());
            }
        }
    }


}
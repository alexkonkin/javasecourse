package com.globallogic.javase.services;

import com.globallogic.javase.services.TeachersCurriculumBuilder;
import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.Teacher;

import java.util.*;

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
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        List<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        List<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        List<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Date aDate = new Date();

        Curriculum curriculum = new Curriculum();

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;


        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);

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
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(20));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();
        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam.get(0), curriculum.getCurriculumItem(0));

        assertEquals(teachersTeam.get(0),(Teacher)curriculum.getTeacher(0));
    }

    @Test
    public void testSetGroupIdCurriculumItem() throws Exception {
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));
        groupFile.add(new Group(20,"Test group"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();
        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile.get(0), curriculum.getCurriculumItem(0));

        assertEquals(groupFile.get(0),(Group)curriculum.getGroup(0));
    }

    @Test
    public void testSetDurationTimeCurriculumItem() throws Exception {
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        ArrayList<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 90;

        Curriculum curriculum = new Curriculum();
        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(90, curriculum.getCurriculumItem(0));

        assertEquals(90,(int)curriculum.getDurationTime(0));
    }

    @Test
    public void testDeleteTeachersRecordFromCurriculumItem() throws Exception {
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        List<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        List<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        List<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);

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
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam.get(0),curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delTeacherFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getTeacher(0));
    }

    @Test
    public void testDelGroupIdFromCurriculumItem() throws Exception {
        List<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"test"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delGroupFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getGroup(0));
    }

    @Test
    public void testDelAuditoriumFromCurriculumItem() throws Exception {
        List<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setAuditoriumCurriculumItem(auditoriumsFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delAuditoriumFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getAuditorium(0));
    }


    @Test
    public void testDelLessonFromCurriculumItem() throws Exception {
        List<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));

        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setLessonCurriculumItem(lessonsFile.get(0), curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delLessonFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertNull(curriculum.getLesson(0));
    }



    @Test
    public void testDelDurationTimeFromCurriculumItem() throws Exception {
        Auditorium anAuditorium = new Auditorium();
        Lesson aLesson = new Lesson();
        Group aGroup = new Group();
        Teacher aTeacher = new Teacher();
        Integer durationTime = 45;

        Curriculum curriculum = new Curriculum();

        CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());
        curriculum.addCurriculumItem(aCurriculumItem);
        curriculum.addCurriculumItem(aCurriculumItem);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(100,curriculum.getCurriculumItem(0));

        teachersCurriculumBuilder.delDurationTimeFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(0,(int)curriculum.getDurationTime(0));
    }

    @Test
    public void testTeachersCurriculum() throws Exception {
        List<Teacher> teachersTeam = new ArrayList<Teacher>();
        teachersTeam.add(new Teacher(10));

        List<Group> groupFile = new ArrayList<Group>();
        groupFile.add(new Group(10,"Test group"));

        List<Auditorium> auditoriumsFile = new ArrayList<Auditorium>();
        auditoriumsFile.add(new Auditorium(1, 1, 1, 1, "Test auditorium"));

        List<Lesson> lessonsFile = new ArrayList<Lesson>();
        lessonsFile.add(new Lesson(1,"Math","Mathematics lesson"));
        lessonsFile.add(new Lesson(2,"English","English lesson"));
        lessonsFile.add(new Lesson(3,"Chemistry","Chemistry lesson"));

        Date currDate = new Date();
        Date aDate;
        long incMinutes = currDate.getTime();
        Curriculum curriculum = new Curriculum();
        for(int i = 0; i < 10 ; i++)
            curriculum.addCurriculumItem(new CurriculumItem());

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
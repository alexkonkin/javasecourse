package tests;

import com.globallogic.javase.services.TeachersCurriculumBuilder;
import com.globallogic.javase.university.businessObjects.Curriculum;
import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.businessObjects.Lesson;
import com.globallogic.javase.university.businessObjects.Auditorium;
import com.globallogic.javase.university.staff.Teacher;
import java.util.Arrays;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(10);

        Group[] groupFile = new Group[1];
        groupFile[0] = new Group(10,"Test group");

        Auditorium[] auditoriumsFile = new Auditorium[1];
        auditoriumsFile[0] = new Auditorium(1,1,1,1,"Test auditorium");

        Lesson[] lessonsFile = new Lesson[1];
        lessonsFile[0] = new Lesson(1,"Math","Mathematics lesson");

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam[0],
                                                                    groupFile[0],
                                                                    auditoriumsFile[0],
                                                                    lessonsFile[0],
                                                                    45 ,
                                                                    curriculum.getCurriculumItem(0));

        assertEquals(teachersTeam[0],(Teacher)curriculum.getTeacher(0));
        assertEquals(groupFile[0],(Group)curriculum.getGroup(0));
        assertEquals(auditoriumsFile[0],(Auditorium)curriculum.getAuditorium(0));
        assertEquals(45,(int)curriculum.getDurationTime(0));
    }



    @Test
    public void testSetTeacherIdCurriculumItem() throws Exception {
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(20);


        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam[0], curriculum.getCurriculumItem(0));

        assertEquals(teachersTeam[0],(Teacher)curriculum.getTeacher(0));
    }

    @Test
    public void testSetGroupIdCurriculumItem() throws Exception {
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(10);

        Group[] groupFile = new Group[2];
        groupFile[0] = new Group(10,"Test group 1");
        groupFile[1] = new Group(20,"Test group 2");

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile[0], curriculum.getCurriculumItem(0));

        assertEquals(groupFile[0],(Group)curriculum.getGroup(0));
    }

    @Test
    public void testSetDurationTimeCurriculumItem() throws Exception {
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(10);

        Group[] groupFile = new Group[1];
        groupFile[0] = new Group(10,"Test group");

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(90, curriculum.getCurriculumItem(0));

        assertEquals(90,(int)curriculum.getDurationTime(0));
    }

    @Test
    public void testDeleteTeachersRecordFromCurriculumItem() throws Exception {
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(10);

        Group[] groupFile = new Group[1];
        groupFile[0] = new Group(10,"Test group");

        Auditorium[] auditoriumsFile = new Auditorium[1];
        auditoriumsFile[0] = new Auditorium(1,1,1,1,"Test auditorium");

        Lesson[] lessonsFile = new Lesson[1];
        lessonsFile[0] = new Lesson(1,"Math","Mathematics lesson");

        Curriculum curriculum = new Curriculum();
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();

        teachersCurriculumBuilder.addTeachersRecordToCurriculumItem(teachersTeam[0],
                groupFile[0],
                auditoriumsFile[0],
                lessonsFile[0],
                45 ,
                curriculum.getCurriculumItem(0));

        teachersCurriculumBuilder.deleteTeachersRecordFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(true,(boolean)(curriculum.getTeacher(0)== null?true:false));
        assertEquals(true,(boolean)(curriculum.getGroup(0) == null?true:false));
        assertEquals(0,(int)curriculum.getDurationTime(0));
    }


    @Test
    public void testDelTeacherFromCurriculumItem() throws Exception {
        Teacher[] teachersTeam = new Teacher[1];
        teachersTeam[0] = new Teacher(10);
        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setTeacherCurriculumItem(teachersTeam[0],curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delTeacherFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(true,(boolean)((curriculum.getTeacher(0) == null)?true:false));
    }

    @Test
    public void testDelGroupIdFromCurriculumItem() throws Exception {
        Group[] groupFile = new Group[1];
        groupFile[0] = new Group(10,"test");
        Curriculum curriculum = new Curriculum(1);
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setGroupCurriculumItem(groupFile[0], curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delGroupFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(true,(boolean)((curriculum.getGroup(0) == null)?true:false));
    }

    @Test
    public void testDelAuditoriumFromCurriculumItem() throws Exception {
        Auditorium[] auditoriumsFile = new Auditorium[1];
        auditoriumsFile[0] = new Auditorium(1,1,1,1,"test");
        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setAuditoriumCurriculumItem(auditoriumsFile[0], curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delAuditoriumFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(true,(boolean)((curriculum.getAuditorium(0) == null)?true:false));
    }


    @Test
    public void testDelLessonFromCurriculumItem() throws Exception {
        Lesson[] lessonsFile = new Lesson[1];
        lessonsFile[0] = new Lesson(1,"Math","Mathematics lesson");

        Curriculum curriculum = new Curriculum(1);

        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setLessonCurriculumItem(lessonsFile[0], curriculum.getCurriculumItem(0));
        teachersCurriculumBuilder.delLessonFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(true,(boolean)((curriculum.getLesson(0) == null)?true:false));
    }



    @Test
    public void testDelDurationTimeFromCurriculumItem() throws Exception {
        Curriculum curriculum = new Curriculum(1);
        TeachersCurriculumBuilder teachersCurriculumBuilder = new TeachersCurriculumBuilder();
        teachersCurriculumBuilder.setDurationTimeCurriculumItem(100,curriculum.getCurriculumItem(0));

        teachersCurriculumBuilder.delDurationTimeFromCurriculumItem(curriculum.getCurriculumItem(0));

        assertEquals(0,(int)curriculum.getDurationTime(0));
    }
}

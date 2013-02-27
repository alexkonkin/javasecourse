package com.globallogic.javase.services;

import com.globallogic.javase.university.businessObjects.CurriculumItem;
import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.businessObjects.Auditorium;
import com.globallogic.javase.university.businessObjects.Lesson;
import com.globallogic.javase.university.staff.Teacher;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TeachersCurriculumBuilder {
    public TeachersCurriculumBuilder(){
    }

    public void addTeachersRecordToCurriculumItem(Teacher aTeacher,Group aGroup,Auditorium anAuditorium ,Lesson aLesson,Integer aDuration ,CurriculumItem anItem){
        anItem.setTeacher(aTeacher);
        anItem.setGroup(aGroup);
        anItem.setAuditorium(anAuditorium);
        anItem.setLesson(aLesson);
        anItem.setDurationTime(aDuration);
    }

    public void deleteTeachersRecordFromCurriculumItem(CurriculumItem anItem){
        anItem.setTeacher(null);
        anItem.setGroup(null);
        anItem.setAuditorium(null);
        anItem.setLesson(null);
        anItem.setDurationTime(0);
    }

    public void setTeacherCurriculumItem (Teacher aTeacher,CurriculumItem anItem){
        anItem.setTeacher(aTeacher);
    }

    public void setGroupCurriculumItem (Group aGroup,CurriculumItem anItem){
        anItem.setGroup(aGroup);
    }

    public void setAuditoriumCurriculumItem (Auditorium anAuditorium,CurriculumItem anItem){
        anItem.setAuditorium(anAuditorium);
    }

    public void setLessonCurriculumItem (Lesson aLesson,CurriculumItem anItem){
        anItem.setLesson(aLesson);
    }


    public void setDurationTimeCurriculumItem (Integer aDurationTime,CurriculumItem anItem){
        anItem.setDurationTime(aDurationTime);
    }

    public void delTeacherFromCurriculumItem (CurriculumItem anItem){
        anItem.setTeacher(null);
    }

    public void delGroupFromCurriculumItem (CurriculumItem anItem){
        anItem.setGroup(null);
    }

    public void delAuditoriumFromCurriculumItem (CurriculumItem anItem){
        anItem.setAuditorium(null);
    }

    public void delLessonFromCurriculumItem (CurriculumItem anItem){
        anItem.setLesson(null);
    }


    public void delDurationTimeFromCurriculumItem (CurriculumItem anItem){
        anItem.setDurationTime(0);
    }

}

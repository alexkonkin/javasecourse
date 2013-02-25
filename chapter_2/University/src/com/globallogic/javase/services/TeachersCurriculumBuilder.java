package com.globallogic.javase.services;

import com.globallogic.javase.university.businessObjects.CurriculumItem;
import com.globallogic.javase.university.businessObjects.Group;
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

    public void addTeachersRecordToCurriculumItem(Teacher aTeacher,Group aGroup,Integer aDuration ,CurriculumItem anItem){
        anItem.setCiTeacher(aTeacher.getTeacherId());
        anItem.setCiGroup(aGroup.getGroupId());
        anItem.setDurationTime(aDuration);
    }

    public void deleteTeachersRecordFromCurriculumItem(CurriculumItem anItem){
        anItem.setCiTeacher(0);
        anItem.setCiGroup(0);
        anItem.setDurationTime(0);
    }

    public void setTeacherIdCurriculumItem (Teacher aTeacher,CurriculumItem anItem){
        anItem.setCiTeacher(aTeacher.getTeacherId());
    }

    public void setGroupIdCurriculumItem (Group aGroup,CurriculumItem anItem){
        anItem.setCiGroup(aGroup.getGroupId());
    }

    public void setDurationTimeCurriculumItem (Integer aDurationTime,CurriculumItem anItem){
        anItem.setDurationTime(aDurationTime);
    }

    public void delTeacherIdFromCurriculumItem (CurriculumItem anItem){
        anItem.setCiTeacher(0);
    }

    public void delGroupIdFromCurriculumItem (CurriculumItem anItem){
        anItem.setCiGroup(0);
    }

    public void delDurationTimeFromCurriculumItem (CurriculumItem anItem){
        anItem.setDurationTime(0);
    }
}

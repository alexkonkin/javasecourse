package com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.staff.Teacher;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumItem {
    private Auditorium ciAuditorium;
    private Lesson ciLesson;
    private Group ciGroup;
    private Teacher ciTeacher;

    public CurriculumItem(Auditorium ciAud, Lesson ciLes, Group ciGr, Teacher ciTchr){
        ciAuditorium = ciAud;
        ciLesson = ciLes;
        ciGroup = ciGr;
        ciTeacher = ciTchr;
    }

    public void setCiAuditorium(Auditorium ciAud){
        ciAuditorium = ciAud;
    }

    public void setCiLesson(Lesson ciLes){
        ciLesson = ciLes;
    }

    public void setCiGroup(Group ciGr){
        ciGroup = ciGr;
    }

    public void setCiTeacher(Teacher ciTchr){
        ciTeacher = ciTchr;
    }
}

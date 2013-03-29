package com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.staff.Teacher;
import java.util.Date;
import java.util.Arrays;
import java.lang.StringBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumItem {
    private Auditorium anAuditorium;
    private Lesson aLesson;
    private Group aGroup;
    private Teacher aTeacher;
    private Integer durationTime = 0;
    private Date aDateTime;

    public CurriculumItem(){
    }


    public CurriculumItem(Auditorium ciAud, Lesson ciLes, Group ciGr, Teacher ciTchr, Integer ciDuration, Date ciDateTime){
        anAuditorium = ciAud;
        aLesson = ciLes;
        aGroup = ciGr;
        aTeacher = ciTchr;
        aDateTime = ciDateTime;
        durationTime = new Integer(ciDuration);
    }



    public void setAuditorium(Auditorium ciAud){
        anAuditorium = ciAud;
    }

    public void setLesson(Lesson ciLes){
        aLesson = ciLes;
    }

    public void setGroup(Group ciGr){
        aGroup = ciGr;
    }

    public void setTeacher(Teacher ciTchr){
        aTeacher = ciTchr;
    }

    public void setDurationTime(Integer ciDurationTime){
        durationTime = ciDurationTime;
    }

    public Auditorium getAuditorium(){
        return anAuditorium;
    }

    public Lesson getLesson() {
        return aLesson;
    }

    public Group getGroup(){
        return aGroup;
    }

    public Teacher getTeacher(){
        return aTeacher;
    }

    public Integer getDurationTime(){
        return durationTime;
    }

    public boolean isEmpty(){
        if (durationTime == 0)
                return true;
            else
                return false;
    }

    public void clearData(){
        anAuditorium = null;
        aLesson = null;
        aGroup = null;
        aTeacher = null;
        aDateTime = null;
        durationTime = 0;
    }

    public void setDateTime(Date ciDateTime){
        aDateTime = ciDateTime;
    }

    public Date getDateTime(){
        return aDateTime;
    }

    public String dumpInfo(){
        StringBuilder itemInfo = new StringBuilder();
        if(anAuditorium != null){
                itemInfo.append("Auditorium ");
                itemInfo.append(anAuditorium.getAuditoriumId());
            }
            else
                itemInfo.append("Auditorium -");
        itemInfo.append(" ");
        if(aLesson != null){
                itemInfo.append("Lesson ");
                itemInfo.append(aLesson.getLessonId());
            }
            else
                itemInfo.append("Lesson -");
        itemInfo.append(" ");
        if(aGroup != null){
                itemInfo.append("Group ");
                itemInfo.append(aGroup.getGroupId());
            }
            else
                itemInfo.append("Group -");
        itemInfo.append(" ");
        if(aTeacher != null){
                itemInfo.append("Teacher ");
                itemInfo.append(aTeacher.getTeacherId());
            }
            else
                itemInfo.append("Teacher -");
        itemInfo.append(" ");
        if(aDateTime != null){
                itemInfo.append("Start date/time ");
                itemInfo.append(aDateTime);
            }
            else
                itemInfo.append("Start date/time -");
        itemInfo.append(" ");
        itemInfo.append("Duration "+durationTime);
        return itemInfo.toString();
    }

}

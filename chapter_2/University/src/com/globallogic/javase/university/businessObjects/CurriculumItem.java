package com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.staff.Teacher;

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
    private Integer auditoriumId;
    private Integer lessonId;
    private Integer groupId;
    private Integer teacherId;
    private Integer durationTime;

    public CurriculumItem(){
        auditoriumId = 0;
        lessonId = 0;
        groupId = 0;
        teacherId = 0;
        durationTime = 0;
    }

    public CurriculumItem(Integer ciAudId, Integer ciLesId, Integer ciGrId, Integer ciTchrId, Integer ciDuration){
        auditoriumId = new Integer(ciAudId);
        lessonId = new Integer(ciLesId);
        groupId = new Integer(ciGrId);
        teacherId = new Integer(ciTchrId);
        durationTime = new Integer(ciDuration);
    }

    public void setCiAuditorium(Integer ciAudId){
        auditoriumId = ciAudId;
    }

    public void setCiLesson(Integer ciLesId){
        lessonId = ciLesId;
    }

    public void setCiGroup(Integer ciGrId){
        groupId = ciGrId;
    }

    public void setCiTeacher(Integer ciTchrId){
        teacherId = ciTchrId;
    }

    public void setDurationTime(Integer ciDurationTime){
        durationTime = ciDurationTime;
    }

    public Integer getAuditoriumId(){
        return auditoriumId;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public Integer getGroupId(){
        return groupId;
    }

    public Integer getTeacherId(){
        return teacherId;
    }

    public Integer getDurationTime(){
        return durationTime;
    }


    public boolean isEmpty(){
        if (auditoriumId == 0)
                return true;
            else
                return false;
    }

    public void clearData(){
        auditoriumId = 0;
        lessonId = 0;
        groupId = 0;
        teacherId = 0;
        durationTime = 0;
    }

    public String dumpInfo(){
        StringBuilder itemInfo = new StringBuilder();
        itemInfo.append(auditoriumId);
        itemInfo.append(" ");
        itemInfo.append(lessonId);
        itemInfo.append(" ");
        itemInfo.append(groupId);
        itemInfo.append(" ");
        itemInfo.append(teacherId);
        itemInfo.append(" ");
        itemInfo.append(durationTime);
        return itemInfo.toString();
    }

}

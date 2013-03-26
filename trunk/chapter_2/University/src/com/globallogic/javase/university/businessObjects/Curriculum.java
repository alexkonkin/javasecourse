package com.globallogic.javase.university.businessObjects;
import com.globallogic.javase.university.staff.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Curriculum {

    ArrayList<CurriculumItem> curriculumItems = new ArrayList<CurriculumItem>();

    public Curriculum(){
        for(int i = 0; i < 10 ; i++)
            curriculumItems.add(new CurriculumItem());
    }

    public Curriculum(Integer itemCount){
        for(int i = 0; i < itemCount ; i++)
            curriculumItems.add(new CurriculumItem());
    }

    public void addCurriculumItem(CurriculumItem aCurriculumItem){
        curriculumItems.add(aCurriculumItem);
    }

    public void delCurriculumItem(Integer ciIndex){
        curriculumItems.remove(ciIndex);

    }

    public String printInfo(Integer ciIndex){
        return curriculumItems.get(ciIndex).dumpInfo();
    }

    public Auditorium getAuditorium(Integer ciIndex){
        return curriculumItems.get(ciIndex).getAuditorium();
    }

    public Lesson getLesson(Integer ciIndex){
        return curriculumItems.get(ciIndex).getLesson();
    }

    public Group getGroup(Integer ciIndex){
        return curriculumItems.get(ciIndex).getGroup();
    }

    public Teacher getTeacher(Integer ciIndex){
        return curriculumItems.get(ciIndex).getTeacher();
    }

    public Integer getDurationTime(Integer ciIndex){
        return curriculumItems.get(ciIndex).getDurationTime();
    }

    public CurriculumItem getCurriculumItem(Integer ciIndex){
        return curriculumItems.get(ciIndex);
    }

    public Integer getItemCount(){
        return curriculumItems.size();
    }

    public boolean isEmpty(Integer ciIndex){
        if(curriculumItems.get(ciIndex).isEmpty() == true)
                return true;
            else
                return false;
    }

    public Date getDateTime(Integer ciIndex){
        return curriculumItems.get(ciIndex).getDateTime();
    }

}

package com.globallogic.javase.university.businessObjects;
import com.globallogic.javase.university.staff.Teacher;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Curriculum {

    CurriculumItem[] curriculumItems;

    public Curriculum(){
        curriculumItems = new CurriculumItem[10];
        for(int i = 0; i < curriculumItems.length ; i++)
            curriculumItems[i] = new CurriculumItem();
    }

    public Curriculum(Integer itemCount){
        curriculumItems = new CurriculumItem[itemCount];
        for(int i = 0; i < curriculumItems.length ; i++)
            curriculumItems[i] = new CurriculumItem();
    }

    public void addCurriculumItem(CurriculumItem aCurriculumItem){
        for(int i = 0;i < curriculumItems.length;i++){
            if(curriculumItems[i].isEmpty()){
                curriculumItems[i] = aCurriculumItem;
                break;
            }
            else
                continue;
        }
    }

    public void delCurriculumItem(Integer ciIndex){
        curriculumItems[ciIndex].clearData();

    }

    public String printInfo(Integer ciIndex){
        return curriculumItems[ciIndex].dumpInfo();
    }

    public Auditorium getAuditorium(Integer ciIndex){
        return curriculumItems[ciIndex].getAuditorium();
    }

    public Lesson getLesson(Integer ciIndex){
        return curriculumItems[ciIndex].getLesson();
    }

    public Group getGroup(Integer ciIndex){
        return curriculumItems[ciIndex].getGroup();
    }

    public Teacher getTeacher(Integer ciIndex){
        return curriculumItems[ciIndex].getTeacher();
    }

    public Integer getDurationTime(Integer ciIndex){
        return curriculumItems[ciIndex].getDurationTime();
    }

    public CurriculumItem getCurriculumItem(Integer ciIndex){
        return curriculumItems[ciIndex];
    }

    public Integer getItemCount(){
        return curriculumItems.length;
    }

}

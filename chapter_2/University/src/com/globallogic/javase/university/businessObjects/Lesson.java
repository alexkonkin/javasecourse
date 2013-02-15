package com.globallogic.javase.university.businessObjects;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lesson {
    private Integer lessonId;
    private String lessonName;
    private String lessonDesciption;

    public Lesson(){
        lessonId = 0;
        lessonName = "-";
        lessonDesciption = "-";
    }

    public Lesson(Integer lId, String lName, String lDesciption){
        lessonId = lId;
        lessonName = lName;
        lessonDesciption = lDesciption;
    }

    public void setLessonId(Integer lId){
        lessonId = lId;
    }

    public void setLessonName(String lName){
        lessonName = lName;
    }

    public void setLessonDesciption(String lDesciption){
        lessonDesciption = lDesciption;
    }

    public Integer getLessonId(){
        return lessonId;
    }

    public String getLessonName(){
        return lessonName;
    }

    public String getLessonDesciption(){
        return lessonDesciption;
    }
}

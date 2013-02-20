package com.globallogic.javase.tests;

import com.globallogic.javase.university.businessObjects.Lesson;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LessonTest {

    Lesson aLessonNoArgs = new Lesson();
    Lesson aLessonThreeArgs = new Lesson(1,"Math","Mathematics lesson");

    //default constructor
    @Test
    public void testSetLessonId() throws Exception {
        assertEquals(0,(int)aLessonNoArgs.getLessonId());
    }

    @Test
    public void testSetLessonName() throws Exception {
        assertEquals("-",aLessonNoArgs.getLessonName());
    }

    @Test
    public void testSetLessonDesciption() throws Exception {
        assertEquals("-",aLessonNoArgs.getLessonDesciption());
    }

    //constructor with 3 arguments
    @Test
    public void testGetLessonId() throws Exception {
        assertEquals(1,(int)aLessonThreeArgs.getLessonId());
    }

    @Test
    public void testGetLessonName() throws Exception {
        assertEquals("Math",aLessonThreeArgs.getLessonName());
    }

    @Test
    public void testGetLessonDesciption() throws Exception {
        assertEquals("Mathematics lesson",aLessonThreeArgs.getLessonDesciption());
    }
}

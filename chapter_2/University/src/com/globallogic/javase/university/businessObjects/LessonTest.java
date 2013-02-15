package com.globallogic.javase.university.businessObjects;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/15/13
 * Time: 7:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class LessonTest {
    @Before
    Lesson aLessonNoArgs = new Lesson();
    Lesson aLessonThreeArgs = new Lesson(1,"Math","Mathematics lesson");

    //Let's check the lesson object that was created via default constructor
    @Test
    public void testSetLessonId() throws Exception {

    }

    @Test
    public void testSetLessonName() throws Exception {

    }

    @Test
    public void testSetLessonDesciption() throws Exception {

    }

    @Test
    public void testGetLessonId() throws Exception {

    }

    @Test
    public void testGetLessonName() throws Exception {

    }

    @Test
    public void testGetLessonDesciption() throws Exception {

    }
}

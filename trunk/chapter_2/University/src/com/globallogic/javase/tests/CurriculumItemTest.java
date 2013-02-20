package com.globallogic.javase.tests;

import com.globallogic.javase.university.businessObjects.CurriculumItem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumItemTest {

    CurriculumItem aCurriculumItem = new CurriculumItem();
    CurriculumItem aCurriculumItemFiveArgs = new CurriculumItem(1,1,1,1,45);

    @Test
    public void testSetCiAuditorium() throws Exception {
        aCurriculumItem.setCiAuditorium(10);
        assertEquals(10,(int)aCurriculumItem.getAuditoriumId());
    }

    @Test
    public void testSetCiLesson() throws Exception {
        aCurriculumItem.setCiLesson(10);
        assertEquals(10,(int)aCurriculumItem.getLessonId());
    }

    @Test
    public void testSetCiGroup() throws Exception {
        aCurriculumItem.setCiGroup(10);
        assertEquals(10,(int)aCurriculumItem.getGroupId());
    }

    @Test
    public void testSetCiTeacher() throws Exception {
        aCurriculumItem.setCiTeacher(10);
        assertEquals(10,(int)aCurriculumItem.getTeacherId());
    }

    @Test
    public void testSetDurationTime() throws Exception {
        aCurriculumItem.setDurationTime(90);
        assertEquals(90,(int)aCurriculumItem.getDurationTime());
    }

    @Test
    public void testIsEmpty() throws Exception {
        aCurriculumItem.setCiAuditorium(10);
        assertEquals(10,(int)aCurriculumItem.getAuditoriumId());
        aCurriculumItem.setCiAuditorium(0);
        assertEquals(true,(boolean)aCurriculumItem.isEmpty());
    }

    @Test
    public void testClearData() throws Exception {
        aCurriculumItemFiveArgs.clearData();
        assertEquals(true,(boolean)aCurriculumItem.isEmpty());
    }

    @Test
    public void testCurriculumItem() throws Exception {
        assertEquals(0,(int)aCurriculumItem.getAuditoriumId());
        assertEquals(0,(int)aCurriculumItem.getLessonId());
        assertEquals(0,(int)aCurriculumItem.getGroupId());
        assertEquals(0,(int)aCurriculumItem.getTeacherId());
        assertEquals(0,(int)aCurriculumItem.getDurationTime());
    }

    @Test
    public void testCurriculumItemFiveArgs() throws Exception {
        assertEquals(1,(int)aCurriculumItemFiveArgs.getAuditoriumId());
        assertEquals(1,(int)aCurriculumItemFiveArgs.getLessonId());
        assertEquals(1,(int)aCurriculumItemFiveArgs.getGroupId());
        assertEquals(1,(int)aCurriculumItemFiveArgs.getTeacherId());
        assertEquals(45,(int)aCurriculumItemFiveArgs.getDurationTime());
    }
}

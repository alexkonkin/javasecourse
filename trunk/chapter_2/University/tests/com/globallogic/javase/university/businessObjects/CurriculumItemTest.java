package tests.com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.businessObjects.Auditorium;
import com.globallogic.javase.university.businessObjects.CurriculumItem;

import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.businessObjects.Lesson;
import com.globallogic.javase.university.staff.Teacher;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumItemTest {

    Auditorium anAuditorium = new Auditorium();
    Lesson aLesson = new Lesson();
    Group aGroup = new Group();
    Teacher aTeacher = new Teacher();
    Integer durationTime = 45;
    Date aDate = new Date();

    CurriculumItem aCurriculumItemDefault = new CurriculumItem();
    CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45,aDate);

    @Test
    public void testClearData() throws Exception {
        aCurriculumItem.clearData();
        assertTrue(aCurriculumItem.isEmpty());
    }

    @Test
    public void testCurriculumItemDefault() throws Exception {
        assertNull(aCurriculumItemDefault.getAuditorium());
        assertNull(aCurriculumItemDefault.getLesson());
        assertNull(aCurriculumItemDefault.getGroup());
        assertNull(aCurriculumItemDefault.getTeacher());
        assertNull(aCurriculumItemDefault.getDateTime());
        assertEquals(0,(int)aCurriculumItemDefault.getDurationTime());
    }



    @Test
    public void testCurriculumItem() throws Exception {
        assertTrue(aCurriculumItem.getAuditorium().equals(anAuditorium));
        assertTrue(aCurriculumItem.getLesson().equals(aLesson));
        assertTrue(aCurriculumItem.getGroup().equals(aGroup));
        assertTrue(aCurriculumItem.getTeacher().equals(aTeacher));
        assertEquals(45,(int)aCurriculumItem.getDurationTime());
    }
}

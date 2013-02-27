package tests;

import com.globallogic.javase.university.businessObjects.Auditorium;
import com.globallogic.javase.university.businessObjects.CurriculumItem;

import com.globallogic.javase.university.businessObjects.Group;
import com.globallogic.javase.university.businessObjects.Lesson;
import com.globallogic.javase.university.staff.Teacher;
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

    Auditorium anAuditorium = new Auditorium();
    Lesson aLesson = new Lesson();
    Group aGroup = new Group();
    Teacher aTeacher = new Teacher();
    Integer durationTime = 45;

    CurriculumItem aCurriculumItemDefault = new CurriculumItem();
    CurriculumItem aCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45);

    @Test
    public void testClearData() throws Exception {
        aCurriculumItem.clearData();
        assertEquals(true,(boolean)aCurriculumItem.isEmpty());
    }

    @Test
    public void testCurriculumItemDefault() throws Exception {
        assertEquals(true,(boolean)(aCurriculumItemDefault.getAuditorium() == null)?true:false);
        assertEquals(true,(boolean)(aCurriculumItemDefault.getLesson() == null)?true:false);
        assertEquals(true,(boolean)(aCurriculumItemDefault.getGroup() == null)?true:false);
        assertEquals(true,(boolean)(aCurriculumItemDefault.getTeacher() == null)?true:false);
        assertEquals(0,(int)aCurriculumItemDefault.getDurationTime());
    }



    @Test
    public void testCurriculumItem() throws Exception {
        assertEquals(true,(boolean)aCurriculumItem.getAuditorium().equals(anAuditorium));
        assertEquals(true,(boolean)aCurriculumItem.getLesson().equals(aLesson));
        assertEquals(true,(boolean)aCurriculumItem.getGroup().equals(aGroup));
        assertEquals(true,(boolean)aCurriculumItem.getTeacher().equals(aTeacher));
        assertEquals(45,(int)aCurriculumItem.getDurationTime());
    }
}

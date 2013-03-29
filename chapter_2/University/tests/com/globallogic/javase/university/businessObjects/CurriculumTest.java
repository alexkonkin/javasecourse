package tests.com.globallogic.javase.university.businessObjects;

import com.globallogic.javase.university.businessObjects.*;
import com.globallogic.javase.university.staff.Teacher;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumTest {
    Auditorium anAuditorium = new Auditorium();
    Lesson aLesson = new Lesson();
    Group aGroup = new Group();
    Teacher aTeacher = new Teacher();
    Integer durationTime = 45;

    Curriculum oneCurriculumDefault = new Curriculum();


    CurriculumItem oneCurriculumItem = new CurriculumItem(anAuditorium,aLesson,aGroup,aTeacher,45, new Date());

    @Test
    public void testAddCurriculumItem()throws Exception{
        for(int i = 0; i <10; i++)
            oneCurriculumDefault.addCurriculumItem(oneCurriculumItem);
        for(int n = 0; n <10; n++){
            assertEquals(45, (int) oneCurriculumItem.getDurationTime());
        }
    }

    @Test
    public void testDelCurriculumItemDefault() throws Exception{
        for(int i = 0; i < 10 ; i++)
            oneCurriculumDefault.addCurriculumItem(new CurriculumItem());

        for(int i = 0; i < 10; i++)
            oneCurriculumDefault.delCurriculumItem(i);
        for(int n = 0; n < 10; n++){
            assertEquals(0, (int) oneCurriculumDefault.getDurationTime(n));
        }
    }

    @Test
    public void testDelCurriculumItemOneArg() throws Exception{
        Curriculum oneCurriculumOneArg = new Curriculum(3);
        assertEquals(3, (int) oneCurriculumOneArg.getItemCount());
        }

}

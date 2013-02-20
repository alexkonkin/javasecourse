package com.globallogic.javase.tests;

import com.globallogic.javase.university.businessObjects.Curriculum;
import com.globallogic.javase.university.businessObjects.CurriculumItem;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class CurriculumTest {

    Curriculum oneCurriculumDefault = new Curriculum();
    CurriculumItem oneCurriculumItem = new CurriculumItem(1,1,1,1,45);

    @Test
    public void testAddCurriculumItemDefault()throws Exception{
        for(int i = 0; i <10; i++)
            oneCurriculumDefault.addCurriculumItem(oneCurriculumItem);
        for(int n = 0; n <10; n++){
            assertEquals(1, (int) oneCurriculumDefault.getAuditoriumId(n));
            System.out.println(oneCurriculumDefault.printInfo(n));
        }
    }

    @Test
    public void testDelCurriculumItemDefault() throws Exception{
        for(int i = 0; i < 10; i++)
            oneCurriculumDefault.delCurriculumItem(i);
        for(int n = 0; n < 10; n++){
            assertEquals(0, (int) oneCurriculumDefault.getAuditoriumId(n));
            System.out.println(oneCurriculumDefault.printInfo(n));
        }
    }


}

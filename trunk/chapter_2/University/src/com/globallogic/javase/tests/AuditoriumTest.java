package com.globallogic.javase.tests;

import com.globallogic.javase.university.businessObjects.Auditorium;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: oleksiy.konkin
 * Date: 2/20/13
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class AuditoriumTest {
    Auditorium oneAuditorium = new Auditorium();
    Auditorium oneAuditoriumThreeArgs = new Auditorium(1,1,1,1,"Small auditorium");

    @Test
     public void testSetAuditoriumId() throws Exception {
        oneAuditorium.setAuditoriumId(10);
        assertEquals(10,(int)oneAuditorium.getAuditoriumId());
    }

    @Test
    public void testSetCampusId() throws Exception {
        oneAuditorium.setCampusId(10);
        assertEquals(10,(int)oneAuditorium.getCampusId());
    }

    @Test
    public void testSetFloorId() throws Exception {
        oneAuditorium.setFloorId(10);
        assertEquals(10,(int)oneAuditorium.getFloorId());
    }

    @Test
    public void testSetAuditoriumNumber() throws Exception {
        oneAuditorium.setAuditoriumNumber(10);
        assertEquals(10,(int)oneAuditorium.getAuditoriumNumber());
    }

    @Test
    public void testSetTextComment() throws Exception {
        oneAuditorium.setTextComment("none");
        assertEquals("none", oneAuditorium.getTextComment());
    }

    @Test
    public void testAuditorium() throws Exception {
        assertEquals(0,(int)oneAuditorium.getAuditoriumId());
        assertEquals(0,(int)oneAuditorium.getCampusId());
        assertEquals(0,(int)oneAuditorium.getFloorId());
        assertEquals(0,(int)oneAuditorium.getAuditoriumNumber());
        assertEquals("-",oneAuditorium.getTextComment());
    }

    @Test
    public void testAuditoriumThreeParams() throws Exception {
        assertEquals(1,(int)oneAuditoriumThreeArgs.getAuditoriumId());
        assertEquals(1,(int)oneAuditoriumThreeArgs.getCampusId());
        assertEquals(1,(int)oneAuditoriumThreeArgs.getFloorId());
        assertEquals(1,(int)oneAuditoriumThreeArgs.getAuditoriumNumber());
        assertEquals("Small auditorium",oneAuditoriumThreeArgs.getTextComment());
    }

}

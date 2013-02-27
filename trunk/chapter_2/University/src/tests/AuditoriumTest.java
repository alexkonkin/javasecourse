package tests;

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

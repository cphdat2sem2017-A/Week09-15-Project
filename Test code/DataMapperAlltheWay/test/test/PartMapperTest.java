package test;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Part;
import data.PartMapper;

public class PartMapperTest {

    PartMapper pm;
    JdbcTestFixture fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new JdbcTestFixture();
        fixture.setUp();
        pm = new PartMapper();
    }

    @Test
    public void testGetPart() {
        Part p = pm.getPart(10506);
        assertTrue("Get Part failed", p.getPno() == 10506);
    }

    @Test
    public void testUpdatePart() {
        pm.updatePart(10506, 400);
        Part p = pm.getPart(10506);
        assertTrue("Update part failed", p.getQOH() == 400);
    }
}

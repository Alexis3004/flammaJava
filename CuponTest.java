

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CuponTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CuponTest
{
    private Cupon cupon1;

    /**
     * Default constructor for test class CuponTest
     */
    public CuponTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        cupon1 = new Cupon(1, "flammashop2020", .2);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void TestGetNombre()
    {
        assertEquals("flammashop2020", cupon1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, cupon1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("BlackFriday", cupon1.setNombre("BlackFriday"));
    }
    
    @Test
    public void TestGetDescuento()
    {
        assertEquals(.2, cupon1.getDescuento(),1e-30);
    }
    
    @Test
    public void TestSetDescuento()
    {
        assertEquals(.1, cupon1.setDescuento(.1),1e-30);
    }
}



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CiudadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CiudadTest
{
    private Ciudad ciudad1;

    /**
     * Default constructor for test class CiudadTest
     */
    public CiudadTest()
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
        ciudad1 = new Ciudad(1, "Bucaramanga", 5000);
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
        assertEquals("Bucaramanga", ciudad1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, ciudad1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("Búcara", ciudad1.setNombre("Búcara"));
    }
    
    @Test
    public void TestGetCosto()
    {
        assertEquals(5000, ciudad1.getCosto(),1e-30);
    }
    
    @Test
    public void setCosto()
    {
        ciudad1.setCosto(10000);
        assertEquals(10000, ciudad1.getCosto(),1e-30);
    }
}

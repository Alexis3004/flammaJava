

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ColeccionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ColeccionTest
{
    private Coleccion coleccio1;

    /**
     * Default constructor for test class ColeccionTest
     */
    public ColeccionTest()
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
        coleccio1 = new Coleccion(1, "Básicos", "Ropa casual", "10/07/2020");
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
    public void TestGetDescripcion()
    {
        assertEquals("Ropa casual", coleccio1.getDescripcion());
    }

    @Test
    public void TestSetdescripcion()
    {
        assertEquals("De todo", coleccio1.setdescripcion("De todo"));
    }
    
    @Test
    public void TestGetNombre()
    {
        assertEquals("Básicos", coleccio1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, coleccio1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("News", coleccio1.setNombre("News"));
    }
}

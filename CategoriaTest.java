

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CategoriaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CategoriaTest
{
    private Categoria categori1;

    /**
     * Default constructor for test class CategoriaTest
     */
    public CategoriaTest()
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
        categori1 = new Categoria(1, "Accesories", "Accesorios flamma");
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
        assertEquals("Accesorios flamma", categori1.getDescripcion());
    }

    @Test
    public void TestSetdescripcion()
    {
        assertEquals("Accesorios varios", categori1.setdescripcion("Accesorios varios"));
    }
    
    @Test
    public void TestGetNombre()
    {
        assertEquals("Accesories", categori1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, categori1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("Accesorios", categori1.setNombre("Accesorios"));
    }
}



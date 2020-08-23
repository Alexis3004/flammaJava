

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AlmacenProductoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlmacenProductoTest
{
    private Factory factory1;
    private AlmacenProducto almacenP1;
    private java.util.ArrayList<Item> cate;
    private java.util.ArrayList<Item> cole;
    private java.util.ArrayList<Item> prod;
    private String det;
    /**
     * Default constructor for test class AlmacenProductoTest
     */
    public AlmacenProductoTest()
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
        factory1 = new Factory();
        almacenP1 = factory1.getProductos();
        det = almacenP1.getObjetos();
        prod = almacenP1.getLista();
        cate = factory1.getCategoras().getLista();
        cole = factory1.getColecciones().getLista();
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
    public void TestGetProductosClasificacion()
    {
        assertEquals(prod, almacenP1.getProductosClasificacion(cole.get(0)));
    }

    @Test
    public void TestDelProductoClasificacion()
    {
        assertEquals(true, almacenP1.delProductoClasificacion(cate.get(0)));
        assertEquals(false, almacenP1.delProductoClasificacion(cate.get(0)));
    }

    @Test
    public void TestGetObjetosClasificacion()
    {
        assertEquals(det, almacenP1.getObjetosClasificacion(cole.get(0)));
        assertEquals(true, almacenP1.delProductoClasificacion(cole.get(0)));
        assertEquals("no hay objetos disponibles", almacenP1.getObjetosClasificacion(cate.get(0)));
    }
}




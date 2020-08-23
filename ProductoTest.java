

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ProductoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ProductoTest
{
    private Producto producto1;
    private Item categoria1;
    private Item coleccion1;
    /**
     * Default constructor for test class ProductoTest
     */
    public ProductoTest()
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
        categoria1 = new Categoria(2,"Accesories", "Accesorios flamma");
        coleccion1 = new Coleccion(1,"Básicos", "Ropa casual","16/08/2020");
        producto1 = new Producto(1, "Glasses flamma", 60000, "Gafas de llama", "única", 20, categoria1,coleccion1);
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
        assertEquals("Glasses flamma", producto1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, producto1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("Glasses", producto1.setNombre("Glasses"));
    }
    
    @Test
    public void TestGetDescripcion()
    {
        assertEquals("Gafas de llama", producto1.getDescripcion());
    }
    
    @Test
    public void TestGetCosto()
    {
        assertEquals(60000, producto1.getCosto(),1e-30);
    }
    
    @Test
    public void TestGetTalla()
    {
        assertEquals("única", producto1.getTalla());
    }
    
    @Test
    public void TestGetCantidad()
    {
        assertEquals(20, producto1.getCantidad());
    }
    
    @Test
    public void TestGetCategoria()
    {
        assertEquals(categoria1, producto1.getCategoria());
    }
    
    @Test
    public void TestGetColeccion()
    {
        assertEquals(coleccion1, producto1.getColeccion());
    }
    
    @Test
    public void TestSetDescripcion()
    {
        assertEquals("Gafas", producto1.setDescripcion("Gafas"));
    }
    
    @Test
    public void TestSetCosto()
    {
        assertEquals(true, producto1.setCosto(10000));
        assertEquals(10000, producto1.getCosto(),1e-30);
    }
    
    @Test
    public void TestSetCostoNegativo()
    {
        assertEquals(false, producto1.setCosto(-10000));
    }
    
    @Test
    public void TestSetTalla()
    {
        assertEquals("exclusiva", producto1.setTalla("exclusiva"));
    }
    
    @Test
    public void TestaumentaCantidad()
    {
        assertEquals(true, producto1.aumentaCantidad(2));
        assertEquals(22, producto1.getCantidad());
    }
    
    @Test
    public void TestaumentaCantidadNegativa()
    {
        assertEquals(false, producto1.aumentaCantidad(-2));
        assertEquals(20, producto1.getCantidad());
    }
    
    @Test
    public void TestdisminuyeCantidad()
    {
        assertEquals(true, producto1.disminuyeCantidad(2));
        assertEquals(18, producto1.getCantidad());
    }
    
    @Test
    public void TestdisminuyeCantidadNegativa()
    {
        assertEquals(false, producto1.disminuyeCantidad(-2));
        assertEquals(20, producto1.getCantidad());
    }
    
    /**
     * probar disminuir una cantidad mayor a la que hay
     */
    @Test
    public void TestdisminuyeCantidadMayor()
    {
        assertEquals(false, producto1.disminuyeCantidad(21));
    }
}

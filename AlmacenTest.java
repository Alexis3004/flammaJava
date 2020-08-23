

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class AlmacenTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AlmacenTest
{
    private Factory factory1;
    private AlmacenProducto almacenP1;
    private java.util.ArrayList<Item> prods1;
    private Almacen almacen1;
    private Almacen almacen2;
    private Factory factory2;
    private java.util.ArrayList<Item> pedi1;
    private Item pedido2;

    /**
     * Default constructor for test class AlmacenTest
     */
    public AlmacenTest()
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
        factory2 = new Factory();
        almacenP1 = factory1.getProductos();
        prods1 = almacenP1.getLista();
        almacen1 = factory1.getPedidos();
        almacen2 = factory2.getPedidos();
        pedi1 = almacen2.getLista();
        pedido2 = factory1.getPedidos().getLista().get(2);
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
    public void TestGetNumeroObjetos()
    {
        assertEquals(3, almacen1.getNumeroObjetos(),1e-30);
    }
    
    @Test
    public void TestGetNumeroCompras()
    {
        assertEquals(5, almacen1.getNumeroCompras(),1e-30);
    }
    
    @Test
    public void TestBuscarProducto()
    {
        assertEquals(true, almacen1.buscarProducto(prods1.get(0)));
        assertEquals(true, almacen1.buscarProducto(prods1.get(1)));
        assertEquals(true, almacen1.buscarProducto(factory2.getProductos().getLista().get(2)));
        assertEquals(false, almacen1.buscarProducto(prods1.get(5)));
    }
    
    @Test
    public void TestAddElemento()
    {
        assertEquals(false, almacen1.addElemento(pedi1.get(0)));
        assertEquals(true, almacen1.EliminarElemento(3));
        assertEquals(2, almacen1.getNumeroObjetos(),1e-30);
        assertEquals(true, almacen1.addElemento(pedido2));
    }
    
    @Test
    public void TestGetObjetos()
    {
        almacen1.vaciarAlmacen();
        assertEquals("No hay items almacenados todavía", almacen1.getObjetos());
    }
    
    @Test
    public void TestGetObjeto()
    {
        assertEquals(pedi1.get(0), almacen1.getObjeto(1));
        assertEquals(true, almacen1.EliminarElemento(3));
        assertEquals(null, almacen1.getObjeto(3));
        almacen1.vaciarAlmacen();
        assertEquals(null, almacen1.getObjeto(1));
    }
    
    
    @Test
    public void TestGetObjetoN()
    {
        assertEquals(pedi1.get(0), almacen1.getObjetoN("Alexis Cáceres"));
        assertEquals(null, almacen1.getObjetoN("sacarías"));
        almacen1.vaciarAlmacen();
        assertEquals(null, almacen1.getObjetoN("Alexis Cáceres"));
    }
    
    @Test
    public void TestEliminarElemento()
    {
        assertEquals(false, almacen1.EliminarElemento(5));
        assertEquals(true, almacen1.EliminarElemento(1));
        almacen1.vaciarAlmacen();
        assertEquals(false, almacen1.EliminarElemento(1));
    }
}

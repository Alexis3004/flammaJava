

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PedidoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PedidoTest
{
    private Factory factory1;
    private Almacen cupon1;
    private Pedido pedido1;
    //private AlmacenProducto almacenP1;
    private Carrito carrito1;
    //private java.util.HashMap<Producto,java.lang.Integer> hashMap1;

    /**
     * Default constructor for test class PedidoTest
     */
    public PedidoTest()
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
        cupon1 = factory1.getCupones();
        //almacenP1 = factory1.getProductos();
        carrito1 = new Carrito();
        carrito1.addProducto(1, factory1.getProductos(), 7);
        carrito1.addProducto(2, factory1.getProductos(), 1);
        pedido1 = new Pedido(1, "Jenny Santamaría", "Bucaramanga", 5000, "campo hermoso", carrito1.getcarro(), carrito1.calcularSubTotal());
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
        assertEquals("Jenny Santamaría", pedido1.getNombre());
    }
    
    @Test
    public void TestGetId()
    {
        assertEquals(1, pedido1.getId());
    }
    
    
    @Test
    public void TestSetNombre()
    {
        assertEquals("Alexis", pedido1.setNombre("Alexis"));
    }
    /*
    @Test
    public void TestGetFecha()
    {
        assertEquals("2020-08-21", pedido1.getFecha());
    }*/

    @Test
    public void TestGetCiudad()
    {
        assertEquals("Bucaramanga", pedido1.getCiudad());
    }

    @Test
    public void TestGetCostoDomi()
    {
        assertEquals(5000, pedido1.getCostoDomi(), 1e-30);
    }
    
    @Test
    public void TestGetDescuento()
    {
        assertEquals(0, pedido1.getDescuento(), 1e-30);
    }

    @Test
    public void TestGetEstado()
    {
        assertEquals("no enviado", pedido1.getEstado());
    }
    
    @Test
    public void TestGetDireccion()
    {
        assertEquals("campo hermoso", pedido1.getDireccion());
    }
    
    @Test
    public void TestGetsubTotal()
    {
        assertEquals(415000, pedido1.getsubTotal(),1e-30);
    }
    
    @Test
    public void TestGetTotal()
    {
        assertEquals(420000, pedido1.getTotal(),1e-30);
    }
    
    @Test
    public void TestAgregarCupon()
    {
        assertEquals(true, pedido1.agregarCupon("BlackFriday",cupon1));
        assertEquals(.5, pedido1.getDescuento(), 1e-30);
        assertEquals(212500, pedido1.getTotal(),1e-30);
        
        assertEquals(false, pedido1.agregarCupon("nocupon",cupon1));
    }
    
    @Test
    public void TestSetEstado()
    {
        pedido1.setEstado("enviado");
        assertEquals("enviado", pedido1.getEstado());
    }
    
    @Test
    public void TestGetObjetoDetalle()
    {
        assertEquals(carrito1.getcarro(), pedido1.getObjetoDetalle());
    }
}





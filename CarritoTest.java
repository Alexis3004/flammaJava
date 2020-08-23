

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CarritoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CarritoTest
{
    private Carrito carrito1;
    private AlmacenProducto almacenP1;
    private Factory fact1;
    /**
     * Default constructor for test class CarritoTest
     */
    public CarritoTest()
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
        carrito1 = new Carrito();
        almacenP1 = new AlmacenProducto();
        fact1 = new Factory();
        almacenP1 = fact1.getProductos();
        carrito1.addProducto(1, almacenP1, 2);
        carrito1.addProducto(2, almacenP1, 3);
        carrito1.addProducto(3, almacenP1, 1);
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
    public void TestGetCantidad()
    {
        //cuando existe el producto en el carrito
        assertEquals(2, carrito1.getCantidad(1),1e-30);
        //cuando el producto no existe en el carrito
        assertEquals(0, carrito1.getCantidad(6),1e-30);
    }
    
    @Test
    public void TestAddProducto()
    {
        //Cuando se intenta agregar un producto que no existe, pero si está almacenado
        assertEquals(true, carrito1.addProducto(5,almacenP1,2));
        assertEquals(2, carrito1.getCantidad(5),1e-30);
        //Cuando el producto ya está en el carrito
        assertEquals(true, carrito1.addProducto(1,almacenP1,2));
        assertEquals(4, carrito1.getCantidad(1),1e-30);
        //Cuando se desea agregar un producto con una cantidad negativa
        assertEquals(false, carrito1.addProducto(4,almacenP1,-2));
    }
    
    
    @Test
    public void TestBuscarProducto()
    {
        //cuando el producto no está en el carrito
        assertEquals(null, carrito1.buscarProducto(7));
        //cuando el producto se encuentra en el carrito
        assertEquals(almacenP1.getObjeto(1), carrito1.buscarProducto(1));
    }
    
    @Test
    public void TestDelProducto()
    {
        //eliminar un producto que no está agregado
        assertEquals(false, carrito1.delProducto(7));
        //eliminar un producto que sí está agregado
        assertEquals(true, carrito1.delProducto(1));
        assertEquals(null, carrito1.buscarProducto(1));
    }
    
    @Test
    public void TestMostrarContenido()
    {
        //cuando el carrito está vacío
        carrito1.vaciarCarrito();
        assertEquals("Su carrito está vacío", carrito1.mostrarContenido());
    }
    
    @Test
    public void TestCalcularSubTotal()
    {
        //cuando no está vacío
        assertEquals(315000, carrito1.calcularSubTotal(),1e-30);
        //cuando el carrito está vacío
        carrito1.vaciarCarrito();
        assertEquals(0, carrito1.calcularSubTotal(),1e-30);
    }
}

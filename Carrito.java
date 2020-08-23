import java.util.HashMap;
/**
 * Write a description of class Carrito here.
 * 
 * @author Alexis Cáceres & Jenny Santamaría  
 * @version 2
 */

public class Carrito
{
    private HashMap<Producto, Integer> carro;
    /**
     * el carrito se crea para un usuario en específico y su subtotal inicial es 0
    */
    public Carrito()
    {
        carro = new HashMap<Producto, Integer>();
    }
    
    public HashMap<Producto,Integer> getcarro()
    {
        return carro;
    }
    
    /**
     * Con este método se pueden añadir producuos al carrito, que posteriormente serán comprados
     * @param producto producto a agregar
     * @param cantidad, cantidad del producto a agregar
     */
    public boolean addProducto(int producto,Almacen lista, int cantidad)
    {
        if(cantidad>0)
        {
            Item produc = lista.getObjeto(producto);
            if(produc != null)
            {
                Producto prod = buscarProducto(produc.getId());
                if(prod == null)
                {
                    carro.put(((Producto) produc), cantidad);
                }
                else
                {
                    int cant = carro.get(produc);
                    carro.remove(produc);
                    carro.put(((Producto) produc), cant + cantidad);
                }
                return true;
            }
        }
        return false;
    }
    
    public Producto buscarProducto(int referencia)
    {
        for (Producto prod : carro.keySet()) 
        {
            if(prod.getId()==referencia)
            {
                return prod;
            }
        }
        return null;
    }
    
    /**
     * Con este método se pueden eliminar producuos del carrito
     * @param producto producto a eliminar
     */
    public boolean delProducto(int referencia)
    {
        Producto producto = buscarProducto(referencia);
        if(producto != null)
        {
            for (Producto prod : carro.keySet()) 
            {
                if(prod.equals(producto))
                {
                    carro.remove(prod);
                    return true;
                }
            }
        }
        return false;
        
    }
    
    /**
     * Con este método se muestran todos los productos agragados al carrito así como la cantidad
     * @return detalle del carrito
     */
    public String mostrarContenido()
    {
        if(carro.size() > 0)
        {
            String conte = "";
            for (Producto prod : carro.keySet()) 
            {
                conte = conte + prod.toString() + " cantidad: " + carro.get(prod) + "\n";
            }
            return conte;
        }
        else
        {
            return "Su carrito está vacío";
        }
    }
    
    /**
     * Con este método, se eliminan todos los productos que se encuentran en el carrito
     */
    public void vaciarCarrito()
    {
        carro.clear();
    }
    
    public double getCantidad(int referencia)
    {
        Producto producto = buscarProducto(referencia);
        if(producto != null)
        {
            return carro.get(producto);
        }
        return 0;
    }
    
    /**
     * Con este método se calcula el subtotal a pagar por los artículos que están en el carrito
     */
    public double calcularSubTotal()
    {
        if(carro.size() > 0)
        {
            double subtotal = 0;
            for (Producto prod : carro.keySet()) 
            {
                subtotal = subtotal + (((Producto) prod).getCosto()*carro.get(prod));
            }
            return subtotal;
        }
        else
        {
            return 0;
        }
    }
}

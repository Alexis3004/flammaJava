import java.util.HashMap;
/**
 * Clase encargada de almacenar los productos que el cliente desea comprar, así como la cantidad
 * 
 * @author Alexis Cáceres & Jenny Santamaría  
 * @version 2
 */

public class Carrito
{
    private HashMap<Producto, Integer> carro;
    /**
     *el carrito se crea para un usuario y su subtotal inicial es 0
    */
    public Carrito()
    {
        carro = new HashMap<Producto, Integer>();
    }
    
    /**
     *@return HashMap de detalle del producto
    */
    public HashMap<Producto,Integer> getcarro()
    {
        return carro;
    }
    
    /**
     * Con este método se pueden añadir producuos al carrito, que posteriormente serán comprados
     * @param producto producto a agregar
     * @param cantidad, cantidad del producto a agregar
     * @return true si se pudo añadir, false si no
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
                    if(((Producto) produc).getCantidad()>=cantidad)
                    {
                        carro.put(((Producto) produc), cantidad);
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    if(((Producto) produc).getCantidad()>=(cantidad+carro.get(produc)))
                    {
                        int cant = carro.get(produc);
                        carro.remove(produc);
                        carro.put(((Producto) produc), cant + cantidad);
                    }
                    else
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    /**
     * Realiza la búsqueda de un producto dentro del carrito
     * @param referencia, esta es la referencia del producto que se desea buscar
     * @return objeto Producto si lo encuentra dentro del carrito, null si no lo ecuentra
    */
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
     * @param referencia del producto a eliminar
     * @return true si se pudo eliminar, false si no
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
     *Con este método se muestran todos los productos agragados al carrito así como la cantidad
     *@return detalle del carrito
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
     *Con este método, se eliminan todos los productos que se encuentran en el carrito
     */
    public void vaciarCarrito()
    {
        carro.clear();
    }
    
    /**
     *obtiene la cantidad que se encuentra agregada de un producto específico
     *@param referencia del producto del cual se va a obtener la cantidad
     *@return double con la cantidad del producto
    */
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
     * @return double con el valor subTotal
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

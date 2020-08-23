/**
 * Encargada de representar cada uno de los productos que ofrece la tienda virtual
 * @author Alexis Cáceres y Jenny Santamaría 
 * @version 2
 */
public class Producto extends Item
{
    private double costo;
    private String descripcion;
    private String talla;
    private int cantidad;
    private Item categoria;
    private Item coleccion;
    
    /**
     *El producto debe inizializarse con una referencia un nombre, el costo comercial, una descripción, la talla del producto
     *la cantidad en existencia, la categoría a la que pertenece y la colección en la que fué lanzado.
     *@param referencia int con la referencia del producto
     *@param nombre String con el nombre del producto
     *@param costo double con el costo del producto
     *@param descripcion String con la descripción del producto
     *@param talla String con la talla que tiene el producto
     *@param catidad int con la cantidad en stock del producto
     *@param categoria Item objeto de tipo Categoria a la que pertenece el producto
     *@param coleccion Item objeto de tipo Coleccion a la que pertenece el producto
    */
    public Producto(int referencia, String nombre,double costo,String descripcion,
    String talla, int cantidad, Item categoria, Item coleccion)
    {
        super(referencia,nombre);
        this.costo=costo;
        this.descripcion=descripcion;
        this.talla=talla;
        this.cantidad=cantidad;
        this.categoria=categoria;
        this.coleccion=coleccion;
    }
    
    /**
     * Obtiene la descripcion del producto
     */
    public String getDescripcion()
    {
        return this.descripcion;
    }
    
    /**
     * Obtiene el costo del producto
     */
    public double getCosto()
    {
        return this.costo;
    }
    
    /**
     * Obtiene la talla del producto
     */
    public String getTalla()
    {
        return this.talla;
    }
    
    /**
     * obtiene la cantidad en stock del producto 
     */
    public int getCantidad()
    {
        return this.cantidad;
    }
    
    /**
     * Obtiene el objeto el objeto categoría a la que pertenece el producto
     */
    public Item getCategoria()
    {
        return this.categoria;
    }
    
    /**
     * Obtiene el objeto el objeto colección a la que pertenece el producto
     */
    public Item getColeccion()
    {
        return this.coleccion;
    }
    
    public String setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
        return this.descripcion;
    }
    
    /**
     *Cambia el costo del producto
     *@param costo int con el nuevo costo del producto, debe ser mayor que cero
     *@return false si no se puede cambiar el costo, true si se puede cambiar el costo
    */
    public boolean setCosto(double costo)
    {
        if(costo>0)
        {
            this.costo = costo;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Modifica la talla del producto
     * @param talla String con la nueva talla del producto
     */
    public String setTalla(String talla)
    {
        this.talla = talla;
        return this.talla;
    }
    
    /**
     *Con este método aumenta la cantidad del producto, la cantidad a aumentar debe ser un entero positivo mayor que cero
     *@param cantidad int con la cantidad a quitar del la existencia del producto
     *@return false si no se puede aumentar la cantidad, true si se puede aumentar la cantidad
     */
    public boolean aumentaCantidad(int cantidad)
    {
        if(cantidad>0)
        {
            this.cantidad = this.cantidad+cantidad;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *Con este método disminuye la cantidad del producto, la cantidad a disminuir debe ser un entero positivo mayor que cero
     *y no debe exceder la existencia actual del producto.
     *@param cantidad int con la cantidad a quitar del la existencia del producto
     *@return false si no se puede disminuir la cantidad, true si se puede disminuir la cantidad
     */
    public boolean disminuyeCantidad(int cantidad)
    {
        if(cantidad>0 && (getCantidad()-cantidad>=0))
        {
            this.cantidad = this.cantidad-cantidad;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     *Obtiene la información del producto
     *@return String con la información
    */
    public String toString()
    {
        String producto = super.toString();
        producto = producto + "    " + getTalla() + "    $" + getCosto();
        if(this.getCantidad()>0 && this.getCantidad()<5)
        {
            producto = producto + "    "+"ÚLTIMAS UNIDADES("+this.getCantidad()+")";
        }
        if(this.getCantidad()==0)
        {
            producto = producto + "    "+"AGOTADO";
        }
        return producto;
    }
    
    /**
     *Permite saber si dos objetos de esta clase son iguales
     *@param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
    public boolean equals (Object obj) 
    {
        if (obj instanceof Producto && super.equals(obj) )
        {
            Producto tmpProducto = (Producto) obj;
            if (this.costo==tmpProducto.getCosto() && this.descripcion.equals(tmpProducto.getDescripcion())
            &&this.talla.equals(tmpProducto.getTalla()) && this.cantidad==tmpProducto.getCantidad() 
            && this.categoria.equals(tmpProducto.getCategoria()) && this.coleccion.equals(tmpProducto.getColeccion())) 
            {
                return true; 
            }
            else 
            { 
                return false; 
            }
        } 
        else 
        { 
            return false; 
        }
    }   
}

    
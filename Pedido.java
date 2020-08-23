import java.time.LocalDate;
import java.util.*;
/**
 * Representa la compra de productos y los datos del comprador en cuestion
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class Pedido extends Item
{
    private String fecha;
    private String direccion;
    private String ciudad;
    private double costoDomi;
    private double total;
    private double subtotal;
    private String estado;
    private HashMap<Producto, Integer> detalle;
    private double descu;
    /**
     *Se crea el pedido con un número de pedido,una fecha de realización del pedido, un usuario propietario del pedido
     *una ciudad a la que va el pedido, una dirección de envío, un estado del pedido que inicialmente será no enviado y
     *un descuento que por defecto es cero.
    */
    public Pedido(int numero,String usuario, String ciudad,double costo, String direccion,HashMap<Producto,Integer> car,double subtotal)
    {
        super(numero,usuario);
        LocalDate myObj = LocalDate.now();
        this.fecha = ""+ myObj;
        this.direccion = direccion;
        this.detalle = car;
        this.subtotal = subtotal;
        this.estado = "no enviado";
        this.ciudad = ciudad;
        this.costoDomi = costo;
        this.total = subtotal + costo;
        this.descu = 0;
    }
    
    /**
     * Obtiene la fecha en la que se realizó el pedido
     */
    public String getFecha()
    {
        return this.fecha;
    }
    
    /**
     * Obtiene la ciudad a la que el pedido va dirigido
     */
    public String getCiudad()
    {
        return this.ciudad;
    }
    
    /**
     * Obtiene el costo del domicilio a la ciudad de destino
     */
    public double getCostoDomi()
    {
        return this.costoDomi;
    }
    
    /**
     * obtiene el descuento que se le hizo al pedido
     */
    public double getDescuento()
    {
        return this.descu;
    }
    
    /**
     * Obtiene el estado del pedido
     */
    public String getEstado()
    {
        return this.estado;
    }
    
    /**
     * Obtine la dirección a la que va dirigido el pedido
     */
    public String getDireccion()
    {
        return this.direccion;
    }
    
    /**
     * Obtiene el subtotal del pedido, sin tener en cuenta el costo del domicilio y el descuento que se le hizo
     */
    public double getsubTotal()
    {
        return this.subtotal;
    }
    
    /**
     * Obtiene el total del pedido, es decir el subtotal más el costo de envío menos el descuento
     */
    public double getTotal()
    {
        return this.total;
    }
    
    /**
     *@return HashMap de detalle del producto
    */
    public HashMap<Producto, Integer> getObjetoDetalle()
    {
        return this.detalle;
    }
    
    /**
     * Este método comprueba si existe un cupón con ese nombre, de ser así, modifica el valor que tiene el cupón de dscunto del pedido 
     * @param cupon un nombre de un cupón
     * @param cupones, lista de cupones almacenados
     * return true si encontró el cupon en la lista de cupones y lo agrega al pedido,
     * false si no lo encuentra
    */
    public boolean agregarCupon(String cupon, Almacen cupones)
    {
        ArrayList<Item> listacupones = cupones.getLista();
        for(Item cup: listacupones)
        {
            if(cup.getNombre().equals(cupon))
            {
                this.descu = ((Cupon)cup).getDescuento();
                this.total = (subtotal-(subtotal*descu)) + getCostoDomi();
                return true;
            }
        }
        return false;
    }
    
    /**
     *Este método modifica el estado inicial del pedido
     *@param estado un estado del pedido
    */
    public void setEstado(String estado)
    {
       this.estado = estado;
    }
    
    /**
     * Hace la confirmación del pedido y le disminuye la cantidad a los productos comprados
     * @return true si pudo disminuir la cantidad de todos los productos, false si no
     */
    public boolean ConfirmarPedido()
    {
        for(Item it:  getObjetoDetalle().keySet())
        {
            if(!((Producto) it).disminuyeCantidad(getObjetoDetalle().get(it)))
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Obtiene el detalle del pedido, los productos de este pedido, el costo del domicilio
     * el descuento y el costo total del pedido
     *@return String con el detalle del pedido
    */
    public String getDetalle()
    {
        if(detalle.size()>0)
        {
            String deta = "Referencia   nombre  talla   costo   cantidad    subtotal \n"; 
            for (Item prod : detalle.keySet()) 
            {
                deta = deta + prod.toString() + " " + detalle.get(prod) + " " +(((Producto) prod).getCosto()*detalle.get(prod))+"\n";
            }
            deta = deta + "subtotal: "+ getsubTotal()+"\n"+"costo envío: +"+getCostoDomi()+"\n";
            deta = deta + "Descuento: -"+getDescuento()*getsubTotal()+"\n"+"Total: "+getTotal()+"\n";
            return deta;
        }
        return "No se ha agregado productos al pedido";
    }
    
    /**
     * Obtiene la información del pedido
     *@return String con la información
    */
    public String toString()
    {
        String pedido = "";
        pedido = pedido + "#pedido: "+super.getId() + "\n";
        pedido = pedido + "fecha: "+getFecha()+"\n";
        pedido = pedido + "dirección: "+getDireccion()+"\n";
        pedido = pedido + "ciudad: "+getCiudad()+"\n";
        pedido = pedido + "cliente: "+super.getNombre()+"\n";
        pedido = pedido + "estado: "+this.getEstado()+"\n";
        pedido = pedido + "total: "+getTotal()+"\n";
        return pedido;
    }
    
    /**
     * Permite saber si dos objetos de esta clase son iguales
     * @param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
    public boolean equals (Object obj) 
    {
        if (obj instanceof Pedido && super.equals(obj) )
        {
            Pedido tmpPedido = (Pedido) obj;
            if ((this.direccion.equals(tmpPedido.getDireccion()) && (this.total==tmpPedido.getTotal())) && 
            (this.subtotal==tmpPedido.getsubTotal()) && (this.ciudad.equals(tmpPedido.getCiudad())) && (this.estado.equals(tmpPedido.getEstado()))) 
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

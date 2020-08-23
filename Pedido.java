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
    private Item descuento;
    private String estado;
    private HashMap<Producto, Integer> detalle;
    /**
     * Se crea el pedido con un número de pedido,una fecha de realización del pedido, un usuario propietario del pedido
     * una ciudad a la que va el pedido, una dirección de envío, un estado del pedido que inicialmente será no enviado y
     * un descuento que por defecto es cero.
    */
    public Pedido(int numero,String usuario, String ciudad,double costo, String direccion,HashMap<Producto,Integer> car,double subtotal)
    {
        super(numero,usuario);
        LocalDate myObj = LocalDate.now();
        this.fecha = ""+ myObj;
        this.direccion = direccion;
        this.detalle = car;
        this.subtotal = subtotal;
        this.descuento = null;
        this.estado = "no enviado";
        this.ciudad = ciudad;
        this.costoDomi = costo;
        this.total = subtotal + costo;
    }
    
    public String getFecha()
    {
        return this.fecha;
    }
    
    public String getCiudad()
    {
        return this.ciudad;
    }
    
    public double getCostoDomi()
    {
        return this.costoDomi;
    }
    
    public double getDescuento()
    {
        if(descuento != null)
        {
            return ((Cupon) descuento).getDescuento();
        }
        return 0;
    }
    
    public String getEstado()
    {
        return this.estado;
    }
    
    public String getDireccion()
    {
        return this.direccion;
    }
    
    public double getsubTotal()
    {
        return this.subtotal;
    }
    
    public double getTotal()
    {
        return this.total;
    }
    
    public HashMap<Producto, Integer> getObjetoDetalle()
    {
        return this.detalle;
    }
    
    /**
     * Este método comprueba si existe un cupón con ese nombre, de ser así, modifica el valor que tiene el cupón de dscunto del pedido 
     * @param cupon un nombre de un cupón
    */
    public boolean agregarCupon(String cupon, Almacen cupones)
    {
        ArrayList<Item> listacupones = cupones.getLista();
        for(Item cup: listacupones)
        {
            if(cup.getNombre().equals(cupon))
            {
                this.descuento = cup;
                this.total = (subtotal-(subtotal*((Cupon) cup).getDescuento())) + getCostoDomi();
                return true;
            }
        }
        return false;
    }
    
    /**
     * Este método modifica el estado inicial del pedido
     * @param estado un estado del pedido
    */
    public void setEstado(String estado)
    {
       this.estado = estado;
    }
    
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
    
    public String toString()
    {
        String pedido = "";
        pedido = pedido + "#pedido: "+super.getId() + "\n";
        pedido = pedido + "fecha: "+getFecha()+"\n";
        pedido = pedido + "dirección: "+getDireccion()+"\n";
        pedido = pedido + "ciudad: "+getCiudad()+"\n";
        pedido = pedido + "cliente: "+super.getNombre()+"\n";
        pedido = pedido + "total: "+getTotal()+"\n";
        return pedido;
    }

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
import java.util.*;
/**
 * 
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class Factory
{
    private Almacen ciudades;
    private Almacen cupones;
    private AlmacenProducto productos;
    private Almacen categorias;
    private Almacen colecciones;
    private Almacen pedidos;
    /**
     * Constructor for objects of class Factory
     */
    public Factory()
    {
       ciudades = new Almacen();
       cupones = new Almacen();
       productos = new AlmacenProducto(); 
       categorias = new Almacen();
       colecciones = new Almacen();
       pedidos = new Almacen();
       
       ciudades.addElemento(new Ciudad(1,"Floridablanca",6000));
       ciudades.addElemento(new Ciudad(2,"Bucaramanga",5000));
       ciudades.addElemento(new Ciudad(3,"Piedecuesta",7000));
       ciudades.addElemento(new Ciudad(4,"Lebrija",8000));
       ciudades.addElemento(new Ciudad(5,"San Gil",10000));
       
       cupones.addElemento(new Cupon(1,"flammashop",0.2));
       cupones.addElemento(new Cupon(2,"BlackFriday",0.5)); 
       
       categorias.addElemento(new Categoria(1,"T-shirt & tops", "Camisetas y tops flamma"));
       categorias.addElemento(new Categoria(2,"Accesories", "Accesorios flamma"));
       categorias.addElemento(new Categoria(3,"Bucket hats & balaclava", "Gorros flamma"));
       colecciones.addElemento(new Coleccion(1,"Básicos", "Ropa casual","16/08/2020"));
       productos.addElemento(new Producto(1, "Bucket hats basic",50000,"Gorro pescador en drill","estándar", 30, categorias.getObjetoN("Bucket hats & balaclava"), colecciones.getObjetoN("Básicos")));
       productos.addElemento(new Producto(2, "Balaclava basic",65000,"100% acrílico","estándar", 30, categorias.getObjetoN("Bucket hats & balaclava"), colecciones.getObjetoN("Básicos"))); 
       productos.addElemento(new Producto(3, "T-shirt basic flamma",20000,"Logotipo frontal serigrafiado","S", 30, categorias.getObjetoN("T-shirt & tops"), colecciones.getObjetoN("Básicos")));   
       productos.addElemento(new Producto(4, "Glasses flamma",60000,"Gafas de llama","única", 20, categorias.getObjetoN("Accesories"), colecciones.getObjetoN("Básicos")));
       productos.addElemento(new Producto(5, "Scarf flamma",25000,"Pañoletas flamma","estándar", 25, categorias.getObjetoN("Accesories"), colecciones.getObjetoN("Básicos")));
       productos.addElemento(new Producto(6, "prueba",0,"un producto de prueba","estándar", 1, categorias.getObjetoN("Accesories"), colecciones.getObjetoN("Básicos")));
       
       Carrito carro = new Carrito();
       carro.addProducto(1,productos,5);
       carro.addProducto(2,productos,2);
       carro.addProducto(3,productos,5);
       pedidos.addElemento(new Pedido(1,"Alexis Cáceres","Bucaramanga",((Ciudad) ciudades.getObjetoN("Bucaramanga")).getCosto(),"Cll 13 #29-17",carro.getcarro(),carro.calcularSubTotal()));
       Carrito carro1 = new Carrito();
       carro1.addProducto(5,productos,6);
       carro1.addProducto(4,productos,10);
       carro1.addProducto(3,productos,2);
       pedidos.addElemento(new Pedido(2,"Jenny Santamaría","Bucaramanga",((Ciudad) ciudades.getObjetoN("Bucaramanga")).getCosto(),"Cll 45 #1-68",carro1.getcarro(),carro1.calcularSubTotal()));
       
       Carrito carro2 = new Carrito();
       carro2.addProducto(1,productos,1);
       carro2.addProducto(4,productos,1);
       pedidos.addElemento(new Pedido(3,"Alexis Cáceres","Bucaramanga",((Ciudad) ciudades.getObjetoN("Bucaramanga")).getCosto(),"Cll",carro2.getcarro(),carro2.calcularSubTotal()));
    }

    public Almacen getCiudades()
    {
        return ciudades;
    }
    
    public Almacen getCupones()
    {
        return cupones;
    }
    
    public Almacen getCategoras()
    {
        return categorias;
    }
    
    public Almacen getColecciones()
    {
        return colecciones;
    }
    
    public AlmacenProducto getProductos()
    {
        return productos;
    }
    
    public Almacen getPedidos()
    {
        return pedidos;
    }
}

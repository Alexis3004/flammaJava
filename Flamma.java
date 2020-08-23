import java.util.Scanner;
import java.util.*;
/**
* Write a description of class Flamma here.
* 
* @author Alexis Cáceres & Jenny Santamaría 
* @version 2
*/
public class Flamma
{
    /**
     * 
     */
    public static void main(String[] args) 
    {
        boolean inicio = true;
        Factory fac = new Factory();
        Almacen ciudades = fac.getCiudades();
        Almacen cupones = fac.getCupones();
        Almacen categorias = fac.getCategoras();
        Almacen colecciones = fac.getColecciones();
        AlmacenProducto productos = fac.getProductos();
        Almacen pedidos = fac.getPedidos();
        productos.EliminarElemento(6);
        int entrada;
        int entrad;
        int cantidad;
        String usuario;
        int ciudad;
        String direccion;
        while(inicio)
        {
            System.out.println("Bienvenido a Flamma Shop");
            System.out.println("Introduzca su opción:");
            System.out.println("1. entrar como Administrador        2. entrar como Cliente");
            System.out.println("3. Salir");
            Scanner myObj = new Scanner(System.in);
            int rol = myObj.nextInt(); 
            switch (rol) 
            {
              case 1:
                System.out.println("Es Administrador");
                break;
              case 2:
                //System.out.println("Usted está en la sección del cliente");
                Carrito carro = new Carrito();
                boolean rolCliente = true;
                while(rolCliente)
                {
                    //System.out.flush();
                    System.out.println("Menú cliente:");
                    System.out.println("1. ver por Categoría                2. Ver por colección");
                    System.out.println("3. Ver todos los productos          4. Ver carrito");
                    System.out.println("5. Realizar pedido                  6. Salir de la sesión del cliente");
                    int fil = myObj.nextInt();
                    switch (fil) 
                    {
                     case 1:
                        
                        System.out.println("\nCategorías");
                        System.out.println(categorias.getObjetos());
                        System.out.println("\nIngrese el código de la categoría que desea buscar");
                        myObj.close();
                        myObj = new Scanner(System.in);
                        entrada = myObj.nextInt();
                        Item categoria = categorias.getObjeto(entrada);
                        if(categoria != null)
                        {
                            System.out.println("Referencia    Nombre        talla        costo");
                            ArrayList<Item> prod= productos.getProductosClasificacion(categoria);
                            for(Item pro: prod)
                            {
                                System.out.println(pro.toString());
                            }
                            myObj = new Scanner(System.in);
                            System.out.println("\nIngrese la referencia del producto que desea agregar al carrito");
                            entrada = myObj.nextInt();
                            System.out.println("Ingrese la cantidad del producto que desea agregar al carrito");
                            cantidad = myObj.nextInt();
                            if(carro.addProducto(entrada,productos, cantidad))
                            {
                                System.out.println("Producto agregado correctamente \n\n");
                            }
                            else
                            {
                                System.out.println("El producto no se ha podido agregar \n\n");
                            }
                        }
                        else
                        {
                            System.out.println("Categoría no encontrada, por favor ingrese bien el id de la categoría \n\n");
                        }
                        break;
                     case 2:                                                                                                                                   
                        
                        System.out.println("Colecciones");
                        System.out.println(colecciones.getObjetos());
                        System.out.println("\nIngrese el código de la colección que desea buscar");
                        myObj.close();
                        myObj = new Scanner(System.in);
                        entrada = myObj.nextInt();
                        Item coleccion = colecciones.getObjeto(entrada);
                        if(coleccion != null)
                        {
                            System.out.println("Referencia    Nombre        talla        costo");
                            ArrayList<Item> prod= productos.getProductosClasificacion(coleccion);
                            for(Item pro: prod)
                            {
                                System.out.println(pro.toString());
                            }
                            myObj = new Scanner(System.in);
                            System.out.println("\nIngrese la referencia del producto que desea agregar al carrito");
                            entrada = myObj.nextInt();
                            System.out.println("Ingrese la cantidad del producto que desea agregar al carrito");
                            cantidad = myObj.nextInt();
                            if(carro.addProducto(entrada,productos, cantidad))
                            {
                                System.out.println("Producto agregado correctamente \n\n");
                            }
                            else
                            {
                                System.out.println("El producto no se ha podido agregar \n\n");
                            }
                        }
                        else
                        {
                            System.out.println("Colección no encontrada, por favor ingrese bien el id de la Colección \n\n");
                        }
                        break;
                     case 3:
                        
                        System.out.println("Todos los productos");
                        System.out.println("Referencia    Nombre        talla        costo");
                        System.out.println(productos.getObjetos());
                        System.out.println("\nIngrese la referencia del producto que desea agregar al carrito");
                        myObj = new Scanner(System.in);
                        entrada = myObj.nextInt();
                        System.out.println("Ingrese la cantidad del producto que desea agregar al carrito");
                        cantidad = myObj.nextInt();
                        if(carro.addProducto(entrada,productos, cantidad))
                        {
                            System.out.println("Producto agregado correctamente \n\n");
                        }
                        else
                        {
                            System.out.println("El producto no se ha podido agregar \n\n");
                        }
                        break;
                     case 4:
                        System.out.println("\n\nContenido del carrito\n");
                        System.out.println("Referencia  nombre  talla   costo   cantidad");
                        System.out.println(carro.mostrarContenido());
                        System.out.println("Subtotal: "+carro.calcularSubTotal()+"\n\n");
                        if(carro.getcarro().size()>0)
                        {
                            boolean car = true;
                            while(car)
                            {
                                System.out.println("1. Ver carrito              2.Eliminar producto");
                                System.out.println("3. Vaciar carrito           4.salir");
                                myObj.reset();
                                entrada = myObj.nextInt();
                                switch (entrada) 
                                {
                                    case 1:
                                        System.out.println("\n\nContenido del carrito\n");
                                        System.out.println("Referencia  nombre  talla   costo   cantidad");
                                        System.out.println(carro.mostrarContenido());
                                        System.out.println("Subtotal: "+carro.calcularSubTotal()+"\n\n");
                                        break;
                                    case 2:
                                        System.out.println("\nIngrese la referencia del producto que desea eliminar");
                                        myObj.reset();
                                        entrad = myObj.nextInt();
                                        if(carro.delProducto(entrad))
                                        {
                                            System.out.println("\nproducto eliminado correctamente\n\n");
                                        }
                                        else
                                        {
                                            System.out.println("\nEl producto no se pudo encontrar\n\n");
                                        }
                                        break;
                                    case 3:
                                        carro.vaciarCarrito();
                                        System.out.println("\nEl carrito está limpio"+"\n\n");
                                        break;
                                    case 4:
                                        car = false;
                                        System.out.println("\n\n");
                                        break;
                                }
                            }
                        }
                        break;
                     case 5:
                        if(carro.getcarro().size()>0)
                        {
                            System.out.println("\n\nIngrese la siguiente información:");
                            System.out.println("\nNombre del titular del pedido:");
                            myObj.close();
                            myObj = new Scanner(System.in);
                            usuario = myObj.nextLine();
                            System.out.println("\nCiudades disponibles:");
                            System.out.println("Código    nombre      costo domicilio:");
                            System.out.println(ciudades.getObjetos()+"\n");
                            System.out.println("\nIngrese el código de la ciudad a la que va el pedido:");
                            myObj.close();
                            myObj = new Scanner(System.in);
                            ciudad = myObj.nextInt();
                            System.out.println("\nDirección :");
                            myObj.close();
                            myObj = new Scanner(System.in);
                            direccion = myObj.nextLine();
                            if(ciudades.getObjeto(ciudad)!=null)
                            {
                                Item ciu = ciudades.getObjeto(ciudad);
                                Pedido ped = new Pedido(pedidos.getNumeroObjetos()+1,usuario,ciu.getNombre(),((Ciudad) ciu).getCosto(),
                                direccion,carro.getcarro(),carro.calcularSubTotal());
                                boolean pe = true;
                                while(pe)
                                {
                                    System.out.println("\nConfirmación de pedido :");
                                    System.out.println("\n1. Ver info pedido            2. Ver detalle pedido");
                                    System.out.println("\n3. Agregar cupón              4. Confirmar pedido");
                                    myObj.close();
                                    myObj = new Scanner(System.in);
                                    entrada = myObj.nextInt();
                                    switch (entrada) 
                                    {
                                        case 1:
                                            System.out.println("\n\nDetalle del pedido\n");
                                            System.out.println(ped.toString()+"\n\n");
                                            
                                            break;
                                        case 2:
                                            System.out.println("\n\nInformación del pedido\n");
                                            System.out.println(ped.getDetalle()+"\n\n");
                                            break;
                                        case 3:
                                            System.out.println("\nIngrese el nombre del cupón a canjear\n");
                                            myObj.close();
                                            myObj = new Scanner(System.in);
                                            usuario = myObj.nextLine();
                                            if(ped.agregarCupon(usuario, cupones))
                                            {
                                                System.out.println("\nCupón agregado correctamente");
                                                System.out.println("Usted tiene un descuento del :"+ped.getDescuento()*100+"%\n");
                                            }
                                            else
                                            {
                                                System.out.println("\nCupón inválido\n\n");
                                            }
                                            break;
                                        case 4:
                                            pe = false;
                                            if(pedidos.addElemento(ped))
                                            {
                                                ped = null;
                                                System.out.println("Su pedido se ha registrado, gracias por su compra"+"\n\n");
                                                carro.vaciarCarrito();
                                            }
                                            else
                                            {
                                                System.out.println("Su pedido no se ha registrado\n\n");
                                            }
                                            break;
                                        default:
                                            System.out.println("opción no válida\n\n");
                                            break;
                                    }
                                }
                            }
                            else
                            {
                                System.out.println("\nIngrese un código de ciudad correcto\n\n");
                            }
                        }
                        else
                        {
                           System.out.println("\n\nSu carrito está vacío, debe ingresar productos primero"+"\n\n"); 
                        }
                        break;
                     case 6:
                        
                        rolCliente = false;
                        break;
                     default:
                        
                        System.out.println("Por favor ingrese una expresión válida \n\n"); 
                    }
                }
                break;
              case 3:
                System.out.println("Vuelva pronto"); 
                inicio = false;
                break;
              default:
                 System.out.println("Por favor ingrese una expresión válida"); 
            }
        }
    }
    /*
    public static void limpiarpantalla()
    {
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_K);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_K);
            robot = null;
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }*/
}

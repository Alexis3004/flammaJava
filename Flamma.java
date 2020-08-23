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
        int fil;
        boolean rolCliente;
        boolean opcion;
        double cost;
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
                rolCliente = true;
                while(rolCliente)
                {
                    System.out.println("Menú Administrador:");
                    System.out.println("1. Agregar                 2. modificar");
                    System.out.println("3. eliminar                4. Ver");
                    System.out.println("5. Salir de la sesión del administrador");
                    myObj = new Scanner(System.in);
                    entrada = myObj.nextInt();
                    switch (entrada) 
                    {
                     case 1:
                        opcion = true;
                        while(opcion)
                        {
                            System.out.println("Seleccione lo que desea agregar");
                            System.out.println("1.Ciudades                 2. Cupones");
                            System.out.println("3. Categorías              4. Colecciones");
                            System.out.println("5. Productos               6. Salir");
                            myObj = new Scanner(System.in);
                            entrad = myObj.nextInt();
                            switch (entrad) 
                            {
                             case 1:
                                System.out.println("Ingrese los siguientes datos\n");
                                System.out.println("Id de la ciudad:");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                System.out.println("Nombre de la ciudad:");
                                myObj = new Scanner(System.in);
                                usuario = myObj.nextLine();
                                System.out.println("Costo domicilio:");
                                myObj = new Scanner(System.in);
                                cost = myObj.nextDouble();
                                if(ciudades.addElemento(new Ciudad(entrada,usuario,cost)))
                                {
                                    System.out.println("Ciudad agregada correctamente\n");
                                }
                                else
                                {
                                    System.out.println("La ciudad no se agregó\n");
                                }
                                break;
                             case 2:
                                System.out.println("Ingrese los siguientes datos\n");
                                System.out.println("Id del cupón:");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                System.out.println("Nombre del cupón:");
                                myObj = new Scanner(System.in);
                                usuario = myObj.nextLine();
                                System.out.println("Descuento que ofrece:");
                                myObj = new Scanner(System.in);
                                cost = myObj.nextDouble();
                                System.out.println("costo "+cost);
                                if(cupones.addElemento(new Cupon(entrada,usuario,cost)))
                                {
                                    System.out.println("Cupón agregado correctamente\n");
                                }
                                else
                                {
                                    System.out.println("El cupón no se agregó\n");
                                }
                                break;
                             case 3:
                                System.out.println("Ingrese los siguientes datos\n");
                                System.out.println("Id de la categoría:");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                System.out.println("Nombre de la categoría:");
                                myObj = new Scanner(System.in);
                                usuario = myObj.nextLine();
                                System.out.println("Descripción:");
                                myObj = new Scanner(System.in);
                                direccion = myObj.nextLine();
                                if(categorias.addElemento(new Categoria(entrada,usuario,direccion)))
                                {
                                    System.out.println("Categoría agregada correctamente\n");
                                }
                                else
                                {
                                    System.out.println("La categoría no se agregó\n");
                                }
                                break;
                             case 4:
                                System.out.println("Ingrese los siguientes datos\n");
                                System.out.println("Id de la colección:");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                System.out.println("Nombre de la colección:");
                                myObj = new Scanner(System.in);
                                usuario = myObj.nextLine();
                                System.out.println("Descripción:");
                                myObj = new Scanner(System.in);
                                direccion = myObj.nextLine();
                                System.out.println("fecha de lanzamiento:");
                                myObj = new Scanner(System.in);
                                if(colecciones.addElemento(new Coleccion(entrada,usuario,direccion,myObj.nextLine())))
                                {
                                    System.out.println("Colección agregada correctamente\n");
                                }
                                else
                                {
                                    System.out.println("La colección no se agregó\n");
                                }
                                break;
                             case 5:
                                System.out.println("Ingrese los siguientes datos\n");
                                System.out.println("Referencia:");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                System.out.println("nombre:");
                                myObj = new Scanner(System.in);
                                usuario = myObj.nextLine();
                                System.out.println("Costo:");
                                myObj = new Scanner(System.in);
                                cost = myObj.nextDouble();
                                System.out.println("Descripción:");
                                myObj = new Scanner(System.in);
                                direccion = myObj.nextLine();
                                System.out.println("talla:");
                                myObj = new Scanner(System.in);
                                String talla = myObj.nextLine();
                                System.out.println("cantidad:");
                                myObj = new Scanner(System.in);
                                int canti = myObj.nextInt();
                                System.out.println("Id categoría:");
                                System.out.println(categorias.getObjetos());
                                myObj = new Scanner(System.in);
                                int cat = myObj.nextInt();
                                System.out.println("Id Colección:");
                                System.out.println(colecciones.getObjetos());
                                myObj = new Scanner(System.in);
                                int col = myObj.nextInt();
                                if(categorias.getObjeto(cat)!=null && colecciones.getObjeto(col)!=null)
                                {
                                    if(productos.addElemento(new Producto(entrada,usuario,cost,direccion,talla,canti,categorias.getObjeto(cat),
                                    colecciones.getObjeto(col))))
                                    {
                                        System.out.println("Producto agregado correctamente\n");
                                    }
                                    else
                                    {
                                        System.out.println("El producto no se agregó\n");
                                    }
                                }
                                else
                                {
                                    System.out.println("Categoría o coleccion no encontrada\n");
                                }
                                break;
                             case 6:
                                opcion = false;
                                break;
                             default:
                                System.out.println("Por favor ingrese una expresión válida \n\n");
                            }
                        }
                        break;
                     case 2:
                        opcion = true;
                        while(opcion)
                        {
                            System.out.println("Seleccione lo que desea modificar");
                            System.out.println("1.Ciudades                 2. Cupones");
                            System.out.println("3. Categorías              4. Colecciones");
                            System.out.println("5. Productos               6. Pedidos");
                            System.out.println("7. Salir");
                            myObj = new Scanner(System.in);
                            entrad = myObj.nextInt();
                            switch (entrad) 
                            {
                             case 1:
                                System.out.println("¿Qué desea modificar de la ciudad?");
                                System.out.println("1. Nombre ciudad           2. costo envío");
                                myObj = new Scanner(System.in);
                                entrad = myObj.nextInt();
                                System.out.println(ciudades.getObjetos()+"\n");
                                switch (entrad) 
                                {
                                 case 1:
                                    System.out.println("Digite el id de la ciudad a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo nombre");
                                    myObj = new Scanner(System.in);
                                    usuario = myObj.nextLine();
                                    if(ciudades.getObjeto(entrad)!=null)
                                    {
                                        ciudades.getObjeto(entrad).setNombre(usuario);
                                        if(ciudades.getObjeto(entrad).getNombre().equals(usuario))
                                        {
                                            System.out.println("Nombre modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El nombre no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Ciudad no encontrada\n");
                                    }
                                    break;
                                 case 2:
                                    System.out.println("Digite el id de la ciudad a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo costo");
                                    myObj = new Scanner(System.in);
                                    entrada = myObj.nextInt();
                                    if(ciudades.getObjeto(entrad)!=null)
                                    {
                                        ((Ciudad) ciudades.getObjeto(entrad)).setCosto(entrada);
                                        if(((Ciudad) ciudades.getObjeto(entrad)).getCosto()==entrada)
                                        {
                                            System.out.println("costo modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El costo no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Ciudad no encontrada\n");
                                    }
                                    break;
                                 default:
                                    System.out.println("Por favor ingrese una expresión válida \n\n");
                                }
                                break;
                             case 2:
                                System.out.println("¿Qué desea modificar del cupón?");
                                System.out.println("1. Nombre cupón            2. descuento");
                                myObj = new Scanner(System.in);
                                entrad = myObj.nextInt();
                                System.out.println(cupones.getObjetos()+"\n");
                                switch (entrad) 
                                {
                                 case 1:
                                    System.out.println("Digite el id del cupón a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo nombre");
                                    myObj = new Scanner(System.in);
                                    usuario = myObj.nextLine();
                                    if(cupones.getObjeto(entrad)!=null)
                                    {
                                        cupones.getObjeto(entrad).setNombre(usuario);
                                        if(cupones.getObjeto(entrad).getNombre().equals(usuario))
                                        {
                                            System.out.println("Nombre modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El nombre no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Cupón no encontrado\n");
                                    }
                                    break;
                                 case 2:
                                    System.out.println("Digite el id del cupón a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo descuento");
                                    myObj = new Scanner(System.in);
                                    cost = myObj.nextDouble();
                                    if(cupones.getObjeto(entrad)!=null)
                                    {
                                        ((Cupon) cupones.getObjeto(entrad)).setDescuento(cost);
                                        if(((Cupon) cupones.getObjeto(entrad)).getDescuento()==cost)
                                        {
                                            System.out.println("descuento modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El descuento no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Cupón no encontrado\n");
                                    }
                                    
                                    break;
                                 default:
                                    System.out.println("Por favor ingrese una expresión válida \n\n");
                                }
                                break;
                             case 3:
                                System.out.println("¿Qué desea modificar de la categoría?");
                                System.out.println("1. Nombre categoría        2. descripción categoría");
                                myObj = new Scanner(System.in);
                                entrad = myObj.nextInt();
                                System.out.println(categorias.getObjetos()+"\n");
                                switch (entrad) 
                                {
                                 case 1:
                                    System.out.println("Digite el id de la categoría a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo nombre");
                                    myObj = new Scanner(System.in);
                                    usuario = myObj.nextLine();
                                    if(categorias.getObjeto(entrad)!=null)
                                    {
                                        categorias.getObjeto(entrad).setNombre(usuario);
                                        if(categorias.getObjeto(entrad).getNombre().equals(usuario))
                                        {
                                            System.out.println("Nombre modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El nombre no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Categoría no encontrada\n");
                                    }
                                    break;
                                 case 2:
                                    System.out.println("Digite el id de la categoría a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite la nueva descripcion");
                                    myObj = new Scanner(System.in);
                                    direccion = myObj.nextLine();
                                    if(categorias.getObjeto(entrad)!=null)
                                    {
                                        ((Categoria) categorias.getObjeto(entrad)).setdescripcion(direccion);
                                        if(((Categoria) categorias.getObjeto(entrad)).getDescripcion()==direccion)
                                        {
                                            System.out.println("Descripción modificada exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("La Descripción no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Categoria no encontrada\n");
                                    }
                                    break;
                                 default:
                                    System.out.println("Por favor ingrese una expresión válida \n\n");
                                }
                                break;
                             case 4:
                                System.out.println("¿Qué desea modificar de la colección?");
                                System.out.println("1. Nombre colección        2. descripción colección");
                                myObj = new Scanner(System.in);
                                entrad = myObj.nextInt();
                                System.out.println(colecciones.getObjetos()+"\n");
                                switch (entrad) 
                                {
                                 case 1:
                                    System.out.println("Digite el id de la colección a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo nombre");
                                    myObj = new Scanner(System.in);
                                    usuario = myObj.nextLine();
                                    if(colecciones.getObjeto(entrad)!=null)
                                    {
                                        colecciones.getObjeto(entrad).setNombre(usuario);
                                        if(colecciones.getObjeto(entrad).getNombre().equals(usuario))
                                        {
                                            System.out.println("Nombre modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El nombre no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Colección no encontrada\n");
                                    }
                                    break;
                                 case 2:
                                    System.out.println("Digite el id de la colección a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite la nueva descripcion");
                                    myObj = new Scanner(System.in);
                                    direccion = myObj.nextLine();
                                    if(colecciones.getObjeto(entrad)!=null)
                                    {
                                        ((Coleccion) colecciones.getObjeto(entrad)).setdescripcion(direccion);
                                        if(((Coleccion) colecciones.getObjeto(entrad)).getDescripcion().equals(direccion))
                                        {
                                            System.out.println("Descripción modificada exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("La Descripción no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Coleccion no encontrada\n");
                                    }
                                    break;
                                 default:
                                    System.out.println("Por favor ingrese una expresión válida \n\n");
                                }
                                break;
                             case 5:
                                System.out.println("¿Qué desea modificar del producto?");
                                System.out.println("1. Nombre producto         2. descripción");
                                System.out.println("3. costo                   4. Aumentar cantiad en stock");
                                myObj = new Scanner(System.in);
                                entrad = myObj.nextInt();
                                System.out.println(productos.getObjetos()+"\n");
                                switch (entrad) 
                                {
                                 case 1:
                                    System.out.println("Digite el id del producto a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo nombre");
                                    myObj = new Scanner(System.in);
                                    usuario = myObj.nextLine();
                                    if(productos.getObjeto(entrad)!=null)
                                    {
                                        productos.getObjeto(entrad).setNombre(usuario);
                                        if(productos.getObjeto(entrad).getNombre().equals(usuario))
                                        {
                                            System.out.println("Nombre modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El nombre no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("producto no encontrado\n");
                                    }
                                    break;
                                 case 2:
                                    System.out.println("Digite el id del producto a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite la nueva descripción");
                                    myObj = new Scanner(System.in);
                                    direccion = myObj.nextLine();
                                    if(productos.getObjeto(entrad)!=null)
                                    {
                                        ((Producto) productos.getObjeto(entrad)).setDescripcion(direccion);
                                        if(((Producto) productos.getObjeto(entrad)).getDescripcion().equals(direccion))
                                        {
                                            System.out.println("Descripcion modificada exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("La descripcion no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Producto no encontrado\n");
                                    }
                                    break;
                                 case 3:
                                    System.out.println("Digite el id del producto a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("Digite el nuevo costo");
                                    myObj = new Scanner(System.in);
                                    cost = myObj.nextDouble();
                                    if(productos.getObjeto(entrad)!=null)
                                    {
                                        ((Producto) productos.getObjeto(entrad)).setCosto(cost);
                                        if(((Producto) productos.getObjeto(entrad)).getCosto()==cost)
                                        {
                                            System.out.println("Costo modificado exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("El costo no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Producto no encontrado\n");
                                    }
                                    break;
                                 case 4:
                                    System.out.println("Digite el id del producto a modificar");
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    System.out.println("La cantidad a aumentar en stock del producto");
                                    myObj = new Scanner(System.in);
                                    entrada = myObj.nextInt();
                                    if(productos.getObjeto(entrad)!=null)
                                    {
                                        if(((Producto) productos.getObjeto(entrad)).aumentaCantidad(entrada))
                                        {
                                            System.out.println("Cantidad aumentada exitosamente\n");
                                        }
                                        else
                                        {
                                            System.out.println("La cantidad no se modificó\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Producto no encontrado\n");
                                    }
                                    break;

                                 default:
                                    System.out.println("Por favor ingrese una expresión válida \n\n");
                                }
                                break;
                             case 6:
                                ArrayList<Item> pediFE = pedidos.getListaFE();
                                if(pediFE.size()>0)
                                {
                                    System.out.println("Listado de pedidos pendientes de envío");
                                    for(Item it: pediFE)
                                    {
                                      System.out.println(it.toString());  
                                    }
                                    System.out.println("\n"); 
                                    System.out.println("Ingrese el código del pedido que desea modificar el estado"); 
                                    myObj = new Scanner(System.in);
                                    entrad = myObj.nextInt();
                                    if(pedidos.getObjeto(entrad)!=null)
                                    {
                                        if(((Pedido) pedidos.getObjeto(entrad)).getEstado().equals("no enviado"))
                                        {
                                            System.out.println("Ingrese el nuevo estado del pedido"); 
                                            myObj = new Scanner(System.in);
                                            usuario = myObj.nextLine();
                                            ((Pedido) pedidos.getObjeto(entrad)).setEstado(usuario);
                                            if(((Pedido) pedidos.getObjeto(entrad)).getEstado().equals(usuario))
                                            {
                                                System.out.println("Estado modificado exitosamente\n"); 
                                            }
                                            else
                                            {
                                                System.out.println("Estado no modificado\n"); 
                                            }
                                        }
                                        else
                                        {
                                           System.out.println("El pedido ya fué enviado\n\n");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Pedido no encontrado\n\n"); 
                                    }
                                }
                                else
                                {
                                    System.out.println("No hay productos con falta de envío\n\n");
                                }
                                break;
                             case 7:
                                opcion = false;
                                break;
                             default:
                                System.out.println("Por favor ingrese una expresión válida \n\n");
                            }
                        }
                        break;
                     case 3:
                        opcion = true;
                        while(opcion)
                        {
                            System.out.println("Seleccione lo que desea eliminar");
                            System.out.println("1.Ciudades                 2. Cupones");
                            System.out.println("3. Categorías              4. Colecciones");
                            System.out.println("5. Productos               6. Salir");
                            Item cat;
                            myObj = new Scanner(System.in);
                            entrad = myObj.nextInt();
                            switch (entrad) 
                            {
                             case 1:
                                System.out.println("\nIngrese el id de la ciudad a eliminar\n");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                cat = ciudades.getObjeto(entrada);
                                if(ciudades.EliminarElemento(entrada))
                                {
                                    System.out.println("Ciudad eliminada correctamente");
                                    System.out.println(cat+"\n");
                                }
                                else
                                {
                                    System.out.println("ciudad no encontrada\n");
                                }
                                break;
                             case 2:
                                System.out.println("\nIngrese el id del cupón a eliminar\n");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                cat = cupones.getObjeto(entrada);
                                if(cupones.EliminarElemento(entrada))
                                {
                                    System.out.println("Cupón eliminado correctamento");
                                    System.out.println(cat+"\n");
                                }
                                else
                                {
                                    System.out.println("cupón no encontrado\n");
                                }
                                break;
                             case 3:
                                System.out.println("\nIngrese el id de la categoría a eliminar\n");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                cat = categorias.getObjeto(entrada);
                                if(categorias.EliminarElemento(entrada))
                                {
                                    productos.delProductoClasificacion(cat);
                                    System.out.println("Categoría eliminada correctamente");
                                    System.out.println(cat+"\n");
                                }
                                else
                                {
                                    System.out.println("categoría no encontrada\n");
                                }
                                break;
                             case 4:
                                System.out.println("\nIngrese el id de la colección a eliminar\n");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                cat = colecciones.getObjeto(entrada);
                                if(colecciones.EliminarElemento(entrada))
                                {
                                    productos.delProductoClasificacion(cat);
                                    System.out.println("Colección eliminada correctamente");
                                    System.out.println(cat+"\n");
                                }
                                else
                                {
                                    System.out.println("Colección no encontrada\n");
                                }
                                break;
                             case 5:
                                System.out.println("\nIngrese el id del producto a eliminar");
                                myObj = new Scanner(System.in);
                                entrada = myObj.nextInt();
                                cat = productos.getObjeto(entrada);
                                if(productos.EliminarElemento(entrada))
                                {
                                    System.out.println("Producto eliminado correctamente\n");
                                    System.out.println(cat+"\n");
                                }
                                else
                                {
                                    System.out.println("Producto no encontrado\n");
                                }
                                break;
                             case 6:
                                opcion = false;
                                break;
                             default:
                                System.out.println("Por favor ingrese una expresión válida \n\n");
                            }
                        }
                        break;
                     case 4:
                        opcion = true;
                        while(opcion)
                        {
                            System.out.println("Seleccione lo que desea ver");
                            System.out.println("1.Ciudades                 2. Cupones");
                            System.out.println("3. Categorías              4. Colecciones");
                            System.out.println("5. Productos               6. Productos más vendidos");
                            System.out.println("7. Todos los pedidos       8. Salir");
                            myObj = new Scanner(System.in);
                            entrad = myObj.nextInt();
                            switch (entrad) 
                            {
                             case 1:
                                System.out.println("Lista de ciudades");
                                System.out.println(ciudades.getObjetos()+"\n");
                                break;
                             case 2:
                                System.out.println("Lista de cupones");   
                                System.out.println(cupones.getObjetos()+"\n");
                                break;
                             case 3:
                                System.out.println("Lista de categorias"); 
                                System.out.println(categorias.getObjetos()+"\n");
                                break;
                             case 4:
                                System.out.println("Lista de colecciones"); 
                                System.out.println(colecciones.getObjetos()+"\n");
                                break;
                             case 5:
                                System.out.println("Lista de productos"); 
                                System.out.println(productos.getObjetos()+"\n");
                                break;
                             case 6:
                                System.out.println("Lista de productos más vendidos"); 
                                System.out.println(pedidos.getProductosMV()+"\n");
                                break;
                             case 7:
                                System.out.println("Lista de todos los pedidos"); 
                                System.out.println(pedidos.getObjetos()+"\n");
                                break;
                             case 8:
                                opcion = false;
                                break;
                             default:
                                System.out.println("Por favor ingrese una expresión válida \n\n");
                            }
                        }
                        break;
                     case 5:
                        rolCliente = false;
                        break;
                     default:
                        System.out.println("Por favor ingrese una expresión válida \n\n");
                    }
                }
                break;
              case 2:
                Carrito carro = new Carrito();
                rolCliente = true;
                while(rolCliente)
                {
                    //System.out.flush();
                    System.out.println("Menú cliente:");
                    System.out.println("1. ver por Categoría                2. Ver por colección");
                    System.out.println("3. Ver todos los productos          4. Ver carrito");
                    System.out.println("5. Realizar pedido                  6. Salir de la sesión del cliente");
                    fil = myObj.nextInt();
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
                                            if(ped.ConfirmarPedido())
                                            {
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
                                            }
                                            else
                                            {
                                                System.out.println("Está intentando comprar un producto que no tine suficiente stock"+"\n\n");
                                                carro.vaciarCarrito();
                                            }
                                            
                                            break;
                                        default:
                                            System.out.println("opción no válida\n\n");
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

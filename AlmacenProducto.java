import java.util.*;
/**
 * Se encarga de almacenar los productos que se le presentarán al cliente
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class AlmacenProducto extends Almacen
{
    /**
     * Obtiene un ArrayList con todos los productos que pertenecen a un objeto clasificador
     * ya sea una categoría o una colección
     * @param Item clasificador
     * @return ArrayList de Items que pertencen al clasificador
     */
    public ArrayList<Item> getProductosClasificacion(Item clf)
    {
       ArrayList<Item> del = new ArrayList();
       for(Item prod: super.Almacen)
       {
           if((clf instanceof Coleccion) && (((Producto) prod).getColeccion().equals(clf)))
           {
               del.add(prod);
           }
           else
           {
               if((clf instanceof Categoria) && (((Producto) prod).getCategoria().equals(clf)))
               {
                   del.add(prod);
               }
           }
       }
       return del;
    }
    
    /**
     * permite eliminar los productos de alguna categoria o coleccion
     * @param clf objeto de cualquier categoria o coleccion
     * @return true si se pudieron eliminar los productos de esa categoria o coleccion, false si no se pudo eliminar
    */
    public boolean delProductoClasificacion(Item clf)
    {
        ArrayList<Item> del = getProductosClasificacion(clf);
        if(del.size()>0)
        {
           for(Item prod : del)
           {
              super.Almacen.remove(prod); 
           }
           return true;
        }
        return false;
    }
    
    /**
     * permite clasificar los productos en categorias o colecciones
     * @param clf objeto de cualquier categoria o coleccion
     * @return String con la informacion de todos los productos que pertenecen a cierta clasificacion 
    */
    public String getObjetosClasificacion(Item clf)
    {
        if(Almacen.size()>0)
        {
            ArrayList<Item> del = getProductosClasificacion(clf);
            if(del.size()>0)
            {
                String obj = "";
                for (Item ob: del) 
                {
                   obj = obj + ob.toString()+"\n";
                }
                return obj;
            }
            else
            {
                return "No hay productos de ese tipo de clasificador";
            } 
        }
        return "no hay objetos disponibles";
    }
}

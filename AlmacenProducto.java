import java.util.*;
/**
 * 
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class AlmacenProducto extends Almacen
{
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

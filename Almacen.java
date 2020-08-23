import java.util.*;
/**
 * 
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class Almacen
{
    protected HashMap<Item, Integer> compras;
    protected ArrayList<Item> Almacen;
    public Almacen()
    {
        Almacen = new ArrayList();
        compras = new HashMap();
    }
    
    public ArrayList<Item> getLista()
    {
        return this.Almacen;
    }
    
    public int getNumeroObjetos()
    {
        return this.Almacen.size();
    }
    
    public HashMap<Item, Integer> getCompras()
    {
        return this.compras;
    }
    
    public int getNumeroCompras()
    {
        return this.compras.size();
    }
    
    public boolean buscarProducto(Item prodr)
    {
        for (Item prod : compras.keySet()) 
        {
            if(prod.equals(prodr))
            {
                return true;
            }
        }
        return false;
    }

    public boolean  addElemento(Item obj)
    {
        if(getObjeto(obj.getId()) == null)
        {
            if(obj instanceof Pedido)
            {
                HashMap<Producto,Integer> det = ((Pedido) obj).getObjetoDetalle();
                if(compras.size()>0)
                {
                    for(Item prod: det.keySet())
                    {
                        Item producto = getObjetoP(prod.getId());
                        if(buscarProducto(prod) && (producto != null))
                        {
                            compras.replace(producto, compras.get(producto)+det.get(producto));
                        }
                        else
                        {
                            compras.put(prod,det.get(prod));
                        }
                    }
                }
                else
                {
                    for(Item prod: det.keySet())
                    {
                        compras.put(prod,det.get(prod));
                    }
                }
            }
            this.Almacen.add(obj);
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public String getObjetos()
    {
        if(Almacen.size()>0)
        {
            String info = "";
            for(Item it: Almacen)
            {
                info = info + it.toString() + "\n";
            }
            return info;
        }
        else
        {
            return "No hay items almacenados todavía";
        }
    }
    
    public Item getObjeto(int id)
    {
        if(Almacen.size()>0)
        {
            Item obj = null;
            for(Item it: Almacen)
            {
                if(it.getId()==id)
                {
                    obj = it;
                    return obj;
                }
            }
            return obj;
        }
        else
        {
            return null;
        }
    }
    
    public Item getObjetoP(int id)
    {
        if(compras.size()>0)
        {
            Item obj = null;
            for(Item it: compras.keySet())
            {
                if(it.getId()==id)
                {
                    obj = it;
                    return obj;
                }
            }
            return obj;
        }
        else
        {
            return null;
        }
    }
    
    public Item getObjetoN(String nombre)
    {
        if(Almacen.size()>0)
        {
            Item obj = null;
            for(Item it: Almacen)
            {
                if(it.getNombre().equals(nombre))
                {
                    obj = it;
                    return obj;
                }
            }
            return obj;
        }
        else
        {
            return null;
        }
    }
    
    public boolean EliminarElemento(int id)
    {
        if(Almacen.size()>0)
        {
            for (Item it: Almacen) 
            {
               Item item = getObjeto(id);
               if(item != null)
               {
                   Almacen.remove(item);
                   return true;
               }
            }
            return false;
        }
        else
        {
            return false;
        }
    }
    
    public void vaciarAlmacen()
    {
        Almacen.clear();
    }
}
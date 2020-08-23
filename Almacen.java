import java.util.*;
import java.util.stream.Collectors;
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
    
    public ArrayList<Item> getListaFE()
    {
        ArrayList<Item> EN = new ArrayList();
        if(Almacen.size()>0 && (Almacen.get(0) instanceof Pedido))
        {
            for(Item it: Almacen)
            {
                if(((Pedido) it).getEstado().equals("no enviado"))
                {
                    EN.add(it);
                }
            }
            return EN;
        }
        else
        {
            return EN;
        }
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
    
    public String getProductosMV()
    {
        if(compras.size()>0)
        {
            final HashMap<Item, Integer> sortedByCount = sortByValue(compras);
            String pr = "";
            for(Item it: sortedByCount.keySet())
            {
                pr += it.getId()+"   "+it.getNombre()+"      cantidad: "+compras.get(it)+"\n";
            }
            return pr;
        }
        else
        {
            return "No se han vendido productos";
        }
    }
    

    public static HashMap<Item, Integer> sortByValue(final Map<Item, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Item, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
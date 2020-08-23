import java.util.*;
import java.util.stream.Collectors;
/**
 * Esta clase es la encargada de almacenar los diferentes objetos items que se les mostrarán al cliente
 * si lo que se almacena es un pedido, se alacena también las compras que se han hecho de todos los pedidos
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class Almacen
{
    protected HashMap<Item, Integer> compras;
    protected ArrayList<Item> Almacen;
    /**
     * La clase inicializa un ArrayList para almacenar Items y un HashMap para almacenar los productos vendidos
     */
    public Almacen()
    {
        Almacen = new ArrayList();
        compras = new HashMap();
    }
    
    /**
     * Obtiene un ArrayList con los objetos almacenados
     */
    public ArrayList<Item> getLista()
    {
        return this.Almacen;
    }
    
    /**
     * Obtiene un ArrayList con los pedidos que no han sido enviados, si el Item almacenado no es un pedido, se 
     * obtiene un ArrayList vacío
     */
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
    
    /**
     * Obtiene el número de objetos almacenados en el almacén
     */
    public int getNumeroObjetos()
    {
        return this.Almacen.size();
    }
    
    /**
     * Obtiene un HashMap con las compras que se han realizado, es decir, el producto y la cantidad total vendida
     */
    public HashMap<Item, Integer> getCompras()
    {
        return this.compras;
    }
    
    /**
     * Obtiene el número de compras que se han hecho, es decir la cantidad de productos diferentes que se han vendido
     */
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

    /**
     * Agrega un elemento a la lista Almacén, si lo que se desea almacenar es un pedido, también se almacena el detalle 
     * del pedido que se desea almacenar, es decir, los productos que se vendieron en ese pedido
     * @param objeto de tipo Item que se desea almacenar
     * @return false si el id de ese elemento ya se encuentra almacenado, true si si pudo almacenar el elemento
     */
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
    
    /**
     * Obtiene un String con toda la información de los elementos u objetos almacenados en el Almacén
     * si no hay elementos almacenados, se retornará: No hay items almacenados todavía
     */
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
    
    /**
     * Obtiene un objeto de tipo Item por medio del Id de ese objeto, se busca en la lista de Almacén
     * @param id entero con el identificador 
     * @reurn el objeto Item que tiene ese Id, si no lo encuentra el valor es null
     */
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
    
    /**
     * obtiene el producto almacenado en compras mediante el id
         * @param id del objeto que se quiere obtener
     * @return Item,hace referencia al objeto
    */
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
    
    /**
     * obtiene el objeto mediante el nombre
     * @param nombre del objeto que se quiere obtener
     * @return Item, hace referencia al objeto
    */
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
    
    /**
     * permite eliminar un objeto Item almacenado mediante su identificador
     * @param id del elemento que se desea eliminar
     * @return true si se pudo eliminar, false si no se pudo eliminar 
    */
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
    
    /**
     * Elimina todos los Objetos del almacén
     */
    public void vaciarAlmacen()
    {
        Almacen.clear();
    }
    
    /**
     * permite obtener los productos más vendidos ordenados descendentemente
     * @return String que contiene los productos mas vendidos con su cantidad
    */
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
    
    /**
     * Ordena un Map por medio del valor de manera descendiente
     * @retun un HashMap ordenado por su valor
     */
    public static HashMap<Item, Integer> sortByValue(final Map<Item, Integer> wordCounts) {
        return wordCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Item, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
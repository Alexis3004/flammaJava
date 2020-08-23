/**
 * Abstract class Item - write a description of the class here
 * 
 * @author: Alexis Cáceres & Jenny Santamaría
 * Date: 
 */
public abstract class Item
{
    private int Id;
    private String nombre;

    public Item(int id, String nombre)
    {
        this.nombre = nombre;
        this.Id = id;
    }
    
    protected String getNombre()
    {
        return this.nombre;
    }
    
    protected int getId()
    {
        return this.Id;
    }
    
    protected String setNombre(String nombre)
    {
        this.nombre = nombre;
        return this.nombre;
    }
    
    public String toString()
    {
        return getId() + "  " + getNombre() + " ";
    }
    
    public boolean equals (Object obj) 
    {
        if (obj instanceof Item)
        {
            Item tmpPedido = (Item) obj;
            if (this.Id==tmpPedido.Id && this.nombre.equals(tmpPedido.nombre)) 
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

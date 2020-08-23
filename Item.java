/**
 * Abstract class Item - Súperclase Item, creada para los objetos que serán almacenados 
 * 
 * @author: Alexis Cáceres & Jenny Santamaría
 * Date: 23/08/2020
 */
public abstract class Item
{
    private int Id;
    private String nombre;
    
    /**
     * Los objetos Item se inicializan con un identificador y un nombre
     * @param id entero con el identificador del objeto Item
     * @param nombre String con el nombre del objeto Item
     */
    public Item(int id, String nombre)
    {
        this.nombre = nombre;
        this.Id = id;
    }
    
    /**
     * Obtiene el nombre del objeto Item
     */
    protected String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * Obtiene el Id del objeto Item
     */
    protected int getId()
    {
        return this.Id;
    }
    
    /**
     * Cambia el nombre del objeto Item
     * @param nombre String con el nuevo nombre
     * @return String con el nuevo nombre
     */
    protected String setNombre(String nombre)
    {
        this.nombre = nombre;
        return this.nombre;
    }
    
    /**
     * Obtiene la información de la clase
     *@return String con la información
    */
    public String toString()
    {
        return getId() + "  " + getNombre() + " ";
    }
    
    /**
     * Permite saber si dos objetos de esta clase son iguales
     * @param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
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

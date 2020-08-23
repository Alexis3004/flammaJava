/**
 * Representa grupos de prodcutos que se ordenan siguiendo un parámetro establecido por el administrador
 * 
 * @author Alexis Cáceres & Jenny Santamaría 
 * @version 2
 */
public class Categoria extends Item
{
    private String descripcion;
    /**
     *Las categorías se crean con un nombre, un identificador y una descripcion
     *@param descripcion String con la descripción de la categoría
    */
    public Categoria(int id,String nombre,String descripcion)
    {
        super(id, nombre);
        this.descripcion = descripcion;
    }
    
    /**
     * Obtiene la descripción de la categoría
     */
    public String getDescripcion()
    {
        return this.descripcion;
    }
    
    /**
     * Cambia la descripción de la categoría
     * @param descripcion String con la nueva descripcion
     */
    public String setdescripcion(String descripcion)
    {
        this.descripcion = descripcion;
        return this.descripcion;
    }
    
    /**
     * Obtiene la información d la categoria
     *@return String con la información
    */
    public String toString()
    {
        String categoria = super.toString();
        return categoria + " " +getDescripcion();
    }
    
    /**
     * Permite saber si dos objetos de esta clase son iguales
     * @param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
    public boolean equals (Object obj) 
    {
        if (obj instanceof Categoria && super.equals(obj) )
        {
            Categoria tmpCategoria = (Categoria) obj;
            if (this.descripcion.equals(tmpCategoria.getDescripcion()))
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
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
     * Las categorías se crean con un nombre, un identificador y una descripcion
    */
    public Categoria(int id,String nombre,String descripcion)
    {
        super(id, nombre);
        this.descripcion = descripcion;
    }
    
    protected String getDescripcion()
    {
        return this.descripcion;
    }
    
    protected String setdescripcion(String descripcion)
    {
        this.descripcion = descripcion;
        return this.descripcion;
    }
    
    public String toString()
    {
        String categoria = super.toString();
        return categoria + " " +getDescripcion();
    }
    
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
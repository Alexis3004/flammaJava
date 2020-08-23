/**
 * Representa grupos de prodcutos que se lanzaron con un mismas características o ediciones
 * 
 * @author Alexis Cáceres & Jenny Santamaría 
 * @version 2
 */
public class Coleccion extends Item
{
    private String fechaCreacion;
    private String descripcion;
    /**
     * Las colecciones se crean con un nombre, un identificador, una descripcion y una fecha en la cual fué creada la colección
     * @param nombre String con el nombre de la colección
     * @param Id int con el identificador de la colección
     * @param descripcion Sting con la descripción de la colección
     * @fecha String con la fecha de lanzamiento de la colección
    */
    public Coleccion(int Id,String nombre,String descripcion,String fecha)
    {
        super(Id, nombre);
        this.fechaCreacion = fecha;
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
    
    public String getFechaCreacion()
    {
        return this.fechaCreacion;
    }
    
    
    public String toString()
    {
        String coleccion = super.toString();
        return coleccion + " " + getFechaCreacion() + " " +getDescripcion();
    }
    
    public boolean equals (Object obj) 
    {
        if (obj instanceof Coleccion && super.equals(obj) )
        {
            Coleccion tmpColeccion = (Coleccion) obj;
            if (this.fechaCreacion.equals(tmpColeccion.getFechaCreacion()) && this.descripcion.equals(tmpColeccion.getDescripcion())) 
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
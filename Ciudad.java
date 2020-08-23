
/**
 * Con esta clase se pueden crear los objetos de tipo ciudad a los cuales los pedidos ralizados serán enviados
 * @author Alexis Cáceres & Jenny Santamaría 
 * @version 2
 */
public class Ciudad extends Item
{
    private double costo;

    /**
     *Los objetos de tipo ciudad se crean con un nombre de la ciudad, un identificador y un costo de envío 
     *@param costo double con el valor del costo del domicilio a esa ciudad
     */
    public Ciudad(int id,String nombre,double costo)
    {
        super(id,nombre);
        this.costo = costo;
    }
    
    /**
     * Obtiene el costo del Domicilio a esta ciudad
     */
    public double getCosto()
    {
        return this.costo;
    }
    
    /**
     *Cambia el valor del costo de envío para el objeto ciudad
     * 
     * @param  costo es el costo de envío a esa ciudad
    */
    public void setCosto(int costo)
    {
        this.costo = costo;
    }
    
    /**
     * Obtiene la información de la ciudad
     *@return String con la información
    */
    public String toString()
    {
        String ciudad = super.toString();
        return ciudad + getCosto();
    }
    
    /**
     * Permite saber si dos objetos de esta clase son iguales
     * @param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
    public boolean equals (Object obj) 
    {
        if (obj instanceof Ciudad && super.equals(obj) )
        {
            Ciudad tmpPedido = (Ciudad) obj;
            if (this.costo==tmpPedido.getCosto()) 
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

/**
 * Con esta clase se crean objetos de tipo cupón que pueden ser aplicados a un Cupon
 * 
 * @author Alexis Cáceres & Jenny Santamaría
 * @version 2
 */
public class Cupon extends Item
{
    private double descuento;

    /**
     *El cupón se crea con un identificador, un nombre y el valor de descuento que proporciona
     *@param descuento double con el porcentaje de descuento que brinda
     */
    public Cupon(int id,String nombre,double descuento)
    {
        super(id,nombre);
        this.descuento = descuento;
    }
    
    /**
     * Obtiene el descuento que brinda el cupón
     */
    public double getDescuento()
    {
        return this.descuento;
    }
    
    /**
     * con éste método se puede cambiar el valor de descuento que el cupón ejerce
     * @param  descuento un número double con el porcentaje de descuento que aplica a una compra
     * @return valor del descuento nuevo
    */
    public double setDescuento(double descuento)
    {
        this.descuento = descuento;
        return this.descuento;
    }
    
    /**
     * Obtiene la información del cupón
     *@return String con la información
    */
    public String toString()
    {
        String cupon = super.toString();
        return cupon + getDescuento();
    }
    
    /**
     * Permite saber si dos objetos de esta clase son iguales
     * @param obj recibe un objeto
     *@return false si no son iguales y true si lo son
    */
    public boolean equals (Object obj) 
    {
        if (obj instanceof Cupon && super.equals(obj) )
        {
            Cupon tmpCupon = (Cupon) obj;
            if (this.descuento==tmpCupon.getDescuento()) 
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

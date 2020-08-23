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
     * El cupón se crea con un identificador o nombre y el valor de descuento que proporciona
     */
    public Cupon(int id,String nombre,double descuento)
    {
        super(id,nombre);
        this.descuento = descuento;
    }
    
    public double getDescuento()
    {
        return this.descuento;
    }
    
    /**
     * con éste método s pued cambiar el valor de descuento qu el cupón ejerce sobre un Cupon
     * @param  dscuento un número flotante con el porcntaje de descunto que aplica a una compra
    */
    public double setDescuento(double descuento)
    {
        this.descuento = descuento;
        return this.descuento;
    }
    
    public String toString()
    {
        String cupon = super.toString();
        return cupon + getDescuento();
    }
    
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

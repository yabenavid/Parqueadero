package co.unicauca.proyectoparqueadero.negocio;

/**
 * Rate interface
 *
 * @author Juliana Mora - Yeferson Benavides
 */
public interface IRate {

    /**
     * Rate methods
     *
     * @param hours floating value for the number of hours spent in the parking
     * lot
     * @return
     */
    public int rate(float hours);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

/**
 *
 * @author marcelo
 */
public class vacio extends ficha {
    private boolean movimiento;

    public vacio(String colorCasilla, boolean movimiento){
        super(colorCasilla);
        this.movimiento= movimiento;

    }

    /**
     * @return the movimiento
     */
    public boolean isMovimiento() {
        return movimiento;
    }

    /**
     * @param movimiento the movimiento to set
     */
    public void setMovimiento(boolean movimiento) {
        this.movimiento = movimiento;
    }

}

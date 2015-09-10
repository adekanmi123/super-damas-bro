/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

/**
 *
 * @author marcelo
 */
public class ficha {

    protected String colorCasilla;
   

    /**
     * @colorCasilla constructor que modifica el color de la casilla
     */
    public ficha(String colorCasilla) {
        this.colorCasilla = colorCasilla;
        
    }

    public String getColorCasilla() {
        return colorCasilla;
    }

    /**
     * @param colorCasilla smodifica la variable
     */
    public void setColorCasilla(String colorCasilla) {
        this.colorCasilla = colorCasilla;
    }


}

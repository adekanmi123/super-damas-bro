    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;

/**
 *
 * @author marcelo
 */
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class jugador implements Serializable {

    private String nombre;
    private String apellido;
    private String email;
    private String id;
    private int partidasGanadas;
    private int partidasPerdidas;
    private int puntuacionMaxima;

    public jugador(String nombre, String apellido, String email, String id, int partidasGanadas, int partidasPerdidas, int puntuacionMaxima) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.id = id;
        this.partidasGanadas = partidasGanadas;
        this.partidasPerdidas = partidasPerdidas;
        this.puntuacionMaxima = puntuacionMaxima;

        }

    public jugador(){}

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

 
    /**
     * @return the partidasGanadas
     */
    public int getPartidasGanadas() {
        return partidasGanadas;
    }

    /**
     * @param partidasGanadas the partidasGanadas to set
     */
    public void setPartidasGanadas(int partidasGanadas) {
        this.partidasGanadas = partidasGanadas;
    }

    /**
     * @return the partidasPerdidas
     */
    public int getPartidasPerdidas() {
        return partidasPerdidas;
    }

    /**
     * @param partidasPerdidas the partidasPerdidas to set
     */
    public void setPartidasPerdidas(int partidasPerdidas) {
        this.partidasPerdidas = partidasPerdidas;
    }

    /**
     * @return the puntuacionMaxima
     */
    public int getPuntuacionMaxima() {
        return puntuacionMaxima;
    }

    /**
     * @param puntuacionMaxima the puntuacionMaxima to set
     */
    public void setPuntuacionMaxima(int puntuacionMaxima) {
        this.puntuacionMaxima = puntuacionMaxima;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    }

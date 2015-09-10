/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package damaschinas;
import Cliente.Cliente;
import interfaz.Menuprincipal;
import interfaz.loggin;
import interfaz.numeroDeJugadores;
import java.io.*;
import javax.swing.JOptionPane;

/**
 *
 * @author marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

      loggin numjug = new loggin();
         numjug.setVisible(true);
     Sonido son = new Sonido();
     son.Music();
     
      
    }

}

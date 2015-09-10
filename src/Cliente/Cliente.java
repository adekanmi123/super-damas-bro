/*
 * Cliente.java
 *
 * Created on 21 de marzo de 2008, 12:11 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Cliente;

import damaschinas.tablero;
import Cliente.threadCliente;
import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.ficha;
import persistencia.jugador;
import persistencia.tablaJuego;

/**
 *
 * @author Administrador
 */
public class Cliente
{
   public static String IP_SERVER;
   tablaJuego tabj = new tablaJuego();
   tablero tab = new tablero();
   DataInputStream entrada = null;
   static DataOutputStream salida = null;
   DataInputStream entrada2 = null;
   Socket comunication = null;//para la comunicacion
   Socket comunication2 = null;//para recivir msg
  
   String nomCliente;
   /** Creates a new instance of Cliente */
   public  Cliente(tablero tab) throws IOException
   {
     this.tab= tab;
   }

//    public Cliente(tablaJuego tabj) throws IOException {
//        this.tabj=tabj;
//    }




   
   public  void conexion(jugador player) throws IOException
   {
      try {

         comunication = new Socket(Cliente.IP_SERVER, 8081);
         comunication2 = new Socket(Cliente.IP_SERVER, 8082);
         entrada = new DataInputStream(comunication.getInputStream());
         salida = new DataOutputStream(comunication.getOutputStream());
         entrada2 = new DataInputStream(comunication2.getInputStream());
//         nomCliente = JOptionPane.showInputDialog("Introducir Nick :");
//         tab.setNombreUser(nomCliente);
//         salida.writeUTF(nomCliente);

//          tab.setNombreUser(player.getId());
         salida.writeUTF(player.getId());
         
      } catch (IOException e) {
         JOptionPane.showMessageDialog(null,"El servidor no esta levantado", "Error al conectar", JOptionPane.ERROR_MESSAGE);
        
      }
      
      new threadCliente(entrada2, tab).start();
    }
   public String getNombre()
   {
      return nomCliente;
   }
   public Vector<String> pedirUsuarios()
   {
      Vector<String> users = new Vector();
      try {         
         salida.writeInt(2);
         int numUsers=entrada.readInt();
         for(int i=0;i<numUsers;i++)
            users.add(entrada.readUTF());
      } catch (IOException ex) {
         Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
      }
      return users;
   }
   public static void flujo(String mens)
   {
      try {             
        // System.out.println("el mensaje enviado desde el cliente es :"
            // + mens);
         salida.writeInt(1);
         salida.writeUTF(mens);
      } catch (IOException e) {
         System.out.println("error...." + e);
      }
   }

   public static void flujoPosicion(String mens)
   {
      try {
         System.out.println("el mensaje enviado desde el cliente es :"
             + mens);
         salida.writeInt(4);
         salida.writeUTF(mens);
      } catch (IOException e) {
         System.out.println("error...." + e);
      }
   }
   

   
   public void flujo(String amigo,String mens) 
   {
      try {             
         System.out.println("el mensaje enviado desde el cliente es :"
             + mens);
         salida.writeInt(3);//opcion de mensage a amigo
         salida.writeUTF(amigo);
         salida.writeUTF(mens);
      } catch (IOException e) {
         System.out.println("error...." + e);
      }
   }


   
  
}

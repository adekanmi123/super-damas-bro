package Cliente;
import java.net.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import damaschinas.tablero;
import persistencia.tablaJuego;
class threadCliente extends Thread{
   DataInputStream entrada;
   tablero tab = new tablero();
   tablaJuego vcli = new tablaJuego();

   public threadCliente (DataInputStream entrada,tablero tab) throws IOException
   {
      this.entrada=entrada;
      this.tab=tab;
   }
   public void run()
   {
      String menser="",amigo="";
      int opcion=0;
      while(true)
      {         
         try{
            opcion=entrada.readInt();
            switch(opcion)
            {
               case 1://mensage enviado
                  menser=entrada.readUTF();
                  System.out.println("ECO del servidor:"+menser);
                  tab.mostrarMsg(menser);
                  break;
               case 2://se agrega
                  menser=entrada.readUTF();
                  tab.agregarUser(menser);
                  break;
               case 3://mensage de amigo
                  amigo=entrada.readUTF();
                  menser=entrada.readUTF();
                  //vcli.mensageAmigo(amigo,menser);
                  System.out.println("ECO del servidor:"+menser);
                  break;
                case 4:
                    String[] posiciones = entrada.readUTF().split(":");
                    int filaSalida, columnaSalida, filaLlegada, columnaLlegada;
                    filaSalida = Integer.parseInt(posiciones[0]);
                    columnaSalida = Integer.parseInt(posiciones[1]);
                    filaLlegada = Integer.parseInt(posiciones[2]);
                    columnaLlegada = Integer.parseInt(posiciones[3]);
                    tablaJuego.validarMovimiento(filaSalida, columnaSalida, filaLlegada, columnaLlegada);
                    tab.ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
                    System.out.println(filaSalida);
            }
         }
         catch (IOException e){
            System.out.println("Error en la comunicaci�n "+"Informaci�n para el usuario");
            break;
         }
      }
      System.out.println("se desconecto el servidor");
   }

   
}
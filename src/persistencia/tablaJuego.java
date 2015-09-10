/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package persistencia;
import Cliente.Cliente;
import Cliente.VentanaAyuda;
import interfaz.numeroDeJugadores;
import javax.swing.*;
import persistencia.*;
import interfaz.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Vector;
import Cliente.Cliente;
import Servidor.threadServidor;
import damaschinas.tablero;
import java.io.DataInputStream;
import java.io.PrintStream;
import persistencia.tablaJuego;
/**
 *
 * @author marcelo
 */
public class tablaJuego {


    public static ficha [][] mitablero= mitablero= new ficha[17][25];
    

     /**
     * Procedimiento que inicializa cada casilla del tablero en null
     */
//    public static void inicializarTab(){
//        for (int i=0 ; i<17 ; i++)
//        {
//            for (int j=0 ; j<25 ; j++)
//            {
//                tablaJuego.mitablero[i][j]=null;
//            }
//        }
//    }


    public tablaJuego()throws IOException{

    }


    public static void jugadores2 ()
    {


   
        tablaJuego.mitablero[0][12] = new pink ("pink",false);
        tablaJuego.mitablero[1][11] = new pink ("pink",false);
        tablaJuego.mitablero[1][13] = new pink ("pink",false);
        tablaJuego.mitablero[2][10] = new pink ("pink",false);
        tablaJuego.mitablero[2][12] = new pink ("pink",false);
        tablaJuego.mitablero[2][14] = new pink ("pink",false);
        tablaJuego.mitablero[3][9]  = new pink ("pink",false);
        tablaJuego.mitablero[3][11] = new pink ("pink",false);
        tablaJuego.mitablero[3][13] = new pink ("pink",false);
        tablaJuego.mitablero[3][15] = new pink ("pink",false);

       int valor,numero;
        valor=0;
        numero=24;
         for (int i=4;i<=8;i++)
        {

                   for(int j= valor;j<=numero;j++)
                    {
                         tablaJuego.mitablero[i][j] = new vacio ("vacio",false);
                            j++;
                    }
            valor++;
            numero--;
        }

         valor=0;
        numero=24;
         for (int i=12;i>=9;i--)
        {

            for(int j= valor; j<=numero;j++)
            {
                 tablaJuego.mitablero[i][j] = new vacio ("vacio",false);
                   j++;
            }
            valor++;
            numero--;
        }

        tablaJuego.mitablero[13][9] =  new rojo ("rojo",false);
        tablaJuego.mitablero[13][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][15] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][10] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][12] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][14] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[16][12] = new rojo ("rojo",false);








           //  Cliente  cliente=new Cliente(this);
//             cliente.conexion();
//             Vector nomUsers=new Vector();
//             ponerActivos(cliente.pedirUsuarios());
//

    }

    public static void jugadores3 (){



        tablaJuego.mitablero[4][0] = new azul ("azul",false);
        tablaJuego.mitablero[4][2] = new azul ("azul",false);
        tablaJuego.mitablero[4][4] = new azul ("azul",false);
        tablaJuego.mitablero[4][6] = new azul ("azul",false);
        tablaJuego.mitablero[5][1] = new azul ("azul",false);
        tablaJuego.mitablero[5][3] = new azul ("azul",false);
        tablaJuego.mitablero[5][5] = new azul ("azul",false);
        tablaJuego.mitablero[6][2] = new azul ("azul",false);
        tablaJuego.mitablero[6][4] = new azul ("azul",false);
        tablaJuego.mitablero[7][3] = new azul ("azul",false);

        tablaJuego.mitablero[4][18] = new verde ("verde",false);
        tablaJuego.mitablero[4][20] = new verde ("verde",false);
        tablaJuego.mitablero[4][22] = new verde ("verde",false);
        tablaJuego.mitablero[4][24] = new verde ("verde",false);
        tablaJuego.mitablero[5][19] = new verde ("verde",false);
        tablaJuego.mitablero[5][21] = new verde ("verde",false);
        tablaJuego.mitablero[5][23]  = new verde ("verde",false);
        tablaJuego.mitablero[6][20] = new verde ("verde",false);
        tablaJuego.mitablero[6][22] = new verde ("verde",false);
        tablaJuego.mitablero[7][21] = new verde ("verde",false);

        tablaJuego.mitablero[13][9] =  new rojo ("rojo",false);
        tablaJuego.mitablero[13][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][15] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][10] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][12] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][14] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[16][12] = new rojo ("rojo",false);

  int aux=0;

        for(int i=12; i>=0; i--){
            aux++;
            for(int j=aux-1; j<=26-aux-1; j++){

               tablaJuego.mitablero[i][j] = new vacio ("vacio",false);

              j++;
            }
        }
       

    }

    public static void jugadores4(){

        tablaJuego.mitablero[0][12] = new pink ("pink",false);
        tablaJuego.mitablero[1][11] = new pink ("pink",false);
        tablaJuego.mitablero[1][13] = new pink ("pink",false);
        tablaJuego.mitablero[2][10] = new pink ("pink",false);
        tablaJuego.mitablero[2][12] = new pink ("pink",false);
        tablaJuego.mitablero[2][14] = new pink ("pink",false);
        tablaJuego.mitablero[3][9]  = new pink ("pink",false);
        tablaJuego.mitablero[3][11] = new pink ("pink",false);
        tablaJuego.mitablero[3][13] = new pink ("pink",false);
        tablaJuego.mitablero[3][15] = new pink ("pink",false);

         tablaJuego.mitablero[4][0] = new azul ("azul",false);
        tablaJuego.mitablero[4][2] = new azul ("azul",false);
        tablaJuego.mitablero[4][4] = new azul ("azul",false);
        tablaJuego.mitablero[4][6] = new azul ("azul",false);
        tablaJuego.mitablero[5][1] = new azul ("azul",false);
        tablaJuego.mitablero[5][3] = new azul ("azul",false);
        tablaJuego.mitablero[5][5] = new azul ("azul",false);
        tablaJuego.mitablero[6][2] = new azul ("azul",false);
        tablaJuego.mitablero[6][4] = new azul ("azul",false);
        tablaJuego.mitablero[7][3] = new azul ("azul",false);

        tablaJuego.mitablero[13][9] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][15] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][10] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][12] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][14] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[16][12] = new rojo ("rojo",false);

        tablaJuego.mitablero[9][21] = new  amarillo ("amarillo",false);
        tablaJuego.mitablero[10][20] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[10][22] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][19] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][21] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][23] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][18] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][20] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][22] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][24] = new amarillo ("amarillo",false);

         int aux=0;

        for(int i=12; i>=4; i--){
            aux++;
            for(int j=aux-1; j<=16+aux-1; j++){
                tablaJuego.mitablero[i][j] = new vacio ("vacio",false);
              j++;
            }
        }
        
    }

    public static void jugadores6(){

        tablaJuego.mitablero[0][12] =new pink ("pink",false);
        tablaJuego.mitablero[1][11] = new pink ("pink",false);
        tablaJuego.mitablero[1][13] = new pink ("pink",false);
        tablaJuego.mitablero[2][10] = new pink ("pink",false);
        tablaJuego.mitablero[2][12] = new pink ("pink",false);
        tablaJuego.mitablero[2][14] = new pink ("pink",false);
        tablaJuego.mitablero[3][9]  = new pink ("pink",false);
        tablaJuego.mitablero[3][11] = new pink ("pink",false);
        tablaJuego.mitablero[3][13] = new pink ("pink",false);
        tablaJuego.mitablero[3][15] = new pink ("pink",false);

         tablaJuego.mitablero[4][0] =new azul ("azul",false);
        tablaJuego.mitablero[4][2] = new azul ("azul",false);
        tablaJuego.mitablero[4][4] = new azul ("azul",false);
        tablaJuego.mitablero[4][6] = new azul ("azul",false);
        tablaJuego.mitablero[5][1] = new azul ("azul",false);
        tablaJuego.mitablero[5][3] = new azul ("azul",false);
        tablaJuego.mitablero[5][5] = new azul ("azul",false);
        tablaJuego.mitablero[6][2] = new azul ("azul",false);
        tablaJuego.mitablero[6][4] = new azul ("azul",false);
        tablaJuego.mitablero[7][3] = new azul ("azul",false);

        tablaJuego.mitablero[13][9] =  new rojo ("rojo",false);
        tablaJuego.mitablero[13][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[13][15] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][10] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][12] = new rojo ("rojo",false);
        tablaJuego.mitablero[14][14] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][11] = new rojo ("rojo",false);
        tablaJuego.mitablero[15][13] = new rojo ("rojo",false);
        tablaJuego.mitablero[16][12] = new rojo ("rojo",false);

        tablaJuego.mitablero[9][21] =  new  amarillo ("amarillo",false);
        tablaJuego.mitablero[10][20] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[10][22] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][19] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][21] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[11][23] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][18] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][20] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][22] = new amarillo ("amarillo",false);
        tablaJuego.mitablero[12][24] = new amarillo ("amarillo",false);

        tablaJuego.mitablero[9][3] =  new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[10][2] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[10][4] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[11][1] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[11][3] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[11][5] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[12][0] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[12][2] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[12][4] = new azulClaro ("azulClaro",false);
        tablaJuego.mitablero[12][6] = new azulClaro ("azulClaro",false);

        tablaJuego.mitablero[4][18] = new verde ("verde",false);
        tablaJuego.mitablero[4][20] = new verde ("verde",false);
        tablaJuego.mitablero[4][22] = new verde ("verde",false);
        tablaJuego.mitablero[4][24] = new verde ("verde",false);
        tablaJuego.mitablero[5][19] = new verde ("verde",false);
        tablaJuego.mitablero[5][21] = new verde ("verde",false);
        tablaJuego.mitablero[5][23]  = new verde ("verde",false);
        tablaJuego.mitablero[6][20] = new verde ("verde",false);
        tablaJuego.mitablero[6][22] = new verde ("verde",false);
        tablaJuego.mitablero[7][21] = new verde ("verde",false);

        tablaJuego.mitablero[8][4] = new vacio ("vacio",false);
        tablaJuego.mitablero[8][6] = new vacio ("vacio",false);
        tablaJuego.mitablero[8][18] = new vacio ("vacio",false);
        tablaJuego.mitablero[8][20] = new vacio ("vacio",false);

        tablaJuego.mitablero[7][5] = new vacio ("vacio",false);
        tablaJuego.mitablero[7][19] = new vacio ("vacio",false);
        tablaJuego.mitablero[9][5] = new vacio ("vacio",false);
        tablaJuego.mitablero[9][19] = new vacio ("vacio",false);
        tablaJuego.mitablero[10][6] = new vacio ("vacio",false);
        tablaJuego.mitablero[10][18] = new vacio ("vacio",false);
        tablaJuego.mitablero[6][6] = new vacio ("vacio",false);
        tablaJuego.mitablero[6][18] = new vacio ("vacio",false);

            int aux=0,count=0;

        for(int i=4; i<=12; i++){
            aux++;
            count=0;
             if(( i % 2) ==0){
                    count= 1;
                }
            for(int j= 7+count ; j<=17; j++){


                tablaJuego.mitablero[i][j] = new vacio ("vacio",false);
              j++;
            }
        }



     

    }

    public static boolean casillaNoVacia (int Fila, int Columna)
{
    if (tablaJuego.mitablero[Fila][Columna] instanceof vacio)
        return true;
    else
        return false;
    }

    
    
    
    public static boolean validarWin( String jugador){
if( (jugador == "pink")&&(tablaJuego.mitablero[13][9] instanceof pink)
        &&(tablaJuego.mitablero[13][11] instanceof pink)  
        &&(tablaJuego.mitablero[13][13] instanceof pink)
        &&(tablaJuego.mitablero[13][15] instanceof pink)
        &&(tablaJuego.mitablero[14][10] instanceof pink)
        &&(tablaJuego.mitablero[14][12] instanceof pink)
        &&(tablaJuego.mitablero[14][14] instanceof pink)
        &&(tablaJuego.mitablero[15][11] instanceof pink)
        &&(tablaJuego.mitablero[15][13] instanceof pink)
        &&(tablaJuego.mitablero[16][12] instanceof pink)
        
        
        ){
    System.out.println("GANASTE PICK!!!!");
    return true;
    }
if( (jugador == "rojo")&&(tablaJuego.mitablero[0][12] instanceof rojo)
        &&(tablaJuego.mitablero[1][11] instanceof rojo)  
        &&(tablaJuego.mitablero[1][13] instanceof rojo)
        &&(tablaJuego.mitablero[2][10] instanceof rojo)
        &&(tablaJuego.mitablero[2][12] instanceof rojo)
        &&(tablaJuego.mitablero[2][14] instanceof rojo)
        &&(tablaJuego.mitablero[3][9]  instanceof rojo)
        &&(tablaJuego.mitablero[3][11] instanceof rojo)
        &&(tablaJuego.mitablero[3][13] instanceof rojo)
        &&(tablaJuego.mitablero[3][15] instanceof rojo)
        
        
        ){
    System.out.println("GANASTE ROJOOO!!!!");
    return true;
    }


if( (jugador == "verde")&&(tablaJuego.mitablero[9][3] instanceof verde)
        &&(tablaJuego.mitablero[10][2] instanceof verde)  
        &&(tablaJuego.mitablero[10][4] instanceof verde)
        &&(tablaJuego.mitablero[11][1] instanceof verde)
        &&(tablaJuego.mitablero[11][3] instanceof verde)
        &&(tablaJuego.mitablero[11][5] instanceof verde)
        &&(tablaJuego.mitablero[12][0] instanceof verde)
        &&(tablaJuego.mitablero[12][2] instanceof verde)
        &&(tablaJuego.mitablero[12][4] instanceof verde)
        &&(tablaJuego.mitablero[12][6] instanceof verde)
        
        
        ){
    System.out.println("GANASTE VErde!!!!!");
    return true;
    }

else if( (jugador == "azul")&&(tablaJuego.mitablero[9][21] instanceof azul)
        &&(tablaJuego.mitablero[10][20] instanceof azul)  
        &&(tablaJuego.mitablero[10][22] instanceof azul)
        &&(tablaJuego.mitablero[11][19] instanceof azul)
        &&(tablaJuego.mitablero[11][21] instanceof azul)
        &&(tablaJuego.mitablero[11][23] instanceof azul)
        &&(tablaJuego.mitablero[12][18] instanceof azul)
        &&(tablaJuego.mitablero[12][20] instanceof azul)
        &&(tablaJuego.mitablero[12][22] instanceof azul)
        &&(tablaJuego.mitablero[12][24] instanceof azul)
        
        
        ){
    System.out.println("GANASTE AZURRRRRR!!!!!");
    return true;
    }


else if( (jugador == "amarillo")&&(tablaJuego.mitablero[7][3] instanceof amarillo)
        &&(tablaJuego.mitablero[6][2] instanceof amarillo)  
        &&(tablaJuego.mitablero[6][4] instanceof amarillo)
        &&(tablaJuego.mitablero[5][1] instanceof amarillo)
        &&(tablaJuego.mitablero[5][3] instanceof amarillo)
        &&(tablaJuego.mitablero[5][5] instanceof amarillo)
        &&(tablaJuego.mitablero[4][0] instanceof amarillo)
        &&(tablaJuego.mitablero[4][2] instanceof amarillo)
        &&(tablaJuego.mitablero[4][4] instanceof amarillo)
        &&(tablaJuego.mitablero[4][6] instanceof amarillo)
        
        
        ){
    System.out.println("GANASTE AMARILLOOO!!");
    return true;
    }


else if( (jugador == "azulClaro")&&(tablaJuego.mitablero[7][21] instanceof azulClaro)
        &&(tablaJuego.mitablero[6][20] instanceof azulClaro)  
        &&(tablaJuego.mitablero[6][22] instanceof azulClaro)
        &&(tablaJuego.mitablero[5][19] instanceof azulClaro)
        &&(tablaJuego.mitablero[5][21] instanceof azulClaro)
        &&(tablaJuego.mitablero[5][23] instanceof azulClaro)
        &&(tablaJuego.mitablero[4][18] instanceof azulClaro)
        &&(tablaJuego.mitablero[4][20] instanceof azulClaro)
        &&(tablaJuego.mitablero[4][22] instanceof azulClaro)
        &&(tablaJuego.mitablero[4][24] instanceof azulClaro)
        
        
        ){
    System.out.println("GANASTE AZUL CLAROOO!!");
    return true;
    }


return false;
    }
    
     public static String validarMovimiento (int filaSalida, int columnaSalida, int filaLlegada, int columnaLlegada)
    {
    String pieza;
     DataInputStream entrada2 = null;
     boolean resultado=false;

    if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof pink){

        

      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

          if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }
         else    if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }
             else if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

        else           if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }
        else                     if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }
        else       if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic

 else    if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

  else   if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

  else   if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else  if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new pink ("pink",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }



     }

else     if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof verde){



      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

           if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
    else         if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
    else          if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }

    else               if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
    else                         if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
      else         if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic



    else if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

   else  if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     else if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new verde ("verde",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     }

else     if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof azulClaro){




      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

           if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
          else   if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
          else    if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }

          else         if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
              else               if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
             else  if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

   else  if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else  if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azulClaro ("azulClaro",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     }

else      if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof amarillo){






      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

           if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
    else         if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
    else          if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }

        else           if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else                     if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else       if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     else if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new amarillo ("amarillo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     }

     else    if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof rojo){




      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

           if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
     else        if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
     else         if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }

     else              if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
     else                        if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
     else          if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

   else  if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else  if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new rojo ("rojo",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     }
        else       if (tablaJuego.mitablero[filaSalida][columnaSalida] instanceof azul){




      //Comienza salto 23456789876543234567876532345678765432345675432345676543!"!"12!"!2121"!2!"$%$7#$%

           if((filaLlegada == filaSalida) && (columnaLlegada+4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada+2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else     if((filaLlegada == filaSalida) && (columnaLlegada-4==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada-2] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else      if((filaLlegada+2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }

        else           if((filaLlegada+2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada+1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else                     if((filaLlegada-2 == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada+1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        else       if((filaLlegada-2 == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada-1][columnaLlegada-1] instanceof vacio)==false)&&((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));

        }
        //asdfghjhgfdfghjkjhgfghjijxicjixjcixjcxijcijxijcijxcijxicjxijcixjcijxicjxic

        else if((filaLlegada+1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada+1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada+2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada == filaSalida) && (columnaLlegada-2==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else if((filaLlegada-1 == filaSalida) && (columnaLlegada+1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

    else  if((filaLlegada-1 == filaSalida) && (columnaLlegada-1==columnaSalida) && ((tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof vacio)==true)){
                resultado=true;
                tablaJuego.mitablero[filaSalida][columnaSalida]= new vacio ("vacio",false);
                tablaJuego.mitablero[filaLlegada][columnaLlegada]= new azul ("azul",false);
                return (String.valueOf(filaSalida) + ":" + String.valueOf(columnaSalida)+ ":" + String.valueOf(filaLlegada)+ ":" + String.valueOf(columnaLlegada));
        }

     }

          return ("");
        
          
    }
}











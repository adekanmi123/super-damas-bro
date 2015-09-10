/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * tablero.java
 *
 * Created on 24/05/2011, 07:24:19 PM
 */

package damaschinas;
import Cliente.Cliente;
import Cliente.VentanaAyuda;
import interfaz.numeroDeJugadores;
import javax.swing.*;
import persistencia.*;
import interfaz.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Vector;
import base_datos.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author marcelo
 */

public class tablero extends javax.swing.JFrame {

    Vector<String> nomUsers;
    VentanaAyuda va;
    Cliente cliente;
    int cont;
    private jugador player;
    /** Creates new form tablero */

    public tablero()throws IOException{
        initComponents();
        this.setLocationRelativeTo(null);
    }

     public tablero(int numero, jugador player) throws IOException {
       // Cliente.IP_SERVER = JOptionPane.showInputDialog("Introducir IP_SERVER :","localhost");


        
        initComponents();
        this.setLocationRelativeTo(null);
         this.player = player;
//        tablaJuego.inicializarTab();

        setNombreUser(player);


         if( numero== 2)
             tablaJuego.jugadores2();
        if( numero== 3)
             tablaJuego.jugadores3();
        if( numero== 4)
             tablaJuego.jugadores4();
        if( numero== 6)
             tablaJuego.jugadores6();
        

        final JButton botones[][] = {                              {H0H12},
                                                                 {H1H11,H1H13},
                                                             {H2H10,H2H12,H2H14},
                                                            {H3H9,H3H11,H3H13,H3H15},
                                         {H4H0,H4H2,H4H4,H4H6,H4H8,H4H10,H4H12,H4H14,H4H16,H4H18,H4H20,H4H22,H4H24},
                                             {H5H1,H5H3,H5H5,H5H7,H5H9,H5H11,H5H13,H5H15,H5H17,H5H19,H5H21,H5H23},
                                                {H6H2,H6H4,H6H6,H6H8,H6H10,H6H12,H6H14,H6H16,H6H18,H6H20,H6H22},
                                                    {H7H3,H7H5,H7H7,H7H9,H7H11,H7H13,H7H15,H7H17,H7H19,H7H21},
                                                      {H8H4,H8H6,H8H8,H8H10,H8H12,H8H14,H8H16,H8H18,H8H20},
                                                    {H9H3,H9H5,H9H7,H9H9,H9H11,H9H13,H9H15,H9H17,H9H19,H9H21},
                                          {H10H2,H10H4,H10H6,H10H8,H10H10,H10H12,H10H14,H10H16,H10H18,H10H20,H10H22},
                                       {H11H1,H11H3,H11H5,H11H7,H11H9,H11H11,H11H13,H11H15,H11H17,H11H19,H11H21,H11H23},
                                     {H12H0,H12H2,H12H4,H12H6,H12H8,H12H10,H12H12,H12H14,H12H16,H12H18,H12H20,H12H22,H12H24},
                                                             {H13H9,H13H11,H13H13,H13H15},
                                                              {H14H10,H14H12,H14H14},
                                                                 {H15H11,H15H13},
                                                                    {H16H12},
                                      };
                     int cont=0;
                    int posy=11;


 
        for (int i = 0; i <=16; i++) {
            cont=0;
                     for (int j = 0; j <=24; j++) {

                                  if (tablaJuego.mitablero[i][j] instanceof verde  ){
                                     cont++;
                                
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichaverde.png")));
                         }

                                else if (tablaJuego.mitablero[i][j] instanceof pink  ){
                                     cont++;
                                 
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichapink.png")));
                         }
                               
                                else if (tablaJuego.mitablero[i][j] instanceof rojo  ){
                                     cont++;
                                 
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ficharoja.png")));
                         }

                                    else if (tablaJuego.mitablero[i][j] instanceof amarillo  ){
                                     cont++;
                                
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichamarilla.png")));
                         }

                                else if (tablaJuego.mitablero[i][j] instanceof azulClaro  ){
                                     cont++;
                                
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichazulclaro.png")));
                         }

                                else if (tablaJuego.mitablero[i][j] instanceof vacio  ){
                                     cont++;
                                
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
                         }
                                 
                               else    if (tablaJuego.mitablero[i][j] instanceof azul  ){
                                     cont++;
                                 
                                    botones[i][cont-1].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichazul.png")));
                         }
                                 





                                                     }
                                  }

   
              Cliente  cliente=new Cliente(this);
             cliente.conexion(player);
             Vector nomUsers=new Vector();
             ponerActivos(cliente.pedirUsuarios());
             cont++;
            
            
    
    }


        int numeroClick = 0;
        int filaSalida;
        int columnaSalida;
        int filaLlegada;
        int columnaLlegada;
        //transformamos columna para que funcionen los botones
         public  int TransformarColumna (int fila,int columna){
             
              if((fila==0) || (fila==16)) {
              columna=0;}
             
             else if((fila==1) || (fila==15)) {
              
                if(columna==11)columna=0; 
                 if(columna==13)columna=1;  
                  }
              
             else       if((fila==2) || (fila==14)) {
              
                 if(columna==10)columna=0; 
                 if(columna==12)columna=1;
                 if(columna==14)columna=2; 
                  }
             else          if((fila==3) || (fila==13)) {
              
                 if(columna==9)columna=0; 
                 if(columna==11)columna=1;
                 if(columna==13)columna=2; 
                 if(columna==15)columna=3; 
                  }

             else       if((fila==4) || (fila==12)) {

                 if(columna==2)columna=1;
                 if(columna==4)columna=2;
                 if(columna==6)columna=3;
                 if(columna==8)columna=4;
                 if(columna==10)columna=5;
                 if(columna==12)columna=6;
                 if(columna==14)columna=7;
                 if(columna==16)columna=8;
                 if(columna==18)columna=9;
                 if(columna==20)columna=10;
                 if(columna==22)columna=11;
                 if(columna==24)columna=12;
                  }

            else if((fila==5) || (fila==11)) {

                 if(columna==1)columna=0;
              else   if(columna==3)columna=1;
              else   if(columna==5)columna=2;
              else   if(columna==7)columna=3;
              else   if(columna==9)columna=4;
              else   if(columna==11)columna=5;
              else   if(columna==13)columna=6;
              else   if(columna==15)columna=7;
              else   if(columna==17)columna=8;
              else   if(columna==19)columna=9;
              else   if(columna==21)columna=10;
              else   if(columna==23)columna=11;
                  }

             else if((fila==6) || (fila==10)) {

                 if(columna==2)columna=0;
                else if(columna==4)columna=1;
                else if(columna==6)columna=2;
               else  if(columna==8)columna=3;
             else    if(columna==10)columna=4;
                else if(columna==12)columna=5;
                else if(columna==14)columna=6;
                else if(columna==16)columna=7;
                else if(columna==18)columna=8;
               else  if(columna==20)columna=9;
               else  if(columna==22)columna=10;
                  }

              if((fila==7) || (fila==9)) {

                 if(columna==3)columna=0;
                 if(columna==5)columna=1;
                 if(columna==7)columna=2;
                 if(columna==9)columna=3;
                 if(columna==11)columna=4;
                 if(columna==13)columna=5;
                 if(columna==15)columna=6;
                 if(columna==17)columna=7;
                 if(columna==19)columna=8;
                 if(columna==21)columna=9;
                    }

              if(fila==8) {

                 if(columna==4)columna=0;
                 if(columna==6)columna=1;
                 if(columna==8)columna=2;
                 if(columna==10)columna=3;
                 if(columna==12)columna=4;
                 if(columna==14)columna=5;
                 if(columna==16)columna=6;
                 if(columna==18)columna=7;
                 if(columna==20)columna=8;
                  }


      
               return columna;
                            
               }
        public void ActualizarTablero (int filaSalida, int columnaSalida, int filaLlegada, int columnaLlegada)
{

             final JButton botones[][] = {                           {H0H12},
                                                                 {H1H11,H1H13},
                                                             {H2H10,H2H12,H2H14},
                                                            {H3H9,H3H11,H3H13,H3H15},
                                         {H4H0,H4H2,H4H4,H4H6,H4H8,H4H10,H4H12,H4H14,H4H16,H4H18,H4H20,H4H22,H4H24},
                                             {H5H1,H5H3,H5H5,H5H7,H5H9,H5H11,H5H13,H5H15,H5H17,H5H19,H5H21,H5H23},
                                                {H6H2,H6H4,H6H6,H6H8,H6H10,H6H12,H6H14,H6H16,H6H18,H6H20,H6H22},
                                                    {H7H3,H7H5,H7H7,H7H9,H7H11,H7H13,H7H15,H7H17,H7H19,H7H21},
                                                      {H8H4,H8H6,H8H8,H8H10,H8H12,H8H14,H8H16,H8H18,H8H20},
                                                    {H9H3,H9H5,H9H7,H9H9,H9H11,H9H13,H9H15,H9H17,H9H19,H9H21},
                                          {H10H2,H10H4,H10H6,H10H8,H10H10,H10H12,H10H14,H10H16,H10H18,H10H20,H10H22},
                                       {H11H1,H11H3,H11H5,H11H7,H11H9,H11H11,H11H13,H11H15,H11H17,H11H19,H11H21,H11H23},
                                     {H12H0,H12H2,H12H4,H12H6,H12H8,H12H10,H12H12,H12H14,H12H16,H12H18,H12H20,H12H22,H12H24},
                                                             {H13H9,H13H11,H13H13,H13H15},
                                                              {H14H10,H14H12,H14H14},
                                                                 {H15H11,H15H13},
                                                                    {H16H12},
                                      };

              if(tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof pink){
          
           columnaSalida=TransformarColumna(filaSalida,columnaSalida);  
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichapink.png")));
         
              }
    else if(tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof azulClaro)
    {

           columnaSalida=TransformarColumna(filaSalida,columnaSalida);
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichazulclaro.png")));
         }

     else if (tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof amarillo) {

           columnaSalida=TransformarColumna(filaSalida,columnaSalida);
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichamarilla.png")));
         }
    else if (tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof rojo) {

           columnaSalida=TransformarColumna(filaSalida,columnaSalida);
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ficharoja.png")));
         
              }
        else if (tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof azul) {

           columnaSalida=TransformarColumna(filaSalida,columnaSalida);
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichazul.png")));
         }

      else if (tablaJuego.mitablero[filaLlegada][columnaLlegada] instanceof verde) {

           columnaSalida=TransformarColumna(filaSalida,columnaSalida);
           columnaLlegada=TransformarColumna(filaLlegada,columnaLlegada);
           botones[filaSalida][columnaSalida].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png")));
           botones[filaLlegada][columnaLlegada].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichaverde.png")));
         }

       
        }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        H7H13 = new javax.swing.JButton();
        H7H5 = new javax.swing.JButton();
        H7H9 = new javax.swing.JButton();
        H7H7 = new javax.swing.JButton();
        H7H17 = new javax.swing.JButton();
        H7H15 = new javax.swing.JButton();
        H7H11 = new javax.swing.JButton();
        H5H1 = new javax.swing.JButton();
        H4H4 = new javax.swing.JButton();
        H4H6 = new javax.swing.JButton();
        H4H2 = new javax.swing.JButton();
        H4H0 = new javax.swing.JButton();
        H7H3 = new javax.swing.JButton();
        H6H2 = new javax.swing.JButton();
        H5H5 = new javax.swing.JButton();
        H5H3 = new javax.swing.JButton();
        H6H4 = new javax.swing.JButton();
        H7H19 = new javax.swing.JButton();
        H6H6 = new javax.swing.JButton();
        H6H8 = new javax.swing.JButton();
        H6H10 = new javax.swing.JButton();
        H6H12 = new javax.swing.JButton();
        H6H14 = new javax.swing.JButton();
        H6H16 = new javax.swing.JButton();
        H6H18 = new javax.swing.JButton();
        H5H7 = new javax.swing.JButton();
        H5H9 = new javax.swing.JButton();
        H5H11 = new javax.swing.JButton();
        H5H13 = new javax.swing.JButton();
        H5H15 = new javax.swing.JButton();
        H5H17 = new javax.swing.JButton();
        H4H8 = new javax.swing.JButton();
        H4H10 = new javax.swing.JButton();
        H4H12 = new javax.swing.JButton();
        H4H14 = new javax.swing.JButton();
        H4H16 = new javax.swing.JButton();
        H4H18 = new javax.swing.JButton();
        H4H20 = new javax.swing.JButton();
        H4H22 = new javax.swing.JButton();
        H4H24 = new javax.swing.JButton();
        H5H19 = new javax.swing.JButton();
        H5H21 = new javax.swing.JButton();
        H5H23 = new javax.swing.JButton();
        H6H20 = new javax.swing.JButton();
        H6H22 = new javax.swing.JButton();
        H7H21 = new javax.swing.JButton();
        H3H9 = new javax.swing.JButton();
        H3H15 = new javax.swing.JButton();
        H3H11 = new javax.swing.JButton();
        H3H13 = new javax.swing.JButton();
        H2H10 = new javax.swing.JButton();
        H2H12 = new javax.swing.JButton();
        H2H14 = new javax.swing.JButton();
        H1H11 = new javax.swing.JButton();
        H1H13 = new javax.swing.JButton();
        H0H12 = new javax.swing.JButton();
        H8H4 = new javax.swing.JButton();
        H8H6 = new javax.swing.JButton();
        H8H8 = new javax.swing.JButton();
        H8H10 = new javax.swing.JButton();
        H8H12 = new javax.swing.JButton();
        H8H14 = new javax.swing.JButton();
        H8H16 = new javax.swing.JButton();
        H8H18 = new javax.swing.JButton();
        H8H20 = new javax.swing.JButton();
        H9H3 = new javax.swing.JButton();
        H10H4 = new javax.swing.JButton();
        H10H2 = new javax.swing.JButton();
        H11H5 = new javax.swing.JButton();
        H11H3 = new javax.swing.JButton();
        H11H1 = new javax.swing.JButton();
        H12H0 = new javax.swing.JButton();
        H12H2 = new javax.swing.JButton();
        H12H4 = new javax.swing.JButton();
        H12H6 = new javax.swing.JButton();
        H9H5 = new javax.swing.JButton();
        H9H7 = new javax.swing.JButton();
        H9H19 = new javax.swing.JButton();
        H9H17 = new javax.swing.JButton();
        H9H15 = new javax.swing.JButton();
        H9H13 = new javax.swing.JButton();
        H9H11 = new javax.swing.JButton();
        H9H9 = new javax.swing.JButton();
        H13H9 = new javax.swing.JButton();
        H12H8 = new javax.swing.JButton();
        H10H6 = new javax.swing.JButton();
        H11H7 = new javax.swing.JButton();
        H13H11 = new javax.swing.JButton();
        H13H13 = new javax.swing.JButton();
        H13H15 = new javax.swing.JButton();
        H14H10 = new javax.swing.JButton();
        H14H12 = new javax.swing.JButton();
        H14H14 = new javax.swing.JButton();
        H15H11 = new javax.swing.JButton();
        H15H13 = new javax.swing.JButton();
        H16H12 = new javax.swing.JButton();
        H10H8 = new javax.swing.JButton();
        H11H9 = new javax.swing.JButton();
        H12H10 = new javax.swing.JButton();
        H10H10 = new javax.swing.JButton();
        H11H11 = new javax.swing.JButton();
        H12H12 = new javax.swing.JButton();
        H10H12 = new javax.swing.JButton();
        H11H13 = new javax.swing.JButton();
        H12H14 = new javax.swing.JButton();
        H12H16 = new javax.swing.JButton();
        H10H14 = new javax.swing.JButton();
        H11H15 = new javax.swing.JButton();
        H10H16 = new javax.swing.JButton();
        H10H18 = new javax.swing.JButton();
        H11H17 = new javax.swing.JButton();
        H9H21 = new javax.swing.JButton();
        H10H22 = new javax.swing.JButton();
        H11H19 = new javax.swing.JButton();
        H10H20 = new javax.swing.JButton();
        H11H21 = new javax.swing.JButton();
        H11H23 = new javax.swing.JButton();
        H12H18 = new javax.swing.JButton();
        H12H20 = new javax.swing.JButton();
        H12H22 = new javax.swing.JButton();
        H12H24 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panMostrar = new javax.swing.JTextArea();
        txtMensage = new javax.swing.JTextField();
        butEnviar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstActivos1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        estadis = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(255, 51, 0));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLayeredPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        H7H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H13.setBorderPainted(false);
        H7H13.setContentAreaFilled(false);
        H7H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H13.setFocusPainted(false);
        H7H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H13ActionPerformed(evt);
            }
        });
        H7H13.setBounds(290, 270, 29, 28);
        jLayeredPane1.add(H7H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H5.setBorderPainted(false);
        H7H5.setContentAreaFilled(false);
        H7H5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H5.setFocusPainted(false);
        H7H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H5ActionPerformed(evt);
            }
        });
        H7H5.setBounds(170, 270, 29, 28);
        jLayeredPane1.add(H7H5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H9.setBorderPainted(false);
        H7H9.setContentAreaFilled(false);
        H7H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H9.setFocusPainted(false);
        H7H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H9ActionPerformed(evt);
            }
        });
        H7H9.setBounds(230, 270, 29, 28);
        jLayeredPane1.add(H7H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H7.setBorderPainted(false);
        H7H7.setContentAreaFilled(false);
        H7H7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H7.setFocusPainted(false);
        H7H7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H7ActionPerformed(evt);
            }
        });
        H7H7.setBounds(200, 270, 29, 28);
        jLayeredPane1.add(H7H7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H17.setBorderPainted(false);
        H7H17.setContentAreaFilled(false);
        H7H17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H17.setFocusPainted(false);
        H7H17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H17ActionPerformed(evt);
            }
        });
        H7H17.setBounds(350, 270, 29, 28);
        jLayeredPane1.add(H7H17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H15.setBorderPainted(false);
        H7H15.setContentAreaFilled(false);
        H7H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H15.setFocusPainted(false);
        H7H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H15ActionPerformed(evt);
            }
        });
        H7H15.setBounds(320, 270, 29, 28);
        jLayeredPane1.add(H7H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H11.setBorderPainted(false);
        H7H11.setContentAreaFilled(false);
        H7H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H11.setFocusPainted(false);
        H7H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H11ActionPerformed(evt);
            }
        });
        H7H11.setBounds(260, 270, 29, 28);
        jLayeredPane1.add(H7H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H1.setBorderPainted(false);
        H5H1.setContentAreaFilled(false);
        H5H1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H1.setFocusPainted(false);
        H5H1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H1ActionPerformed(evt);
            }
        });
        H5H1.setBounds(110, 210, 29, 28);
        jLayeredPane1.add(H5H1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H4.setBorderPainted(false);
        H4H4.setContentAreaFilled(false);
        H4H4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H4.setFocusPainted(false);
        H4H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H4ActionPerformed(evt);
            }
        });
        H4H4.setBounds(150, 180, 29, 28);
        jLayeredPane1.add(H4H4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H6.setBorderPainted(false);
        H4H6.setContentAreaFilled(false);
        H4H6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H6.setFocusPainted(false);
        H4H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H6ActionPerformed(evt);
            }
        });
        H4H6.setBounds(180, 180, 29, 28);
        jLayeredPane1.add(H4H6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H2.setBorderPainted(false);
        H4H2.setContentAreaFilled(false);
        H4H2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H2.setFocusPainted(false);
        H4H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H2ActionPerformed(evt);
            }
        });
        H4H2.setBounds(120, 180, 29, 28);
        jLayeredPane1.add(H4H2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H0.setBorderPainted(false);
        H4H0.setContentAreaFilled(false);
        H4H0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H0.setFocusPainted(false);
        H4H0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H0ActionPerformed(evt);
            }
        });
        H4H0.setBounds(89, 180, 30, 30);
        jLayeredPane1.add(H4H0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H3.setBorderPainted(false);
        H7H3.setContentAreaFilled(false);
        H7H3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H3.setFocusPainted(false);
        H7H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H3ActionPerformed(evt);
            }
        });
        H7H3.setBounds(140, 270, 29, 28);
        jLayeredPane1.add(H7H3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H2.setBorderPainted(false);
        H6H2.setContentAreaFilled(false);
        H6H2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H2.setFocusPainted(false);
        H6H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H2ActionPerformed(evt);
            }
        });
        H6H2.setBounds(120, 240, 29, 28);
        jLayeredPane1.add(H6H2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H5.setBorderPainted(false);
        H5H5.setContentAreaFilled(false);
        H5H5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H5.setFocusPainted(false);
        H5H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H5ActionPerformed(evt);
            }
        });
        H5H5.setBounds(170, 210, 29, 28);
        jLayeredPane1.add(H5H5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H3.setBorderPainted(false);
        H5H3.setContentAreaFilled(false);
        H5H3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H3.setFocusPainted(false);
        H5H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H3ActionPerformed(evt);
            }
        });
        H5H3.setBounds(140, 210, 29, 28);
        jLayeredPane1.add(H5H3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H4.setBorderPainted(false);
        H6H4.setContentAreaFilled(false);
        H6H4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H4.setFocusPainted(false);
        H6H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H4ActionPerformed(evt);
            }
        });
        H6H4.setBounds(150, 240, 29, 28);
        jLayeredPane1.add(H6H4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H19.setBorderPainted(false);
        H7H19.setContentAreaFilled(false);
        H7H19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H19.setFocusPainted(false);
        H7H19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H19ActionPerformed(evt);
            }
        });
        H7H19.setBounds(380, 270, 29, 28);
        jLayeredPane1.add(H7H19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H6.setBorderPainted(false);
        H6H6.setContentAreaFilled(false);
        H6H6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H6.setFocusPainted(false);
        H6H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H6ActionPerformed(evt);
            }
        });
        H6H6.setBounds(180, 240, 29, 28);
        jLayeredPane1.add(H6H6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H8.setBorderPainted(false);
        H6H8.setContentAreaFilled(false);
        H6H8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H8.setFocusPainted(false);
        H6H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H8ActionPerformed(evt);
            }
        });
        H6H8.setBounds(210, 240, 29, 28);
        jLayeredPane1.add(H6H8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H10.setBorderPainted(false);
        H6H10.setContentAreaFilled(false);
        H6H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H10.setFocusPainted(false);
        H6H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H10ActionPerformed(evt);
            }
        });
        H6H10.setBounds(240, 240, 29, 28);
        jLayeredPane1.add(H6H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H12.setBorderPainted(false);
        H6H12.setContentAreaFilled(false);
        H6H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H12.setFocusPainted(false);
        H6H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H12ActionPerformed(evt);
            }
        });
        H6H12.setBounds(270, 240, 29, 28);
        jLayeredPane1.add(H6H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H14.setBorderPainted(false);
        H6H14.setContentAreaFilled(false);
        H6H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H14.setFocusPainted(false);
        H6H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H14ActionPerformed(evt);
            }
        });
        H6H14.setBounds(300, 240, 29, 28);
        jLayeredPane1.add(H6H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H16.setBorderPainted(false);
        H6H16.setContentAreaFilled(false);
        H6H16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H16.setFocusPainted(false);
        H6H16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H16ActionPerformed(evt);
            }
        });
        H6H16.setBounds(330, 240, 29, 28);
        jLayeredPane1.add(H6H16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H18.setBorderPainted(false);
        H6H18.setContentAreaFilled(false);
        H6H18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H18.setFocusPainted(false);
        H6H18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H18ActionPerformed(evt);
            }
        });
        H6H18.setBounds(360, 240, 29, 28);
        jLayeredPane1.add(H6H18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H7.setBorderPainted(false);
        H5H7.setContentAreaFilled(false);
        H5H7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H7.setFocusPainted(false);
        H5H7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H7ActionPerformed(evt);
            }
        });
        H5H7.setBounds(200, 210, 29, 28);
        jLayeredPane1.add(H5H7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H9.setBorderPainted(false);
        H5H9.setContentAreaFilled(false);
        H5H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H9.setFocusPainted(false);
        H5H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H9ActionPerformed(evt);
            }
        });
        H5H9.setBounds(230, 210, 29, 28);
        jLayeredPane1.add(H5H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H11.setBorderPainted(false);
        H5H11.setContentAreaFilled(false);
        H5H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H11.setFocusPainted(false);
        H5H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H11ActionPerformed(evt);
            }
        });
        H5H11.setBounds(260, 210, 29, 28);
        jLayeredPane1.add(H5H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H13.setBorderPainted(false);
        H5H13.setContentAreaFilled(false);
        H5H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H13.setFocusPainted(false);
        H5H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H13ActionPerformed(evt);
            }
        });
        H5H13.setBounds(290, 210, 29, 28);
        jLayeredPane1.add(H5H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H15.setBorderPainted(false);
        H5H15.setContentAreaFilled(false);
        H5H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H15.setFocusPainted(false);
        H5H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H15ActionPerformed(evt);
            }
        });
        H5H15.setBounds(320, 210, 29, 28);
        jLayeredPane1.add(H5H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H17.setBorderPainted(false);
        H5H17.setContentAreaFilled(false);
        H5H17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H17.setFocusPainted(false);
        H5H17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H17ActionPerformed(evt);
            }
        });
        H5H17.setBounds(350, 210, 29, 28);
        jLayeredPane1.add(H5H17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H8.setBorderPainted(false);
        H4H8.setContentAreaFilled(false);
        H4H8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H8.setFocusPainted(false);
        H4H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H8ActionPerformed(evt);
            }
        });
        H4H8.setBounds(210, 180, 29, 28);
        jLayeredPane1.add(H4H8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H10.setBorderPainted(false);
        H4H10.setContentAreaFilled(false);
        H4H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H10.setFocusPainted(false);
        H4H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H10ActionPerformed(evt);
            }
        });
        H4H10.setBounds(240, 180, 29, 28);
        jLayeredPane1.add(H4H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H12.setBorderPainted(false);
        H4H12.setContentAreaFilled(false);
        H4H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H12.setFocusPainted(false);
        H4H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H12ActionPerformed(evt);
            }
        });
        H4H12.setBounds(270, 180, 29, 28);
        jLayeredPane1.add(H4H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H14.setBorderPainted(false);
        H4H14.setContentAreaFilled(false);
        H4H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H14.setFocusPainted(false);
        H4H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H14ActionPerformed(evt);
            }
        });
        H4H14.setBounds(300, 180, 29, 28);
        jLayeredPane1.add(H4H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H16.setBorderPainted(false);
        H4H16.setContentAreaFilled(false);
        H4H16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H16.setFocusPainted(false);
        H4H16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H16ActionPerformed(evt);
            }
        });
        H4H16.setBounds(330, 180, 29, 28);
        jLayeredPane1.add(H4H16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H18.setBorderPainted(false);
        H4H18.setContentAreaFilled(false);
        H4H18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H18.setFocusPainted(false);
        H4H18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H18ActionPerformed(evt);
            }
        });
        H4H18.setBounds(360, 180, 29, 28);
        jLayeredPane1.add(H4H18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H20.setBorderPainted(false);
        H4H20.setContentAreaFilled(false);
        H4H20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H20.setFocusPainted(false);
        H4H20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H20ActionPerformed(evt);
            }
        });
        H4H20.setBounds(390, 180, 29, 28);
        jLayeredPane1.add(H4H20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H22.setBorderPainted(false);
        H4H22.setContentAreaFilled(false);
        H4H22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H22.setFocusPainted(false);
        H4H22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H22ActionPerformed(evt);
            }
        });
        H4H22.setBounds(420, 180, 29, 28);
        jLayeredPane1.add(H4H22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H4H24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H4H24.setBorderPainted(false);
        H4H24.setContentAreaFilled(false);
        H4H24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H4H24.setFocusPainted(false);
        H4H24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H4H24ActionPerformed(evt);
            }
        });
        H4H24.setBounds(450, 180, 29, 28);
        jLayeredPane1.add(H4H24, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H19.setBorderPainted(false);
        H5H19.setContentAreaFilled(false);
        H5H19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H19.setFocusPainted(false);
        H5H19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H19ActionPerformed(evt);
            }
        });
        H5H19.setBounds(380, 210, 29, 28);
        jLayeredPane1.add(H5H19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H21.setBorderPainted(false);
        H5H21.setContentAreaFilled(false);
        H5H21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H21.setFocusPainted(false);
        H5H21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H21ActionPerformed(evt);
            }
        });
        H5H21.setBounds(410, 210, 29, 28);
        jLayeredPane1.add(H5H21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H5H23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H5H23.setBorderPainted(false);
        H5H23.setContentAreaFilled(false);
        H5H23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H5H23.setFocusPainted(false);
        H5H23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H5H23ActionPerformed(evt);
            }
        });
        H5H23.setBounds(440, 210, 29, 28);
        jLayeredPane1.add(H5H23, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H20.setBorderPainted(false);
        H6H20.setContentAreaFilled(false);
        H6H20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H20.setFocusPainted(false);
        H6H20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H20ActionPerformed(evt);
            }
        });
        H6H20.setBounds(390, 240, 29, 28);
        jLayeredPane1.add(H6H20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H6H22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H6H22.setBorderPainted(false);
        H6H22.setContentAreaFilled(false);
        H6H22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H6H22.setFocusPainted(false);
        H6H22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H6H22ActionPerformed(evt);
            }
        });
        H6H22.setBounds(420, 240, 29, 28);
        jLayeredPane1.add(H6H22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H7H21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H7H21.setBorderPainted(false);
        H7H21.setContentAreaFilled(false);
        H7H21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H7H21.setFocusPainted(false);
        H7H21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H7H21ActionPerformed(evt);
            }
        });
        H7H21.setBounds(410, 270, 29, 28);
        jLayeredPane1.add(H7H21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H3H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H3H9.setBorderPainted(false);
        H3H9.setContentAreaFilled(false);
        H3H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H3H9.setFocusPainted(false);
        H3H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3H9ActionPerformed(evt);
            }
        });
        H3H9.setBounds(230, 150, 29, 28);
        jLayeredPane1.add(H3H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H3H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H3H15.setBorderPainted(false);
        H3H15.setContentAreaFilled(false);
        H3H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H3H15.setFocusPainted(false);
        H3H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3H15ActionPerformed(evt);
            }
        });
        H3H15.setBounds(320, 150, 29, 28);
        jLayeredPane1.add(H3H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H3H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H3H11.setBorderPainted(false);
        H3H11.setContentAreaFilled(false);
        H3H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H3H11.setFocusPainted(false);
        H3H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3H11ActionPerformed(evt);
            }
        });
        H3H11.setBounds(260, 150, 29, 28);
        jLayeredPane1.add(H3H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H3H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H3H13.setBorderPainted(false);
        H3H13.setContentAreaFilled(false);
        H3H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H3H13.setFocusPainted(false);
        H3H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H3H13ActionPerformed(evt);
            }
        });
        H3H13.setBounds(290, 150, 29, 28);
        jLayeredPane1.add(H3H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H2H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H2H10.setBorderPainted(false);
        H2H10.setContentAreaFilled(false);
        H2H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H2H10.setFocusPainted(false);
        H2H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H2H10ActionPerformed(evt);
            }
        });
        H2H10.setBounds(240, 120, 29, 28);
        jLayeredPane1.add(H2H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H2H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H2H12.setBorderPainted(false);
        H2H12.setContentAreaFilled(false);
        H2H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H2H12.setFocusPainted(false);
        H2H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H2H12ActionPerformed(evt);
            }
        });
        H2H12.setBounds(270, 120, 29, 28);
        jLayeredPane1.add(H2H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H2H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H2H14.setBorderPainted(false);
        H2H14.setContentAreaFilled(false);
        H2H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H2H14.setFocusPainted(false);
        H2H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H2H14ActionPerformed(evt);
            }
        });
        H2H14.setBounds(300, 120, 29, 28);
        jLayeredPane1.add(H2H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H1H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H1H11.setBorderPainted(false);
        H1H11.setContentAreaFilled(false);
        H1H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H1H11.setFocusPainted(false);
        H1H11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        H1H11.setMaximumSize(new java.awt.Dimension(30, 29));
        H1H11.setPreferredSize(new java.awt.Dimension(30, 9));
        H1H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H1H11ActionPerformed(evt);
            }
        });
        H1H11.setBounds(260, 90, 29, 28);
        jLayeredPane1.add(H1H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H1H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H1H13.setBorderPainted(false);
        H1H13.setContentAreaFilled(false);
        H1H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H1H13.setFocusPainted(false);
        H1H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H1H13ActionPerformed(evt);
            }
        });
        H1H13.setBounds(290, 90, 29, 28);
        jLayeredPane1.add(H1H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H0H12.setForeground(new java.awt.Color(255, 255, 255));
        H0H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H0H12.setBorderPainted(false);
        H0H12.setContentAreaFilled(false);
        H0H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H0H12.setFocusPainted(false);
        H0H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H0H12ActionPerformed(evt);
            }
        });
        H0H12.setBounds(270, 60, 29, 28);
        jLayeredPane1.add(H0H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H4.setBorderPainted(false);
        H8H4.setContentAreaFilled(false);
        H8H4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H4.setFocusPainted(false);
        H8H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H4ActionPerformed(evt);
            }
        });
        H8H4.setBounds(160, 300, 29, 28);
        jLayeredPane1.add(H8H4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H6.setBorderPainted(false);
        H8H6.setContentAreaFilled(false);
        H8H6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H6.setFocusPainted(false);
        H8H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H6ActionPerformed(evt);
            }
        });
        H8H6.setBounds(190, 300, 29, 28);
        jLayeredPane1.add(H8H6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H8.setBorderPainted(false);
        H8H8.setContentAreaFilled(false);
        H8H8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H8.setFocusPainted(false);
        H8H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H8ActionPerformed(evt);
            }
        });
        H8H8.setBounds(220, 300, 29, 28);
        jLayeredPane1.add(H8H8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H10.setBorderPainted(false);
        H8H10.setContentAreaFilled(false);
        H8H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H10.setFocusPainted(false);
        H8H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H10ActionPerformed(evt);
            }
        });
        H8H10.setBounds(250, 300, 29, 28);
        jLayeredPane1.add(H8H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H12.setBorderPainted(false);
        H8H12.setContentAreaFilled(false);
        H8H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H12.setFocusPainted(false);
        H8H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H12ActionPerformed(evt);
            }
        });
        H8H12.setBounds(280, 300, 29, 28);
        jLayeredPane1.add(H8H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H14.setBorderPainted(false);
        H8H14.setContentAreaFilled(false);
        H8H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H14.setFocusPainted(false);
        H8H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H14ActionPerformed(evt);
            }
        });
        H8H14.setBounds(310, 300, 29, 28);
        jLayeredPane1.add(H8H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H16.setBorderPainted(false);
        H8H16.setContentAreaFilled(false);
        H8H16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H16.setFocusPainted(false);
        H8H16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H16ActionPerformed(evt);
            }
        });
        H8H16.setBounds(340, 300, 29, 28);
        jLayeredPane1.add(H8H16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H18.setBorderPainted(false);
        H8H18.setContentAreaFilled(false);
        H8H18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H18.setFocusPainted(false);
        H8H18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H18ActionPerformed(evt);
            }
        });
        H8H18.setBounds(370, 300, 29, 28);
        jLayeredPane1.add(H8H18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H8H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H8H20.setBorderPainted(false);
        H8H20.setContentAreaFilled(false);
        H8H20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H8H20.setFocusPainted(false);
        H8H20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H8H20ActionPerformed(evt);
            }
        });
        H8H20.setBounds(400, 300, 29, 28);
        jLayeredPane1.add(H8H20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H3.setBorderPainted(false);
        H9H3.setContentAreaFilled(false);
        H9H3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H3.setFocusPainted(false);
        H9H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H3ActionPerformed(evt);
            }
        });
        H9H3.setBounds(140, 330, 29, 28);
        jLayeredPane1.add(H9H3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H4.setBorderPainted(false);
        H10H4.setContentAreaFilled(false);
        H10H4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H4.setFocusPainted(false);
        H10H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H4ActionPerformed(evt);
            }
        });
        H10H4.setBounds(150, 360, 29, 28);
        jLayeredPane1.add(H10H4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H2.setBorderPainted(false);
        H10H2.setContentAreaFilled(false);
        H10H2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H2.setFocusPainted(false);
        H10H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H2ActionPerformed(evt);
            }
        });
        H10H2.setBounds(120, 360, 29, 28);
        jLayeredPane1.add(H10H2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H5.setBorderPainted(false);
        H11H5.setContentAreaFilled(false);
        H11H5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H5.setFocusPainted(false);
        H11H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H5ActionPerformed(evt);
            }
        });
        H11H5.setBounds(170, 390, 29, 28);
        jLayeredPane1.add(H11H5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H3.setBorderPainted(false);
        H11H3.setContentAreaFilled(false);
        H11H3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H3.setFocusPainted(false);
        H11H3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H3ActionPerformed(evt);
            }
        });
        H11H3.setBounds(140, 390, 29, 28);
        jLayeredPane1.add(H11H3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H1.setBorderPainted(false);
        H11H1.setContentAreaFilled(false);
        H11H1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H1.setFocusPainted(false);
        H11H1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H1ActionPerformed(evt);
            }
        });
        H11H1.setBounds(110, 390, 29, 28);
        jLayeredPane1.add(H11H1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H0.setBorderPainted(false);
        H12H0.setContentAreaFilled(false);
        H12H0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H0.setFocusPainted(false);
        H12H0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H0ActionPerformed(evt);
            }
        });
        H12H0.setBounds(100, 420, 29, 28);
        jLayeredPane1.add(H12H0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H2.setBorderPainted(false);
        H12H2.setContentAreaFilled(false);
        H12H2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H2.setFocusPainted(false);
        H12H2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H2ActionPerformed(evt);
            }
        });
        H12H2.setBounds(130, 420, 29, 28);
        jLayeredPane1.add(H12H2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H4.setBorderPainted(false);
        H12H4.setContentAreaFilled(false);
        H12H4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H4.setFocusPainted(false);
        H12H4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H4ActionPerformed(evt);
            }
        });
        H12H4.setBounds(160, 420, 29, 28);
        jLayeredPane1.add(H12H4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H6.setBorderPainted(false);
        H12H6.setContentAreaFilled(false);
        H12H6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H6.setFocusPainted(false);
        H12H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H6ActionPerformed(evt);
            }
        });
        H12H6.setBounds(190, 420, 29, 28);
        jLayeredPane1.add(H12H6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H5.setBorderPainted(false);
        H9H5.setContentAreaFilled(false);
        H9H5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H5.setFocusPainted(false);
        H9H5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H5ActionPerformed(evt);
            }
        });
        H9H5.setBounds(170, 330, 29, 28);
        jLayeredPane1.add(H9H5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H7.setBorderPainted(false);
        H9H7.setContentAreaFilled(false);
        H9H7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H7.setFocusPainted(false);
        H9H7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H7ActionPerformed(evt);
            }
        });
        H9H7.setBounds(200, 330, 29, 28);
        jLayeredPane1.add(H9H7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H19.setBorderPainted(false);
        H9H19.setContentAreaFilled(false);
        H9H19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H19.setFocusPainted(false);
        H9H19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H19ActionPerformed(evt);
            }
        });
        H9H19.setBounds(380, 330, 29, 28);
        jLayeredPane1.add(H9H19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H17.setBorderPainted(false);
        H9H17.setContentAreaFilled(false);
        H9H17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H17.setFocusPainted(false);
        H9H17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H17ActionPerformed(evt);
            }
        });
        H9H17.setBounds(350, 330, 29, 28);
        jLayeredPane1.add(H9H17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H15.setBorderPainted(false);
        H9H15.setContentAreaFilled(false);
        H9H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H15.setFocusPainted(false);
        H9H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H15ActionPerformed(evt);
            }
        });
        H9H15.setBounds(320, 330, 29, 28);
        jLayeredPane1.add(H9H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H13.setBorderPainted(false);
        H9H13.setContentAreaFilled(false);
        H9H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H13.setFocusPainted(false);
        H9H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H13ActionPerformed(evt);
            }
        });
        H9H13.setBounds(290, 330, 29, 28);
        jLayeredPane1.add(H9H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H11.setBorderPainted(false);
        H9H11.setContentAreaFilled(false);
        H9H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H11.setFocusPainted(false);
        H9H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H11ActionPerformed(evt);
            }
        });
        H9H11.setBounds(260, 330, 29, 28);
        jLayeredPane1.add(H9H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H9.setBorderPainted(false);
        H9H9.setContentAreaFilled(false);
        H9H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H9.setFocusPainted(false);
        H9H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H9ActionPerformed(evt);
            }
        });
        H9H9.setBounds(230, 330, 29, 28);
        jLayeredPane1.add(H9H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H13H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H13H9.setBorderPainted(false);
        H13H9.setContentAreaFilled(false);
        H13H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H13H9.setFocusPainted(false);
        H13H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H13H9ActionPerformed(evt);
            }
        });
        H13H9.setBounds(230, 450, 29, 28);
        jLayeredPane1.add(H13H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H8.setBorderPainted(false);
        H12H8.setContentAreaFilled(false);
        H12H8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H8.setFocusPainted(false);
        H12H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H8ActionPerformed(evt);
            }
        });
        H12H8.setBounds(220, 420, 29, 28);
        jLayeredPane1.add(H12H8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H6.setBorderPainted(false);
        H10H6.setContentAreaFilled(false);
        H10H6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H6.setFocusPainted(false);
        H10H6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H6ActionPerformed(evt);
            }
        });
        H10H6.setBounds(180, 360, 29, 28);
        jLayeredPane1.add(H10H6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H7.setBorderPainted(false);
        H11H7.setContentAreaFilled(false);
        H11H7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H7.setFocusPainted(false);
        H11H7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H7ActionPerformed(evt);
            }
        });
        H11H7.setBounds(200, 390, 29, 28);
        jLayeredPane1.add(H11H7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H13H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H13H11.setBorderPainted(false);
        H13H11.setContentAreaFilled(false);
        H13H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H13H11.setFocusPainted(false);
        H13H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H13H11ActionPerformed(evt);
            }
        });
        H13H11.setBounds(260, 450, 29, 28);
        jLayeredPane1.add(H13H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H13H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H13H13.setBorderPainted(false);
        H13H13.setContentAreaFilled(false);
        H13H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H13H13.setFocusPainted(false);
        H13H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H13H13ActionPerformed(evt);
            }
        });
        H13H13.setBounds(290, 450, 29, 28);
        jLayeredPane1.add(H13H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H13H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H13H15.setBorderPainted(false);
        H13H15.setContentAreaFilled(false);
        H13H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H13H15.setFocusPainted(false);
        H13H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H13H15ActionPerformed(evt);
            }
        });
        H13H15.setBounds(320, 450, 29, 28);
        jLayeredPane1.add(H13H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H14H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H14H10.setBorderPainted(false);
        H14H10.setContentAreaFilled(false);
        H14H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H14H10.setFocusPainted(false);
        H14H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H14H10ActionPerformed(evt);
            }
        });
        H14H10.setBounds(250, 480, 29, 28);
        jLayeredPane1.add(H14H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H14H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H14H12.setBorderPainted(false);
        H14H12.setContentAreaFilled(false);
        H14H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H14H12.setFocusPainted(false);
        H14H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H14H12ActionPerformed(evt);
            }
        });
        H14H12.setBounds(280, 480, 29, 28);
        jLayeredPane1.add(H14H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H14H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H14H14.setBorderPainted(false);
        H14H14.setContentAreaFilled(false);
        H14H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H14H14.setFocusPainted(false);
        H14H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H14H14ActionPerformed(evt);
            }
        });
        H14H14.setBounds(310, 480, 29, 28);
        jLayeredPane1.add(H14H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H15H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H15H11.setBorderPainted(false);
        H15H11.setContentAreaFilled(false);
        H15H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H15H11.setFocusPainted(false);
        H15H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H15H11ActionPerformed(evt);
            }
        });
        H15H11.setBounds(260, 510, 29, 28);
        jLayeredPane1.add(H15H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H15H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H15H13.setBorderPainted(false);
        H15H13.setContentAreaFilled(false);
        H15H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H15H13.setFocusPainted(false);
        H15H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H15H13ActionPerformed(evt);
            }
        });
        H15H13.setBounds(290, 510, 29, 28);
        jLayeredPane1.add(H15H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H16H12.setForeground(new java.awt.Color(255, 255, 51));
        H16H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H16H12.setBorderPainted(false);
        H16H12.setContentAreaFilled(false);
        H16H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H16H12.setFocusPainted(false);
        H16H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H16H12ActionPerformed(evt);
            }
        });
        H16H12.setBounds(280, 540, 29, 28);
        jLayeredPane1.add(H16H12, javax.swing.JLayeredPane.POPUP_LAYER);

        H10H8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H8.setBorderPainted(false);
        H10H8.setContentAreaFilled(false);
        H10H8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H8.setFocusPainted(false);
        H10H8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H8ActionPerformed(evt);
            }
        });
        H10H8.setBounds(210, 360, 29, 28);
        jLayeredPane1.add(H10H8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H9.setBorderPainted(false);
        H11H9.setContentAreaFilled(false);
        H11H9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H9.setFocusPainted(false);
        H11H9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H9ActionPerformed(evt);
            }
        });
        H11H9.setBounds(230, 390, 29, 28);
        jLayeredPane1.add(H11H9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H10.setBorderPainted(false);
        H12H10.setContentAreaFilled(false);
        H12H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H10.setFocusPainted(false);
        H12H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H10ActionPerformed(evt);
            }
        });
        H12H10.setBounds(250, 420, 29, 28);
        jLayeredPane1.add(H12H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H10.setBorderPainted(false);
        H10H10.setContentAreaFilled(false);
        H10H10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H10.setFocusPainted(false);
        H10H10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H10ActionPerformed(evt);
            }
        });
        H10H10.setBounds(240, 360, 29, 28);
        jLayeredPane1.add(H10H10, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H11.setBorderPainted(false);
        H11H11.setContentAreaFilled(false);
        H11H11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H11.setFocusPainted(false);
        H11H11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H11ActionPerformed(evt);
            }
        });
        H11H11.setBounds(260, 390, 29, 28);
        jLayeredPane1.add(H11H11, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H12.setBorderPainted(false);
        H12H12.setContentAreaFilled(false);
        H12H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H12.setFocusPainted(false);
        H12H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H12ActionPerformed(evt);
            }
        });
        H12H12.setBounds(280, 420, 29, 28);
        jLayeredPane1.add(H12H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H12.setBorderPainted(false);
        H10H12.setContentAreaFilled(false);
        H10H12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H12.setFocusPainted(false);
        H10H12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H12ActionPerformed(evt);
            }
        });
        H10H12.setBounds(270, 360, 29, 28);
        jLayeredPane1.add(H10H12, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H13.setBorderPainted(false);
        H11H13.setContentAreaFilled(false);
        H11H13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H13.setFocusPainted(false);
        H11H13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H13ActionPerformed(evt);
            }
        });
        H11H13.setBounds(290, 390, 29, 28);
        jLayeredPane1.add(H11H13, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H14.setBorderPainted(false);
        H12H14.setContentAreaFilled(false);
        H12H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H14.setFocusPainted(false);
        H12H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H14ActionPerformed(evt);
            }
        });
        H12H14.setBounds(310, 420, 29, 28);
        jLayeredPane1.add(H12H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H16.setBorderPainted(false);
        H12H16.setContentAreaFilled(false);
        H12H16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H16.setFocusPainted(false);
        H12H16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H16ActionPerformed(evt);
            }
        });
        H12H16.setBounds(340, 420, 29, 28);
        jLayeredPane1.add(H12H16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H14.setBorderPainted(false);
        H10H14.setContentAreaFilled(false);
        H10H14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H14.setFocusPainted(false);
        H10H14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H14ActionPerformed(evt);
            }
        });
        H10H14.setBounds(300, 360, 29, 28);
        jLayeredPane1.add(H10H14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H15.setBorderPainted(false);
        H11H15.setContentAreaFilled(false);
        H11H15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H15.setFocusPainted(false);
        H11H15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H15ActionPerformed(evt);
            }
        });
        H11H15.setBounds(320, 390, 29, 28);
        jLayeredPane1.add(H11H15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H16.setBorderPainted(false);
        H10H16.setContentAreaFilled(false);
        H10H16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H16.setFocusPainted(false);
        H10H16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H16ActionPerformed(evt);
            }
        });
        H10H16.setBounds(330, 360, 29, 28);
        jLayeredPane1.add(H10H16, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H18.setBorderPainted(false);
        H10H18.setContentAreaFilled(false);
        H10H18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H18.setFocusPainted(false);
        H10H18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H18ActionPerformed(evt);
            }
        });
        H10H18.setBounds(360, 360, 29, 28);
        jLayeredPane1.add(H10H18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H17.setBorderPainted(false);
        H11H17.setContentAreaFilled(false);
        H11H17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H17.setFocusPainted(false);
        H11H17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H17ActionPerformed(evt);
            }
        });
        H11H17.setBounds(350, 390, 29, 28);
        jLayeredPane1.add(H11H17, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H9H21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H9H21.setBorderPainted(false);
        H9H21.setContentAreaFilled(false);
        H9H21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H9H21.setFocusPainted(false);
        H9H21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H9H21ActionPerformed(evt);
            }
        });
        H9H21.setBounds(410, 330, 29, 28);
        jLayeredPane1.add(H9H21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H22.setBorderPainted(false);
        H10H22.setContentAreaFilled(false);
        H10H22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H22.setFocusPainted(false);
        H10H22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H22ActionPerformed(evt);
            }
        });
        H10H22.setBounds(420, 360, 29, 28);
        jLayeredPane1.add(H10H22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H19.setBorderPainted(false);
        H11H19.setContentAreaFilled(false);
        H11H19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H19.setFocusPainted(false);
        H11H19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H19ActionPerformed(evt);
            }
        });
        H11H19.setBounds(380, 390, 29, 28);
        jLayeredPane1.add(H11H19, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H10H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H10H20.setBorderPainted(false);
        H10H20.setContentAreaFilled(false);
        H10H20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H10H20.setFocusPainted(false);
        H10H20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H10H20ActionPerformed(evt);
            }
        });
        H10H20.setBounds(390, 360, 29, 28);
        jLayeredPane1.add(H10H20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H21.setBorderPainted(false);
        H11H21.setContentAreaFilled(false);
        H11H21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H21.setFocusPainted(false);
        H11H21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H21ActionPerformed(evt);
            }
        });
        H11H21.setBounds(410, 390, 29, 28);
        jLayeredPane1.add(H11H21, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H11H23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H11H23.setBorderPainted(false);
        H11H23.setContentAreaFilled(false);
        H11H23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H11H23.setFocusPainted(false);
        H11H23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H11H23ActionPerformed(evt);
            }
        });
        H11H23.setBounds(440, 390, 29, 28);
        jLayeredPane1.add(H11H23, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H18.setBorderPainted(false);
        H12H18.setContentAreaFilled(false);
        H12H18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H18.setFocusPainted(false);
        H12H18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H18ActionPerformed(evt);
            }
        });
        H12H18.setBounds(370, 420, 29, 28);
        jLayeredPane1.add(H12H18, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H20.setBorderPainted(false);
        H12H20.setContentAreaFilled(false);
        H12H20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H20.setFocusPainted(false);
        H12H20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H20ActionPerformed(evt);
            }
        });
        H12H20.setBounds(400, 420, 29, 28);
        jLayeredPane1.add(H12H20, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H22.setBorderPainted(false);
        H12H22.setContentAreaFilled(false);
        H12H22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H22.setFocusPainted(false);
        H12H22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H22ActionPerformed(evt);
            }
        });
        H12H22.setBounds(430, 420, 29, 28);
        jLayeredPane1.add(H12H22, javax.swing.JLayeredPane.DEFAULT_LAYER);

        H12H24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fichavacia.png"))); // NOI18N
        H12H24.setBorderPainted(false);
        H12H24.setContentAreaFilled(false);
        H12H24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        H12H24.setFocusPainted(false);
        H12H24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                H12H24ActionPerformed(evt);
            }
        });
        H12H24.setBounds(460, 420, 29, 28);
        jLayeredPane1.add(H12H24, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/mariofondo.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(960, 720));
        jLabel1.setBounds(-50, -50, 900, 730);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 620));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 140, 20));

        panMostrar.setColumns(20);
        panMostrar.setRows(5);
        jScrollPane1.setViewportView(panMostrar);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 360, 200, 100));

        txtMensage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMensageActionPerformed(evt);
            }
        });
        getContentPane().add(txtMensage, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, 200, -1));

        butEnviar.setText("Enviar");
        butEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(butEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 84, -1));

        jButton1.setText("Regresar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 580, 100, -1));

        jScrollPane3.setViewportView(lstActivos1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 200, 100));

        jLabel2.setFont(new java.awt.Font("Chlorinap", 3, 52));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/damas.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 160, 60));

        jLabel6.setFont(new java.awt.Font("LetterOMatic!", 3, 11));
        jLabel6.setText("Conectados");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 110, -1));

        jLabel4.setFont(new java.awt.Font("LetterOMatic!", 3, 11));
        jLabel4.setText("Chat");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 340, 40, -1));

        jLabel5.setFont(new java.awt.Font("Chlorinap", 3, 52));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/bros.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 160, 120));

        jLabel3.setFont(new java.awt.Font("Chlorinap", 1, 36));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondoazul3.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-80, -50, 930, 670));

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu2MousePressed(evt);
            }
        });

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Objetivo");
        jMenuItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem3MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Como Jugar");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        estadis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        estadis.setText("Estadistica");
        estadis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estadisMousePressed(evt);
            }
        });
        estadis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisActionPerformed(evt);
            }
        });
        estadis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                estadisKeyPressed(evt);
            }
        });
        jMenu2.add(estadis);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void H4H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H2ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=2;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=2;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
 }
        }
    }//GEN-LAST:event_H4H2ActionPerformed
    
    private void H7H7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H7ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=7;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=7;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
        
 }
        }
    }//GEN-LAST:event_H7H7ActionPerformed


    private void H0H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H0H12ActionPerformed
       if(numeroClick==0) {
                 filaSalida=0;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=0;
         columnaLlegada=12;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }
       
    }//GEN-LAST:event_H0H12ActionPerformed

    private void H4H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H12ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=12;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H4H12ActionPerformed

    private void H9H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H9ActionPerformed
        if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=9;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
 }
        }
    }//GEN-LAST:event_H9H9ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        numeroDeJugadores num = new numeroDeJugadores(this.player);
        num.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void H6H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H12ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=12;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H12ActionPerformed

    private void H3H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3H11ActionPerformed

     if(numeroClick==0) {
                 filaSalida=3;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=3;
         columnaLlegada=11;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }

      // TODO add your handling code here:
    }//GEN-LAST:event_H3H11ActionPerformed

    private void H2H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H2H10ActionPerformed
       if(numeroClick==0) {
                 filaSalida=2;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=2;
         columnaLlegada=10;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }
    }//GEN-LAST:event_H2H10ActionPerformed

    private void H2H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H2H12ActionPerformed

        
               if(numeroClick==0) {
                 filaSalida=2;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=2;
         columnaLlegada=12;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

         if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
       }
 }

    }//GEN-LAST:event_H2H12ActionPerformed

    private void H2H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H2H14ActionPerformed
       if(numeroClick==0) {
                 filaSalida=2;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=2;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }
        
    }//GEN-LAST:event_H2H14ActionPerformed

    private void H1H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H1H13ActionPerformed
       if(numeroClick==0) {
                 filaSalida=1;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=1;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_H1H13ActionPerformed

    private void H1H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H1H11ActionPerformed
       if(numeroClick==0) {
                 filaSalida=1;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=1;
         columnaLlegada=11;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("rojo");
         }
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_H1H11ActionPerformed

    private void H3H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3H9ActionPerformed
       if(numeroClick==0) {
                 filaSalida=3;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=3;
         columnaLlegada=9;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
          }
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_H3H9ActionPerformed

    private void H3H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3H13ActionPerformed
       if(numeroClick==0) {
                 filaSalida=3;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=3;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("rojo");
         }
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_H3H13ActionPerformed

    private void H3H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H3H15ActionPerformed
       if(numeroClick==0) {
                 filaSalida=3;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=3;
         columnaLlegada=15;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("rojo");
         }
 }
        // TODO add your handling code here:
    }//GEN-LAST:event_H3H15ActionPerformed

    private void H4H0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H0ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=0;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=0;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H4H0ActionPerformed

    private void H4H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H4ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=4;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=4;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H4H4ActionPerformed

    private void H4H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H6ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=6;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=6;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H4H6ActionPerformed

    private void H4H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H8ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=8;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=8;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H4H8ActionPerformed

    private void H4H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H10ActionPerformed
        if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=10;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H4H10ActionPerformed

    private void H4H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H14ActionPerformed
        if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H4H14ActionPerformed

    private void H4H16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H16ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=16;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=16;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H4H16ActionPerformed

    private void H4H18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H18ActionPerformed
        if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=18;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=18;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H4H18ActionPerformed

    private void H4H20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H20ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=20;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=20;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H4H20ActionPerformed

    private void H4H22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H22ActionPerformed
        if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=22;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=22;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H4H22ActionPerformed

    private void H4H24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H4H24ActionPerformed
         if(numeroClick==0) {
                 filaSalida=4;
                 columnaSalida=24;
                  numeroClick++;





        }
 else
     {
         filaLlegada=4;
         columnaLlegada=24;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H4H24ActionPerformed

    private void H5H1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H1ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=1;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=1;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H5H1ActionPerformed

    private void H5H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H3ActionPerformed
       if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=3;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=3;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H5H3ActionPerformed

    private void H5H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H5ActionPerformed
        if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=5;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=5;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H5H5ActionPerformed

    private void H5H7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H7ActionPerformed
       if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=7;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=7;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
          if(mov!= "")
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
          cliente.flujoPosicion(mov);
          
 }
    }//GEN-LAST:event_H5H7ActionPerformed

    private void H5H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H9ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=9;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H5H9ActionPerformed

    private void H5H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H11ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=11;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H5H11ActionPerformed

    private void H5H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H13ActionPerformed
        if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H5H13ActionPerformed

    private void H5H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H15ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=15;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H5H15ActionPerformed

    private void H5H17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H17ActionPerformed
        if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=17;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=17;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H5H17ActionPerformed

    private void H5H19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H19ActionPerformed
        if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=19;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=19;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H5H19ActionPerformed

    private void H5H21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H21ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=21;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=21;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H5H21ActionPerformed

    private void H5H23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H5H23ActionPerformed
         if(numeroClick==0) {
                 filaSalida=5;
                 columnaSalida=23;
                  numeroClick++;





        }
 else
     {
         filaLlegada=5;
         columnaLlegada=23;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H5H23ActionPerformed

    private void H6H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H2ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=2;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=2;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H6H2ActionPerformed

    private void H6H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H4ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=4;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=4;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H6H4ActionPerformed

    private void H6H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H6ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=6;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=6;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H6ActionPerformed

    private void H6H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H8ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=8;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=8;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H8ActionPerformed

    private void H6H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H10ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=10;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H10ActionPerformed

    private void H6H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H14ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H14ActionPerformed

    private void H6H16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H16ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=16;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=16;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H16ActionPerformed

    private void H6H18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H18ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=18;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=18;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H6H18ActionPerformed

    private void H6H20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H20ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=20;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=20;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H6H20ActionPerformed

    private void H6H22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H6H22ActionPerformed
        if(numeroClick==0) {
                 filaSalida=6;
                 columnaSalida=22;
                  numeroClick++;





        }
 else
     {
         filaLlegada=6;
         columnaLlegada=22;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H6H22ActionPerformed

    private void H7H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H3ActionPerformed
         if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=3;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=3;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("amarillo");
         }
 }
    }//GEN-LAST:event_H7H3ActionPerformed

    private void H7H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H5ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=5;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=5;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H5ActionPerformed

    private void H7H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H9ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=9;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H9ActionPerformed

    private void H7H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H11ActionPerformed
         if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=11;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H11ActionPerformed

    private void H7H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H13ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H13ActionPerformed

    private void H7H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H15ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=15;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H15ActionPerformed

    private void H7H17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H17ActionPerformed
       if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=17;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=17;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H17ActionPerformed

    private void H7H19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H19ActionPerformed
        if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=19;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=19;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H7H19ActionPerformed

    private void H7H21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H7H21ActionPerformed
         if(numeroClick==0) {
                 filaSalida=7;
                 columnaSalida=21;
                  numeroClick++;





        }
 else
     {
         filaLlegada=7;
         columnaLlegada=21;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azulClaro");
         }
 }
    }//GEN-LAST:event_H7H21ActionPerformed

    private void H8H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H4ActionPerformed
         if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=4;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=4;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H4ActionPerformed

    private void H8H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H6ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=6;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=6;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H6ActionPerformed

    private void H8H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H8ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=8;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=8;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H8ActionPerformed

    private void H8H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H10ActionPerformed
         if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=10;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H10ActionPerformed

    private void H8H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H12ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=12;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H12ActionPerformed

    private void H8H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H14ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H14ActionPerformed

    private void H8H16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H16ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=16;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=16;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H16ActionPerformed

    private void H8H18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H18ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=18;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=18;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H18ActionPerformed

    private void H8H20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H8H20ActionPerformed
        if(numeroClick==0) {
                 filaSalida=8;
                 columnaSalida=20;
                  numeroClick++;





        }
 else
     {
         filaLlegada=8;
         columnaLlegada=20;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H8H20ActionPerformed

    private void H9H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H3ActionPerformed
         if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=3;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=3;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H9H3ActionPerformed

    private void H9H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H5ActionPerformed
         if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=5;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=5;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H5ActionPerformed

    private void H9H7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H7ActionPerformed
         if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=7;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=7;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H7ActionPerformed

    private void H9H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H11ActionPerformed
         if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=11;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H11ActionPerformed

    private void H9H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H13ActionPerformed
         if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H13ActionPerformed

    private void H9H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H15ActionPerformed
        if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=15;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H15ActionPerformed

    private void H9H17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H17ActionPerformed
        if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=17;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=17;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H17ActionPerformed

    private void H9H19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H19ActionPerformed
        if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=19;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=19;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H9H19ActionPerformed

    private void H9H21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H9H21ActionPerformed
        if(numeroClick==0) {
                 filaSalida=9;
                 columnaSalida=21;
                  numeroClick++;





        }
 else
     {
         filaLlegada=9;
         columnaLlegada=21;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H9H21ActionPerformed

    private void H10H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H2ActionPerformed
         if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=2;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=2;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H10H2ActionPerformed

    private void H10H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H4ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=4;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=4;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H10H4ActionPerformed

    private void H10H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H6ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=6;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=6;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H6ActionPerformed

    private void H10H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H8ActionPerformed
         if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=8;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=8;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H8ActionPerformed

    private void H10H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H10ActionPerformed
         if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=10;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H10ActionPerformed

    private void H10H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H12ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=12;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H12ActionPerformed

    private void H10H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H14ActionPerformed
         if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=14;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H14ActionPerformed

    private void H10H16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H16ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=16;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=16;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H16ActionPerformed

    private void H10H18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H18ActionPerformed
         if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=18;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=18;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H10H18ActionPerformed

    private void H10H20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H20ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=20;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=20;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H10H20ActionPerformed

    private void H10H22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H10H22ActionPerformed
        if(numeroClick==0) {
                 filaSalida=10;
                 columnaSalida=22;
                  numeroClick++;





        }
 else
     {
         filaLlegada=10;
         columnaLlegada=22;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H10H22ActionPerformed

    private void H11H1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H1ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=1;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=1;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H11H1ActionPerformed

    private void H11H3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H3ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=3;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=3;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H11H3ActionPerformed

    private void H11H5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H5ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=5;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=5;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H11H5ActionPerformed

    private void H11H7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H7ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=7;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=7;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H7ActionPerformed

    private void H11H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H9ActionPerformed
         if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=9;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H9ActionPerformed

    private void H11H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H11ActionPerformed
         if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=11;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H11ActionPerformed

    private void H11H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H13ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H13ActionPerformed

    private void H11H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H15ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=15;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H15ActionPerformed

    private void H11H17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H17ActionPerformed
         if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=17;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=17;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H11H17ActionPerformed

    private void H11H19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H19ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=19;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=19;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H11H19ActionPerformed

    private void H11H21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H21ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=21;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=21;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H11H21ActionPerformed

    private void H11H23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H11H23ActionPerformed
        if(numeroClick==0) {
                 filaSalida=11;
                 columnaSalida=23;
                  numeroClick++;





        }
 else
     {
         filaLlegada=11;
         columnaLlegada=23;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H11H23ActionPerformed

    private void H12H0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H0ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=0;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=0;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H12H0ActionPerformed

    private void H12H2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H2ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=2;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=2;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H12H2ActionPerformed

    private void H12H4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H4ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=4;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=4;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H12H4ActionPerformed

    private void H12H6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H6ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=6;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=6;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("verde");
         }
 }
    }//GEN-LAST:event_H12H6ActionPerformed

    private void H12H8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H8ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=8;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=8;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H12H8ActionPerformed

    private void H12H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H10ActionPerformed
       if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=10;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H12H10ActionPerformed

    private void H12H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H12ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=12;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H12H12ActionPerformed

    private void H12H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H14ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H12H14ActionPerformed

    private void H12H16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H16ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=16;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=16;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
         }
 }
    }//GEN-LAST:event_H12H16ActionPerformed

    private void H12H18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H18ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=18;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=18;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H12H18ActionPerformed

    private void H12H20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H20ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=20;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=20;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H12H20ActionPerformed

    private void H12H22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H22ActionPerformed
         if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=22;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=22;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H12H22ActionPerformed

    private void H12H24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H12H24ActionPerformed
        if(numeroClick==0) {
                 filaSalida=12;
                 columnaSalida=24;
                  numeroClick++;





        }
 else
     {
         filaLlegada=12;
         columnaLlegada=24;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
            tablaJuego.validarWin("azul");
         }
 }
    }//GEN-LAST:event_H12H24ActionPerformed

    private void H13H9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H13H9ActionPerformed
         if(numeroClick==0) {
                 filaSalida=13;
                 columnaSalida=9;
                  numeroClick++;





        }
 else
     {
         filaLlegada=13;
         columnaLlegada=9;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H13H9ActionPerformed

    private void H13H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H13H11ActionPerformed
        if(numeroClick==0) {
                 filaSalida=13;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=13;
         columnaLlegada=11;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H13H11ActionPerformed

    private void H13H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H13H13ActionPerformed
         if(numeroClick==0) {
                 filaSalida=13;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=13;
         columnaLlegada=13;
         numeroClick=0;
         
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H13H13ActionPerformed

    private void H13H15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H13H15ActionPerformed
        if(numeroClick==0) {
                 filaSalida=13;
                 columnaSalida=15;
                  numeroClick++;





        }
 else
     {
         filaLlegada=13;
         columnaLlegada=15;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H13H15ActionPerformed

    private void H14H10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H14H10ActionPerformed
        if(numeroClick==0) {
                 filaSalida=14;
                 columnaSalida=10;
                  numeroClick++;





        }
 else
     {
         filaLlegada=14;
         columnaLlegada=10;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H14H10ActionPerformed

    private void H14H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H14H12ActionPerformed
         if(numeroClick==0) {
                 filaSalida=14;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=14;
         columnaLlegada=12;
         numeroClick=0;
           String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H14H12ActionPerformed

    private void H14H14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H14H14ActionPerformed
        if(numeroClick==0) {
                 filaSalida=14;
                 columnaSalida=14;
                  numeroClick++;





        }
 else
     {
         filaLlegada=14;
         columnaLlegada=14;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H14H14ActionPerformed

    private void H15H11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H15H11ActionPerformed
         if(numeroClick==0) {
                 filaSalida=15;
                 columnaSalida=11;
                  numeroClick++;





        }
 else
     {
         filaLlegada=15;
         columnaLlegada=11;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H15H11ActionPerformed

    private void H15H13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H15H13ActionPerformed
       if(numeroClick==0) {
                 filaSalida=15;
                 columnaSalida=13;
                  numeroClick++;





        }
 else
     {
         filaLlegada=15;
         columnaLlegada=13;
         numeroClick=0;
          String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H15H13ActionPerformed

    private void H16H12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_H16H12ActionPerformed
         if(numeroClick==0) {
                 filaSalida=16;
                 columnaSalida=12;
                  numeroClick++;





        }
 else
     {
         filaLlegada=16;
         columnaLlegada=12;
         numeroClick=0;
         String mov = tablaJuego.validarMovimiento(filaSalida,columnaSalida,filaLlegada,columnaLlegada);

          if(mov!=""){
           ActualizarTablero(filaSalida,columnaSalida,filaLlegada,columnaLlegada);
           cliente.flujoPosicion(mov);
           tablaJuego.validarWin("pink");
         }
 }
    }//GEN-LAST:event_H16H12ActionPerformed

    private void txtMensageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMensageActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtMensageActionPerformed

    private void butEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEnviarActionPerformed
        actionPerformed(evt);
}//GEN-LAST:event_butEnviarActionPerformed

    private void jMenuItem3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem3MousePressed
         objetivo hola = new objetivo();
        hola.setVisible(true);
    }//GEN-LAST:event_jMenuItem3MousePressed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
         ayuda hola = new ayuda();
     hola.setVisible(true);
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void estadisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadisMousePressed
       estadistica tab = null;
        try {
            tab = new estadistica(this.player);
        } catch (SQLException ex) {
            Logger.getLogger(Menuprincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
            tab.setVisible(true);
           
    }//GEN-LAST:event_estadisMousePressed

    private void jMenu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2MousePressed

    private void estadisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadisActionPerformed

    private void estadisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_estadisKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadisKeyPressed


   
     public void setNombreUser(jugador player)
     {
        nombre.setText("USUARIO: " + player.getNombre());
     }
     public void mostrarMsg(String msg)
     {
        this.panMostrar.append(msg+"\n");
     }
     public void ponerActivos(Vector datos)
     {
        nomUsers=datos;
        ponerDatosList(this.lstActivos1,nomUsers);
     }



     public void agregarUser(String user)
     {
        nomUsers.add(user);
        ponerDatosList(this.lstActivos1,nomUsers);
     }
     public void retirraUser(String user)
     {
        nomUsers.remove(user);
        ponerDatosList(this.lstActivos1,nomUsers);
     }
    private void ponerDatosList(JList list,final Vector datos)
    {
        list.setModel(new AbstractListModel() {
            @Override
            public int getSize() { return datos.size(); }
            @Override
            public Object getElementAt(int i) { return datos.get(i); }
        });
    }

     public void actionPerformed(ActionEvent evt) {

       String comand=(String)evt.getActionCommand();
        if(comand.compareTo("help")==0)
        {
                va=new VentanaAyuda();
                va.setVisible(true);
        }

        if(evt.getSource()==this.butEnviar || evt.getSource()==this.txtMensage)
        {
           String mensaje = txtMensage.getText();
           cliente.flujo(mensaje);
           txtMensage.setText("");
        }
//        else if(evt.getSource()==this.butPrivado)
//        {
//           int pos=this.lstActivos.getSelectedIndex();
//           if(pos>=0)
//           {
//              ventPrivada.setAmigo(nomUsers.get(pos));
//              ventPrivada.setVisible(true);
//           }
//        }
     }

//     public void mensageAmigo(String amigo,String msg)
//     {
//        ventPrivada.setAmigo(amigo);
//        ventPrivada.mostrarMsg(msg);
//        ventPrivada.setVisible(true);
//     }

     public static void main(String args[]) throws IOException {

            tablero p = new tablero();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton H0H12;
    private javax.swing.JButton H10H10;
    private javax.swing.JButton H10H12;
    private javax.swing.JButton H10H14;
    private javax.swing.JButton H10H16;
    private javax.swing.JButton H10H18;
    private javax.swing.JButton H10H2;
    private javax.swing.JButton H10H20;
    private javax.swing.JButton H10H22;
    private javax.swing.JButton H10H4;
    private javax.swing.JButton H10H6;
    private javax.swing.JButton H10H8;
    private javax.swing.JButton H11H1;
    private javax.swing.JButton H11H11;
    private javax.swing.JButton H11H13;
    private javax.swing.JButton H11H15;
    private javax.swing.JButton H11H17;
    private javax.swing.JButton H11H19;
    private javax.swing.JButton H11H21;
    private javax.swing.JButton H11H23;
    private javax.swing.JButton H11H3;
    private javax.swing.JButton H11H5;
    private javax.swing.JButton H11H7;
    private javax.swing.JButton H11H9;
    private javax.swing.JButton H12H0;
    private javax.swing.JButton H12H10;
    private javax.swing.JButton H12H12;
    private javax.swing.JButton H12H14;
    private javax.swing.JButton H12H16;
    private javax.swing.JButton H12H18;
    private javax.swing.JButton H12H2;
    private javax.swing.JButton H12H20;
    private javax.swing.JButton H12H22;
    private javax.swing.JButton H12H24;
    private javax.swing.JButton H12H4;
    private javax.swing.JButton H12H6;
    private javax.swing.JButton H12H8;
    private javax.swing.JButton H13H11;
    private javax.swing.JButton H13H13;
    private javax.swing.JButton H13H15;
    private javax.swing.JButton H13H9;
    private javax.swing.JButton H14H10;
    private javax.swing.JButton H14H12;
    private javax.swing.JButton H14H14;
    private javax.swing.JButton H15H11;
    private javax.swing.JButton H15H13;
    private javax.swing.JButton H16H12;
    private javax.swing.JButton H1H11;
    private javax.swing.JButton H1H13;
    private javax.swing.JButton H2H10;
    private javax.swing.JButton H2H12;
    private javax.swing.JButton H2H14;
    private javax.swing.JButton H3H11;
    private javax.swing.JButton H3H13;
    private javax.swing.JButton H3H15;
    private javax.swing.JButton H3H9;
    private javax.swing.JButton H4H0;
    private javax.swing.JButton H4H10;
    private javax.swing.JButton H4H12;
    private javax.swing.JButton H4H14;
    private javax.swing.JButton H4H16;
    private javax.swing.JButton H4H18;
    private javax.swing.JButton H4H2;
    private javax.swing.JButton H4H20;
    private javax.swing.JButton H4H22;
    private javax.swing.JButton H4H24;
    private javax.swing.JButton H4H4;
    private javax.swing.JButton H4H6;
    private javax.swing.JButton H4H8;
    private javax.swing.JButton H5H1;
    private javax.swing.JButton H5H11;
    private javax.swing.JButton H5H13;
    private javax.swing.JButton H5H15;
    private javax.swing.JButton H5H17;
    private javax.swing.JButton H5H19;
    private javax.swing.JButton H5H21;
    private javax.swing.JButton H5H23;
    private javax.swing.JButton H5H3;
    private javax.swing.JButton H5H5;
    private javax.swing.JButton H5H7;
    private javax.swing.JButton H5H9;
    private javax.swing.JButton H6H10;
    private javax.swing.JButton H6H12;
    private javax.swing.JButton H6H14;
    private javax.swing.JButton H6H16;
    private javax.swing.JButton H6H18;
    private javax.swing.JButton H6H2;
    private javax.swing.JButton H6H20;
    private javax.swing.JButton H6H22;
    private javax.swing.JButton H6H4;
    private javax.swing.JButton H6H6;
    private javax.swing.JButton H6H8;
    private javax.swing.JButton H7H11;
    private javax.swing.JButton H7H13;
    private javax.swing.JButton H7H15;
    private javax.swing.JButton H7H17;
    private javax.swing.JButton H7H19;
    private javax.swing.JButton H7H21;
    private javax.swing.JButton H7H3;
    private javax.swing.JButton H7H5;
    private javax.swing.JButton H7H7;
    private javax.swing.JButton H7H9;
    private javax.swing.JButton H8H10;
    private javax.swing.JButton H8H12;
    private javax.swing.JButton H8H14;
    private javax.swing.JButton H8H16;
    private javax.swing.JButton H8H18;
    private javax.swing.JButton H8H20;
    private javax.swing.JButton H8H4;
    private javax.swing.JButton H8H6;
    private javax.swing.JButton H8H8;
    private javax.swing.JButton H9H11;
    private javax.swing.JButton H9H13;
    private javax.swing.JButton H9H15;
    private javax.swing.JButton H9H17;
    private javax.swing.JButton H9H19;
    private javax.swing.JButton H9H21;
    private javax.swing.JButton H9H3;
    private javax.swing.JButton H9H5;
    private javax.swing.JButton H9H7;
    private javax.swing.JButton H9H9;
    private javax.swing.JButton butEnviar;
    private javax.swing.JMenuItem estadis;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstActivos1;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextArea panMostrar;
    private javax.swing.JTextField txtMensage;
    // End of variables declaration//GEN-END:variables

}

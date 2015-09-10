/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package base_datos;

import persistencia.jugador;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcelo
 */
public class conexcion_prueba {

    public Statement coneccion_bd() {
    try {
           Class.forName("com.mysql.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost/damaschinas?user=root&password=root");
            Statement st = conection.createStatement();
            return(st);
        } catch (SQLException ex) {
            Logger.getLogger(conexcion_prueba.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
           Logger.getLogger(conexcion_prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(null);
    }

    public jugador autenticar_usuario(String username,String password) throws SQLException{

       Statement st = coneccion_bd();
       if(st != null){
          ResultSet rs =st.executeQuery("select * from persona ");
          if(rs!=null)
            while(rs.next()){
                if(username.equals(rs.getString("nickname")))
                    if (password.equals(rs.getString("password"))){
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String email = rs.getString("email");
                        int partidas_ganadas = rs.getInt("ganadas");
                        int partidas_perdidas = rs.getInt("perdida");
                        int score = rs.getInt("dinero");
                        jugador jugador = new jugador(nombre,apellido,email,username, partidas_perdidas,partidas_ganadas,score);
                        return(jugador);
                     }
                    else
                        return(null);
            }
       }
     return(null);
    }
 public ArrayList<jugador> vaciarJugadores() throws SQLException{
     ArrayList<jugador> jugadores = new ArrayList<jugador>();


     Statement st = coneccion_bd();
       if(st != null){
          ResultSet rs =st.executeQuery("select * from persona ");
          if(rs!=null)
            while(rs.next()){
                        String username = rs.getString("nickname");
                        String nombre = rs.getString("nombre");
                        String apellido = rs.getString("apellido");
                        String email = rs.getString("email");
                        int partidas_ganadas = rs.getInt("ganadas");
                        int partidas_perdidas = rs.getInt("perdida");
                        int score = rs.getInt("dinero");
                        jugador jugador = new jugador(nombre,apellido,email,username, partidas_perdidas,partidas_ganadas,score);
                        jugadores.add(jugador);
                     }
                    else
                        return(jugadores);
            }
      return(jugadores);


 }
    public boolean actualizar_jugador(jugador jugador) throws SQLException{
        Statement st = coneccion_bd();
         if(st != null){
              st.executeQuery("UPDATE dinero="+jugador.getPuntuacionMaxima()
                  +" partidas_ganadas="+jugador.getPartidasGanadas()
                  +" partidas_perdidas="+jugador.getPartidasPerdidas()
                  +" INTO persona where username="+jugador.getId());
                  return(true);
         }
         return(false);
    }

    public int numero_usuarios() throws SQLException{

        int resultado= 1;
       Statement st = coneccion_bd();
       if(st != null){
          ResultSet rs =st.executeQuery("select * from persona ");
            while(rs.next()){
                     resultado ++;
                     return(resultado);
                     }

            }
       return(resultado);
       }
    
}

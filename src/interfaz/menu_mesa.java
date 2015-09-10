/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * menu_mesa.java
 *
 * Created on 24/06/2011, 03:04:59 PM
 */
package interfaz;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.*;
import persistencia.jugador;

/**
 *
 * @author Casa
 */
public class menu_mesa extends javax.swing.JFrame {
    
    jugador player;

    /** Creates new form menu_mesa */
    public menu_mesa() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public menu_mesa(jugador player){
        initComponents();
       this.player = player;
       this.setLocationRelativeTo(null);
    }



//     private void llenar () throws SQLException{
//
//    javax.swing.table.DefaultTableModel tabModel=new javax.swing.table.DefaultTableModel(
//null,
//    new String [] {
//        "Mesa", "Jugadores", "Apuesta"
//    }
//) {
//    Class[] types = new Class [] {
//        java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
//    };
//    boolean[] canEdit = new boolean [] {
//        false, false, false, false, false, false
//    };
//
//    public Class getColumnClass(int columnIndex) {
//        return types [columnIndex];
//    }
//
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        return canEdit [columnIndex];
//    }
//};
//            jTable1.setModel(tabModel);
//            jTable1.setDragEnabled(false);
//            int numero;
//
//         conexcion_prueba prueba = new conexcion_prueba();
//
//         numero = prueba.numero_usuarios();
//          ArrayList<jugador> jugadores = new ArrayList<jugador>();
//          jugadores= prueba.vaciarJugadores();
//                        for(int i=0;i<numero;i++) {
//                        jugador player = jugadores.get(i);
//                            Object[] rowData = {player.getNombre(), player.getApellido(), player.getId(),player.getPartidasGanadas(),player.getPartidasPerdidas(),player.getPuntuacionMaxima()};
//                            tabModel.insertRow(i,rowData);
//                        }
//
//
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton5.setText("Crear Mesa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(450, 300, 120, 30);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton9.setText("Regresar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.setBounds(460, 350, 110, 23);
        jLayeredPane1.add(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Jugador", "Credito", "Localidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setShowHorizontalLines(false);
        jTable2.setShowVerticalLines(false);
        jScrollPane2.setViewportView(jTable2);

        jScrollPane2.setBounds(350, 110, 300, 100);
        jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mesa", "Jugadores", "Apuesta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jScrollPane1.setBounds(40, 110, 270, 140);
        jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/fondoazul3.jpg"))); // NOI18N
        jLabel3.setBounds(0, 0, 670, 460);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        numeroDeJugadores tab = new numeroDeJugadores(this.player);
        tab.setVisible(true);
        this.dispose();
        
        // TODO add your handling code here:
}//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

       Menuprincipal tab = new Menuprincipal(this.player);
            tab.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new menu_mesa().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}

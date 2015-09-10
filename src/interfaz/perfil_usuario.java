/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * perfil_usuario.java
 *
 * Created on 24/06/2011, 02:48:51 PM
 */

package interfaz;

import persistencia.jugador;

/**
 *
 * @author marcelo
 */
public class perfil_usuario extends javax.swing.JFrame {

   private jugador player;

    public perfil_usuario() {
        initComponents();
         this.setLocationRelativeTo(null);
    }


    public perfil_usuario(jugador player){
        initComponents();
        this.setLocationRelativeTo(null);
       this.player = player;

       nombre.setText(player.getNombre());
       apellido.setText(player.getApellido());
       nickname.setText(player.getId());
       ganada.setText(Integer.toString(player.getPartidasGanadas()));
       perdida.setText(Integer.toString(player.getPartidasPerdidas()));
       dinero.setText(Integer.toString(player.getPuntuacionMaxima()));

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        jLabelCedula = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        nickname = new javax.swing.JTextField();
        ganada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        perdida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dinero = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(300, 350, 90, 23);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Datos personales:");
        jLabel8.setBounds(50, 40, 150, 17);
        jLayeredPane1.add(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelNombre.setText("Nombre(s):");
        jLabelNombre.setBounds(40, 50, 70, 14);
        jLayeredPane2.add(jLabelNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelApellido.setText("Apellido(s):");
        jLabelApellido.setBounds(160, 50, 70, 14);
        jLayeredPane2.add(jLabelApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        nombre.setBounds(40, 70, 100, 25);
        jLayeredPane2.add(nombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        apellido.setBounds(160, 70, 100, 25);
        jLayeredPane2.add(apellido, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelCedula.setText("Nickname:");
        jLabelCedula.setBounds(40, 100, 80, 14);
        jLayeredPane2.add(jLabelCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabelTelefono.setText("Jugadas Ganadas:");
        jLabelTelefono.setBounds(160, 150, 120, 14);
        jLayeredPane2.add(jLabelTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        nickname.setBounds(40, 120, 100, 25);
        jLayeredPane2.add(nickname, javax.swing.JLayeredPane.DEFAULT_LAYER);
        ganada.setBounds(160, 170, 40, 25);
        jLayeredPane2.add(ganada, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("Jugadas Perdidas:");
        jLabel5.setBounds(40, 150, 110, 14);
        jLayeredPane2.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        perdida.setBounds(40, 170, 40, 25);
        jLayeredPane2.add(perdida, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel6.setText("Dinero:");
        jLabel6.setBounds(160, 100, 80, 14);
        jLayeredPane2.add(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        dinero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dineroActionPerformed(evt);
            }
        });
        dinero.setBounds(160, 120, 80, 25);
        jLayeredPane2.add(dinero, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/sections-300x250.png"))); // NOI18N
        jLabel1.setBounds(0, 10, 330, 280);
        jLayeredPane2.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane2.setBounds(0, 40, 320, 290);
        jLayeredPane1.add(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Imagen personal:");
        jLabel7.setBounds(400, 40, 150, 17);
        jLayeredPane1.add(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/images-search32.png"))); // NOI18N
        jLabel3.setBounds(130, 220, 40, 40);
        jLayeredPane3.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setText("Examinar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(50, 230, 110, 23);
        jLayeredPane3.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/sections-170x250.png"))); // NOI18N
        jLabel2.setBounds(20, 0, 170, 250);
        jLayeredPane3.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane3.setBounds(370, 60, 200, 260);
        jLayeredPane1.add(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_nombreActionPerformed

    private void dineroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dineroActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_dineroActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Menuprincipal tab = new   Menuprincipal(this.player);
            tab.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new perfil_usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellido;
    private javax.swing.JTextField dinero;
    private javax.swing.JTextField ganada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCedula;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JTextField nickname;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField perdida;
    // End of variables declaration//GEN-END:variables

}

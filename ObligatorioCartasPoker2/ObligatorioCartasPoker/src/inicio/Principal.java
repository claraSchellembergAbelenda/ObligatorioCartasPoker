
package inicio;

import pokerApp.Fachada.Fachada;
import pokerApp.iu.LoginAdministrador;
import pokerApp.iu.LoginJugador;


public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        JmnuOpciones = new javax.swing.JMenu();
        mnuJugador = new javax.swing.JMenuItem();
        mnuAdministrador = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JmnuOpciones.setText("Opciones");

        mnuJugador.setText("Aplicacion para Jugadores");
        mnuJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuJugadorActionPerformed(evt);
            }
        });
        JmnuOpciones.add(mnuJugador);

        mnuAdministrador.setText("Aplicacion para administradores");
        mnuAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAdministradorActionPerformed(evt);
            }
        });
        JmnuOpciones.add(mnuAdministrador);

        jMenuBar1.add(JmnuOpciones);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuJugadorActionPerformed
        LoginJugador loginJugador = new LoginJugador(null, false, Fachada.getInstancia());
        loginJugador.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_mnuJugadorActionPerformed

    private void mnuAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAdministradorActionPerformed
        LoginAdministrador loginAdministrador = new LoginAdministrador(null, false, Fachada.getInstancia());
        loginAdministrador.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_mnuAdministradorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JmnuOpciones;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAdministrador;
    private javax.swing.JMenuItem mnuJugador;
    // End of variables declaration//GEN-END:variables
}

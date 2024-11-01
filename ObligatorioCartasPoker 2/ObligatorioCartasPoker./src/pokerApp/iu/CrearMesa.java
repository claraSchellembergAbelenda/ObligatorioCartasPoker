/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pokerApp.iu;

import pokerApp.Sistemas.Fachada;

/**
 *
 * @author maximiliano
 */
public class CrearMesa extends javax.swing.JDialog {

    
    public CrearMesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mostrarTitulo();
        initComponents();
        
    }

    
    private void mostrarTitulo() {
        String titulo = "Crear Mesa";
        setTitle(titulo);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNumeroJugadores = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtMontoBase = new javax.swing.JTextField();
        lblMontoBase = new javax.swing.JLabel();
        lblPorcentajeComision = new javax.swing.JLabel();
        txtPorcentajeComision = new javax.swing.JTextField();
        btnCrearMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNumeroJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroJugadoresActionPerformed(evt);
            }
        });

        jLabel1.setText("Ingrese numero de jugadores: ");

        lblMontoBase.setText("Ingrese monto base:");

        lblPorcentajeComision.setText("Porcentaje de comision:");

        txtPorcentajeComision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentajeComisionActionPerformed(evt);
            }
        });

        btnCrearMesa.setText("Crear Mesa");
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearMesa)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPorcentajeComision)
                        .addComponent(lblMontoBase)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumeroJugadores)
                        .addComponent(txtMontoBase)
                        .addComponent(txtPorcentajeComision)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeroJugadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(lblMontoBase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMontoBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPorcentajeComision)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPorcentajeComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCrearMesa)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumeroJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroJugadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroJugadoresActionPerformed

    private void txtPorcentajeComisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentajeComisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcentajeComisionActionPerformed

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMesaActionPerformed
        int cantJugadores = Integer.parseInt(txtNumeroJugadores.getText());
        int montoBase = Integer.parseInt(txtMontoBase.getText());
        int porcentajeComision = Integer.parseInt(txtPorcentajeComision.getText());
        
        String mesaCreada = Fachada.getInstancia().crearMesa(cantJugadores ,montoBase ,porcentajeComision);
        setTitle(mesaCreada);

        
    }//GEN-LAST:event_btnCrearMesaActionPerformed

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
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CrearMesa dialog = new CrearMesa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMontoBase;
    private javax.swing.JLabel lblPorcentajeComision;
    private javax.swing.JTextField txtMontoBase;
    private javax.swing.JTextField txtNumeroJugadores;
    private javax.swing.JTextField txtPorcentajeComision;
    // End of variables declaration//GEN-END:variables
}
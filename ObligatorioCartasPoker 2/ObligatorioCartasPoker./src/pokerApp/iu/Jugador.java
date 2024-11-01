/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pokerApp.iu;

import java.util.ArrayList;
import pokerApp.Sistemas.Fachada;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Sesion;


public class Jugador extends javax.swing.JDialog {

    private Sesion sesion;
    private ArrayList<Mesa> mesasAbiertas = new ArrayList<>();
    
    
    
    public Jugador(java.awt.Frame parent, boolean modal, Sesion sesion) {
        super(parent, modal);
        this.sesion = sesion;
        initComponents();
        setTitle("Jugador - " + sesion.getUsuario().getNombreCompleto());// + getSaldo()
        CargarMesas();
    }
    
    
    
    private void CargarMesas() {
        mesasAbiertas = Fachada.getInstancia().obtenerMesasAbiertas();
        
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIngresarAMesa = new javax.swing.JLabel();
        btnIngresarAMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JTextField();
        cmbMesasAbiertas = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIngresarAMesa.setText("Seleccionar una Mesa:");

        btnIngresarAMesa.setText("Ingresar");
        btnIngresarAMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAMesaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Del Jugador:");

        lblNombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNombreJugadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbMesasAbiertas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnIngresarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(lblIngresarAMesa))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblIngresarAMesa)
                .addGap(18, 18, 18)
                .addComponent(cmbMesasAbiertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresarAMesa)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarAMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarAMesaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarAMesaActionPerformed

    private void lblNombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNombreJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNombreJugadorActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarAMesa;
    private javax.swing.JComboBox cmbMesasAbiertas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIngresarAMesa;
    private javax.swing.JTextField lblNombreJugador;
    // End of variables declaration//GEN-END:variables

    
}
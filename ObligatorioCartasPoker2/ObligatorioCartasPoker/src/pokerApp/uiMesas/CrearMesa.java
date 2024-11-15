
package pokerApp.uiMesas;

import dominiomesaymano.MesaException;
import dominio.Fachada.Fachada;

public class CrearMesa extends javax.swing.JDialog {
    
    private AdministrarMesa administrarMesa;
    
    public CrearMesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        mostrarTitulo();
        initComponents();
        
    }

    // Constructor con AdministrarMesa como parámetro
    public CrearMesa(java.awt.Frame parent, boolean modal, AdministrarMesa administrarMesa) {
        super(parent, modal);
        mostrarTitulo();
        initComponents();
        this.administrarMesa = administrarMesa;

    }
    
    private void mostrarTitulo() {
        String titulo = "Crear Mesa";
        setTitle(titulo);
    }

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
        lblMensaje = new javax.swing.JLabel();

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

        lblMensaje.setText("Aqui se vera un mensaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrearMesa)
                    .addComponent(lblPorcentajeComision)
                    .addComponent(lblMontoBase)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNumeroJugadores)
                    .addComponent(txtMontoBase)
                    .addComponent(txtPorcentajeComision)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        float montoBase = Float.parseFloat(txtMontoBase.getText());
        float porcentajeComision = Float.parseFloat(txtPorcentajeComision.getText());
        try{
        Fachada.getInstancia().crearMesa(cantJugadores ,montoBase ,porcentajeComision);
        lblMensaje.setText( "Mesa creada con exito");
            // Llama a actualizarMesas en AdministrarMesa para refrescar el combo
            if (administrarMesa != null) {
                administrarMesa.actualizarMesas(); 
            }
        }catch(MesaException me){
            // Recuerde que puede mostrar mensajes al usuario utilizando por 
//            ejemplo etiquetas, barras de estado o áreas de texto específicas para mensajes.  
            lblMensaje.setText(
                    "Error: "+
                    me.getMessage());
        }

        
    }//GEN-LAST:event_btnCrearMesaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMontoBase;
    private javax.swing.JLabel lblPorcentajeComision;
    private javax.swing.JTextField txtMontoBase;
    private javax.swing.JTextField txtNumeroJugadores;
    private javax.swing.JTextField txtPorcentajeComision;
    // End of variables declaration//GEN-END:variables
}

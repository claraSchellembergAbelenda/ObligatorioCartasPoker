package pokerApp.iu;

import javax.swing.JOptionPane;
import pokerApp.juego.Mesa;

public class PanelDeCartas extends javax.swing.JFrame {

    private JuegoPoker juegoPoker;
    
    public PanelDeCartas() {
        initComponents();
        
        Mesa mesa = new Mesa(5,200,23);//ejemplo de mesa
        juegoPoker = new JuegoPoker(mesa);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartasPoker = new panelCartasPoker.PanelCartasPoker();
        jButton1 = new javax.swing.JButton();
        btnIniciarApuesta = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnCambiarCartas = new javax.swing.JButton();
        btnAbandonarMesa = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnPagarApuesta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Apuesta Base");

        btnIniciarApuesta.setText("Iniciar Apuesta");
        btnIniciarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarApuestaActionPerformed(evt);
            }
        });

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnCambiarCartas.setText("Cambiar Cartas");
        btnCambiarCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCartasActionPerformed(evt);
            }
        });

        btnAbandonarMesa.setText("Abandonar Mesa");
        btnAbandonarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarMesaActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnPagarApuesta.setText("Pagar Apuesta");
        btnPagarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarApuestaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnIniciarApuesta)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPagarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCambiarCartas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPasar)
                                .addGap(161, 161, 161)))
                        .addGap(86, 86, 86)
                        .addComponent(btnJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbandonarMesa)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAbandonarMesa)
                        .addComponent(btnJugar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarApuesta)
                            .addComponent(btnPagarApuesta)
                            .addComponent(btnCambiarCartas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPasar)))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        //logica para iniciar el juego, si la mesa esta iniciada entonces... sino...
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarApuestaActionPerformed

    IniciarApuesta iniciarApuesta = new IniciarApuesta(this, true);
    iniciarApuesta.setVisible(true);

    double montoApuesta = iniciarApuesta.getApuesta();

    if (montoApuesta > 0) {
        try {
            if (juegoPoker.iniciarApuesta(montoApuesta)) {
                JOptionPane.showMessageDialog(this, "Apuesta de $" + montoApuesta + " iniciada.");
                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios

                // Mostrar el pozo actual en un JOptionPane
                double pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                JOptionPane.showMessageDialog(this, "El pozo actual es: $" + pozoActual, "Pozo Actual", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente para iniciar la apuesta.");
            }
        } catch (IllegalStateException e) {
            JOptionPane.showMessageDialog(this, "No hay jugadores en la mesa. No se puede iniciar la apuesta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Apuesta cancelada o inválida.");
    }
    }//GEN-LAST:event_btnIniciarApuestaActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        //logica para pasar 
    }//GEN-LAST:event_btnPasarActionPerformed

    private void btnPagarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarApuestaActionPerformed
        //logica para pagar apuesta 
    }//GEN-LAST:event_btnPagarApuestaActionPerformed

    private void btnCambiarCartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCartasActionPerformed
        //logica para cambiar cartas
    }//GEN-LAST:event_btnCambiarCartasActionPerformed

    private void btnAbandonarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarMesaActionPerformed
        juegoPoker.abandonarMesa();
        JOptionPane.showMessageDialog(this, "Has abandonado la mesa.");
        this.dispose(); // Cierra la ventana
    }//GEN-LAST:event_btnAbandonarMesaActionPerformed

    
    // Método para actualizar la interfaz con el estado actual del juego
    private void actualizarInterfaz() {
        // Actualiza paneles o etiquetas con la información actual del juego
        //panelCartasPoker.actualizarCartas(juegoPoker.getCartasJugador());//hay que ver como actualizar ya que esta en el package libreria y no deja editar el PanelCartasPoker
        // Aquí podrías actualizar otros elementos de la interfaz, como el saldo o el pozo.
        // Por ejemplo:
    Mesa mesa = juegoPoker.getMesa(); // Obtener la mesa desde juegoPoker
    double pozo = mesa.getMontoTotalApostado(); // Obtener el pozo desde mesa
    JOptionPane.showMessageDialog(this, "El pozo actual es: $" + pozo, "Pozo Actual", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelDeCartas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarMesa;
    private javax.swing.JButton btnCambiarCartas;
    private javax.swing.JButton btnIniciarApuesta;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPagarApuesta;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton jButton1;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker;
    // End of variables declaration//GEN-END:variables
}

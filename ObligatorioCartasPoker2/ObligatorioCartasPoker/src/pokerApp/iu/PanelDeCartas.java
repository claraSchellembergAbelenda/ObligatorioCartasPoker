package pokerApp.iu;

import pokerApp.juego.JuegoPoker;
import javax.swing.JOptionPane;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;

public class PanelDeCartas extends javax.swing.JFrame {

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    
    public PanelDeCartas() {
        initComponents();
        
        Mesa mesa = new Mesa(5,200,23);//ejemplo de mesa
        juegoPoker = new JuegoPoker(mesa);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartas1 = new pokerApp.iu.PanelCartas();
        panelCartasPoker = new panelCartasPoker.PanelCartasPoker();
        btnIniciarApuesta = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnCambiarCartas = new javax.swing.JButton();
        btnAbandonarMesa = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnPagarApuesta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblSaldoJugador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        lblSaldoJugador.setText("Saldo:");

        jLabel1.setText("No se encontro usuario hbsdbjadsbjabdjbldalbj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblSaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 464, Short.MAX_VALUE))
                            .addComponent(btnIniciarApuesta))
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
                        .addComponent(btnAbandonarMesa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(495, 495, 495)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAbandonarMesa)
                        .addComponent(btnJugar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarApuesta)
                            .addComponent(btnPagarApuesta)
                            .addComponent(btnCambiarCartas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasar)
                            .addComponent(lblSaldoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        //logica para iniciar el juego, si la mesa esta iniciada entonces... sino...
        //una vez que ya todos los jugadores pagaron las apuestas o pasaron y ya se cambiaron las cartas
        //TERMINA MANO, se determina el ganador de la mano
        //se incrementa su saldo x el valor del pozo-% de comision
        //se le muestra cartel y cambia el estado de la mano y si les da el saldo aparece cartel de que decidan 
        //si seguir jugando
        //si no le da la plata se sale y va a la interfaz de ingresar a mesa
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarApuestaActionPerformed

    IniciarApuesta iniciarApuesta = new IniciarApuesta(this, false, jugador);
    iniciarApuesta.setVisible(true);

    float montoApuesta = iniciarApuesta.getApuesta();

    if (montoApuesta > 0) {
        try {
                juegoPoker.iniciarApuesta(montoApuesta);
                JOptionPane.showMessageDialog(this, "Apuesta de $" + montoApuesta + " iniciada.");
                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios

                // Mostrar el pozo actual en un JOptionPane
                double pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                JOptionPane.showMessageDialog(this, "El pozo actual es: $" + pozoActual, "Pozo Actual", JOptionPane.INFORMATION_MESSAGE);
            
                JOptionPane.showMessageDialog(this, "Saldo insuficiente para iniciar la apuesta.");
            }
            catch (UsuarioException ue) {
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
        //uno apuesta, se le resta de su saldo el valor de la apuesta hecha y les aparece un dialogo al resto de los 
        //jugadores que dice "tal jugador hizo una apuesta, desea pagar, si o no"
        //si ponen que si se les descuenta
        //si no pagan la apuesta se cierra esa ventana y se le desabilitan todos los botones excepto el de abandonar mesa
        
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblSaldoJugador;
    private pokerApp.iu.PanelCartas panelCartas1;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker;
    // End of variables declaration//GEN-END:variables
}

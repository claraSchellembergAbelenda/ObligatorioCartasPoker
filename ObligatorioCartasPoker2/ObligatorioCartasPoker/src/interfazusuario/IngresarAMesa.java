
package interfazusuario;

import estados.EstadoMano;
import java.util.ArrayList;
import java.util.List;
import modelUsuario.UsuarioException;
import modelFachada.Fachada;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import pokerApp.listeners.EventoJugador;
import utilidades.Observable;
import utilidades.Observador;


public class IngresarAMesa extends javax.swing.JDialog {

    private Jugador jugador;
    private List<Mesa> mesasAbiertas = new ArrayList<>();
    private Mesa mesaSeleccionada;
    
    
    public IngresarAMesa(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        this.jugador = jugador;
        initComponents();
        MostrarDatosJugador();
        CargarMesas();
    }
    
    
    
    public void CargarMesas() {

    mesasAbiertas = Fachada.getInstancia().obtenerMesasAbiertas();
            List <String> mesas= new ArrayList<String>();
    //        siguiente información para cada mesa: 
    //        -Número de mesa 
    //        -Cantidad de jugadores requeridos para iniciar la mesa
    //        -Valor de la apuesta base -Cantidad actual de jugadores
    //        -Porcentaje de comisión de la mesa 
            for (Mesa mesa : mesasAbiertas) {
                mesas.add("Numero de mesa: "+ mesa.getNumeroMesa()
                        + "Cantidad de jugadores requeridos: "+ mesa.getCantidadJugadoresRequeridos()
                        + "Valor de apuesta base: "+ mesa.getApuestaBase()
                        + "Cantidad actual de jugadores: "+ mesa.getCantidadJugadoresActual()
                        +"Porcentaje de comision de mesa: "+ mesa.getComision()+"%");
            }
            lstMesasAbiertas.setListData(mesas.toArray());
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreJugador = new javax.swing.JTextField();
        lblIngresarAMesa = new javax.swing.JLabel();
        btnIngresarAMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMesasAbiertas = new javax.swing.JList();
        lblDatosJugador = new javax.swing.JLabel();
        lblRespuestaIngreso = new javax.swing.JLabel();

        lblNombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblNombreJugadorActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblIngresarAMesa.setText("Seleccionar una Mesa:");

        btnIngresarAMesa.setText("Ingresar");
        btnIngresarAMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAMesaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre Del Jugador:");

        jScrollPane1.setViewportView(lstMesasAbiertas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnIngresarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblIngresarAMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDatosJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(121, 121, 121))
                            .addComponent(lblRespuestaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRespuestaIngreso)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDatosJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblIngresarAMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIngresarAMesa))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarAMesaActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        // Obtén la mesa seleccionada de la lista
        int indiceSeleccionado = lstMesasAbiertas.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            mesaSeleccionada = mesasAbiertas.get(indiceSeleccionado);
            
            // Verifica el saldo del jugador antes de entrar a la sala de espera
            Fachada.getInstancia().validarSaldoDeJugador(jugador, mesaSeleccionada);
            
            // Ingresar a la sala de espera
            SalaEsperaPoker salaEspera = new SalaEsperaPoker(null, false, mesaSeleccionada, jugador);
            salaEspera.setVisible(true);
            
            dispose(); // Cerrar el diálogo de selección de mesa
        } else {
            lblRespuestaIngreso.setText("No seleccionó una mesa.");
        }
    } catch (UsuarioException ue) {
        lblRespuestaIngreso.setText("Error: " + ue.getMessage());
    }
}
    
    private void lblNombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblNombreJugadorActionPerformed
        

        // TODO add your handling code here:
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarAMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatosJugador;
    private javax.swing.JLabel lblIngresarAMesa;
    private javax.swing.JTextField lblNombreJugador;
    private javax.swing.JLabel lblRespuestaIngreso;
    private javax.swing.JList lstMesasAbiertas;
    // End of variables declaration//GEN-END:variables

    private void MostrarDatosJugador() {
        lblDatosJugador.setText(jugador.getNombreCompleto()
                +" saldo: "+ jugador.getSaldo());
    }

    

    
}

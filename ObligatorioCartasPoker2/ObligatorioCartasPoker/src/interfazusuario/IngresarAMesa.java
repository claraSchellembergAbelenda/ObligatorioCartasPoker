
package interfazusuario;

import controladores.IngresarAMesaController;
import estados.EstadoPartida;
import java.util.ArrayList;
import java.util.List;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import utilidades.Observable;
import utilidades.Observador;
import vista.VistaIngresarAMesa;


public class IngresarAMesa extends javax.swing.JDialog implements VistaIngresarAMesa  {
    private List<Mesa> mesas = new ArrayList<>();
    private IngresarAMesaController controlador;
    
    
    public IngresarAMesa(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        controlador=new IngresarAMesaController(jugador, this);
        controlador.cargarMesas();
        controlador.mostrarDatosJugador();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDatosJugador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMesasAbiertas = new javax.swing.JList();
        btnIngresarAMesa = new javax.swing.JButton();
        lblRespuestaIngreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDatosJugador.setText("jLabel1");

        jLabel1.setText("Ingresar a una mesa:");

        jScrollPane1.setViewportView(lstMesasAbiertas);

        btnIngresarAMesa.setText("Ingresar a mesa");
        btnIngresarAMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarAMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addComponent(btnIngresarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblDatosJugador, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                                    .addComponent(lblRespuestaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblRespuestaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDatosJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnIngresarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarAMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarAMesaActionPerformed
        ingresarAMesa();
    }//GEN-LAST:event_btnIngresarAMesaActionPerformed

    @Override
    public void cargarMesas(ArrayList<Mesa>mesasAbiertas) {
            List <String> mesas= new ArrayList<String>();
            for (Mesa mesa : mesasAbiertas) {
                mesas.add("Numero de mesa: "+ mesa.getNumeroMesa()
                        + "Cantidad de jugadores requeridos: "+ mesa.getCantidadJugadoresRequeridos()
                        + "Valor de apuesta base: "+ mesa.getApuestaBase()
                        + "Cantidad actual de jugadores: "+ mesa.getCantidadJugadoresActual()
                        +"Porcentaje de comision de mesa: "+ mesa.getComision()+"%");
            }
            lstMesasAbiertas.setListData(mesas.toArray());
            this.mesas=mesasAbiertas;
    }

    @Override
    public void mostrarDatosJugador(Jugador jugador) {
        lblDatosJugador.setText(jugador.getNombreCompleto()
                +" saldo: "+ jugador.getSaldo());
    }

    @Override
    public void ingresarAMesa() {
        // Obtén la mesa seleccionada de la lista
        int indiceSeleccionado = lstMesasAbiertas.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            Mesa mesaSeleccionada = mesas.get(indiceSeleccionado);
            if(controlador.ingresarAMesa(mesaSeleccionada)){
                dispose();
            }
            //dispose();
        }
}

    @Override
    public void mostrarMensajeError(String mensaje) {
        lblRespuestaIngreso.setText(mensaje);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarAMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDatosJugador;
    private javax.swing.JLabel lblRespuestaIngreso;
    private javax.swing.JList lstMesasAbiertas;
    // End of variables declaration//GEN-END:variables

    
}

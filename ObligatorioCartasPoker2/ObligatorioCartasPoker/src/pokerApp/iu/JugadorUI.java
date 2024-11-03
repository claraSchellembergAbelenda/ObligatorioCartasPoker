
package pokerApp.iu;

import java.util.ArrayList;
import java.util.List;
import pokerApp.Fachada.Fachada;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Sesion;


public class JugadorUI extends javax.swing.JDialog {

    private Sesion sesion;
    private List<Mesa> mesasAbiertas = new ArrayList<>();
    
    
    public JugadorUI(java.awt.Frame parent, boolean modal, Sesion sesion) {
        super(parent, modal);
        this.sesion = sesion;
        initComponents();
        setTitle("Jugador - " + sesion.getUsuario().getNombreCompleto());// + getSaldo()
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

        lblIngresarAMesa = new javax.swing.JLabel();
        btnIngresarAMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstMesasAbiertas = new javax.swing.JList();

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

        jScrollPane1.setViewportView(lstMesasAbiertas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(btnIngresarAMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIngresarAMesa)
                            .addComponent(jLabel1))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(lblIngresarAMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresarAMesa))
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIngresarAMesa;
    private javax.swing.JTextField lblNombreJugador;
    private javax.swing.JList lstMesasAbiertas;
    // End of variables declaration//GEN-END:variables

    
}

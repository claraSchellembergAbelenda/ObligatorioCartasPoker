
package interfazusuario;

import controladores.AdministrarMesaController;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import modelFachada.Fachada;
import modelJuego.Mesa;
import vista.VistaAdministrarMesa;

public class AdministrarMesa extends javax.swing.JDialog implements VistaAdministrarMesa{

    private AdministrarMesaController controlador;
    
    private ArrayList<Mesa> mesas=new ArrayList<>();
    private boolean cargandoComboMesas=false;
    
    public AdministrarMesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.mesas=Fachada.getInstancia().getMesas();
        initComponents();
        controlador=new AdministrarMesaController(this);
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMontoTotalRecaudado = new javax.swing.JLabel();
        lblMesas = new javax.swing.JLabel();
        cmbMesas = new javax.swing.JComboBox();
        lblMesas2 = new javax.swing.JLabel();
        btnCrearMesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstMesas = new javax.swing.JList();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMontoTotalRecaudado.setText("Monto total recaudado:");

        lblMesas.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblMesas.setText("Mesas:");

        cmbMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMesasActionPerformed(evt);
            }
        });

        lblMesas2.setText("Mesas:");

        btnCrearMesa.setText("Crear mesa");
        btnCrearMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMesaActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(lstMesas);

        lblMensaje.setText("lblMensaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMontoTotalRecaudado)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMesas2)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnCrearMesa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lblMesas2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMontoTotalRecaudado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCrearMesa)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesasActionPerformed
        if(!cargandoComboMesas){
            Mesa selectedItem =(Mesa) cmbMesas.getSelectedItem();
            Mesa selectedMesa = (Mesa) selectedItem;
            MostrarManosJugadas mostrarManos = new MostrarManosJugadas(null, false, selectedMesa);
            mostrarManos.setVisible(true);
        }
    }//GEN-LAST:event_cmbMesasActionPerformed

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMesaActionPerformed
        CrearMesa crearmesa = new CrearMesa(null, false,this);
        crearmesa.setVisible(true);
        
        CargarCombo(mesas);
    }//GEN-LAST:event_btnCrearMesaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMesa;
    private javax.swing.JComboBox cmbMesas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMesas;
    private javax.swing.JLabel lblMesas2;
    private javax.swing.JLabel lblMontoTotalRecaudado;
    private javax.swing.JList lstMesas;
    // End of variables declaration//GEN-END:variables

    //cuando aprieto crear mesa esto deberia actualizar e combo.
    public void actualizarMesas() {
        this.mesas = Fachada.getInstancia().getMesas();
        CargarCombo(mesas);
        CargarDatosEnLista(mesas);
    }

    @Override
    public void mostrarTitulo(String mensaje) {
        setTitle(mensaje);
    }

    @Override
    public void mostrarMensajeExitoso(String mensaje) {
        lblMensaje.setText(mensaje);
        }

    @Override
    public void mostrarMensajeError(String mensaje) {

        lblMensaje.setText(mensaje);
    }

    @Override
    public void CargarDatosEnLista(ArrayList<Mesa> mesas) {
         List <String> datosMesas= new ArrayList<String>();
        for (Mesa mesa : mesas) {
            int numeroMano=0;
            if(mesa.getManoActual()!=null){
                       numeroMano= mesa.getNumeroManoActual();
            }
            //num mesa, cant Jugadores Req, Apuesta Base Jugadores Act:Mano, Apostado
            //Comisión, Recaudado Estado
            datosMesas.add("numero de mesa: "+ mesa.getNumeroMesa()+
                    " Cantidad de jugadores req: "+
            mesa.getCantidadJugadoresRequeridos()+
                    " Apuesta base: "+
            mesa.getApuestaBase()+
                    " Cantidad de jugadores actual: "+
            mesa.getCantidadJugadoresActual()+
                    " Mano actual: "+
            numeroMano+
                  " Monto total apostado: "+
            mesa.getMontoTotalApostado()+
                    " Comisión"+
            mesa.getComision()+
                    " Monto total recaudado: "+
            mesa.getMontoTotalRecaudado()+
                    " Estado de partida: "+
            mesa.getEstadoPartida());
        
        }
             lstMesas.setListData(datosMesas.toArray());

    }

    @Override
    public void CargarCombo(ArrayList<Mesa> mesas) {
        cmbMesas.removeAllItems();
        for (Mesa mesa : mesas) {
            cmbMesas.addItem(mesa);
        }
    }
    
}

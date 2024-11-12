
package pokerApp.uiMesas;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import pokerApp.Fachada.Fachada;
import pokerApp.juego.Mesa;

public class AdministrarMesa extends javax.swing.JDialog {

    
    private ArrayList<Mesa> mesas;
    
    public AdministrarMesa(java.awt.Frame parent, boolean modal, ArrayList<Mesa> mesas) {
        super(parent, modal);
        this.mesas=mesas;
        initComponents();
        CargarDatosEnLista();
        CargarCombo();
        
    }

    private AdministrarMesa(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCrearMesa)
                            .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMontoTotalRecaudado)
                                .addGap(121, 121, 121)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMesas2)
                                    .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMontoTotalRecaudado)
                    .addComponent(lblMesas2))
                .addGap(5, 5, 5)
                .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnCrearMesa)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesasActionPerformed

        Mesa selectedItem =(Mesa) cmbMesas.getSelectedItem();
        Mesa selectedMesa = (Mesa) selectedItem;
        MostrarManosJugadas mostrarManos = new MostrarManosJugadas(null, false, selectedMesa);
        mostrarManos.setVisible(true);
   
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMesasActionPerformed

    private void btnCrearMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMesaActionPerformed
        CrearMesa crearmesa = new CrearMesa(null, false,this);
        crearmesa.setVisible(true);
        
        CargarCombo();
    }//GEN-LAST:event_btnCrearMesaActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Fachada.getInstancia().getMesas();
                AdministrarMesa dialog = new AdministrarMesa(new javax.swing.JFrame(), true, Fachada.getInstancia().getMesas());
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
    private javax.swing.JComboBox cmbMesas;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMesas;
    private javax.swing.JLabel lblMesas2;
    private javax.swing.JLabel lblMontoTotalRecaudado;
    private javax.swing.JList lstMesas;
    // End of variables declaration//GEN-END:variables

    private void CargarDatosEnLista() {
        DefaultListModel<String> model = new DefaultListModel<>();
    
    // Itera sobre las mesas y añade los datos en el modelo de la lista
    for (Mesa mesa : mesas) {
        // Crea una representación de texto para cada mesa con sus atributos
        String row = String.format(
            "Mesa %d - Jugadores Req: %d, Apuesta Base: %.2f, Jugadores Act: %d, Mano: %d, Apostado: %.2f, Comisión: %.2f, Recaudado: %.2f, Estado: %s",
            mesa.getNumeroMesa(),
            mesa.getCantidadJugadoresRequeridos(),
            mesa.getApuestaBase(),
            mesa.getCantidadJugadoresActual(),
            mesa.getNumeroManoActual(),
            mesa.getMontoTotalApostado(),
            mesa.getComision(),
            mesa.getMontoTotalRecaudado(),
            mesa.getEstadoPartida()
        );
        
        // Añade la representación de texto de la mesa al modelo de la lista
        model.addElement(row);
           // Asigna el modelo al JList
        lstMesas.setModel(model);

        // Actualiza el texto de lblMontoTotalRecaudado
        lblMontoTotalRecaudado.setText("Monto total recaudado: " + Fachada.getInstancia().calcularMontoTotalRecaudado());

    }
    
 
        

    public void CargarCombo() {
        cmbMesas.removeAllItems();
        for (Mesa mesa : mesas) {
            cmbMesas.addItem(mesa);
        }
    }
    
    //cuando aprieto crear mesa esto deberia actualizar e combo.
    public void actualizarMesas() {
        this.mesas = Fachada.getInstancia().getMesas();
        CargarCombo();
        CargarDatosEnLista();
    }
    
}

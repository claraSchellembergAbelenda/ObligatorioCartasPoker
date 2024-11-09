
package pokerApp.uiMesas;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import pokerApp.Fachada.Fachada;
import pokerApp.juego.Mesa;

public class AdministrarMesa extends javax.swing.JDialog {

    
    private ArrayList<Mesa> mesas;
    
    public AdministrarMesa(java.awt.Frame parent, boolean modal, ArrayList<Mesa> mesas) {
        super(parent, modal);
        this.mesas=mesas;
        initComponents();
        CargarDatosEnTabla();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarMesas = new javax.swing.JTable();
        cmbMesas = new javax.swing.JComboBox();
        lblMesas2 = new javax.swing.JLabel();
        btnCrearMesa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMontoTotalRecaudado.setText("Monto total recaudado:");

        lblMesas.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblMesas.setText("Mesas:");

        tblListarMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListarMesas);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearMesa)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMontoTotalRecaudado)
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMesas2)
                            .addComponent(cmbMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnCrearMesa)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMesasActionPerformed

    Object selectedItem = cmbMesas.getSelectedItem();
    if (selectedItem instanceof Mesa) { // Verifica que selectedItem sea de tipo Mesa
        Mesa selectedMesa = (Mesa) selectedItem;
        MostrarManosJugadas mostrarManos = new MostrarManosJugadas(null, true, selectedMesa);
        mostrarManos.setVisible(true);
    } else {
        System.out.println("Elemento seleccionado no es de tipo Mesa.");
    }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMesas;
    private javax.swing.JLabel lblMesas2;
    private javax.swing.JLabel lblMontoTotalRecaudado;
    private javax.swing.JTable tblListarMesas;
    // End of variables declaration//GEN-END:variables

    private void CargarDatosEnTabla() {
DefaultTableModel model = (DefaultTableModel) tblListarMesas.getModel();
    model.setRowCount(0); // Limpiar la tabla

    for (Mesa mesa : mesas) {
        Object[] row = new Object[]{
            mesa.getNumeroMesa(),
            mesa.getCantidadJugadoresRequeridos(),
            mesa.getApuestaBase(),
            mesa.getCantidadJugadoresActual(),
            mesa.getNumeroManoActual(),
            mesa.getMontoTotalApostado(),
            mesa.getComision(),
            mesa.getMontoTotalRecaudado(),
            mesa.getEstadoPartida()
        };
        model.addRow(row);
    }
    lblMontoTotalRecaudado.setText("Monto total recaudado: " + Fachada.getInstancia().calcularMontoTotalRecaudado());
}
        

    private void CargarCombo() {
        cmbMesas.removeAllItems();
        for (Mesa mesa : mesas) {
            cmbMesas.addItem(mesa);
        }
    }
    
    //cuando aprieto crear mesa esto deberia actualizar e combo.
    public void actualizarMesas() {
        this.mesas = Fachada.getInstancia().getMesas();
        CargarCombo();
        CargarDatosEnTabla();
    }
    
}


package pokerApp.uiMesas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import pokerApp.juego.Mano;
import pokerApp.juego.Mesa;


public class MostrarManosJugadas extends javax.swing.JDialog {

    /**
     * Creates new form MostrarManosJugadas
     */
    Mesa mesaSeleccionada=null;
    public MostrarManosJugadas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarDatosEnTabla();
    }

    public MostrarManosJugadas(java.awt.Frame parent, boolean modal, Object selectedItem) {
        super(parent, modal);
        this.mesaSeleccionada=(Mesa)selectedItem;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblManos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblManos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblManos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MostrarManosJugadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MostrarManosJugadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MostrarManosJugadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MostrarManosJugadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MostrarManosJugadas dialog = new MostrarManosJugadas(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManos;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosEnTabla() {
        ArrayList<Mano> manos= this.mesaSeleccionada.getManosJugadas();
        DefaultTableModel model = (DefaultTableModel) tblManos.getModel();
        model.setRowCount(0); // Limpiar la tabla
        manos=mesaSeleccionada.cargarManos();
        for (Mano mano : manos) {
//            -Número de mano
//-Cantidad de jugadores participantes
//-Total apostado en la mano
//-Estado actual de la mano (*2)
//-Nombre del jugador ganador
//-Nombre de la figura con la que ganó
            Object[] row = new Object[]{
                mano.getCantJugadores(),
                mano.getPozoApuestas(),
                mano.getEstadoMano(),
                mano.getJugadorGanador(),
                mano.getFiguraGanadora()
            };
            model.addRow(row);
        }
        
    }
}

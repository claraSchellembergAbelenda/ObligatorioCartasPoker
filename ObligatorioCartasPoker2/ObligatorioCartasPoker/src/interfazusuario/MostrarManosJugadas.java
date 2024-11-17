
package interfazusuario;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelJuego.Mano;
import modelJuego.Mesa;


public class MostrarManosJugadas extends javax.swing.JDialog {

    
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
        cargarDatosEnTabla();
        setTitle("Manos jugadas en mano: "+ mesaSeleccionada.getNumeroMesa());
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




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblManos;
    // End of variables declaration//GEN-END:variables

    private void cargarDatosEnTabla() {
        DefaultTableModel model = (DefaultTableModel) tblManos.getModel();
        model.setRowCount(0); // Limpiar la tabla

        ArrayList<Mano> manos = mesaSeleccionada.getManos();
        System.out.println("Número de manos en mesa seleccionada: " + manos.size());

        if (manos.isEmpty()) {
            System.out.println("La mesa seleccionada no tiene manos jugadas.");
        } else {
            for (Mano mano : manos) {
                Object[] row = new Object[]{
                    mano.getNumeroMano(),
                    mano.getCantJugadores(),
                    mano.getPozoApuestas(),
                    mano.getEstadoMano(),
                    mano.getJugadorGanador() != null ? mano.getJugadorGanador().getNombreCompleto() : "Sin ganador",
                    mano.getFiguraGanadora() != null ? mano.getFiguraGanadora().getNombre() : "Sin figura ganadora"
                };
                model.addRow(row);
            }
        }
    }



}

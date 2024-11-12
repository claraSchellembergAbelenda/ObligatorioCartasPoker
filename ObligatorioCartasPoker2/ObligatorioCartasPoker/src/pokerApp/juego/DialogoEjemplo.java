package pokerApp.juego;

import java.util.ArrayList;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;


public class DialogoEjemplo extends javax.swing.JDialog implements PanelCartasListener {

    
    public DialogoEjemplo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        //OJO: Layaout = null, Generate resize code
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartasPoker1 = new panelCartasPoker.PanelCartasPoker();
        lblMensaje = new javax.swing.JLabel();
        habilitarPanel = new javax.swing.JCheckBox();
        checkListener = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EJEMPLO PANEL DE CARTAS POKER");
        getContentPane().setLayout(null);
        getContentPane().add(panelCartasPoker1);
        panelCartasPoker1.setBounds(41, 92, 910, 257);

        lblMensaje.setText("EL PANEL ES EL QUE ESTA AQUI ABAJO :=)");
        getContentPane().add(lblMensaje);
        lblMensaje.setBounds(393, 33, 270, 16);

        habilitarPanel.setSelected(true);
        habilitarPanel.setText("Habilitar Panel");
        habilitarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habilitarPanelActionPerformed(evt);
            }
        });
        getContentPane().add(habilitarPanel);
        habilitarPanel.setBounds(447, 396, 150, 20);

        checkListener.setText("Escuchar clicks del panel");
        checkListener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkListenerActionPerformed(evt);
            }
        });
        getContentPane().add(checkListener);
        checkListener.setBounds(447, 434, 210, 20);

        setBounds(0, 0, 1045, 514);
    }// </editor-fold>//GEN-END:initComponents

    private void habilitarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habilitarPanelActionPerformed
        // TODO add your handling code here:
        panelCartasPoker1.setEnabled(habilitarPanel.isSelected());
    }//GEN-LAST:event_habilitarPanelActionPerformed

    private void checkListenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkListenerActionPerformed
        // TODO add your handling code here:
        if(checkListener.isSelected()){
            panelCartasPoker1.setListener(this);
        }else panelCartasPoker1.setListener(null);
    }//GEN-LAST:event_checkListenerActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkListener;
    private javax.swing.JCheckBox habilitarPanel;
    private javax.swing.JLabel lblMensaje;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker1;
    // End of variables declaration//GEN-END:variables

   public void cargarCartas(ArrayList<CartaPoker> cartas){
        try {
            panelCartasPoker1.cargarCartas(cartas);
        } catch (PanelCartasPokerException ex) {
            lblMensaje.setText("Error: "+ ex.getMessage());
        }
   }
      
   

    @Override
    public void clickEnCarta(CartaPoker carta) {
        lblMensaje.setText( carta.toString());
    }
}

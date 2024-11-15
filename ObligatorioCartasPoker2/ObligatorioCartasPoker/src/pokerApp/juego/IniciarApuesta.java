
package pokerApp.juego;

import pokerApp.listeners.ApuestaListener;
import dominiousuario.Jugador;


public class IniciarApuesta extends javax.swing.JDialog {

    private float apuesta;
    private Jugador jugador;
    private ApuestaListener apuestaListener;


    public IniciarApuesta(java.awt.Frame parent, boolean modal, Jugador jugador) {
        super(parent, modal);
        initComponents();
        apuesta = 0; // Inicializa la apuesta
        this.jugador=jugador;
        

    }
    public IniciarApuesta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        apuesta = 0; // Inicializa la apuesta

    }
    
    public void setApuestaListener(ApuestaListener apuestaListener){
        this.apuestaListener=apuestaListener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApuesta = new javax.swing.JTextField();
        btnConfirmar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("INGRESE EL MONTO A APOSTAR:");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblMensaje.setText("aqui se verá un mensaje de respuesta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        confirmarApuesta();
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtApuesta;
    // End of variables declaration//GEN-END:variables

    public void confirmarApuesta() {
            float monto = obtenerMontoIngresado();
            if(monto<=0){
                lblMensaje.setText("Debe ingresar un numero mayor a 0");
                txtApuesta.setText("");
            }else{
                    if(apuestaListener==null){
                        System.out.println("apuesta listener es null, hay que configurarla en otro lado");
                     }else{
                        apuestaListener.apuestaIngresada(monto);
                    }   
            }
            dispose();
    }
    public float obtenerMontoIngresado(){
        try{
            apuesta = Float.parseFloat(txtApuesta.getText()); // Captura el valor de la apuesta
            return apuesta;
        }
        catch(NumberFormatException nfe){
            lblMensaje.setText("Ingrese un monto válido.");
        }
        return 0;
    }
    
    public float getApuesta() {
        // Retorna el valor ingresado por el usuario en el diálogo,
        //tengo que capturar este valor
        confirmarApuesta();
        return apuesta;
    }
    
    
}

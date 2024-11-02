package pokerApp.iu;

import javax.swing.JOptionPane;
import pokerApp.usuarios.Sesion;
import pokerApp.Fachada.Fachada;
import pokerApp.usuarios.Usuario;

public class Login extends javax.swing.JDialog {

    private Fachada fachada;
    private Sesion sesionActiva; 

    public Login(java.awt.Frame parent, boolean modal, Fachada fachada) {
        super(parent, modal);
        this.fachada = fachada;
        initComponents();
        setLocationRelativeTo(parent); // Centra el formulario
        btnLogin.setEnabled(true);
    }

   public Sesion getSesionActiva(){
       return sesionActiva;
   }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pwdPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bienvenido a JugarPokeruy");
        setBackground(new java.awt.Color(153, 0, 51));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnLogin.setBackground(new java.awt.Color(153, 0, 0));
        btnLogin.setFont(new java.awt.Font("PT Serif", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 204, 0));
        btnLogin.setText("Ingresar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblUsuario.setFont(new java.awt.Font("PT Serif", 1, 14)); // NOI18N
        lblUsuario.setText("Ingrese su usuario:");

        lblPassword.setFont(new java.awt.Font("PT Serif", 1, 14)); // NOI18N
        lblPassword.setText("Ingrese su contraseña:");

        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        pwdPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdPassword)
                            .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnLogin)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblUsuario)
                .addGap(18, 18, 18)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblPassword)
                .addGap(18, 18, 18)
                .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed
     
    private void login() {
        String username = txtUsuario.getText();
        String password = new String(pwdPassword.getPassword());

        if (username.isBlank() || password.isBlank()) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, complete todos los campos.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        Sesion sesion = fachada.login(username, password);  // Devuelve una Sesion

        if (sesion != null) {
            JOptionPane.showMessageDialog(this, "Bienvenido " + sesion.getUsuario().getNombreCompleto(), "Acceso concedido", JOptionPane.INFORMATION_MESSAGE);
            sesionActiva = sesion; // Guardamos la sesión activa
            dispose(); // Cierra el diálogo de login

            // Redirigir a la interfaz adecuada
            if (sesion.esAdministrador()) {
                AdministradorUI adminUI = new AdministradorUI(sesion);
                adminUI.setVisible(true);
            } else if (sesion.esJugador()) {
                JugadorUI jugadorUI = new JugadorUI(null, false, sesion);
                jugadorUI.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(
                this,
                "Usuario y/o password incorrectos o ya logueado",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

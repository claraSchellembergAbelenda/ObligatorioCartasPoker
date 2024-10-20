package iu;

import javax.swing.JOptionPane;
import pokerApp.usuarios.Sesion;
import pokerApp.Sistemas.Fachada;
import pokerApp.usuarios.Usuario;

public class Principal extends javax.swing.JFrame {

    private Fachada fachada;
    private Sesion sesion;

    public Principal(Sesion sesion) {
        initComponents();
        this.sesion = sesion; // Guardamos la sesión activa
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuItemLogin = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuItemLogin.setText("Opciones");

        jMenuItem1.setText("Login");
        menuItemLogin.add(jMenuItem1);

        jMenuBar1.add(menuItemLogin);

        jMenu2.setText("Salir");

        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemSalirActionPerformed

private void mnuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        salir();
    }

    private void salir() {
        int opcion = JOptionPane.showConfirmDialog(this, "¿Desea salir?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Fachada fachada = new Fachada();
        
        Login login = new Login(null, true, fachada);
        login.setVisible(true);

        Sesion sesionActiva = login.getSesionActiva();
        if (sesionActiva != null) {
            Principal principal = new Principal(sesionActiva);
            principal.setVisible(true);
        } else {
            System.exit(0); // Si el login no es exitoso, se cierra la aplicación
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuItemLogin;
    private javax.swing.JMenuItem menuItemSalir;
    // End of variables declaration//GEN-END:variables
}

package pokerApp.iu;

import javax.swing.*;
import pokerApp.usuarios.Sesion;

public class JugadorUI extends JFrame {

    private Sesion sesion;

    public JugadorUI(Sesion sesion) {
        this.sesion = sesion;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Jugador - " + sesion.getUsuario().getNombreCompleto());
    }

    private void initComponents() {
        JLabel label = new JLabel("Bienvenido, Jugador " + sesion.getUsuario().getNombreCompleto());
        JButton btnIngresarMesa = new JButton("Ingresar a una Mesa");

        btnIngresarMesa.addActionListener(evt -> ingresarMesa());

        // Layout y otros componentes
        add(label);
        add(btnIngresarMesa);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void ingresarMesa() {
        // Lógica para ingresar a una mesa
        // aca hacemos o llamamos a la funcion 
        JOptionPane.showMessageDialog(this, "Ingresando a una mesa...");
    }
}
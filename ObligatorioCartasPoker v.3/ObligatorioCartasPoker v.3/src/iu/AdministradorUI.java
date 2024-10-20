package iu;

import javax.swing.*;
import pokerApp.Sesion;

public class AdministradorUI extends JFrame {

    private Sesion sesion;

    public AdministradorUI(Sesion sesion) {
        this.sesion = sesion;
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Administrador - " + sesion.getUsuario().getNombreCompleto());
    }

    private void initComponents() {
        JLabel label = new JLabel("Bienvenido, Administrador " + sesion.getUsuario().getNombreCompleto());
        JButton btnAdministrarMesas = new JButton("Administrar Mesas");
        JButton btnCrearMesa = new JButton("Crear Nueva Mesa");

        btnAdministrarMesas.addActionListener(evt -> mostrarMesas());
        btnCrearMesa.addActionListener(evt -> crearMesa());

        // Layout y otros componentes
        add(label);
        add(btnAdministrarMesas);
        add(btnCrearMesa);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void mostrarMesas() {
        // Lógica para mostrar mesas
        JOptionPane.showMessageDialog(this, "Mostrando mesas...");
    }

    private void crearMesa() {
        // Lógica para crear mesa
        JOptionPane.showMessageDialog(this, "Creando nueva mesa...");
    }
}
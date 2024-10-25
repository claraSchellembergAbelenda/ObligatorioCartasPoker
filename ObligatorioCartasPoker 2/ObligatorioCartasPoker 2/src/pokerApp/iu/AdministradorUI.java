package pokerApp.iu;

import java.util.ArrayList;
import javax.swing.*;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Sesion;

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

        btnAdministrarMesas.addActionListener(evt -> administrarMesas());
        btnCrearMesa.addActionListener(evt -> crearMesa());

        // Layout y otros componentes
        add(label);
        add(btnAdministrarMesas);
        add(btnCrearMesa);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }

    private void administrarMesas() {
        //creamos un arraylisg de mesas cargadas
        ArrayList<Mesa> mesasAdministrar = new ArrayList<>();
        AdministrarMesa adminMesas = new AdministrarMesa(null,false, mesasAdministrar);
        
    }

    private void crearMesa() {
        // Lógica para crear mesa, podria abrirnos un form y lo llena ahi 
        
        
        JOptionPane.showMessageDialog(this, "Creando nueva mesa...");
    }
}
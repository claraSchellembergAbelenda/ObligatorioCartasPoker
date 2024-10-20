package pokerApp.Sistemas;

import java.util.ArrayList;
import java.util.List;
import pokerApp.Administrador;
import pokerApp.Jugador;
import pokerApp.Usuario;

public class SistemaUsuario {
    private List<Administrador> administradores;
    private List<Jugador> jugadores;

    public SistemaUsuario() {
        administradores = new ArrayList<>();
        jugadores = new ArrayList<>();
        precargarUsuarios();
    }

    // Método de precarga
    private void precargarUsuarios() {
        administradores.add(new Administrador("100", "100", "A 100"));
        administradores.add(new Administrador("200", "101", "A 200"));

        jugadores.add(new Jugador("52940836", "maxi1234", "Maximiliano", 0));
        jugadores.add(new Jugador("12345678", "clara1234", "Clara", 1000));
        jugadores.add(new Jugador("2", "2", "J2", 2000));
        jugadores.add(new Jugador("3", "3", "J3", 3000));
        jugadores.add(new Jugador("4", "4", "J4", 4000));
        jugadores.add(new Jugador("5", "5", "J5", 5000));
        jugadores.add(new Jugador("6", "6", "J6", 6000));
        jugadores.add(new Jugador("7", "7", "J7", 7000));
        jugadores.add(new Jugador("8", "8", "J8", 8000));
        jugadores.add(new Jugador("9", "9", "J9", 9000));
    }

    // Método de login
    public Usuario login(String cedula, String password) {
        for (Administrador admin : administradores) {
            if (admin.getCedula().equals(cedula) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        for (Jugador jugador : jugadores) {
            if (jugador.getCedula().equals(cedula) && jugador.getPassword().equals(password)) {
                return jugador;
            }
        }
        return null; // Usuario no encontrado
    }
}
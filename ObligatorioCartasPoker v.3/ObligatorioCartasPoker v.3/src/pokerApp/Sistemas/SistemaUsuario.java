package pokerApp.Sistemas;

import java.util.ArrayList;
import java.util.List;
import pokerApp.Administrador;
import pokerApp.Jugador;
import pokerApp.Sesion;
import pokerApp.Usuario;

public class SistemaUsuario {
    private List<Usuario> usuarios;
    private List<Sesion> sesionesActivas;

    public SistemaUsuario() {
        usuarios = new ArrayList<>();
        sesionesActivas = new ArrayList<>();
        precargarUsuarios();
    }

    // Método de precarga
    private void precargarUsuarios() {
        usuarios.add(new Administrador("100", "100", "A 100"));
        usuarios.add(new Administrador("200", "101", "A 200"));

        usuarios.add(new Jugador("52940836", "maxi1234", "Maximiliano", 0));
        usuarios.add(new Jugador("12345678", "clara1234", "Clara", 1000));
        usuarios.add(new Jugador("2", "2", "J2", 2000));
        usuarios.add(new Jugador("3", "3", "J3", 3000));
        usuarios.add(new Jugador("4", "4", "J4", 4000));
        usuarios.add(new Jugador("5", "5", "J5", 5000));
        usuarios.add(new Jugador("6", "6", "J6", 6000));
        usuarios.add(new Jugador("7", "7", "J7", 7000));
        usuarios.add(new Jugador("8", "8", "J8", 8000));
        usuarios.add(new Jugador("9", "9", "J9", 9000));
    }

    // Método de login 
    public Sesion login(String cedula, String password){
        Usuario usuario = buscarUsuario(cedula, password);
        if(usuario != null && !estaLogueado(usuario)){
            Sesion nuevaSesion = new Sesion(usuario);
            sesionesActivas.add(nuevaSesion);
            return nuevaSesion;
        } else if (usuario != null && estaLogueado(usuario)){
            System.out.println("El usuario ya está logueado");
        }
        return null;
    }
    
    private Usuario buscarUsuario(String cedula, String password){
        for (Usuario usuario : usuarios) {
            if(usuario.getCedula().equals(cedula) && usuario.getPassword().equals(password)){
                return usuario;
            }
        }
        return null;
    }
    
    private boolean estaLogueado(Usuario usuario) {
        for (Sesion sesion : sesionesActivas) {
            if (sesion.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }

    public void logout(Sesion sesion) {
        sesionesActivas.remove(sesion);
        System.out.println("El usuario " + sesion.getUsuario().getNombreCompleto() + " ha cerrado sesión.");
    }
}
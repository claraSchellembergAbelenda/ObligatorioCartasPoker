package modelUsuario;

import java.util.ArrayList;
import java.util.List;
import modelJuego.Mesa;
import modelUsuario.Administrador;
import modelUsuario.Jugador;
import modelUsuario.Sesion;
import modelUsuario.Usuario;

public class SistemaUsuario {
    private List<Administrador> usuariosAdministradores;
    private List<Jugador> usuariosJugadores;
    private List<Sesion> sesionesActivas;

    public SistemaUsuario() {
        usuariosAdministradores = new ArrayList<>();
        usuariosJugadores = new ArrayList<>();
        sesionesActivas = new ArrayList<>();
        precargarUsuarios();
    }

    // Método de precarga
    public void precargarUsuarios() {
        //admins
        usuariosAdministradores.add(new Administrador("100", "100", "A 100"));
        usuariosAdministradores.add(new Administrador("200", "101", "A 200"));
        //users
        usuariosJugadores.add(new Jugador("0", "0", "J0", 1000));
        usuariosJugadores.add(new Jugador("1", "1", "J1", 1000));
        usuariosJugadores.add(new Jugador("2", "2", "J2", 2000));
        usuariosJugadores.add(new Jugador("3", "3", "J3", 3000));
        usuariosJugadores.add(new Jugador("4", "4", "J4", 4000));
        usuariosJugadores.add(new Jugador("5", "5", "J5", 5000));
        usuariosJugadores.add(new Jugador("6", "6", "J6", 6000));
        usuariosJugadores.add(new Jugador("7", "7", "J7", 7000));
        usuariosJugadores.add(new Jugador("8", "8", "J8", 8000));
        usuariosJugadores.add(new Jugador("9", "9", "J9", 9000));
        //personalizados
        usuariosJugadores.add(new Jugador("52940836", "maxi1234", "Maximiliano", 9000));
        usuariosJugadores.add(new Jugador("12345678", "clara1234", "Clara", 2000));
    }

    // Métodos de login
    public Sesion loginAdministrador(String cedula, String password) throws UsuarioException {
        Sesion sesion= login(cedula, password, usuariosAdministradores);
        if (sesion != null) {
            if(!estaLogueado(sesion.getUsuario())){
                sesionesActivas.add(sesion);
            }else{
                throw new UsuarioException("Acceso denegado. El usuario ya esta logueado");
            }
        }
        
        return sesion;
    }
    
    public Sesion loginJugador(String cedula, String password) throws UsuarioException{
        Sesion sesion = login(cedula, password, usuariosJugadores);
        if (sesion != null) {
            if(!estaLogueado(sesion.getUsuario())){
                sesionesActivas.add(sesion);
            }else{
                throw new UsuarioException("Acceso denegado. El usuario ya esta logueado");
            }
        }
        
        return sesion;
    }
    
    public Sesion login(String cedula, String password, List usuarios) throws UsuarioException {
        Usuario usuario;
        for (Object usuarioObj : usuarios) {
            usuario =(Usuario)usuarioObj;
            if(usuario.validarLogin(cedula, password)){
                Sesion sesion= new Sesion(usuario);
                return sesion;
            }
        }
        throw new UsuarioException("Credenciales incorrectas");
       
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

   

    public void validarSaldoJugador(Jugador jugador, Mesa mesaSeleccionada) 
            throws UsuarioException{
        jugador.validarSaldo(mesaSeleccionada);
    }

    
    
}
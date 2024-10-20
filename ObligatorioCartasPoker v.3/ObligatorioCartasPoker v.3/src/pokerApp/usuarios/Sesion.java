package pokerApp.usuarios;

import pokerApp.usuarios.Jugador;
import pokerApp.usuarios.Administrador;
import java.util.Date;

public class Sesion {
    private Usuario usuario;
    private Date fechaIngreso;

    public Sesion(Usuario usuario){
        this.usuario = usuario;
        this.fechaIngreso = new Date();
    }

    public Usuario getUsuario(){
        return usuario;
    }
    
    public Date getFechaIngreso(){
        return fechaIngreso;
    }

    // Verifica si el usuario es administrador
    public boolean esAdministrador() {
        return usuario instanceof Administrador;
    }

    // Verifica si el usuario es jugador
    public boolean esJugador() {
        return usuario instanceof Jugador;
    }
}
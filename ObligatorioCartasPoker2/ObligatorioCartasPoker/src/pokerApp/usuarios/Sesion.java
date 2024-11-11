package pokerApp.usuarios;

import pokerApp.usuarios.Usuario;
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

}
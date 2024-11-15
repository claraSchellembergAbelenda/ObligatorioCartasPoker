package dominiousuario;

import dominiousuario.Jugador;
import dominiousuario.Administrador;
import java.util.Date;

public class Sesion {
    private Usuario usuario;
    private Date fechaIngreso;
    private boolean existe=false;

    public Sesion(Usuario usuario){
        this.usuario = usuario;
        this.fechaIngreso = new Date();
        this.existe=true;
    }

    public Usuario getUsuario(){
        return usuario;
    }
    
    public Date getFechaIngreso(){
        return fechaIngreso;
    }
    
    public boolean haySesionAbierta(){
        return existe;
    }

}
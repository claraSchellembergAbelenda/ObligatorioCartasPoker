
package pokerApp.usuarios;

import inicio.Principal;
import pokerApp.uiMesas.IngresarAMesa;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Fachada.Fachada;
import pokerApp.listeners.SesionListener;
import pokerApp.uiUsuariosYLogin.Login;
import pokerApp.usuarios.Jugador;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


public class LoginJugador extends Login {
    
    private SesionListener sesionListener;
    private Sesion sesion;
    public LoginJugador(Frame parent, boolean modal, Fachada fachada) {
        super(parent, modal, fachada);
    }
    public Sesion getSesion(){
        return sesion;
    }

    @Override
    public Sesion login(String username, String password) throws UsuarioException{
         sesion =Fachada.getInstancia().loginJugador(username, password);
         return sesion;
    }

    @Override
    public void mostrarProximaInterfaz(Usuario usuario) {
        if(sesionListener!=null){
            sesionListener.sesionIniciada();
        }
        IngresarAMesa ingresarAMesa = new IngresarAMesa(null, false,(Jugador)usuario);
        ingresarAMesa.setVisible(true);
    }

    public void setSesionListener(SesionListener sesionListener) {
        this.sesionListener=sesionListener;
    }
    
    
    
}

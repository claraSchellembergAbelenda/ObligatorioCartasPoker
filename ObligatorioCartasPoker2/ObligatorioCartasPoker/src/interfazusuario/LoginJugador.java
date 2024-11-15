
package interfazusuario;

import pokerApp.uiMesas.IngresarAMesa;
import java.awt.Frame;
import dominiousuario.UsuarioException;
import dominio.Fachada.Fachada;
import dominiousuario.Jugador;
import dominiousuario.Sesion;
import dominiousuario.Usuario;


public class LoginJugador extends Login {
    
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
        IngresarAMesa ingresarAMesa = new IngresarAMesa(null, false,(Jugador)usuario);
        ingresarAMesa.setVisible(true);
    }

    
    
    
}


package pokerApp.iu;

import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Fachada.Fachada;
import pokerApp.usuarios.Jugador;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


public class LoginJugador extends Login {

    public LoginJugador(Frame parent, boolean modal, Fachada fachada) {
        super(parent, modal, fachada);
    }

    @Override
    public Sesion login(String username, String password) throws UsuarioException{
         return Fachada.getInstancia().loginJugador(username, password);
      
    }

    @Override
    public void mostrarProximaInterfaz(Usuario usuario) {
        JugadorUI jugadorUi = new JugadorUI(null, false,(Jugador)usuario);
        jugadorUi.setVisible(true);
    }
    
}

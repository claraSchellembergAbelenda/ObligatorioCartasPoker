package interfazusuario;

import java.awt.Frame;
import modelUsuario.UsuarioException;
import modelFachada.Fachada;
import modelUsuario.Sesion;
import modelUsuario.Usuario;


public class LoginAdministrador extends Login {

    public LoginAdministrador(Frame parent, boolean modal, Fachada fachada) {
        super(parent, modal, fachada);
    }

    @Override
    public Sesion login(String username, String password)throws UsuarioException {
        return Fachada.getInstancia().loginAdministrador(username, password);
    }

    @Override
    public void mostrarProximaInterfaz(Usuario usuario) {
        AdministrarMesa administrarMesa = new AdministrarMesa(null, false);
        administrarMesa.setVisible(true);
    }
    
}

package pokerApp.uiUsuariosYLogin;

import pokerApp.uiUsuariosYLogin.Login;
import pokerApp.uiMesas.AdministrarMesa;
import java.awt.Frame;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Fachada.Fachada;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


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
        AdministrarMesa administrarMesa = new AdministrarMesa(null, false, 
                Fachada.getInstancia().getMesas());
        administrarMesa.setVisible(true);
    }
    
}

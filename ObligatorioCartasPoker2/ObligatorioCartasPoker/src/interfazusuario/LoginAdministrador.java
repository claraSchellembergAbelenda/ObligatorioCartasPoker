package interfazusuario;

import pokerApp.uiMesas.AdministrarMesa;
import java.awt.Frame;
import dominiousuario.UsuarioException;
import dominio.Fachada.Fachada;
import dominiousuario.Sesion;
import dominiousuario.Usuario;


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

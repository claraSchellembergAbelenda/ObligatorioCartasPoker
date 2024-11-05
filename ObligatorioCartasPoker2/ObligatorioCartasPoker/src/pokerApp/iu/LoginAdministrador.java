/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokerApp.iu;

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

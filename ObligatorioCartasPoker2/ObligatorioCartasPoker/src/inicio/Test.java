
package inicio;

import pokerApp.Fachada.Fachada;
import pokerApp.uiUsuariosYLogin.Login;
import pokerApp.uiUsuariosYLogin.LoginAdministrador;
import pokerApp.usuarios.LoginJugador;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


public class Test {
 
    public static void main(String[] args){
        DatosPrueba.cargar();
        LoginJugador login = new LoginJugador(null, false, Fachada.getInstancia());
        login.setVisible(true);
    }
}

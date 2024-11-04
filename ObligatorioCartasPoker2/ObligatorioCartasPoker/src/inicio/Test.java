
package inicio;

import pokerApp.Fachada.Fachada;
import pokerApp.iu.Login;
import pokerApp.iu.LoginAdministrador;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


public class Test {
 
    public static void main(String[] args){
        DatosPrueba.cargar();
        LoginAdministrador login = new LoginAdministrador(null, false, Fachada.getInstancia());
        login.setVisible(true);
    }
}

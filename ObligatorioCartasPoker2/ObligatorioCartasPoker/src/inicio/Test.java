
package inicio;

import pokerApp.Fachada.Fachada;
import pokerApp.iuJuego.PanelDeCartas;
import pokerApp.uiUsuariosYLogin.Login;
import pokerApp.uiUsuariosYLogin.LoginAdministrador;
import pokerApp.uiUsuariosYLogin.LoginJugador;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;


public class Test {
 
    public static void main(String[] args){
        DatosPrueba.cargar();
        Principal principal = new Principal();
        principal.setVisible(true);
        
    }
}

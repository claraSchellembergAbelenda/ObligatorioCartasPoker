package modelFachada;

import java.util.ArrayList;
import modelCartasYFiguras.SistemaFiguras;
import modelUsuario.SistemaUsuario;
import java.util.List;
import modelJuego.MesaException;
import modelUsuario.UsuarioException;
import modelCartasYFiguras.SistemaFiguras;
import modelJuego.SistemaMesa;
import modelUsuario.SistemaUsuario;
import modelCartasYFiguras.Carta;
import modelCartasYFiguras.Figura;
import modelCartasYFiguras.TipoFigura;
import modelUsuario.Jugador;
import modelJuego.Mesa;
import modelUsuario.Sesion;
import modelUsuario.Usuario;
//anduvo
public class Fachada {

    private static Fachada instancia = new Fachada();
    private SistemaUsuario sistemaUsuario;
    private SistemaFiguras sistemaFiguras;
    private SistemaMesa sistemaMesa;

    

    public Fachada() {
        sistemaUsuario = new SistemaUsuario();
        sistemaFiguras = new SistemaFiguras();
        sistemaMesa = new SistemaMesa();
        
    }
    
    public static Fachada getInstancia() {
        return instancia;
    }

    // Método de login simplificado
    public Sesion loginAdministrador(String username, String password) throws UsuarioException {
        return sistemaUsuario.loginAdministrador(username, password);
    }
    public Sesion loginJugador(String username, String password) throws UsuarioException {
        return sistemaUsuario.loginJugador(username, password);
    }

    
    
    // Obtener las figuras disponibles (Elimina uno de los métodos duplicados)
    public List<TipoFigura> getFiguras() {
        return sistemaFiguras.getFiguras();
    }

    // Método para comparar figuras sin lógica adicional en Fachada
    public TipoFigura compararFiguras(List<TipoFigura> figuras) {
        return sistemaFiguras.compararFiguras(figuras);  // Llama a SistemaFiguras para la comparación
    }



    public ArrayList<Mesa> getMesas() {
        return sistemaMesa.getMesas();
    }
    
    
    public ArrayList<Mesa> obtenerMesasAbiertas() {
        return sistemaMesa.obtenerMesasAbiertas();
    }
   

    public void setMesas(ArrayList<Mesa> mesas) {
        sistemaMesa.setMesas(mesas);
    }

    public void inicializarJuego() {
        sistemaMesa.inicializarJuego();
    }

    public void crearMesa(int jugadoresRequeridos, float apuestaBase, float comision) throws MesaException {
        sistemaMesa.crearMesa(jugadoresRequeridos, apuestaBase, comision);
    }

    public void cargarUsuarios() {
        sistemaUsuario.precargarUsuarios();
                
    }

    public void precargaMesas() {
        sistemaMesa.precargaMesas();
    }

    public void validarSaldoDeJugador(Jugador jugador, Mesa mesaSeleccionada) throws UsuarioException{
        sistemaUsuario.validarSaldoJugador(jugador, mesaSeleccionada);
    }

    public void precargarJugadoresMesa(Mesa mesa, Jugador jugador){
        sistemaMesa.agregarJugador(mesa, jugador);
    }

    public float calcularMontoTotalRecaudado(){
        return sistemaMesa.calcularMontoTotalRecaudado();
    }

    public void precargarFiguras() {
        sistemaFiguras.precargarFiguras();
    }

    public TipoFigura determinarFigura(List<Carta> cartas) {
        return sistemaFiguras.determinarFigura(cartas);
    }
    
    
}
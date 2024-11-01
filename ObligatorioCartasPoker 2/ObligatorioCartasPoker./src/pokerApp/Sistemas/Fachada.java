package pokerApp.Sistemas;

import java.util.ArrayList;
import pokerApp.Sistemas.SistemaFiguras;
import pokerApp.Sistemas.SistemaUsuario;
import java.util.List;
import pokerApp.figurasYCartas.Figura;
import pokerApp.figurasYCartas.TipoFigura;
import pokerApp.usuarios.Jugador;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Sesion;
import pokerApp.usuarios.Usuario;

public class Fachada {

    private static Fachada instancia = new Fachada();
    private SistemaUsuario sistemaUsuario;
    private SistemaFiguras sistemaFiguras;
    private SistemaManos sistemaManos;
    private SistemaMesa sistemaMesa;
    

    
    public String crearMesa(int jugadores, float apuestaBase, float comision) {
        return sistemaMesa.crearMesa(jugadores, apuestaBase, comision);
    }

    public Fachada() {
        sistemaUsuario = new SistemaUsuario();
        sistemaFiguras = new SistemaFiguras();
        sistemaMesa = new SistemaMesa();
        sistemaManos = new SistemaManos();
        
    }
    
    public static Fachada getInstancia() {
        return instancia;
    }

    // Método de login simplificado
    public Sesion login(String cedula, String password) {
        return sistemaUsuario.login(cedula, password);
    }

    // Obtener las figuras disponibles (Elimina uno de los métodos duplicados)
    public List<TipoFigura> getFiguras() {
        return sistemaFiguras.getFiguras();
    }

    // Método para comparar figuras sin lógica adicional en Fachada
    public TipoFigura compararFiguras(List<TipoFigura> figuras) {
        return sistemaFiguras.compararFiguras(figuras);  // Llama a SistemaFiguras para la comparación
    }

    public void inicializarMano() {
        sistemaManos.inicializarMano();
    }

    public void realizarApuestas() {
        sistemaManos.realizarApuestas();
    }

    public void cambiarCartas() {
        sistemaManos.cambiarCartas();
    }

    public void determinarGanador() {
        sistemaManos.determinarGanador();
    }

    public void finalizarMano() {
        sistemaManos.finalizarMano();
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

    


    

}
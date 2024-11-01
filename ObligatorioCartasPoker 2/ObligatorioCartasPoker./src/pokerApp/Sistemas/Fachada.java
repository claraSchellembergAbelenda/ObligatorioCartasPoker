package pokerApp.Sistemas;

import java.util.ArrayList;
import pokerApp.Sistemas.SistemaFiguras;
import pokerApp.Sistemas.SistemaUsuario;
import java.util.List;
import pokerApp.figurasYCartas.Figura;
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

    // Obtener las figuras disponibles
    public List<Figura> obtenerFiguras() {
        return sistemaFiguras.getFiguras();
    }

    public List<Figura> getFiguras() {
        return sistemaFiguras.getFiguras();
    }

    public Figura compararFiguras(ArrayList<Figura> figuras) {
        return sistemaFiguras.compararFiguras(figuras);
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
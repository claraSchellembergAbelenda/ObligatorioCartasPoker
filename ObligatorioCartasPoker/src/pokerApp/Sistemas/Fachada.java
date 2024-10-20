package pokerApp.Sistemas;

import java.util.ArrayList;
import pokerApp.Sistemas.SistemaFiguras;
import pokerApp.Sistemas.SistemaUsuario;
import java.util.List;
import pokerApp.Figura;
import pokerApp.Jugador;
import pokerApp.Mesa;
import pokerApp.Usuario;

public class Fachada {

    private SistemaUsuario sistemaUsuario;
    private SistemaFiguras sistemaFiguras;
    private SistemaManos sistemaManos;
    private SistemaMesa sistemaMesa;
    
  

    public Fachada() {
        sistemaUsuario = new SistemaUsuario();
        sistemaFiguras = new SistemaFiguras();
        
    }

    // Método de login simplificado
    public Usuario login(String cedula, String password) {
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

    public void setMesas(ArrayList<Mesa> mesas) {
        sistemaMesa.setMesas(mesas);
    }

    public void inicializarJuego() {
        sistemaMesa.inicializarJuego();
    }

    public void agregarJugador(Jugador j) {
        sistemaMesa.agregarJugador(j);
    }

    public void removerJugador(Jugador j) {
        sistemaMesa.removerJugador(j);
    }

    public void finalizarJuego() {
        sistemaMesa.finalizarJuego();
    }

    public void calcularPozoTotal() {
        sistemaMesa.calcularPozoTotal();
    }

    public void reiniciarMesa() {
        sistemaMesa.reiniciarMesa();
    }

    public void determinarGanadorFinal() {
        sistemaMesa.determinarGanadorFinal();
    }

    

}
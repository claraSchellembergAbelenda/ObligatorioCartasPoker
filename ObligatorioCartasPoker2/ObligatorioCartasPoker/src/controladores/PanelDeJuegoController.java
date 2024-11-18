
package controladores;

import estados.EstadoMano;
import interfazusuario.IngresarAMesa;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelCartasYFiguras.Carta;
import modelCartasYFiguras.TipoFigura;
import modelFachada.Fachada;
import modelJuego.JuegoPoker;
import modelJuego.ManoException;
import modelJuego.Mesa;
import modelJuego.ResultadoGanador;
import modelUsuario.Jugador;
import modelUsuario.UsuarioException;
import pokerApp.listeners.ApuestaManager;
import pokerApp.listeners.EventoApuesta;
import pokerApp.listeners.EventoJugador;
import pokerApp.listeners.EventoMesa;
import utilidades.Observable;
import utilidades.Observador;
import vista.VistaPanelDeJuego;


public class PanelDeJuegoController  implements Observador{
    private JuegoPoker juegoPoker;
    private Jugador jugador;
    private Mesa mesa;
    private List<String> figuras;
    private List<Carta> cartasSeleccionadas= new ArrayList<>();
    private ArrayList<Jugador> jugadoresEnMano= new ArrayList<>();
    private VistaPanelDeJuego vista;

    public PanelDeJuegoController(Jugador jugador, Mesa mesa, VistaPanelDeJuego vista) {
        this.jugador = jugador;
        this.mesa = mesa;
        this.vista = vista;
        juegoPoker=mesa.getJuegoPoker();
        jugadoresEnMano = mesa.getJugadoresEnMesa();
        Fachada.getInstancia().precargarFiguras();
        figuras=TipoFigura.getTodasFiguras();
        cargarFiguras();
        juegoPoker.agregar(this);
        mesa.agregar(this);
        ApuestaManager.getInstancia().agregar(this);
        mostrarSaldoJugador();
        mostrarMensaje("El juego ha comenzado en la mesa: "+ mesa.getNumeroMesa());
        mostrarNombreJugador();
        mostrarEstadoMano();
        mostrarNumeroMesa();
        mostrarNumeroMano();
        mostrarMayorFiguraFormada();
        cargarJugadores();
        mostrarPozoActual();
    }
    
    
    private void cargarFiguras() {
        ArrayList<String> auxiliar = new ArrayList<String>();
                for (String figura : figuras) {
                    auxiliar.add(figura);
                }
        vista.cargarFiguras(auxiliar);
    }

    public void mostrarSaldoJugador() {
        String mensaje="Saldo: $" + jugador.getSaldo();
        vista.mostrarSaldoJugador(mensaje);
    }

    private void mostrarMensaje(String mensaje) {
//        String mensaje="El juego ha comenzado en la mesa " 
//                + juegoPoker.getMesa().getNumeroMesa() ;
        vista.mostrarMensaje(mensaje);
    }

    private void mostrarNombreJugador() {
        String mensaje="bienvenido jugador: "+ jugador.getNombre();
        vista.mostrarNombreJugador(mensaje);
    }

    private void mostrarEstadoMano() {
        String mensaje="Estado mano actual: "+juegoPoker.getEstadoMano() ;
        vista.mostrarEstadoMano(mensaje);
    }

    private void mostrarNumeroMesa() {
        String mensaje="Numero de mesa: "+ mesa.getNumeroMesa();
        vista.mostrarNumeroMesa(mensaje);
    }

    private void mostrarNumeroMano() {
        String mensaje="Numero de mano: "+ mesa.getNumeroManoActual();
        vista.mostrarNumeroMesa(mensaje);
    }

    public void mostrarMayorFiguraFormada() {
        TipoFigura figuraActual = Fachada.getInstancia().determinarFigura(jugador.getCartas());
        String mensaje="La figura más grande formada es: " + figuraActual.getNombre();
        vista.mostrarMayorFiguraFormada(mensaje);
    }

    private void cargarJugadores() {
        ArrayList<Jugador> jugadoresMismaSituacion = new ArrayList<>();
        for (Jugador j : jugadoresEnMano) {
            if(j.getEstadoJugadorEnMano()==jugador.getEstadoJugadorEnMano()){
                jugadoresMismaSituacion.add(j);
            }
        }
        vista.cargarJugadores(jugadoresMismaSituacion);
    }

    private void mostrarPozoActual() {
        String mensaje="Pozo actual"+mesa.getApuestaBase();
        vista.mostrarPozoActual(mensaje);
    }
    
    public void actualizarInterfaz(){
        this.mostrarEstadoMano();
        this.mostrarMayorFiguraFormada();
        this.mostrarNumeroMano();
        this.mostrarPozoActual();
        this.mostrarSaldoJugador();
    }
    
    public void abandonarMesa(Jugador jugador){
        juegoPoker.abandonarMesa(jugador);
        vista.mostrarMensaje(" has abandonado la mesa");
    }
    public void pasarMano(Jugador jugador){
        juegoPoker.pasoMano(jugador);
    }
    public void iniciarNuevaMano(){
        juegoPoker.iniciarNuevaMano();
    }
    
    public void ingresarApuesta(float montoApostado){
        try{
            juegoPoker.iniciarApuesta(montoApostado, jugador);
            mostrarMensaje("Apuesta de $" + montoApostado + " iniciada.");
            float pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
            mesa.setApuestaBase(pozoActual);
            ApuestaManager.getInstancia().registrarApuesta(jugador, montoApostado);
            actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios
            mostrarMensaje("Apuesta realizada");
        }catch(UsuarioException ue){
            mostrarMensaje("Error: "+ue.getMessage());
        }catch(ManoException me){
            mostrarMensaje("Error: "+me.getMessage());
        }
    }
    
    
    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento instanceof EventoApuesta){
                   vista.actualizarApuesta(origen, (EventoApuesta) evento);
               }
               if(evento.equals(EventoJugador.NO_TIENE_SALDO_SUFICIENTE)){
                   vista.actualizarJugadorSinSaldo();
                   //mostrar mensaje de error y cerrar ventana
               }
               if(evento.equals(EventoMesa.NUEVA_MANO_INICIADA)){
                   vista.actualizarManoIniciada();
                   System.out.println("empezo mano nueva");
               }
               if(evento.equals(EstadoMano.TERMINADA)){
                   vista.actualizarManoTerminada();
               }
           }
//    
//    
//    public void actualizarApuesta(Observable origen, EventoApuesta evento) {
//        if(evento.getJugador()!=jugador){
//                   int respuesta = JOptionPane.showConfirmDialog(null, 
//                           evento.getJugador().getNombreCompleto()
//                                   + " ha realizado una apuesta de $" + evento.getMonto() +
//                           ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
//                           JOptionPane.YES_NO_OPTION);
//                       if (respuesta == JOptionPane.YES_OPTION && 
//                               jugador.tieneSaldoSuficiente(evento.getMonto())) {
//                           jugador.descontarSaldo(evento.getMonto());
//                           mesa.incrementarPozo(evento.getMonto());
//                           mostrarMensaje(jugador.getNombreCompleto() + " ha pagado la apuesta.");
//                           actualizarInterfaz();
//                       } else {
//                       mostrarMensaje(jugador.getNombreCompleto() 
//                               + " ha decidido no pagar la apuesta.");
//                       // Desactiva botones si el jugador no paga
//                       btnCambiarCartas.setEnabled(false);
//                       //btnJugar.setEnabled(false);
//                       btnPasarMano.setEnabled(false);
//                   }
//               }
//           }
//    
//     public void actualizarJugadorSinSaldo(){
//        IngresarAMesa ingresarAMesa=new IngresarAMesa(null, false, jugador);
//        ingresarAMesa.setVisible(true);
//        this.dispose();
//    }
//
//    private void actualizarManoIniciada() {
//        this.btnAbandonarMesa.setEnabled(true); 
//        btnCambiarCartas.setEnabled(true);
//        btnIniciarApuesta.setEnabled(true);
//        btnPasarMano.setEnabled(true);
//        this.actualizarInterfaz();
//    }
//
//    private void actualizarManoTerminada() {
//        ResultadoGanador resultado = mesa.getResultadoMano();
//        lblMensaje.setText("El ganador de la mano es: "+ resultado.getJugador().getNombre()
//        +" con la figura: "+resultado.getFigura().getNombre());
//        btnCambiarCartas.setEnabled(false);
//        btnIniciarApuesta.setEnabled(false);
//        btnPasarMano.setEnabled(false);
//        lblSeguirJugando.setText("Desea continuar jugando: ");
//        btnSeguirJugando.setVisible(true);
//        
//    }
}

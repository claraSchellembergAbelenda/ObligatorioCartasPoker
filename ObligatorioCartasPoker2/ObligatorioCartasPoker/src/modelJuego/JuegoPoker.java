package modelJuego;

import estados.EstadoMano;
import java.util.ArrayList;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import estados.EstadoPartida;
import interfazusuario.IngresarAMesa;
import modelJuego.ManoException;
import modelUsuario.UsuarioException;
import modelCartasYFiguras.Carta;
import modelCartasYFiguras.Mazo;
import modelCartasYFiguras.TipoFigura;
import pokerApp.listeners.EventoJugador;
import utilidades.Observable;

public class JuegoPoker extends Observable{
    private Mesa mesa;
    private Mano mano;
    private Mazo mazo;
    
    public JuegoPoker(Mesa mesa) {
        this.mesa = mesa;
        this.mazo = mesa.getMazo();
        this.mano = mesa.getManoActual();
        
        iniciarJuego();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void iniciarJuego() {
        if (mesa.getEstadoPartida() != EstadoPartida.ABIERTA) {
            System.out.println("Esperando inicio del juego, hay " + mesa.getJugadoresEnMesa().size()
                               + " jugadores de " + mesa.getCantidadJugadoresRequeridos() + " en la mesa.");
        } else {
            System.out.println("El juego ha comenzado en la mesa " + mesa.getNumeroMesa());
            mesa.setEstadoPartida(EstadoPartida.JUGANDO);  // Cambia el estado de la mesa a 'Jugando'
            mesa.descontarSaldo();
            this.iniciarNuevaMano();
        }
    }

    private void repartirCartas() {
        for (Jugador jugador : mesa.getJugadoresEnMesa()) {
                ArrayList<Carta> mano = mazo.sacarCartas(5); // Suponiendo que `sacarCartas` devuelve una lista de 5 cartas
                jugador.setCartas(mano); // Asigna las cartas a través de `setCartas`
                System.out.println(jugador.getNombre() + " ha recibido sus cartas: " + mano);
        }
    }



    public void realizarApuesta(Jugador jugador, float monto) throws UsuarioException{
            jugador.tieneSaldoSuficiente(monto);
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto);
            System.out.println(jugador.getNombre() + " ha realizado una apuesta de $" + monto);
        
        
    }

    public void finalizarMano() {
        Jugador ganador = determinarGanador();
        if (ganador != null) {
            System.out.println("El ganador es " + ganador.getNombre() + " con un pozo de $" + mesa.getMontoTotalApostado());
            ganador.aumentarSaldo(mesa.getMontoTotalApostado());
            mesa.setMontoTotalApostado(0);
        } else {
            System.out.println("No se ha determinado un ganador para esta mano.");
        }
    }

    private Jugador determinarGanador() {
        if (mesa.getManoActual() != null) {
            return mesa.getManoActual().determinarGanador();  // Llamada al método `determinarGanador` en la clase `Mano`
        }
        return null;
    }

    public boolean mesaEstaIniciada() {
        return mesa.getEstadoPartida() == EstadoPartida.JUGANDO;
    }

    public void abandonarMesa(Jugador jugador) {
        mesa.removerJugador(jugador);
        if(mesa.getCantidadJugadoresActual()==1){
            mesa.setEstadoPartida(EstadoPartida.FINALIZADA);
            avisar(EstadoPartida.FINALIZADA);
        }
        System.out.println(jugador.getNombre() + " ha abandonado la mesa.");
    }

    //metodo  nuevo cambiar cartas
    public void cambiarCartas(Jugador jugador, ArrayList<Carta> cartasACambiar) throws UsuarioException {
        if (cartasACambiar.isEmpty()) {
            throw new UsuarioException("No hay cartas seleccionadas para cambiar.");
        }

        // Verifica que el jugador tiene suficientes cartas para cambiar
        if (cartasACambiar.size() > jugador.getCartas().size()) {
            throw new UsuarioException("El número de cartas seleccionadas excede las que posee el jugador.");
        }

        // Reemplaza las cartas seleccionadas por nuevas cartas del mazo
        ArrayList<Carta> nuevasCartas = mazo.sacarCartas(cartasACambiar.size());
        jugador.cambiarCartas(cartasACambiar, nuevasCartas);

        // Imprime el estado actualizado del jugador
        System.out.println("Cartas actualizadas para " + jugador.getNombre() + ": " + jugador.getCartas());
    }

    public boolean pagarApuesta(Jugador jugador, double monto) throws UsuarioException {
        float montoApuesta = (float) monto;  // Convertimos monto a float si es necesario
        if (jugador.tieneSaldoSuficiente(montoApuesta)) {
            jugador.descontarSaldo(montoApuesta);
            mesa.incrementarPozo(montoApuesta);
            System.
                    out.println(jugador.getNombre() + " ha pagado una apuesta de $" + montoApuesta);
            return true;
        }
        return false;
    }

    public double getMontoApuesta() {
        return this.mano.getPozoApuestas();
    }

    public void iniciarApuesta(float monto, Jugador jugador) throws UsuarioException, ManoException{
        
        // Suponiendo que obtienes el jugador actual de la mesa
            if(mano.getEstadoMano()!=EstadoMano.ESPERANDO_APUESTA){
                throw new ManoException("No es posible realizar una apuesta en este momento");
            }
            mano.setEstadoMano(EstadoMano.APUESTA_INICIADA);
            if(jugador.tieneSaldoSuficiente(monto)){
                jugador.descontarSaldo(monto);
                mesa.incrementarPozo(monto); 
            }else{
                throw new UsuarioException("No tiene saldo suficiente");
            }
            // Incrementa el pozo de la mesa con el monto apostado
            // Saldo insuficiente
        
    }

  public EstadoMano getEstadoMano() {
        return mano.getEstadoMano();
    }

    public void pasoMano(Jugador jugador) {
        jugador.pasoMano();
               if(mesa.todosJugadoresPasaron()){
                   //terminar mano actual
                   Jugador ganador = mano.determinarGanador();
                   TipoFigura figuraGanadora = mano.determinarFiguraGanadora();
                   mesa.darPozoAGanador(ganador);
                   mano.setEstadoMano(EstadoMano.TERMINADA);
                   avisar(EstadoMano.TERMINADA);
                   
                   //sacar jugadores
                   sacarJugadoresSinSaldo();
                   
                   
               }
    }
    
    public void iniciarNuevaMano(){
        
                   //iniciar nueva mano
                   if(mesa.getCantidadJugadoresActual()>=2){
                       
                        mesa.iniciarNuevaMano();
                   }else{
                       avisar(EstadoPartida.FINALIZADA);
                       //notificar finalizacion de mesa
                       //y cerrar paneles y et
                   }
    }
    

    private void sacarJugadoresSinSaldo() {
            //verifica que todoa loa jugadores tengan saldo suficiente y saca de la mesa a los q no
        for (Jugador jugador : mesa.getJugadoresEnMesa()) {
            if(!jugador.tieneSaldoSuficiente(mesa.getApuestaBase())){
                this.mesa.removerJugador(jugador);
                //avisar(EventoJugador.NO_TIENE_SALDO_SUFICIENTE);
//               if(mensaje.contains("saldo")){
//                       IngresarAMesa ingresarAMesa = new IngresarAMesa(null,false,jugador);
//                       ingresarAMesa.setVisible(true);
//                   }
                //avisar solo al jugador que se quedo sin plata 
                //desde la ui del jugador que se quedo sin plata tiene que ir al ingresarAMesa
                //y cerrar el panel
            }
        }
    }

    public void cambiarEstadoMano(EstadoMano estado) {
        mano.setEstadoMano(estado);
    }
//
//    public void gestionarEstadoMano() {
//        switch (mano.getEstadoMano()) {
//            case ESPERANDO_APUESTA:
//                if(mesa.todosJugadoresPasaron()){
//                    System.out.println("todos los jugadores pasaron");
//                    mano.incrementarPozoApuestas(mesa.getMontoTotalApostado());
//                    mano.setEstadoMano(EstadoMano.TERMINADA);
//                    this.iniciarNuevaMano();
//                }else{
//                    mano.setEstadoMano(EstadoMano.APUESTA_INICIADA);
//                }
//                
//                break;
//            case APUESTA_INICIADA:
//                if(mesa.alMenosUnJugadorAposto()){
//                    System.out.println("estado = pidiendo cartas");
//                    mano.setEstadoMano(EstadoMano.PIDIENDO_CARTAS);
//                }else{
//                    Jugador jugadorGanador =mano.getJugadorQueAposto();
//                    if(jugadorGanador!=null){
//                        System.out.println("gano: "+ jugadorGanador.getNombre());
//                        
//                    }
//                }
//                break;
//            default:
//                throw new AssertionError();
//        }
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }


}
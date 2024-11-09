package pokerApp.Sistemas;

import java.util.ArrayList;
import pokerApp.Exceptions.MesaException;
import estados.EstadoPartida;
import pokerApp.juego.Mano;
import pokerApp.usuarios.Jugador;
import pokerApp.juego.Mesa;

public class SistemaMesa {
    private ArrayList<Mesa> mesas;
    private int numeroMesaActual;

    // Constructor con lista de mesas
    public SistemaMesa(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
        this.numeroMesaActual = 0;
        precargaMesas();
        precargaManos();
    }

    // Constructor sin inicialización explícita de mesas
    public SistemaMesa() {
        this.mesas = new ArrayList<>();
        this.numeroMesaActual = 0;
    }

    // Obtener las mesas
    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    // Establecer mesas
    public void setMesas(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
    }
    
    //precarga de datos
    public void precargaMesas(){
        mesas.add(new Mesa(3, 500, 35));
        mesas.add(new Mesa(4, 7000, 50));
        mesas.add(new Mesa(3, 500, 30));
        mesas.add(new Mesa(2, 1000, 25));
        mesas.add(new Mesa(5, 10000, 45));
            
        for (Mesa mesa : mesas) {
        mesa.pracargaManos(); // Llama al método de precarga de manos
    
       }
        
        
    }
    
    public void precargaManos() {
        for (Mesa mesa : mesas) {
            mesa.pracargaManos();
        }
    }
    
    
    // Inicializar un nuevo juego
    public void inicializarJuego() {
        for (Mesa mesa : mesas) {
            mesa.iniciarMesa();
        }
    }

    // Agregar un jugador a una mesa específica
    public void agregarJugador(Mesa mesa, Jugador jugador) {
        if (mesa.getJugadoresEnMesa().size() < mesa.getCantidadJugadoresRequeridos()) {
            mesa.agregarJugador(jugador);          // Agrega el jugador a la lista de la mesa
            mesa.agregarObservador(jugador);       // Agrega el jugador como observador de la mesa
            System.out.println("Jugador agregado a la mesa.");
        } else {
            System.out.println("La mesa ya tiene el número máximo de jugadores.");
        }
    }

    // Remover un jugador de una mesa
    public void removerJugador(Mesa mesa, Jugador j) {
        mesa.removerJugador(j);
    }

    // Finalizar una mesa
    public void finalizarMesa(Mesa mesa) {
        mesa.setEstado("Finalizada");
        calcularPozoTotal(mesa);
        determinarGanadorFinal(mesa);
    }

    // Calcular el pozo total de la mesa
public void calcularPozoTotal(Mesa mesa) {
    float pozoTotal = 0;
    for (Jugador jugador : mesa.getJugadoresEnMesa()) {
        pozoTotal += jugador.getApuesta(); // Asegúrate de que Jugador tenga este método
    }
    System.out.println("El pozo total es: " + pozoTotal);
}

    // Reiniciar una mesa después de finalizar el juego
    public void reiniciarMesa(Mesa mesa) {
        mesa.reiniciar();
    }

    // Determinar el ganador final de la mesa
    public void determinarGanadorFinal(Mesa mesa) {
        Jugador ganador = mesa.determinarGanador();
        if (ganador != null) {
            System.out.println("El ganador de la mesa " + mesa.getNumeroMesa() + " es: " + ganador.getNombreCompleto());
        } else {
            System.out.println("No hay ganador.");
        }
    }

    // Finalizar el juego por completo
    public void finalizarJuego() {
        for (Mesa mesa : mesas) {
            finalizarMesa(mesa);
        }
    }

   // Crear una nueva mesa
    
    public void crearMesa(int jugadoresRequeridos,float apuestaBase, float comision)
            throws MesaException{
        Mesa mesa= new Mesa(jugadoresRequeridos, apuestaBase, comision);
        mesa.validarMesa();
        mesas.add(mesa);
        
    }
    


    
    // Método para obtener las mesas
    public ArrayList<Mesa> obtenerMesas() {
        return mesas;
    }
    
    
    // Obtener las mesas abiertas
    public ArrayList<Mesa> obtenerMesasAbiertas() {
        ArrayList<Mesa> mesasAbiertas = new ArrayList<>();
        for (Mesa mesa : mesas) {
            if (mesa.getEstadoPartida() == EstadoPartida.ABIERTA) {
                mesasAbiertas.add(mesa);
            }
        }
        return mesasAbiertas;
    }

    // Método para agregar una mesa
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }


    // Calcular el monto total recaudado en todas las mesas
    public float calcularMontoTotalRecaudado() {
        float totalRecaudado = 0;
        for (Mesa mesa : mesas) {
            totalRecaudado += mesa.getMontoTotalRecaudado();
        }
        return totalRecaudado;
    }

    // Obtener detalles de una mesa específica
    public ArrayList<String> obtenerDetallesMesa(Mesa mesa) {
        ArrayList<String> detalles = new ArrayList<>();
        detalles.add("Número de mesa: " + mesa.getNumeroMesa());
        detalles.add("Cantidad de jugadores requeridos: " + mesa.getCantidadJugadoresRequeridos());
        detalles.add("Valor de la apuesta base: " + mesa.getApuestaBase());
        detalles.add("Cantidad actual de jugadores: " + mesa.getCantidadJugadoresActual());
        detalles.add("Número de mano actual: " + mesa.getNumeroManoActual());
        detalles.add("Monto total apostado en la mesa: " + mesa.getMontoTotalApostado());
        detalles.add("Porcentaje de comisión de la mesa: " + mesa.getComision());
        detalles.add("Monto total recaudado: " + mesa.getMontoTotalRecaudado());
        detalles.add("Estado actual: " + mesa.getEstadoPartida());
        return detalles;
    }
    
    // Obtener detalles de las manos jugadas en una mesa
    public ArrayList<String> obtenerDetallesManos(Mesa mesa) {
        ArrayList<String> detallesManos = new ArrayList<>();
        for (Mano mano : mesa.getManosJugadas()) {
            detallesManos.add("Número de mano: " + mano.getNumeroMano());
            detallesManos.add("Cantidad de jugadores: " + mano.getCantJugadores());
            detallesManos.add("Total apostado: " + mano.getPozoApuestas());
            detallesManos.add("Estado: " + mano.getEstadoMano());
            detallesManos.add("Jugador ganador: " + (mano.getJugadorGanador() != null ? mano.getJugadorGanador().getNombreCompleto() : "Sin ganador"));
            detallesManos.add("Figura ganadora: " + (mano.getFiguraGanadora() != null ? mano.getFiguraGanadora().getNombre() : "Sin figura ganadora"));
        }
        return detallesManos;
    }

    

    
    
    
}
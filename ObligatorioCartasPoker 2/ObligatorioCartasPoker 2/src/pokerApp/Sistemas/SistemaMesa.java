package pokerApp.Sistemas;

import java.util.ArrayList;
import pokerApp.usuarios.Jugador;
import pokerApp.juego.Mesa;

public class SistemaMesa {
    private ArrayList<Mesa> mesas;
    private int numeroMesaActual;

    // Constructor con lista de mesas
    public SistemaMesa(ArrayList<Mesa> mesas) {
        this.mesas = mesas;
        this.numeroMesaActual = 0;
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
    
    // Inicializar un nuevo juego
    public void inicializarJuego() {
        for (Mesa mesa : mesas) {
            mesa.iniciarMesa();
        }
    }

    // Agregar un jugador a una mesa específica
public void agregarJugador(Mesa mesa, Jugador j) {
    if (mesa.getJugadores().size() < mesa.getCantidadJugadoresRequeridos()) {
        mesa.agregarJugador(j);
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
    for (Jugador jugador : mesa.getJugadores()) {
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
    public void crearMesa(int jugadores, int apuestaBase, int comision) {
        if (jugadores < 2 || jugadores > 5) {
            System.out.println("Cantidad de jugadores no válida.");
            return;
        }
        if (apuestaBase < 1) {
            System.out.println("Apuesta base inválida.");
            return;
        }
        if (comision < 1 || comision > 50) {
            System.out.println("Comisión inválida.");
            return;
        }

        numeroMesaActual++;
        Mesa nuevaMesa = new Mesa(numeroMesaActual, jugadores, apuestaBase, comision);
        mesas.add(nuevaMesa);
        System.out.println("Mesa creada con éxito. Número de mesa: " + numeroMesaActual);
    }
    
    // Método para obtener las mesas
    public ArrayList<Mesa> obtenerMesas() {
        return mesas;
    }

    // Método para agregar una mesa
    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }
    
    
}
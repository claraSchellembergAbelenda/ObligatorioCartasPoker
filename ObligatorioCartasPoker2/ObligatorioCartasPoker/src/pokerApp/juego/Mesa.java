package pokerApp.juego;
import utilidades.Observable;
import pokerApp.figurasYCartas.Mazo;
import pokerApp.figurasYCartas.Figura;
import pokerApp.usuarios.Jugador;
import java.util.ArrayList;
import pokerApp.Exceptions.MesaException;
import utilidades.Observador;

public class Mesa extends Observable{

    private ArrayList<Jugador> jugadores;
    private ArrayList<Mano> manosJugadas;
    private Mazo cartas;
    private float apuestaBase;
    private EstadoPartida estadoPartida;
    private int cantidadJugadoresRequeridos;
    private int cantidadJugadoresActual;
    private int numeroManoActual;
    private float montoTotalApostado;
    private float montoTotalRecaudado;
    private float comision;
    private Jugador ganador;
    private Figura figuraGanadora;
    private static int numeroMesa;

    // Constructor
    public Mesa( int cantidadJugadoresRequeridos, float apuestaBase, float comision) {
        this.jugadores = new ArrayList<>();
        this.manosJugadas = new ArrayList<>();
        this.cartas = new Mazo(); // Inicializamos el mazo
        this.apuestaBase = apuestaBase;
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
        this.comision = comision;
        this.estadoPartida = EstadoPartida.ABIERTA; // Estado inicial de la partida
        this.numeroMesa = numeroMesa++;
        this.montoTotalApostado = 0;
        this.montoTotalRecaudado = 0;
        this.cantidadJugadoresActual = 0;
        this.numeroManoActual = 0;
    }

    

    
    // Getters y setters
    public int getNumeroMesa() {
        return this.hashCode(); // Usamos el hashCode para generar un número único
    }
    
    public void agregarJugador(Jugador jugador) {
        if (jugadores.size() < cantidadJugadoresRequeridos) {
            jugadores.add(jugador);
            cantidadJugadoresActual++;
            System.out.println("Jugador agregado a la mesa.");
            avisar(EventoMesa.JUGADOR_AGREGADO);  // Notifica el evento

        } else {
            System.out.println("La mesa ya tiene el número máximo de jugadores.");
        }
    }
    
    

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    // Remover un jugador de la mesa
    public void removerJugador(Jugador jugador) {
        if (jugadores.remove(jugador)) {
            cantidadJugadoresActual--;
            System.out.println("Jugador " + jugador.getNombreCompleto() + " removido de la mesa.");
        } else {
            System.out.println("El jugador no estaba en la mesa.");
        }
    }

    // Registrar una nueva mano y actualizar el monto total apostado
    public void registrarMano(Mano mano) {
        manosJugadas.add(mano);
        montoTotalApostado += mano.getPozoApuestas();
        montoTotalRecaudado += (1 - (comision / 100)) * mano.getPozoApuestas();
    }
    
        // Método para finalizar la mesa
    public void finalizarMesa() {
        estadoPartida = EstadoPartida.FINALIZADA;
        calcularPozoTotal();
        avisar(EventoMesa.MESA_FINALIZADA); //avisa que finalizo
        System.out.println("La mesa " + numeroMesa + " ha sido finalizada.");
    }

    // Reiniciar la mesa para una nueva partida
    public void reiniciarMesa() {
        jugadores.clear();
        manosJugadas.clear();
        montoTotalApostado = 0;
        montoTotalRecaudado = 0;
        this.estadoPartida = EstadoPartida.ABIERTA;
        System.out.println("Mesa " + numeroMesa + " reiniciada.");
    }
    
    public Jugador determinarGanadorFinal() {
        Jugador ganador = null;
        float maxApuesta = 0;

        for (Jugador jugador : jugadores) {
            if (jugador.getApuesta() > maxApuesta) {
                maxApuesta = jugador.getApuesta();
                ganador = jugador;
            }
        }
        return ganador;
    }
    
    public int getCantidadJugadoresRequeridos() {
        return cantidadJugadoresRequeridos;
    }

    public int getCantidadJugadoresActual() {
        return cantidadJugadoresActual;
    }

    // Método para iniciar la mesa (si se han completado los jugadores)
    public void iniciarMesa() {
        if (cantidadJugadoresActual == cantidadJugadoresRequeridos) {
            estadoPartida = EstadoPartida.JUGANDO;
            System.out.println("La mesa " + numeroMesa + " ha sido iniciada.");
        } else {
            System.out.println("La mesa no puede ser iniciada. Jugadores insuficientes.");
        }
    }
    
    public void iniciarNuevaMano() {
        Mano nuevaMano = new Mano(jugadores);
        nuevaMano.repartirCartas(cartas.getCartas());
        avisar(EventoMesa.NUEVA_MANO_INICIADA);  // Notifica que comenzó una nueva mano
        manosJugadas.add(nuevaMano);
    }



    // Método para reiniciar la mesa
    public void reiniciar() {
        jugadores.clear();
        manosJugadas.clear();
        estadoPartida = EstadoPartida.ABIERTA;
        cantidadJugadoresActual = 0;
        montoTotalApostado = 0;
        montoTotalRecaudado = 0;
        numeroManoActual = 0;
        System.out.println("La mesa " + numeroMesa + " ha sido reiniciada.");
    }

    // Método para calcular el pozo total apostado en la mesa
    public void calcularPozoTotal() {
        montoTotalApostado = 0;
        for (Mano mano : manosJugadas) {
            montoTotalApostado += mano.getPozoApuestas();
        }
        montoTotalRecaudado = montoTotalApostado - (montoTotalApostado * comision / 100);
    }

    // Método para determinar el ganador de la mesa
    public Jugador determinarGanador() {
        // Implementar la lógica para determinar el ganador
        // Aquí puedes evaluar las manos de los jugadores para decidir el ganador
        return null; // Por ahora retornamos null hasta implementar la lógica
    }

    // Getters y Setters


    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Mano> getManosJugadas() {
        return manosJugadas;
    }

    public void setManosJugadas(ArrayList<Mano> manosJugadas) {
        this.manosJugadas = manosJugadas;
    }

    public Mazo getCartas() {
        return cartas;
    }

    public void setCartas(Mazo cartas) {
        this.cartas = cartas;
    }

    public float getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(float apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public EstadoPartida getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(EstadoPartida estadoPartida) {
        this.estadoPartida = estadoPartida;
    }



    public void setCantidadJugadoresRequeridos(int cantidadJugadoresRequeridos) {
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
    }



    public void setCantidadJugadoresActual(int cantidadJugadoresActual) {
        this.cantidadJugadoresActual = cantidadJugadoresActual;
    }

    public int getNumeroManoActual() {
        return numeroManoActual;
    }

    public void setNumeroManoActual(int numeroManoActual) {
        this.numeroManoActual = numeroManoActual;
    }

    public float getMontoTotalApostado() {
        return montoTotalApostado;
    }

    public void setMontoTotalApostado(float montoTotalApostado) {
        this.montoTotalApostado = montoTotalApostado;
    }

    public float getMontoTotalRecaudado() {
        return montoTotalRecaudado;
    }

    public void setMontoTotalRecaudado(float montoTotalRecaudado) {
        this.montoTotalRecaudado = montoTotalRecaudado;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }

   
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Object getJugadoresActuales() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean getJugadoresRequeridos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setEstado(String finalizada) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<Mano> cargarManos(){
        ArrayList<Mano>manos= new ArrayList<>();
        for (Mano manoJugada : manosJugadas) {
            manos.add(manoJugada);
        }
        return manos;
    }
    public void pracargaManos(){
    //queda por terminar porque quiero hablar el tema del constructor de mano
    
        for (Mano mano : manosJugadas) {
          //  manosJugadas.add(new Mano())
        }
    }
    
    public void validarMesa ()throws MesaException{
        if(this.cantidadJugadoresRequeridos<2 || this.cantidadJugadoresRequeridos>5){
            throw new MesaException("No puede ingresar menos de 2 jugadores requeridos ni mas de 5");
        }
        if(this.apuestaBase<=0){
            throw new MesaException("La apuesta base debe ser mayor que 0");
        }
        if(this.comision<=0||comision>50){
            throw new MesaException("La comision debe ser mayor a 0 y menor a 50");
        }
    }

    public void avisar(EventoMesa eventoMesa) {
        super.avisar(eventoMesa);  // Llama al método avisar de Observable
    }

    public void agregarObservador(Jugador jugador) {
        super.agregar((Observador) jugador); // Llama al método agregar de Observable
        System.out.println("Jugador " + jugador.getNombreCompleto() + " agregado como observador de la mesa.");
    }

    

}
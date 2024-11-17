package modelJuego;
import estados.EstadoMano;
import pokerApp.listeners.EventoMesa;
import estados.EstadoPartida;
import utilidades.Observable;
import modelCartasYFiguras.Mazo;
import modelCartasYFiguras.Figura;
import modelUsuario.Jugador;
import java.util.ArrayList;
import modelUsuario.UsuarioException;
import pokerApp.listeners.EventoJugador;
import utilidades.Observador;

public class Mesa extends Observable{

    private ArrayList<Jugador> jugadoresEnMesa;
    private ArrayList<Mano> manos;
    private Mazo mazo;
    private float apuestaBase;
    private EstadoPartida estadoPartida;
    private int cantidadJugadoresRequeridos;
    private int cantidadJugadoresActual;
    private Mano manoActual;
    private float montoTotalApostado;
    private float montoTotalRecaudado;
    private float pozoActual;
    private float comision;
    private Jugador ganador;
    private Figura figuraGanadora;
    private static int contadorMesas = 1;  
    private int numeroMesa; 
    private JuegoPoker juegoPoker;
    private ResultadoGanador resultadoGanador;
    private int cantManos;
    
    
    // Constructor
    public Mesa( int cantidadJugadoresRequeridos, float apuestaBase, float comision) {
        this.jugadoresEnMesa = new ArrayList<>();
        this.manos = new ArrayList<>();
        this.mazo = new Mazo(); // Inicializamos el mazo
        this.apuestaBase = apuestaBase;
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
        this.comision = comision;
        this.estadoPartida = EstadoPartida.ABIERTA; // Estado inicial de la partida
        this.numeroMesa = contadorMesas++; 
        this.montoTotalApostado = 0;
        this.montoTotalRecaudado = 0;
        this.cantidadJugadoresActual = 0;
        this.pozoActual=0;
        this.cantManos=0;
        //iniciarNuevaMano();
    }

    

    
    // Getters y setters
     public int getNumeroMesa() {
        return numeroMesa;
    }
    public ArrayList<Jugador> getJugadoresEnMesa() {
        return jugadoresEnMesa;
    }
   
   public int getCantidadJugadoresRequeridos() {
        return cantidadJugadoresRequeridos;
    }

    public int getCantidadJugadoresActual() {
        return cantidadJugadoresActual;
    }
    
    public void setJugadoresEnMesa(ArrayList<Jugador> jugadoresEnMesa) {
        this.jugadoresEnMesa = jugadoresEnMesa;
    }

    public ArrayList<Mano> getManos() {
        return manos;
    }

    public void setManos(ArrayList<Mano> manos) {
        this.manos = manos;
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
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

    public float getPozoActual() {
        return pozoActual;
    }



    public void setCantidadJugadoresRequeridos(int cantidadJugadoresRequeridos) {
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
    }

    public void setCantidadJugadoresActual(int cantidadJugadoresActual) {
        this.cantidadJugadoresActual = cantidadJugadoresActual;
    }

    public Mano getManoActual() {
        return manoActual;
    }
    public int getNumeroManoActual(){
        return manoActual.getNumeroManoActual();
    }
    // este es el pozo? 
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

    public JuegoPoker getJuegoPoker() {
        return juegoPoker;
    }

    public void setJuegoPoker(JuegoPoker juegoPoker) {
        this.juegoPoker = juegoPoker;
    }
   
    
    
    //------------------------------------funciones de mesa--------------------------------------
    public void agregarJugador(Jugador jugador) {
        if (jugadoresEnMesa.size() < cantidadJugadoresRequeridos) {
            jugadoresEnMesa.add(jugador);
            cantidadJugadoresActual++;
            avisar(EventoMesa.JUGADOR_AGREGADO);  // Notifica el evento
            //aca checkear cantidad de jugadores e iniciar el juego
            if(this.getCantidadJugadoresActual()==this.getCantidadJugadoresRequeridos()){
                juegoPoker = new JuegoPoker(this);
                juegoPoker.iniciarJuego();
                juegoPoker.iniciarMano();
                avisar(EventoMesa.MESA_COMPLETA);
                
            }
            System.out.println("Jugador agregado a la mesa.");

        } else {
            System.out.println("La mesa ya tiene el número máximo de jugadores.");
        }
    }

    // Remover un jugador de la mesa
    public void removerJugador(Jugador jugador) {
        if (jugadoresEnMesa.remove(jugador)) {
            cantidadJugadoresActual--;
            System.out.println("Jugador " + jugador.getNombreCompleto() + " removido de la mesa.");
        } else {
            System.out.println("El jugador no estaba en la mesa.");
        }
    }

    // Registrar una nueva mano y actualizar el monto total apostado
    public void registrarMano(Mano mano) {
        manos.add(mano);
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
        jugadoresEnMesa.clear();
        manos.clear();
        montoTotalApostado = 0;
        montoTotalRecaudado = 0;
        this.estadoPartida = EstadoPartida.ABIERTA;
        System.out.println("Mesa " + numeroMesa + " reiniciada.");
    }
    
    public Jugador determinarGanadorFinal() {
        Jugador ganador = null;
        float maxApuesta = 0;

        for (Jugador jugador : jugadoresEnMesa) {
            if (jugador.getApuesta() > maxApuesta) {
                maxApuesta = jugador.getApuesta();
                ganador = jugador;
            }
        }
        return ganador;
    }
    
    

    // Método para iniciar la mesa (si se han completado los jugadoresEnMesa)
    public void iniciarMesa() {
        if (cantidadJugadoresActual == cantidadJugadoresRequeridos) {
            estadoPartida = EstadoPartida.JUGANDO;
            iniciarNuevaMano();
            System.out.println("La mesa " + numeroMesa + " ha sido iniciada.");
        } else {
            System.out.println("La mesa no puede ser iniciada. Jugadores insuficientes.");
        }
    }
    //metodo actualizado con validaciones
    public void iniciarNuevaMano() {
            cantManos++;
            estadoPartida = EstadoPartida.JUGANDO;
            Mano nuevaMano = new Mano(jugadoresEnMesa, this.cantManos);
            manos.add(nuevaMano);
            this.manoActual=nuevaMano;
            nuevaMano.repartirCartas();
            avisar(EventoMesa.NUEVA_MANO_INICIADA);  // Notifica a todos los observadores (jugadores)

    }



    // Método para reiniciar la mesa
    public void reiniciar() {
        jugadoresEnMesa.clear();
        manos.clear();
        estadoPartida = EstadoPartida.ABIERTA;
        cantidadJugadoresActual = 0;
        montoTotalApostado = 0;
        montoTotalRecaudado = 0;
        manoActual = null;
        System.out.println("La mesa " + numeroMesa + " ha sido reiniciada.");
    }

    // Método para calcular el pozo total apostado en la mesa
    public void calcularPozoTotal() {
        montoTotalApostado = 0;
        for (Mano mano : manos) {
            montoTotalApostado += mano.getPozoApuestas();
        }
        montoTotalRecaudado = montoTotalApostado - (montoTotalApostado * comision / 100);
    }

    public void incrementarPozo(double monto) {
        montoTotalApostado += monto;
    }
    // Método para determinar el ganador de la mesa
    public Jugador determinarGanador() {
        // Implementar la lógica para determinar el ganador
        // Aquí puedes evaluar las manos de los jugadoresEnMesa para decidir el ganador
        return null; // Por ahora retornamos null hasta implementar la lógica
    }

    
    public ArrayList<Mano> cargarManos(){
        ArrayList<Mano>manos= new ArrayList<>();
        for (Mano manoJugada : this.manos) {
            manos.add(manoJugada);
        }
        return manos;
    }
    
    
    public void pracargaManos() {
        for (int i = 1; i <= 3; i++) { // Precarga de 3 manos para el ejemplo
            Mano mano = new Mano(jugadoresEnMesa, i); // Constructor puede ajustarse
            mano.incrementarPozoApuestas(apuestaBase * i);
            mano.setCantJugadores(jugadoresEnMesa.size());
            mano.setEstadoMano(EstadoMano.ESPERANDO_APUESTA);
            if (!jugadoresEnMesa.isEmpty()) {
                mano.setJugadorGanador(jugadoresEnMesa.get(0));
            }
            manos.add(mano);
        }
        // Asignar la última mano creada como la actual
        if (!manos.isEmpty()) {
            manoActual = manos.get(manos.size() - 1);
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

    

    @Override
    public String toString() {
        return "Mesa " + numeroMesa;
    }


    

    public void validarSaldos() throws UsuarioException{
        for (Jugador jugador : jugadoresEnMesa) {
             jugador.tieneSaldoSuficiente(apuestaBase);
        }
    }


    public void descontarSaldo() {
        
        for (Jugador jugador : jugadoresEnMesa) {
            jugador.descontarSaldo(apuestaBase);
            manoActual.incrementarPozoApuestas(apuestaBase);
        }
    }

    public void terminarMano() {
         this.manoActual.terminarMano();
    }

    public Jugador determinarJugadorDeMano() {
        return this.manoActual.determinarGanador();
    }

    public EstadoMano getEstadoMano() {
        return manoActual.getEstadoMano();
    }

    public boolean todosJugadoresPasaron() {
        int cantidad=0;
        for (Jugador jugador : jugadoresEnMesa) {
            if(jugador.getPasoMano()){
                cantidad++;
            }
        }
        if(cantidad==jugadoresEnMesa.size()){
            return true;
        }
        return false;
    }

    public void darPozoAGanador(Jugador ganador) {
        float montoComisionado = this.pozoActual* (comision/100);
        this.montoTotalRecaudado+=montoComisionado;
        float montoGanado = pozoActual-montoComisionado;
        ganador.aumentarSaldo(montoGanado);
        pozoActual=0;
    }

    public ResultadoGanador getResultadoMano() {
        return this.manoActual.determinarResultadoGanador();
    }
    
    
 

    

}
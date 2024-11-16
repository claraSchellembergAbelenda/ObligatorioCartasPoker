package modelUsuario;
import estados.EstadoJugadorEnMano;
import utilidades.Observador;
import java.util.List;
import modelCartasYFiguras.Carta;
import pokerApp.listeners.EventoMesa;
import java.util.ArrayList;
import modelCartasYFiguras.SistemaFiguras;
import modelCartasYFiguras.TipoFigura;
import modelJuego.Mesa;
import utilidades.Observable;

public class Jugador extends Usuario implements Observador{

    private String nombreCompleto;
    private float saldo;
    private float apuesta;
    private ArrayList<Carta> cartas= new ArrayList<>();
    private EstadoJugadorEnMano estadoJugadorEnMano;
    private TipoFigura figuraActual; // Figura actual del jugador
    
    public Jugador(String cedula, String password, String nombreCompleto, float saldo) {
        super(cedula, password, nombreCompleto); // Llamamos al constructor de la clase base Usuario
        this.nombreCompleto = nombreCompleto;
        this.saldo = saldo;
        this.estadoJugadorEnMano=EstadoJugadorEnMano.ACCION_PENDIENTE;

    }

    public EstadoJugadorEnMano getEstadoJugadorEnMano() {
        return estadoJugadorEnMano;
    }

    public void setEstadoJugadorEnMano(EstadoJugadorEnMano estadoJugadorEnMano) {
        this.estadoJugadorEnMano = estadoJugadorEnMano;
    }

    
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    public String getNombre() {
        return nombreCompleto;
    }
    
    public void apostar(float cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad; // Restamos la cantidad apostada del saldo
            System.out.println(getNombreCompleto() + " ha apostado " + cantidad);
        } else {
            System.out.println("Saldo insuficiente para realizar la apuesta.");
        }
    }

    public float getApuesta() {
        return apuesta;
    }

    public void setApuesta(float apuesta) {
        this.apuesta = apuesta;
    }

    @Override
    public String toString() {
        return "Jugador{" + "saldo=" + saldo + ", nombre=" + getNombreCompleto() + '}';
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if (evento == EventoMesa.NUEVA_MANO_INICIADA) {
            System.out.println("Nueva mano iniciada en la mesa.");
        } else if (evento == EventoMesa.MESA_FINALIZADA) {
            System.out.println("La mesa ha finalizado.");
        } else if (evento == EventoMesa.JUGADOR_AGREGADO) {
            System.out.println("Un jugador se ha unido a la mesa.");
        }
    }

    public void validarSaldo(Mesa mesaSeleccionada) throws UsuarioException{
        if(this.getSaldo()<(mesaSeleccionada.getApuestaBase()*10)){
            throw new UsuarioException("Saldo insuficiente");
        }
    }


    public boolean tieneSaldoSuficiente(float monto) {
        return saldo >= monto;
    }

    public void descontarSaldo(float monto) {
        this.saldo-=monto;
    }

    
        // Método para realizar la apuesta, disminuyendo el saldo
        public void realizarApuesta(float monto) throws UsuarioException {
            validarSaldoParaApuesta(monto);
            this.saldo -= monto;
            this.apuesta = monto;
            System.out.println(getNombreCompleto() + " ha apostado " + monto);
        }
    

    // Método para verificar si el jugador tiene saldo suficiente
    public void validarSaldoParaApuesta(float monto) throws UsuarioException {
        if (this.saldo < monto) {
            throw new UsuarioException("Saldo insuficiente para la apuesta.");
        }
    }


        // Método para aumentar el saldo del jugador (por ejemplo, al ganar una ronda)
    public void aumentarSaldo(float montoTotalApostado) {
        this.saldo += montoTotalApostado;
        System.out.println(getNombreCompleto() + " ha ganado " + montoTotalApostado + " y su nuevo saldo es " + saldo);
    }

    public void cambiarCartas(ArrayList<Carta> cartasACambiar, ArrayList<Carta> nuevasCartas) {
        if (cartasACambiar.size() != nuevasCartas.size()) {
            System.out.println("Error: el número de cartas a cambiar y las nuevas cartas deben coincidir.");
            return;
        }

        for (int i = 0; i < cartasACambiar.size(); i++) {
            int index = cartas.indexOf(cartasACambiar.get(i));
            if (index != -1) {
                cartas.set(index, nuevasCartas.get(i)); // Reemplaza la carta en la posición correcta
            }
        }
        
        
        System.out.println(getNombreCompleto() + " ha cambiado sus cartas.");
    }


    
    public void agregarCarta(Carta carta) {
        this.cartas.add(carta);

    }

    public TipoFigura getFiguraActual() {
           return this.figuraActual;
       }

    public void setFiguraActual(TipoFigura figuraActual) {
        this.figuraActual = figuraActual;
        System.out.println("Figura actualizada para " + getNombreCompleto() + ": " + figuraActual.getNombre());
    }

    
    
    
    
        
   
}
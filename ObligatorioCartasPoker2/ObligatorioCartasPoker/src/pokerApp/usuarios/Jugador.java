package pokerApp.usuarios;
import utilidades.Observador;
import java.util.List;
import pokerApp.figurasYCartas.Carta;
import estados.EventoMesa;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.juego.Mesa;
import utilidades.Observable;

public class Jugador extends Usuario implements Observador{
    private float saldo;
    private float apuesta;

    public Jugador(String cedula, String password, String nombreCompleto, float saldo) {
        super(cedula, password, nombreCompleto); // Llamamos al constructor de la clase base Usuario
        this.saldo = saldo;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
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
    
   
}
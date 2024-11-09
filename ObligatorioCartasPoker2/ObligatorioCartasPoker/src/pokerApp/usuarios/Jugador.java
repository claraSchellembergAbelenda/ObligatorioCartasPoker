package pokerApp.usuarios;
import utilidades.Observador;
import java.util.List;
import pokerApp.figurasYCartas.Carta;
import estados.EventoMesa;
import java.util.ArrayList;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.juego.Mesa;
import utilidades.Observable;

public class Jugador extends Usuario implements Observador{

   
    private float saldo;
    private float apuesta;
    private ArrayList<Carta> cartas= new ArrayList<>();
    
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

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }
    public String getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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


    public void tieneSaldoSuficiente(float monto) throws UsuarioException{
        if(this.getSaldo()<monto){
            throw new UsuarioException("Saldo insuficiente");
        }
    }

    public void descontarSaldo(float monto) {
        this.saldo-=monto;
    }

    
    //implementaciones para jugar al poker 
    
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
    
    
    
    
    
        
   
}
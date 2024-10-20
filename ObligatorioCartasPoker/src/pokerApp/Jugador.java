package pokerApp;

public class Jugador extends Usuario {
    private float saldo;

    public Jugador(String cedula, String password, String nombreCompleto, float saldo) {
        super(cedula, password, nombreCompleto);
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
            saldo -= cantidad; // Jugador es el experto en su saldo
            System.out.println(getNombreCompleto() + " ha apostado " + cantidad);
        } else {
            System.out.println("Saldo insuficiente para realizar la apuesta.");
        }
    }

    @Override
    public String toString() {
        return "Jugador{" + "saldo=" + saldo + ", nombre=" + getNombreCompleto() + '}';
    }
}

package pokerApp;

public class Jugador extends Usuario {
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
}
package pokerApp;

public class Administrador extends Usuario {

    public Administrador(String cedula, String password, String nombreCompleto) {
        super(cedula, password, nombreCompleto); // Llamamos al constructor de la clase base Usuario
    }

    public void administrarMesas() {
        System.out.println(getNombreCompleto() + " está administrando las mesas.");
    }

    @Override
    public String toString() {
        return "Administrador{" + "nombre=" + getNombreCompleto() + '}';
    }
}
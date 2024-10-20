package pokerApp;

public class Administrador extends Usuario {
    
    public Administrador(String cedula, String password, String nombreCompleto) {
        super(cedula, password, nombreCompleto);
    }
    public void gestionarMesa() {
        System.out.println(getNombreCompleto() + " está gestionando las mesas.");
    }

    @Override
    public String toString() {
        return "Administrador{" + "nombre=" + getNombreCompleto() + '}';
    }
}
package modelUsuario;

public abstract class Usuario {
    private String cedula;
    private String password;
    private String nombreCompleto;

    public Usuario(String cedula, String password, String nombreCompleto) {
        this.cedula = cedula;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreCompleto=" + nombreCompleto + '}';
    }

    public boolean validarLogin(String cedula, String password) {
        return this.getCedula().equals(cedula)&&this.getPassword().equals(password);
    }
}

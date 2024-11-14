package utilidades;

public interface Observador <T>{
    void actualizar(Observable<T> origen, T evento);
}
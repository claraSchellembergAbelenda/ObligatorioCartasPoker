package utilidades;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private final List<Observador<T>> observadores = new ArrayList<>();

    public void agregar(Observador<T> observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void quitar(Observador<T> observador) {
        observadores.remove(observador);
    }

    protected void avisar(T evento) {
        for (Observador<T> observador : new ArrayList<>(observadores)) {
            observador.actualizar(this, evento);
        }
    }
}
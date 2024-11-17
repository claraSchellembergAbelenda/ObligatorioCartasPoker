package utilidades;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private final List<Observador> observadores = new ArrayList<>();

    public void agregar(Observador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    public void quitar(Observador observador) {
        observadores.remove(observador);
    }

    protected void avisar(Object evento) {
        for (Observador observador : new ArrayList<>(observadores)) {
            observador.actualizar(this, evento);
        }
    }
}
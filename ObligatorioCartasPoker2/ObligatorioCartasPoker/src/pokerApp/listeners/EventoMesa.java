package pokerApp.listeners;

//representa los eventos de juego 
//que queremos notificar
//por ejemplo EstadoMesa y EventoMesa.
public enum EventoMesa {
    NUEVA_MANO_INICIADA,
    MESA_FINALIZADA,
    JUGADOR_AGREGADO,
    JUGADOR_REMOVIDO,
    MESA_COMPLETA
}

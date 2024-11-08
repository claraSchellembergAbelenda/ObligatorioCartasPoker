
package estados;

public enum EstadoMano {
    /*-“Esperando apuesta”: Estado inicial de la mano. Cualquier jugador puede iniciar una apuesta. 
Cualquier jugador puede indicar que no inicia apuesta. 
-“Apuesta iniciada”. Se da cuando un jugador indica que inicia una apuesta. Todos los jugadores, 
menos el que inició la apuesta, deben indicar si pagan la apuesta o pasan.
-“Pidiendo cartas”: Se da cuando todos los jugadores respondieron si pagan o no la apuesta 
iniciada. Todos los jugadores que pagaron la apuesta deben pedir cartas nuevas. (De 0 a 5)
-“Terminada”: Este estado se da cuando termina la mano porque:
● Ningún jugador inició una apuesta o
● Ningún jugador pagó la apuesta iniciada o
● Todos los jugadores terminaron de pedir cartas.
Todos los jugadores deben indicar si desean continuar jugando.*/
    ESPERANDO_APUESTA,
    APUESTA_INICIADA,
    PIDIENDO_CARTAS,
    TERMINADA;
}

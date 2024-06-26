package org.example;

import java.util.Map;

public interface BaseDeDatosPuntuacion {

    //Guardo la puntuacion de un jugador en la base de datos.
    void guardarPuntuacion(String nombreJugador, int puntuacion);
    //Obtengo la puntuacion de un jugador de la base de datos.
    int obtenerPuntuacion(String nombreJugador);
    //Obtengo todas las puntuaciones almacenadas en la base de datos.
    Map<String, Integer> obtenerTodasLasPuntuaciones();
}



package org.example;

import java.util.Map;

public interface BaseDeDatosEstadoOleadas {

    //Guardo el estado de una oleada en la base de datos.
    void guardarEstadoDeOleada(int numeroOleada, String estado);
    //Obtengo el estado de una oleada de la base de datos.
    String obtenerEstadoDeOleada(int numeroOleada);
    //Obtengo todos los estados de oleadas almacenados en la base de datos.
    Map<Integer, String> obtenerTodosLosEstadosDeOleadas();
}



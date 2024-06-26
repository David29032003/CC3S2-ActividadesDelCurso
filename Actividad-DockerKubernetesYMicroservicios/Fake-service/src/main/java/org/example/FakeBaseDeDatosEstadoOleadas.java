package org.example;

import java.util.HashMap;
import java.util.Map;

public class FakeBaseDeDatosEstadoOleadas implements BaseDeDatosEstadoOleadas {
    private Map<Integer, String> estadosDeOleadas = new HashMap<>();

    //Guardo el estado de una oleada en la base de datos.
    @Override
    public void guardarEstadoDeOleada(int numeroOleada, String estado) {
        estadosDeOleadas.put(numeroOleada, estado);
    }

    //Obtengo el estado de una oleada de la base de datos.
    @Override
    public String obtenerEstadoDeOleada(int numeroOleada) {
        return estadosDeOleadas.getOrDefault(numeroOleada, "Desconocido");
    }

    //Obtengo todos los estados de las oleadas almacenadas en la base de datos.
    @Override
    public Map<Integer, String> obtenerTodosLosEstadosDeOleadas() {
        return new HashMap<>(estadosDeOleadas);
    }
}



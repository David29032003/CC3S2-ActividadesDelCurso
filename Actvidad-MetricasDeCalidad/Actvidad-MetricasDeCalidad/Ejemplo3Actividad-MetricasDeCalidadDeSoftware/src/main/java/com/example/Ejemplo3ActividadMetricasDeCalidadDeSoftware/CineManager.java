package com.example.Ejemplo3ActividadMetricasDeCalidadDeSoftware;

import java.util.List;

public class CineManager {
    private PeliculaManager peliculaManager;
    private SalaManager salaManager;

    public CineManager() {
        peliculaManager = new PeliculaManager();
        salaManager = new SalaManager();
    }

    // Métodos delegados para gestión de peliculas
    public void agregarPelicula(Pelicula pelicula) {
        peliculaManager.agregarPelicula(pelicula);
    }

    public boolean eliminarPelicula(String titulo) {
        return peliculaManager.eliminarPelicula(titulo);
    }

    public List<Sesion> sesionesPorPelicula(String titulo) {
        return peliculaManager.sesionesPorPelicula(titulo);
    }

    public void programarSesion(String titulo, Sesion sesion) {
        peliculaManager.programarSesion(titulo, sesion);
    }

    public int contarPeliculas() {
        return peliculaManager.contarPeliculas();
    }

    // Métodos delegados para gestión de salas
    public void agregarSala(Sala sala) {
        salaManager.agregarSala(sala);
    }

    public boolean eliminarSala(int id) {
        return salaManager.eliminarSala(id);
    }

    public int contarSalas() {
        return salaManager.contarSalas();
    }
}

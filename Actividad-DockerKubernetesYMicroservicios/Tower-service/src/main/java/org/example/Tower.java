package org.example;

import java.util.List;

public class Tower {
    private int damage; //Daño que inflige la torre a los enemigos
    private int range; //Alcance maximo de la torre para atacar enemigos
    private int fireRate; //Numero de turnos entre disparos de la torre
    private int turnosDesdeUltimoDisparo; //Turnos transcurridos desde el ultimo disparo de la torre
    private int ActualX; // Coordenada X actual de la torre en el mapa
    private int ActualY; // Coordenada Y actual de la torre en el mapa

    // Constructor de la clase Tower
    public Tower(int damage, int range, int fireRate, int ActualX, int ActualY) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.turnosDesdeUltimoDisparo = 0;
        this.ActualX = ActualX;
        this.ActualY = ActualY;
    }

    //Constructor de la clase Tower
    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.turnosDesdeUltimoDisparo = 0;
    }

    public Tower() {

    }

    //Metodo getter para obtener el daño de la torre
    public int getDamage() {
        return damage;
    }

    //Metodo getter para obtener el alcance de la torre
    public int getRange() {
        return range;
    }

    //Metodo getter para obtener la frecuencia de disparo de la torre
    public int getFireRate() {
        return fireRate;
    }

    //Metodo setter para actualizar el daño de la torre
    public void setDamage(int damage) {
        this.damage = damage;
    }

    //Metodo setter para actualizar el alcance de la torre
    public void setRange(int range) {
        this.range = range;
    }

    //Metodo setter para actualizar la frecuencia de disparo de la torre
    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    //Metodo que verifica si la torre puede disparar en el turno actual
    public boolean puedeDisparar() {
        return turnosDesdeUltimoDisparo >= fireRate;
    }

    //Metodo que simula el disparo de la torre
    public void dispara() {
        turnosDesdeUltimoDisparo = 0; //Reinicia el contador de turnos desde el ultimo disparo
    }

    //Metodo para incrementar el contador de turnos desde el ultimo disparo de la torre
    public void incrementarContadorTorre() {
        turnosDesdeUltimoDisparo++;
    }

    public void setActualX(int actualX) {
        this.ActualX = actualX;
    }

    public void setActualY(int actualY) {
        this.ActualY = actualY;
    }

    // Método para que las torres ataquen a los enemigos dentro de su alcance
    public void TorresAtacan(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            // Calculamos la distancia entre la torre y el enemigo
            double distancia = Math.sqrt(Math.pow(enemy.getActualX() - ActualX, 2) + Math.pow(enemy.getActualY() - ActualY, 2));

            // Verificamos si el enemigo está dentro del alcance y la torre puede disparar
            if (distancia <= range) {
                // Reducimos la salud del enemigo según el daño de la torre
                if (enemy.getHealth() > 0) {
                    int nuevaSalud = enemy.getHealth() - damage;
                    enemy.setHealth(Math.max(nuevaSalud, 0)); // Aseguramos que la salud no sea negativa
                    System.out.println("Torre ataca a enemigo. Salud del enemigo: " + enemy.getHealth());
                    // No deberíamos usar break aquí para permitir que la torre ataque a múltiples enemigos dentro del alcance
                }
            }
        }
    }
}


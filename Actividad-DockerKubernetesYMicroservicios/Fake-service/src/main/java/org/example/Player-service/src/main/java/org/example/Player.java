package org.example;

public class Player {
    private int score;       //Puntuación del jugador
    private int baseHealth;  //Salud de la base del jugador

    //Constructor de la clase Player
    public Player() {
        this.score = 0;
        this.baseHealth = 90;
    }

    //Metodo para agregar puntos a la puntuacion del jugador
    public void agregarScore(int points) {
        this.score += points;
    }

    //Metodo para reducir la salud de la base del jugador
    public void reducirBaseHealth(int damage) {
        this.baseHealth -= damage;
    }

    //Getter para obtener la puntuacion del jugador
    public int getScore() {
        return score;
    }

    //Getter para obtener la salud de la base del jugador
    public int getBaseHealth() {
        return baseHealth;
    }

    //Metodo para actualizar la puntuacion del jugador y la salud de la base
    public void updateScoreAndHealth(Enemy enemy, boolean defeated) {
        if (defeated) {
            agregarScore(enemy.getReward());
        } else {
            reducirBaseHealth(enemy.getReward());
        }
    }

    //Metodo para imprimir el estado actual del jugador
    public void Estado() {
        System.out.println("Puntuación: " + score + " | Vida de la base: " + baseHealth);
    }
}


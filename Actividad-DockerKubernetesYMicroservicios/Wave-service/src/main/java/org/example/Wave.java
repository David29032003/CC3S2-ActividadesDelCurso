package org.example;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Wave {
    private List<Enemy> enemies; //Lista de enemigos en la oleada
    private int waveNumber;      //Numero de la oleada
    private Player player;       //Referencia al jugador

    //Constructor de la clase Wave
    //Inicializo una nueva oleada con un numero especifico, una fábrica de enemigos y el jugador
    public Wave(int waveNumber, EnemyFactory enemyFactory, Player player) {
        this.waveNumber = waveNumber;
        this.player = player;
        this.enemies = GenerarEnemigos(waveNumber, enemyFactory); //Genera los enemigos para esta oleada
    }

    public Wave(int waveNumber) {
        this.waveNumber = waveNumber;
    }

    //Metodo privado para generar enemigos
    private List<Enemy> GenerarEnemigos(int waveNumber, EnemyFactory enemyFactory) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < waveNumber * 5; i++) { //Genera mas enemigos con cada oleada
            enemies.add(enemyFactory.createBasicEnemy());
        }
        if (waveNumber % 5 == 0) { //Añade un jefe cada 5 oleadas
            enemies.add(enemyFactory.createBossEnemy());
        }
        return enemies;
    }

    //Getter para obtener la lista de enemigos de la oleada
    public List<Enemy> getEnemies() {
        return enemies;
    }

    //Getter para obtener el numero de la oleada
    public int getWaveNumber() {
        return waveNumber;
    }

    //Método para comenzar la oleada
    public void iniciarWave(List<Tower> towers, Map map) {
        waveNumber++;
        enemies = spawnEnemies(map); // Generar y colocar enemigos para la nueva oleada
        System.out.println("Wave " + waveNumber + " comenzó con " + enemies.size() + " enemigos");

        boolean waveEnProgreso = true;

        while (waveEnProgreso) {
            // Torres atacan a los enemigos
            for (Tower tower : towers) {
                tower.TorresAtacan(enemies);
            }

            // Simula el movimiento de los enemigos y el ataque a la base del jugador
            for (Enemy enemy : enemies) {
                if (enemy.getHealth() > 0) {
                    // Obtener la posición actual y la siguiente posición del enemigo
                    int actualX = enemy.getActualX();
                    int actualY = enemy.getActualY();
                    int[] nextPosition = map.getNextPosition(actualX, actualY);
                    int siguienteX = nextPosition[0];
                    int siguienteY = nextPosition[1];

                    // Mover al enemigo a la siguiente posición
                    enemy.moverEnCamino(actualX, actualY, siguienteX, siguienteY);

                    // Verificar si el enemigo ha alcanzado el final del camino
                    if (enemy.reachedEndOfPath(map)) {
                        player.updateScoreAndHealth(enemy, false);
                        System.out.println("Un enemigo alcanzó la base, salud de la base reducida en: " + enemy.getReward());
                    }
                } else {
                    player.updateScoreAndHealth(enemy, true);
                    System.out.println("Enemigo derrotado. Puntuación incrementada en: " + enemy.getReward());
                }
            }

            // Verifico si aún quedan enemigos vivos en la oleada
            waveEnProgreso = enemies.stream().anyMatch(enemy -> enemy.getHealth() > 0);
        }

        // Informo al jugador del estado después de la oleada
        player.Estado();
    }

    // Método para generar y colocar enemigos en el mapa
    public List<Enemy> spawnEnemies(Map map) {
        List<Enemy> newEnemies = new ArrayList<>();

        // Generar enemigos y colocarlos en el mapa
        for (int i = 0; i < waveNumber * 5; i++) {
            Enemy enemy = new Enemy(); // Asumiendo que tienes una clase Enemy y constructor adecuado
            map.PosicionEnemigo(enemy); // Colocar enemigo en el mapa
            newEnemies.add(enemy); // Agregar enemigo a la lista
        }

        return newEnemies;
    }

}



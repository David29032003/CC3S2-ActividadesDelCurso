package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    public Map map;           //Objeto para representar el mapa del juego
    public Player player;     //Objeto para representar al jugador
    public List<Wave> waves;  //Lista de oleadas de enemigos
    private List<Tower> towers; //Lista de torres colocadas en el mapa
    public int waveNumber;    //Numero de la oleada actual
    public boolean gameRunning; //Indica si el juego esta en ejecucion

    // Constructor de la clase Game
    public Game() {
        this.map = new Map();
        this.player = new Player();
        this.waves = new ArrayList<>();
        this.towers = new ArrayList<>();
        this.waveNumber = 0;
        this.gameRunning = true;
        IniciarWaves();
    }

    //Metodo privado para inicializar las oleadas de enemigos
    public void IniciarWaves() {
        for (int i = 1; i <= 10; i++) {
            waves.add(new Wave(i, new BasicEnemyFactory() {
                // Crea un BasicEnemy
                @Override
                public Enemy createBasicEnemy(int waveNumber) {
                    int health = 100 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
                    int speed = 1 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
                    int reward = 10 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
                    return new BasicEnemy(speed, health, reward);
                }

                // Crea un BossEnemy
                @Override
                public Enemy createBossEnemy(int waveNumber) {
                    int health = 500 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
                    int speed = 2 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
                    int reward = 50 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
                    return new BossEnemy(speed, health, reward);
                }

                // Crea un FastEnemy
                @Override
                public Enemy createFastEnemy(int waveNumber) {
                    int health = 300 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
                    int speed = 3 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
                    int reward = 20 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
                    return new FastEnemy(speed, health, reward);
                }
            }, player));
        }
    }

    public void LugarDeTorre(TowerFactory factory, int x, int y) {
        if (!map.isValidPosition(x, y)) {
            throw new IllegalArgumentException("Posicion invalida para colocar la torre");
        }

        Tower tower = factory.createCannonTower();
        map.addTower(tower, x, y);
    }

    // Método para comenzar la siguiente oleada de enemigos
    public void ComienzaSiguienteWave() {
        if (waveNumber < waves.size()) {
            Wave currentWave = waves.get(waveNumber++);
            System.out.println("Oleada " + waveNumber + " iniciada");
            currentWave.iniciarWave(towers, map);
            if (player.getBaseHealth() <= 0) {
                FinDelJuego();
            }
        } else {
            System.out.println("Ganaste por completar todas las oleadas");
            gameRunning = false;
        }
    }

    //Metodo privado para terminar el juego
    private void FinDelJuego() {
        System.out.println("Juego terminado! Puntuación final: " + player.getScore());
        gameRunning = false;
    }

    //Metodo para iniciar el juego
    public void ComenzarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Juego iniciado");
        while (gameRunning) { //Ciclo principal del juego mientras este en ejecucion
            System.out.print("Ingrese comando: ");
            String command = scanner.nextLine();
            ProcesarComando(command);
        }
    }

    //Metodo para establecer la oleada actual
    public void setWave(Wave wave) {
        this.waves.add(wave);
    }

    //Metodo para obtener las olas
    public List<Wave> getWaves() {
        return waves;
    }

    //Metodo para obtener la lista de enemigos de la oleada actual
    public List<Enemy> getEnemies() {
        if (waveNumber < waves.size()) {
            return waves.get(waveNumber).getEnemies();
        }
        return new ArrayList<>();
    }

    //Metodo para procesar el comando ingresado por el usuario
    public void ProcesarComando(String command) {
        String[] parts = command.split(" "); //Divide el comando en partes usando espacio como separador
        switch (parts[0]) {
            case "PLACE_TOWER": //Comando para colocar una torre en el mapa
                if (parts.length == 4) {
                    String towerType = parts[1];
                    int x = Integer.parseInt(parts[2]);
                    int y = Integer.parseInt(parts[3]);
                    TowerFactory towerFactory = getTowerFactory(towerType);
                    if (towerFactory != null) {
                        LugarDeTorre(towerFactory, x, y);
                    } else {
                        System.out.println("Tipo de torre desconocido: " + towerType);
                    }
                } else {
                    System.out.println("Comando PLACE_TOWER inválido. Uso: PLACE_TOWER <Tipo_De_Torre> <x> <y>"); // Mensaje de error si el comando no tiene el formato correcto
                }
                break;
            case "START_WAVE": //Comando para comenzar la siguiente oleada de enemigos
                ComienzaSiguienteWave(); //Llama al método para comenzar la siguiente oleada
                break;
            default:
                System.out.println("Comando desconocido: " + parts[0]);
                break;
        }
        ImprimirEstadoDelJuego();
    }

    // Método para comenzar la siguiente oleada de enemigos
    public void startNextWave() {
        if (waveNumber < waves.size()) {
            Wave currentWave = waves.get(waveNumber++);
            System.out.println("Oleada " + waveNumber + " iniciada");

            // Obtener la lista de enemigos de la oleada actual
            List<Enemy> enemies = currentWave.getEnemies();

            // Verificar si hay enemigos disponibles
            if (!enemies.isEmpty()) {
                currentWave.iniciarWave(towers, map);
            } else {
                System.out.println("No hay enemigos disponibles en la oleada " + waveNumber);
            }
        } else {
            System.out.println("Ganaste por completar todas las oleadas");
            gameRunning = false;
        }
    }


    //Metodo para obtener la factoria de torres segun el tipo especificado
    public TowerFactory getTowerFactory(String towerType) {
        switch (towerType) { //Switch para manejar diferentes tipos de torres
            case "Cannon":
                return new CannonTowerFactory();
            default:
                return null;
        }
    }

    //Metodo para imprimir el estado actual del juego
    private void ImprimirEstadoDelJuego() {
        System.out.println("Estado del juego:");
        map.printMap();
        System.out.println("Puntuación: " + player.getScore());
        System.out.println("Vida de la base: " + player.getBaseHealth());
    }

    //Metodo principal para iniciar el juego
    public static void main(String[] args) {
        Map map = new Map();
        System.out.println("Mapa inicial:");
        map.printMap();

        Game game = new Game();
        game.ComenzarJuego();
    }
}




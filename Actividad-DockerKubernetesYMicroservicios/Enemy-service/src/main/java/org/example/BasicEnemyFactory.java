package org.example;

public abstract class BasicEnemyFactory implements EnemyFactory {
    //Crea un BasicEnemy
    @Override
    public Enemy createBasicEnemy() {
        return new BasicEnemy();
    }

    //Crea un BossEnemy
    @Override
    public Enemy createBossEnemy() {
        return new BossEnemy();
    }

    //Crea un FastEnemy
    @Override
    public Enemy createFastEnemy() {
        return new FastEnemy();
    }
    //Crea un BasicEnemy
    @Override
    public Enemy createBasicEnemy(int waveNumber) {
        int health = 100 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
        int speed = 1 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
        int reward = 10 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
        return new BasicEnemy(speed, health, reward);
    }

    //Crea un BossEnemy
    @Override
    public Enemy createBossEnemy(int waveNumber) {
        int health = 500 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
        int speed = 2 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
        int reward = 50 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
        return new BossEnemy(speed, health, reward);
    }

    //Crea un FastEnemy
    @Override
    public Enemy createFastEnemy(int waveNumber) {
        int health = 500 + (waveNumber - 1) * 10; //Incrementa la salud con cada oleada
        int speed = 2 + (waveNumber - 1) / 5; //Incrementa la velocidad cada 5 oleadas
        int reward = 50 + (waveNumber - 1) * 2; //Incrementa la recompensa con cada oleada
        return new FastEnemy(speed, health, reward);
    }
}

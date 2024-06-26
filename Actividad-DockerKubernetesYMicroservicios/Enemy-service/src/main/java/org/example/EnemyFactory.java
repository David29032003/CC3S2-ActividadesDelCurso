package org.example;

//Interfaz que define metodos para crear diferentes tipos de enemigos.
public interface EnemyFactory {
    //Crea un BasicEnemy
    Enemy createBasicEnemy();

    //Crea un BasicEnemy
    Enemy createBasicEnemy(int waveNumber);

    //Crea un BossEnemy
    Enemy createBossEnemy();

    //Crea un BossEnemy
    Enemy createBossEnemy(int waveNumber);

    //Crea un FastEnemy
    Enemy createFastEnemy();

    //Crea un FastEnemy
    Enemy createFastEnemy(int waveNumber);
}


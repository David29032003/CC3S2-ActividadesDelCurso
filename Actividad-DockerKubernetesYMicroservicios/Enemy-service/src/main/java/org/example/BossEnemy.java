package org.example;

public class BossEnemy extends Enemy {
    //Constructor de la clase BossEnemy
    //Inicializo un nuevo BossEnemy con una velocidad de 2, salud de 500 y recompensa de 50
    public BossEnemy() {
        super(2, 500, 50); // velocidad, vida, recompensa
    }

    //Constructor de la clase BossEnemy
    public BossEnemy(int speed, int health, int reward) {
        super(speed, health, reward);
    }

    //Sobreescribo el metodo ataque de la clase Enemy
    @Override
    public void ataque() {
        System.out.println("BossEnemy ataca con velocidad " + getSpeed() + ", salud " + getHealth() + ", recompensa " + getReward());
    }
}


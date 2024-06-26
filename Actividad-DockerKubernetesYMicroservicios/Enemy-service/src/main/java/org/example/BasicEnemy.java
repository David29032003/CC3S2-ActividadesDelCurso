package org.example;

public class BasicEnemy extends Enemy {
    //Constructor de la clase BasicEnemy
    //Inicializo un nuevo BasicEnemy con una velocidad de 1, salud de 100 y recompensa de 10
    public BasicEnemy() {
        super(1, 100, 10); // velocidad, vida, recompensa
    }

    //Constructor de la clase BasicEnemy
    public BasicEnemy(int speed, int health, int reward) {
        super(speed, health, reward);
    }

    //Sobreescrito el metodo ataque de la clase Enemy
    @Override
    public void ataque() {
        System.out.println("BasicEnemy ataca con velocidad " + getSpeed() + ", salud " + getHealth() + ", recompensa " + getReward());
    }
}


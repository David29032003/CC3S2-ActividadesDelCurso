package org.example;

public class FastEnemy extends Enemy {
    //Constructor de la clase FastEnemy
    //Inicializo un nuevo FastEnemy con una velocidad de 2, salud de 80 y recompensa de 10
    public FastEnemy() {
        super(2, 80, 10); // velocidad, vida, recompensa
    }

    public FastEnemy(int speed, int health, int reward) {
        super(speed, health, reward);
    }

    //Sobreescribo el metodo ataque de la clase Enemy
    @Override
    public void ataque() {
        System.out.println("FastEnemy ataca con velocidad " + getSpeed() + ", salud " + getHealth() + ", recompensa " + getReward());
    }
}


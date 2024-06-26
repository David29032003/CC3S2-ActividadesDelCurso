package org.example;

public class SpeedyEnemy extends Enemy {
    //Constructor de la clase SpeedyEnemy
    //Inicializo un nuevo SpeedyEnemy con una velocidad de 3, salud de 60 y recompensa de 10
    public SpeedyEnemy() {
        super(3, 60, 10); // velocidad, vida, recompensa
    }

    //Sobreescribo el metodo ataque de la clase Enemy
    @Override
    public void ataque() {
        System.out.println("SpeedyEnemy ataca con velocidad " + getSpeed() + ", salud " + getHealth() + ", recompensa " + getReward());
    }
}

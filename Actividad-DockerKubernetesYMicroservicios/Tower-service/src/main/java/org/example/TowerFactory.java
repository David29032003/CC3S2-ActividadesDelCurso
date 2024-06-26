package org.example;

//Interfaz que define un método para crear torres en el juego.
public interface TowerFactory {
    //Crea una torre cañon.
    Tower createCannonTower();

    //Crea una torre flecha.
    Tower createArrowTower();

    //Crea una torre laser.
    Tower createLaserTower();
}


package org.example;

public class CannonTowerFactory implements TowerFactory {
    //Crea un CannonTower
    @Override
    public Tower createCannonTower() {
        return new CannonTower();
    }

    //Crea un LaserTower
    @Override
    public Tower createLaserTower() {
        return new LaserTower();
    }

    //Crea un ArrowTower
    @Override
    public Tower createArrowTower() {
        return new ArrowTower();
    }
}

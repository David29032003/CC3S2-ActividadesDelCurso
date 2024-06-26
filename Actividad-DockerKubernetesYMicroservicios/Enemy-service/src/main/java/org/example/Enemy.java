package org.example;

public class Enemy {
    //Atributos de la clase Enemy
    private int speed; //número de celdas que el enemigo puede moverse por turno
    private int health; //salud del enemigo
    private int reward; //recompensa otorgada al derrotar al enemigo
    private char[][] map; //Matriz que representa el mapa del juego
    private int ActualX; //Posicion actual en X del enemigo en el mapa
    private int ActualY; //Posicion actual en Y del enemigo en el mapa

    public Enemy() {
        this.speed =1;
        this.health = 100;
        this.reward = 10;
    }

    //Constructor de la clase Enemy
    //Inicializo un nuevo enemigo con la velocidad, salud y recompensa especificadas
    public void Enemy(int speed, int health, int reward, char[][] map, int InicioX, int InicioY) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
        this.map = map;
        this.ActualX = InicioX;
        this.ActualY = InicioY;
    }

    //Constructor de la clase Enemy
    //Inicializo un nuevo enemigo con la velocidad, salud y recompensa especificadas
    public Enemy(int speed, int health, int reward) {
        this.speed = speed;
        this.health = health;
        this.reward = reward;
    }

    public Enemy(Map map) {
        this.map = map.getMapArray();
    }

    public int getActualX() {
        return ActualX;
    }

    public int getActualY() {
        return ActualY;
    }

    //Metodo getter para obtener la velocidad del enemigo
    public int getSpeed() {
        return speed;
    }

    //Metodo getter para obtener la salud del enemigo
    public int getHealth() {
        return health;
    }

    //Metodo getter para obtener la recompensa del enemigo
    public int getReward() {
        return reward;
    }

    //Metodo setter para establecer la velocidad del enemigo
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //Metodo setter para establecer la salud del enemigo
    public void setHealth(int health) {
        this.health = health;
    }

    //Metodo setter para establecer la recompensa del enemigo
    public void setReward(int reward) {
        this.reward = reward;
    }

    //Metodo setter para establecer la recompensa del enemigo
    public void setActualPosition(int ActualX, int ActualY) {
        this.ActualX = ActualX;
        this.ActualY = ActualY;
    }

    //Metodo para simular el ataque de los enemigos
    public void ataque() {
        System.out.println("Los enemigos están en camino");
    }

    //Metodo para simular la derrota de los enemigos
    public int derrota() {
        System.out.println("Enemigo derrotado, Recompensa: " + reward);
        return reward;
    }

    public void moverEnCamino(int ActualX, int ActualY, int SiguienteX, int SiguienteY) {
        //Verifico si la siguiente posicion esta dentro de los limites del mapa
        if (isValidPosition(SiguienteX, SiguienteY)) {
            //Verifico si la siguiente posicion es un camino ('C')
            if (map[SiguienteY][SiguienteX] == 'C') {
                //Muevo al enemigo a la siguiente posicion
                System.out.println("Moviendo al enemigo de (" + ActualX + ", " + ActualY + ") a (" + SiguienteX + ", " + SiguienteY + ")");
                // Actualizar las coordenadas del enemigo
                this.ActualX = SiguienteX;
                this.ActualY = SiguienteY;
            } else {
                System.out.println("Siguiente posicion no es un camino valido");
            }
        } else {
            System.out.println("Siguiente posicion esta fuera de los limites del mapa");
        }
    }

    //Metodo para verificar si una posicion es valida para colocar una torre
    public boolean isValidPosition(int x, int y) {
        if (map == null) {
            return false;
        }
        //Verifico si las coordenadas estan dentro de los limites del mapa
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }

    public boolean reachedEndOfPath(Map mapInstance) {
        char[][] mapArray = mapInstance.getMapArray();
        int maxX = mapArray[0].length - 1; // Obtener el límite derecho del mapa

        // Verificar si la posición actual está en el último camino del borde derecho del mapa
        if (ActualX == maxX && mapArray[ActualY][ActualX] == 'C') {
            return true;
        } else {
            return false;
        }
    }


}





















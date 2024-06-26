package org.example;

public class Map {
    private char[][] map; //Matriz que representa el mapa del juego

    //Constructor de la clase Map.
    //Inicializo el mapa con un diseño predefinido
    public Map() {
        this.map = new char[][]{
                {' ', ' ', 'C', ' ', ' '},
                {' ', 'C', ' ', ' ', ' '},
                {'C', ' ', ' ', 'C', ' '},
                {' ', ' ', 'C', ' ', ' '},
                {' ', ' ', ' ', ' ', ' '}
        };
    }

    //Metodo para verificar si una posicion (x, y) es valida para colocar una torre
    public boolean isValidPosition(int x, int y) {
        // Verificar límites del mapa
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length) {
            return false;
        }

        //Verifico que la posicion no este ocupada por un camino ('C')
        return map[x][y] != 'C';
    }

    //Intenta añadir una torre en las coordenadas (x, y) del mapa
    public boolean addTower(Tower tower, int x, int y) {
        if (isValidPosition(x, y)) {
            map[x][y] = 'B';
            return true;
        } else {
            return false;
        }
    }

    //Metodo para imprimir el mapa en la consola, mostrando cada celda con su respectivo contenido
    public void printMap() {
        for (char[] row : map) {
            for (char cell : row) {
                System.out.print("[" + cell + "]"); //Imprime cada celda del mapa
            }
            System.out.println(); //Nueva línea para la siguiente fila del mapa
        }
    }

    //Devuelve la matriz que representa el mapa
    public char[][] getMapArray() {
        return map;
    }

    //Metodo para colocar enemigos en el mapa
    public void PosicionEnemigo(Enemy enemy) {
        //Encuentra la posicion inicial del camino 'C'
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'C') {
                    enemy.setActualPosition(i, j); //Coloco el enemigo en la primera celda del camino
                    return; //Salgo del metodo una vez que el enemigo ha sido colocado
                }
            }
        }
    }

    // Método para obtener la siguiente posición en el camino 'C'
    public int[] getNextPosition(int x, int y) {
        // Array para las direcciones: arriba, derecha, abajo, izquierda
        int[][] directions = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };

        for (int[] dir : directions) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (isValidPosition(nextX, nextY) && map[nextX][nextY] == 'C') {
                return new int[]{nextX, nextY};
            }
        }
        return new int[]{x, y}; // Si no hay siguiente posición, retorna la actual
    }
}







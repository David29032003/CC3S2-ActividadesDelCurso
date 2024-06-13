package org.example;


public class ConsoleGraphics implements Graphics{

    @Override
    public void drawText(String text) {
        print(text);

    }

    @Override
    public void drawHorizontalLine(int width) {
        var rowText = new StringBuilder();
        for(int i = 0; i<width;i++){
            rowText.append('X');
        }
        print(rowText.toString());


    }

    @Override
    public void drawCircle(int radius) {
        //dibujar un circulo con el radio
        for (int y = -radius; y <= radius; y++) {
            StringBuilder rowText = new StringBuilder();
            for (int x = -radius; x <= radius; x++) {
                if (x * x + y * y <= radius * radius) {
                    rowText.append('O'); // Puntos dentro del círculo
                } else {
                    rowText.append(' '); // Espacios fuera del círculo
                }
            }
            print(rowText.toString());
        }
    }

    private void print(String text){
        System.out.println(text);
    }
}

package org.example;

public class Circle implements Shape {
    private  final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void draw(Graphics g) {
        g.drawCircle(radius);
    }
    public void drawCircle(Graphics g) {
        int diameter = 2 * radius;
        for (int i = 0; i <= diameter; i++) {
            for (int j = 0; j <= diameter; j++) {
                int xSquared = (i - radius) * (i - radius);
                int ySquared = (j - radius) * (j - radius);
                if (Math.abs(xSquared + ySquared - radius * radius) < radius) {
                    System.out.print('*');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}

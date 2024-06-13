package org.example;


public class TextBoxes implements Shape {

    private final String text;

    public TextBoxes(String text) {
        this.text = text;
    }

    @Override
    public void draw(Graphics g) {
        g.drawText(g.toString());
    }
    public void drawText(Graphics g) {
        g.drawText(text);
    }
}

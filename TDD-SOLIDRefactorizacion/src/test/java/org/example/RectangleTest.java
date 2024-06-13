package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class RectangleTest {
    private Graphics mockGraphics;
    private Rectangle rectangle;

    @BeforeEach
    public void setUp() {
        mockGraphics = Mockito.mock(Graphics.class);
        rectangle = new Rectangle(5, 3);  // Ancho = 5, Alto = 3
    }

    @Test
    public void testDrawRectangle() {
        rectangle.draw(mockGraphics);

        Mockito.verify(mockGraphics, times(3)).drawHorizontalLine(5);
    }

    @Test
    public void testDrawRectangleWithDifferentDimensions() {
        rectangle = new Rectangle(7, 2);  // Ancho = 7, Alto = 2
        rectangle.draw(mockGraphics);

        Mockito.verify(mockGraphics, times(2)).drawHorizontalLine(7);
    }
}
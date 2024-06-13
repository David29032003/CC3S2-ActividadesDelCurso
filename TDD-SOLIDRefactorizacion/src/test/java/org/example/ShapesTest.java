package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ShapesTest {
    private Graphics mockGraphics;
    private Shapes shapes;

    @BeforeEach
    public void setUp() {
        mockGraphics = Mockito.mock(Graphics.class);
        shapes = new Shapes(mockGraphics);
    }

    @Test
    public void testAddAndDrawShapes() {

        Shape rightArrow = new RightArrow();
        shapes.add(rightArrow);
        shapes.draw();

        verify(mockGraphics).drawText(" \\");
        verify(mockGraphics).drawText("----");
        verify(mockGraphics).drawText(" /");
    }
}
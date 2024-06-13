package org.example;

import org.example.TextBoxes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.Graphics;

import static org.mockito.Mockito.*;

public class TextBoxesTest {
    private Graphics mockGraphics;
    private TextBoxes textBox;

    @BeforeEach
    public void setUp() {
        mockGraphics = Mockito.mock(Graphics.class);
        textBox = new TextBoxes("Hello, World!");
    }

    @Test
    public void testDrawText() {
        textBox.draw((org.example.Graphics) mockGraphics);
        verify(mockGraphics).drawText("Hello, World!");
    }

    @Test
    public void testDrawTextWithDifferentText() {
        textBox = new TextBoxes("Different Text");
        textBox.draw((org.example.Graphics) mockGraphics);
        verify(mockGraphics).drawText("Different Text");
    }
}
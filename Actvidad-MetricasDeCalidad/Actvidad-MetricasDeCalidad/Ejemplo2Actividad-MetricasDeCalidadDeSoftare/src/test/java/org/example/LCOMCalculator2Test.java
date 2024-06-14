package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

public class LCOMCalculator2Test {

    @Test
    public void testHighCohesion() {
        ClassInfo classInfo = new ClassInfo();
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr1", "attr2")));

        int lcom = LCOMCalculator2.calculateLCOM(classInfo);
        assertEquals(-1, lcom); // Todos los métodos comparten atributos
    }

    @Test
    public void testLowCohesion() {
        ClassInfo classInfo = new ClassInfo();
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));

        int lcom = LCOMCalculator2.calculateLCOM(classInfo);
        assertEquals(1, lcom); // Ningún método comparte atributos
    }

    @Test
    public void testNoMethods() {
        ClassInfo classInfo = new ClassInfo();

        int lcom = LCOMCalculator2.calculateLCOM(classInfo);
        assertEquals(0, lcom); // No hay métodos en la clase
    }
}
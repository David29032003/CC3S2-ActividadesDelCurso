package org.example;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo(); // Crea una instancia de ClassInfo

        // Simulación de entrada de métodos y sus accesos a atributos
        try {
            classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
            classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));
            classInfo.addMethod("method3", new HashSet<>(Arrays.asList("attr3")));
            classInfo.addMethod("method4", new HashSet<>(Arrays.asList("attr1", "attr4")));
            classInfo.addMethod("method5", new HashSet<>(Arrays.asList("attr2", "attr3")));
            classInfo.addMethod("method6", new HashSet<>(Arrays.asList("attr1", "attr2", "attr3")));
            classInfo.addMethod("method7", new HashSet<>(Arrays.asList("attr4")));
            classInfo.addMethod("method8", new HashSet<>(Arrays.asList("attr1")));
            classInfo.addMethod("method9", new HashSet<>(Arrays.asList("attr2", "attr4")));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // Calcula el LCOM
        int lcom = LCOMCalculator2.calculateLCOM(classInfo);
        System.out.println("LCOM = " + lcom); // Imprime el valor de LCOM
    }
}

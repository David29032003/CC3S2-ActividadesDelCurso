package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCOMCalculator2 {
    public static int calculateLCOM(ClassInfo classInfo) {
        int p = 0, q = 0;
        List<String> methods = classInfo.getMethods();

        // Itera sobre todos los pares de métodos
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                String method1 = methods.get(i); // Obtiene el nombre del primer método del par
                String method2 = methods.get(j); // Obtiene el segundo nombre del método del par

                // Obtiene los atributos usados por cada método
                Set<String> attrs1 = classInfo.getAttributesForMethod(method1);
                Set<String> attrs2 = classInfo.getAttributesForMethod(method2);

                // Calcula la intersección de los conjuntos de atributos de ambos métodos
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);

                if (intersection.isEmpty()) {
                    p++; // Si la intersección está vacía, incrementa el contador de métodos que no comparten atributos
                } else {
                    q++; // Si la intersección no está vacía, incrementa el contador de métodos que comparten al menos un atributo
                }
            }
        }

        return p - q; // Calcula el LCOM
    }
}

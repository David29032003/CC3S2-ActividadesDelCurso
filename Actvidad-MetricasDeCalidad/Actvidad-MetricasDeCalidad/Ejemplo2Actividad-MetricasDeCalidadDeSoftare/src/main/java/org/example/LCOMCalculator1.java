package org.example;

import java.util.*;

public class LCOMCalculator1 {
    //Clase interna para almacenar informacion de la clase analizada
    private static class ClassInfo {
        List<String> methods = new ArrayList<>();//Lista de nombres de metodos
        Map<String, Set<String>> methodAttributes = new HashMap<>();//Mapa de metodos y los atributos que usan
        Set<String> attributes = new HashSet<>();// Conjunto de todos los atributos de la clase

        //Metodo para agregar un metodo y los atributos que usa
        public void addMethod(String methodName, Set<String> attrs) {
            methods.add(methodName);//Agrega el nombre del metodo a la lista de metodos
            methodAttributes.put(methodName, attrs);//Asocia el metodo con sus atributos
            attributes.addAll(attrs);//Agrega todos los atributos al conjunto de atributos de la Clase.
        }
    }
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();// Crea una instancia de ClassInfo
        // Simulación de entrada de métodos y sus accesos a atributos
        // method1 usa attr1 y attr2
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        // method2 usa attr2
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));
        // method3 usa attr3
        classInfo.addMethod("method3", new HashSet<>(Arrays.asList("attr3")));
        //Agreggo mas metodos con diferentes combinaciones de atributos
        classInfo.addMethod("method4", new HashSet<>(Arrays.asList("attr1","attr4")));
        classInfo.addMethod("method5", new HashSet<>(Arrays.asList("attr2","attr3")));
        classInfo.addMethod("method6", new HashSet<>(Arrays.asList("attr1","attr2","attr3")));
        classInfo.addMethod("method7", new HashSet<>(Arrays.asList("attr4")));
        classInfo.addMethod("method8", new HashSet<>(Arrays.asList("attr1")));
        classInfo.addMethod("method9", new HashSet<>(Arrays.asList("attr2","attr4")));

        //Inizializa los contadores de pares de metodos que no comparten y que si comparten atributos
        int p = 0, q = 0;
        //Obtiene la lista de metodos de la Clase
        List<String> methods = classInfo.methods;

        // Itera sobre todos los pares de metodos
        for (int i = 0; i < methods.size(); i++) {
            for (int j = i + 1; j < methods.size(); j++) {
                String method1 = methods.get(i);// Obtiene el nombre del primer metodo del par
                String method2 = methods.get(j);// Obtiene el segundo nombre del metodo del par
                // Obtiene los atributos usados por el primer metodo
                Set<String> attrs1 = classInfo.methodAttributes.get(method1);
                // Obtiene los atributos usados por el segundo metodo
                Set<String> attrs2 = classInfo.methodAttributes.get(method2);
                // Calcula la interseccion de los conjuntos de atributos de ambos metodos
                Set<String> intersection = new HashSet<>(attrs1);
                intersection.retainAll(attrs2);

                if (intersection.isEmpty()) {
                    p++; // Si la interseccion esta vacia, incrementa el contador de metodos que no comparten atributos
                } else {
                    q++; // Si la interseccion no esta vacia, incrementa el contador de metodos que comparten al menos un atributo
                }
            }
        }
        //Calcula el LCOM
        int lcom = p - q;
        System.out.println("LCOM = " + lcom); // Imprime el valor de LCOM
    }
}

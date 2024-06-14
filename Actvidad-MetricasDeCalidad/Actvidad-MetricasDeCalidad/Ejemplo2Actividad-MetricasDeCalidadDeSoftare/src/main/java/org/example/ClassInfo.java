package org.example;

import java.util.*;

public class ClassInfo {
    private List<String> methods = new ArrayList<>(); // Lista de nombres de métodos
    private Map<String, Set<String>> methodAttributes = new HashMap<>(); // Mapa de métodos y los atributos que usan
    private Set<String> attributes = new HashSet<>(); // Conjunto de todos los atributos de la clase

    // Método para agregar un método y los atributos que usa
    public void addMethod(String methodName, Set<String> attrs) {
        if (methodName == null || methodName.isEmpty() || attrs == null) {
            throw new IllegalArgumentException("El nombre del método y los atributos no pueden ser nulos o vacíos.");
        }
        methods.add(methodName); // Agrega el nombre del método a la lista de métodos
        methodAttributes.put(methodName, attrs); // Asocia el método con sus atributos
        attributes.addAll(attrs); // Agrega todos los atributos al conjunto de atributos de la Clase.
    }

    public List<String> getMethods() {
        return methods;
    }

    public Set<String> getAttributesForMethod(String methodName) {
        return methodAttributes.getOrDefault(methodName, Collections.emptySet());
    }
}


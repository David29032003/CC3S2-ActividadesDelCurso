package com.example.Ejemplo3ActividadMetricasDeCalidadDeSoftware;

import java.util.*;

public class LCOM4Calculator {
    private static class ClassInfo {
        List<String> methods = new ArrayList<>();
        Map<String, Set<String>> methodAttributes = new HashMap<>();
        Set<String> attributes = new HashSet<>();
        public void addMethod(String methodName, Set<String> attrs) {
            methods.add(methodName);
            methodAttributes.put(methodName, attrs);
            attributes.addAll(attrs);
        }
        public int calculateLCOM4() {
            Map<String, Set<String>> graph = new HashMap<>();
            for (String method : methods) {
                graph.put(method, new HashSet<>());
            }
            for (int i = 0; i < methods.size(); i++) {
                for (int j = i + 1; j < methods.size(); j++) {
                    String method1 = methods.get(i);
                    String method2 = methods.get(j);
                    Set<String> attrs1 = methodAttributes.get(method1);
                    Set<String> attrs2 = methodAttributes.get(method2);
// Crear un arco si comparten atributos
                    if (!Collections.disjoint(attrs1, attrs2)) {
                        graph.get(method1).add(method2);
                        graph.get(method2).add(method1);
                    }
                }
            }
            return countComponents(graph);
        }
        private int countComponents(Map<String, Set<String>> graph) {
            Set<String> visited = new HashSet<>();
            int components = 0;
            for (String method : methods) {
                if (!visited.contains(method)) {
                    dfs(graph, method, visited);
                    components++;
                }
            }
            return components;
        }
        private void dfs(Map<String, Set<String>> graph, String method, Set<String> visited) {
            Stack<String> stack = new Stack<>();
            stack.push(method);
            while (!stack.isEmpty()) {
                String current = stack.pop();
                if (!visited.contains(current)) {
                    visited.add(current);
                    for (String neighbor : graph.get(current)) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ClassInfo classInfo = new ClassInfo();
// Ejemplo de métodos y atributos
        classInfo.addMethod("method1", new HashSet<>(Arrays.asList("attr1", "attr2")));
        classInfo.addMethod("method2", new HashSet<>(Arrays.asList("attr2")));
        classInfo.addMethod("method3", new HashSet<>(Arrays.asList("attr3")));
        int lcom4 = classInfo.calculateLCOM4();
        System.out.println("LCOM4 = " + lcom4);
    }
}
